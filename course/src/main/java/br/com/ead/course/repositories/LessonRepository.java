package br.com.ead.course.repositories;

import br.com.ead.course.models.LessonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface LessonRepository extends JpaRepository<LessonModel, UUID> {
}
