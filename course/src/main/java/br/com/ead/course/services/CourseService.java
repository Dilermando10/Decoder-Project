package br.com.ead.course.services;

import br.com.ead.course.models.CourseModel;
import br.com.ead.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface CourseService {

    void delete(CourseModel courseModel);


}
