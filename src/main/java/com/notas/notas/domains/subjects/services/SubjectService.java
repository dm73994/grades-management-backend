package com.notas.notas.domains.subjects.services;

import com.notas.notas.domains.subjects.dtos.request.CreateSubjectReqDTO;
import com.notas.notas.domains.subjects.dtos.response.SubjectResDTO;
import com.notas.notas.domains.subjects.mapper.SubjectMapper;
import com.notas.notas.domains.subjects.persistence.entities.SubjectEntity;
import com.notas.notas.domains.subjects.persistence.repositories.ISubjectRepository;
import com.notas.notas.exceptions.custom.ValueShouldBeUniqueException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubjectService implements ISubjectService{
    private final ISubjectRepository subjectRepository;

    public SubjectService(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectResDTO createSubject(CreateSubjectReqDTO request) {
        if(this.subjectRepository.existsByCode(request.code())){
            throw new ValueShouldBeUniqueException("Subject with code " + request.code() + " already exists");
        }
        if(this.subjectRepository.existsByName(request.name())){
            throw new ValueShouldBeUniqueException("Subject with name " + request.name() + " already exists");
        }

        SubjectEntity entity = SubjectMapper.toEntityFrom(request);

        LocalDateTime now = LocalDateTime.now();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);

        SubjectEntity saved = this.subjectRepository.save(entity);
        return SubjectMapper.toResponseFrom(saved);
    }

    @Override
    public List<SubjectResDTO> listAllSubjects() {
        return this.subjectRepository.findAll()
                .stream()
                .map(SubjectMapper::toResponseFrom)
                .toList();
    }

    @Override
    public SubjectResDTO getSubjectById(int id) {
        return this.subjectRepository.findById(id)
                .map(SubjectMapper::toResponseFrom)
                .orElseThrow(() -> new EntityNotFoundException("Subject with id " + id + " does not exist"));
    }

    @Override
    public SubjectResDTO updateSubject(int id, CreateSubjectReqDTO request) {
        SubjectEntity entity = this.subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject with id " + id + " does not exist"));

        if(this.subjectRepository.existsByCode(request.code()) && !entity.getCode().equals(request.code())){
            throw new EntityExistsException("Subject with code " + request.code() + " already exists");
        }

        entity.setName(request.name());
        entity.setCode(request.code());
        entity.setCredits(request.credits());
        entity.setUpdatedAt(LocalDateTime.now());

        SubjectEntity updated = this.subjectRepository.save(entity);
        return SubjectMapper.toResponseFrom(updated);
    }

    @Override
    public void deleteSubject(int id) {
        if(!this.subjectRepository.existsById(id)){
            throw new EntityNotFoundException("Subject with id " + id + " does not exist");
        }
        this.subjectRepository.deleteById(id);
    }
}
