package com.example.demo.service;

import com.example.demo.dao.StudyGroupDao;
import com.example.demo.entity.StudyGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupService {

    private final StudyGroupDao studyGroupDao;

    public StudyGroupService(StudyGroupDao studyGroupDao) {
        this.studyGroupDao = studyGroupDao;
    }

    public List<StudyGroup> getAllStudyGroups() {
        return studyGroupDao.findAll();
    }

    public StudyGroup getStudyGroupById(Integer id) {
        return studyGroupDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Study group with id " + id + " not found"));
    }

    public void saveStudyGroup(StudyGroup studyGroup) {
        studyGroupDao.save(studyGroup);
    }

    public void deleteStudyGroupById(Integer id) {
        studyGroupDao.deleteById(id);
    }
}
