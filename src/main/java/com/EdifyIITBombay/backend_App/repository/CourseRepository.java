package com.EdifyIITBombay.backend_App.repository;
import com.EdifyIITBombay.backend_App.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long> {
    
}
