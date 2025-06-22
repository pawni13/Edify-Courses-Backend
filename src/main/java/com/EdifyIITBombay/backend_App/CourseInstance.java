package com.EdifyIITBombay.backend_App;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInstance {
    //Instance ID 
    private Long id;
    private int year;
    private int semester;
    //Parent course ID
    private Long course;
    
   
    private String title;
    private String courseCode;
    private String instructorName;
    private String description; 
}
