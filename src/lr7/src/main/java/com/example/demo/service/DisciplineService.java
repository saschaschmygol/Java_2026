package com.example.demo.service;

import com.example.demo.dao.DisciplineDao;
import com.example.demo.entity.Discipline;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {

    private final DisciplineDao disciplineDao;

    public DisciplineService(DisciplineDao disciplineDao) {
        this.disciplineDao = disciplineDao;
    }

    public OperationResult<List<Discipline>> findAll() {
        List<Discipline> disciplines = disciplineDao.findAll();
        return OperationResult.success("Disciplines received successfully", disciplines);
    }

    public OperationResult<Discipline> findById(Long id) {
        return disciplineDao.findById(id)
                .map(discipline -> OperationResult.success("Discipline received successfully", discipline))
                .orElseGet(() -> OperationResult.failure("Discipline with id " + id + " not found"));
    }

    public OperationResult<Discipline> create(Discipline discipline) {
        discipline.setId(null);
        Discipline savedDiscipline = disciplineDao.save(discipline);
        return OperationResult.success("Discipline created successfully", savedDiscipline);
    }

    public OperationResult<Discipline> update(Discipline discipline) {
        Long id = discipline.getId();
        if (id == null) {
            return OperationResult.failure("Discipline id is required for update");
        }

        if (!disciplineDao.existsById(id)) {
            return OperationResult.failure("Discipline with id " + id + " not found");
        }

        Discipline savedDiscipline = disciplineDao.save(discipline);
        return OperationResult.success("Discipline updated successfully", savedDiscipline);
    }

    public OperationResult<Void> delete(Long id) {
        if (!disciplineDao.existsById(id)) {
            return OperationResult.failure("Discipline with id " + id + " not found");
        }

        disciplineDao.deleteById(id);
        return OperationResult.success("Discipline deleted successfully", null);
    }
}
