package com.notas.notas.domains.students.services;

import com.notas.notas.domains.students.dtos.request.CreateStudentReqDTO;
import com.notas.notas.domains.students.dtos.request.UpdateStudentReqDTO;
import com.notas.notas.domains.students.dtos.response.StudentResDTO;
import java.util.List;
import java.util.Optional;

public interface IStudentService {
    StudentResDTO save(CreateStudentReqDTO student);
    List<StudentResDTO> findAll();
    StudentResDTO findById(String id);
    StudentResDTO update(String id, UpdateStudentReqDTO student);
    void delete(String id);
}
