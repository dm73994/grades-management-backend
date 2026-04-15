package com.notas.notas.domains.grades.services;

import com.notas.notas.domains.grades.dtos.request.CreateGradeReqDTO;
import com.notas.notas.domains.grades.dtos.request.ListGradesReqDTO;
import com.notas.notas.domains.grades.dtos.resposne.GradeResDTO;

import java.util.List;

public interface IGradeService {
    GradeResDTO createGrade(CreateGradeReqDTO request);
    List<GradeResDTO> getGradesByStudentAndSubject(String studentId, Integer subjectId);
}
