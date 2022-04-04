package br.com.ead.course.repositories;

import br.com.ead.course.models.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface CourseRepository extends JpaRepository <CourseModel, UUID> {


}
