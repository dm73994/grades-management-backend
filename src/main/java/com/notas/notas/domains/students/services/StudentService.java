package com.notas.notas.domains.students.services;

import com.notas.notas.domains.students.dtos.request.CreateStudentReqDTO;
import com.notas.notas.domains.students.dtos.request.UpdateStudentReqDTO;
import com.notas.notas.domains.students.dtos.response.StudentResDTO;
import com.notas.notas.domains.students.mapper.StudentMapper;
import com.notas.notas.domains.students.persistence.entities.StudentEntity;
import com.notas.notas.domains.students.persistence.repositories.IStudentPersistenceRepository;
import com.notas.notas.exceptions.custom.ValueShouldBeUniqueException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    private final IStudentPersistenceRepository studentPersistenceRepository;

    public StudentService(IStudentPersistenceRepository studentPersistenceRepository) {
        this.studentPersistenceRepository = studentPersistenceRepository;
    }

    @Override
    public StudentResDTO save(CreateStudentReqDTO student) {
        if(this.studentPersistenceRepository.existsById(student.id())){
            throw new ValueShouldBeUniqueException("Student with id " + student.id() + " already exist");
        }
        if(this.studentPersistenceRepository.existsByEmail(student.email())){
            throw new ValueShouldBeUniqueException("Student with email " + student.email() + " already exist");
        }
        StudentEntity entity = StudentMapper.toEntityFrom(student);
        StudentEntity saved = this.studentPersistenceRepository.save(entity);
        return StudentMapper.toResponseFrom(saved);
    }

    @Override
    public List<StudentResDTO> findAll() {
        return this.studentPersistenceRepository.findAll()
                .stream()
                .map(StudentMapper::toResponseFrom)
                .toList();
    }

    @Override
    public StudentResDTO findById(String id) {
        Optional<StudentEntity> entity = this.studentPersistenceRepository.findById(id);

        if(entity.isEmpty()){
            throw new EntityNotFoundException("Student with id " + id + " does not exist");
        }

        return StudentMapper.toResponseFrom(entity.get());
    }

    @Override
    public StudentResDTO update(String id, UpdateStudentReqDTO student) {
        Optional<StudentEntity> studentEntity = this.studentPersistenceRepository.findById(id);
        if(studentEntity.isEmpty()){
            throw new EntityNotFoundException("Student with id " + id + " does not exist");
        }
        StudentEntity entity = studentEntity.get();
        entity.setName(student.name());
        entity.setEmail(student.email());
        entity.setLastname(student.lastname());
        entity.setBirthdate(student.birthdate());

        StudentEntity updated = this.studentPersistenceRepository.save(entity);
        return StudentMapper.toResponseFrom(updated);
    }

    @Override
    public void delete(String id) {
        Optional<StudentEntity> studentEntity = this.studentPersistenceRepository.findById(id);
        if(studentEntity.isEmpty()){
            throw new EntityNotFoundException("Student with id " + id + " does not exist");
        }
        this.studentPersistenceRepository.deleteById(id);
    }
}
