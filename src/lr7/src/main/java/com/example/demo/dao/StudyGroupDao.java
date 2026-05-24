package com.example.demo.dao;

import com.example.demo.entity.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyGroupDao extends JpaRepository<StudyGroup, Integer> {
}
