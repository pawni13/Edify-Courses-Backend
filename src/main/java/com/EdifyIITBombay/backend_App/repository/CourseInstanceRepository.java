package com.EdifyIITBombay.backend_App.repository;

import com.EdifyIITBombay.backend_App.model.CourseInstanceModel;
import com.EdifyIITBombay.backend_App.model.CourseModel;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstanceModel, Long> {

    CourseInstanceModel findByYearAndSemesterAndCourseId(int year, int semester, Long courseId);

    List<CourseInstanceModel> findByYearAndSemester(int year, int semester);

    void deleteByYearAndSemesterAndCourseId(int year, int semester, Long courseId);

    @Query("SELECT ci FROM CourseInstanceModel ci JOIN FETCH ci.course")
    List<CourseInstanceModel> findAllWithCourses();

    List<CourseInstanceModel> findByCourse(CourseModel course);

   
}