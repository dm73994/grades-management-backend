package com.notas.notas.domains.subjects.services;

import com.notas.notas.domains.subjects.dtos.request.CreateSubjectReqDTO;
import com.notas.notas.domains.subjects.dtos.response.SubjectResDTO;

import java.util.List;

public interface ISubjectService {
    SubjectResDTO createSubject(CreateSubjectReqDTO request);
    List<SubjectResDTO> listAllSubjects();
    SubjectResDTO getSubjectById(int id);
    SubjectResDTO updateSubject(int id, CreateSubjectReqDTO request);
    void deleteSubject(int id);
}
