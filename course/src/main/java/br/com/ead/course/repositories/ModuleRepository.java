package br.com.ead.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface ModuleRepository extends JpaRepository<ModuleRepository, UUID> {
}
