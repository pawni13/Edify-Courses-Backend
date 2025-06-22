package com.EdifyIITBombay.backend_App;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

     // private Long id;
    private String title;
    private String courseCode;
    private String instructorName;
    private String description;
   
}
