package com.EdifyIITBombay.backend_App;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CourseInstanceDTO {

    private Long id;
    private int year;
    private int semester;
    private Long courseid;

    private String title;
    private String courseCode;
    private String instructorName;
    private String description;

}
