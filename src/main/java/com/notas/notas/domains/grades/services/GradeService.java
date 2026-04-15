package com.notas.notas.domains.grades.services;

import com.notas.notas.domains.grades.dtos.request.CreateGradeReqDTO;
import com.notas.notas.domains.grades.dtos.request.ListGradesReqDTO;
import com.notas.notas.domains.grades.dtos.resposne.GradeResDTO;
import com.notas.notas.domains.grades.mapper.GradeMapper;
import com.notas.notas.domains.grades.persistence.entities.GradeEntity;
import com.notas.notas.domains.grades.persistence.repositories.IGradeRepository;
import com.notas.notas.domains.students.services.IStudentService;
import com.notas.notas.domains.subjects.services.ISubjectService;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GradeService implements IGradeService{
    private final IGradeRepository gradeRepository;
    private final IStudentService studentService;
    private final ISubjectService subjectService;

    public GradeService(
            IGradeRepository gradeRepository,
            IStudentService studentService,
            ISubjectService subjectService
    ) {
        this.gradeRepository = gradeRepository;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @Override
    public GradeResDTO createGrade(CreateGradeReqDTO request) {
        if(this.studentService.findById(request.studentId()) == null) {
            throw new IllegalArgumentException("Student not found");
        }
        if(this.subjectService.getSubjectById(request.subjectId()) == null) {
            throw new IllegalArgumentException("Subject not found");
        }
        GradeEntity entity = GradeMapper.toEntityFrom(request);
        entity.setCreatedAt(LocalDateTime.now());
        GradeEntity saved = this.gradeRepository.save(entity);
        return GradeMapper.toResponseFrom(saved);
    }

    @Override
    public List<GradeResDTO> getGradesByStudentAndSubject(String studentId, Integer subjectId) {
        return this.gradeRepository.findAllByStudentIdAndSubjectId(studentId, subjectId)
                .stream()
                .map(GradeMapper::toResponseFrom)
                .toList();
    }
}
