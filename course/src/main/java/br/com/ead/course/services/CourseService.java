package br.com.ead.course.services;

import br.com.ead.course.models.CourseModel;
import br.com.ead.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseService {

    void delete(CourseModel courseModel);

    CourseModel save(CourseModel courseModel);

    Optional<CourseModel> findById(UUID courseId);

    List<CourseModel> findAll();
}
