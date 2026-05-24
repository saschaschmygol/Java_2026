package com.example.demo.dao;

import com.example.demo.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineDao extends JpaRepository<Discipline, Long> {
}
