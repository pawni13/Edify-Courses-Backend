package com.EdifyIITBombay.backend_App.service;
import com.EdifyIITBombay.backend_App.Course;
import com.EdifyIITBombay.backend_App.model.CourseModel;
import java.util.List;
public interface ICourseService {
    public Course saveCourse(Course course);

    public List<CourseModel> getAllCourses();

    public Course getCourseById(Long id);

    public boolean deleteCourseById(Long id);

}
