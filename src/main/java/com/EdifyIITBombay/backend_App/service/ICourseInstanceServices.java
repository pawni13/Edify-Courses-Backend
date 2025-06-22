package com.EdifyIITBombay.backend_App.service;
import java.util.List;
import com.EdifyIITBombay.backend_App.CourseInstance;
import com.EdifyIITBombay.backend_App.CourseInstanceDTO;
public interface ICourseInstanceServices {

    public String saveCourseInstance(CourseInstance courseInstance);

    public List<CourseInstanceDTO> getAllCourseInstances();

    public CourseInstanceDTO getCourseInstanceByYearSemId(int year, int semester, Long courseId);

    public List<CourseInstanceDTO> getCourseInstancesByYearSem(int year, int semester);

    
}
