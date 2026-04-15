package com.notas.notas.domains.students.mapper;

import com.notas.notas.domains.students.dtos.request.CreateStudentReqDTO;
import com.notas.notas.domains.students.dtos.request.UpdateStudentReqDTO;
import com.notas.notas.domains.students.dtos.response.StudentResDTO;
import com.notas.notas.domains.students.persistence.entities.StudentEntity;

import java.time.LocalDate;
import java.time.Period;

public class StudentMapper {
    public static StudentEntity toEntityFrom(CreateStudentReqDTO request){
        return new StudentEntity(
                request.id(),
                request.name(),
                request.lastname(),
                request.email(),
                request.birthdate()
        );
    }

    public static StudentEntity toEntityFrom(UpdateStudentReqDTO request){
        return new StudentEntity(
                null,
                request.name(),
                request.lastname(),
                request.email(),
                request.birthdate()
        );
    }


    public static StudentResDTO toResponseFrom(StudentEntity student){
        int age = Period
                .between(student.getBirthdate(), LocalDate.now())
                .getYears();
        return new StudentResDTO(
                student.getId(),
                student.getName(),
                student.getLastname(),
                student.getEmail(),
                student.getBirthdate(),
                age
        );
    }
}
