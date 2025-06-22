package com.EdifyIITBombay.backend_App.service;
import com.EdifyIITBombay.backend_App.Course;
import com.EdifyIITBombay.backend_App.model.CourseInstanceModel;
import com.EdifyIITBombay.backend_App.model.CourseModel;
import com.EdifyIITBombay.backend_App.repository.CourseInstanceRepository;
import com.EdifyIITBombay.backend_App.repository.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    public Course saveCourse(Course course) {
        CourseModel courseModel = new CourseModel();
        BeanUtils.copyProperties(course, courseModel);

        CourseModel savedCourseModel = courseRepository.save(courseModel);

        Course savedCourse = new Course();
        BeanUtils.copyProperties(savedCourseModel, savedCourse);

        return savedCourse;
    }

    public List<CourseModel> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) throws EntityNotFoundException {
        CourseModel optionalCourse = courseRepository.findById(id).get();
        Course rescourse = new Course();
        BeanUtils.copyProperties(optionalCourse, rescourse);
        return rescourse;
    }

   public boolean deleteCourseById(Long id) {
        CourseModel course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            return false; 
        }
       
        List<CourseInstanceModel> instances = courseInstanceRepository.findByCourse(course);

        if (!instances.isEmpty()) {
            for (CourseInstanceModel instance : instances) {
                courseInstanceRepository.delete(instance);
            }
        }
        
        courseRepository.delete(course);
        return true;
    }

}