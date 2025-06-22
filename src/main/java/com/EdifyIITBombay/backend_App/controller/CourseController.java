package com.EdifyIITBombay.backend_App.controller;

import org.springframework.web.bind.annotation.RestController;

import com.EdifyIITBombay.backend_App.Course;
import com.EdifyIITBombay.backend_App.model.CourseModel;
import com.EdifyIITBombay.backend_App.service.CourseService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CourseController {

     @Autowired
    CourseService courseService;

    @PostMapping("/courses")
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        try {
            Course savedCourse = courseService.saveCourse(course);
            return ResponseEntity.ok(savedCourse);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Course code already exists: " + course.getCourseCode());
        }
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseModel>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.FOUND);
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/courses/{id}")
    public boolean deleteCourseById(@PathVariable Long id) {
        System.out.println("done deletion");
        return courseService.deleteCourseById(id);
    }

}
   /*List<Course> courses= new ArrayList<>();
 @GetMapping("courses")
 public List<Course> getAllCourses() {
     return courses;
 }
   @PostMapping("courses")
   public String postMethodName(@RequestBody Course course) {
       
       courses.add(course);
       return "Saved Successfully";*/
   
    

