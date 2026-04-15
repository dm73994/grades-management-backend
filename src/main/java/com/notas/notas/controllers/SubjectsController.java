package com.notas.notas.controllers;

import com.notas.notas.domains.subjects.dtos.request.CreateSubjectReqDTO;
import com.notas.notas.domains.subjects.dtos.response.SubjectResDTO;
import com.notas.notas.domains.subjects.services.ISubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectsController {
    private final ISubjectService subjectService;

    public SubjectsController(
            ISubjectService subjectService
    ) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public ResponseEntity<SubjectResDTO> createSubject(@RequestBody CreateSubjectReqDTO request) {
        var subject = this.subjectService.createSubject(request);
        return ResponseEntity.ok(subject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResDTO> getSubjectById(@PathVariable int id) {
        var subject = this.subjectService.getSubjectById(id);
        return ResponseEntity.ok(subject);
    }

    @GetMapping
    public ResponseEntity<List<SubjectResDTO>> listAllSubjects() {
        var subjects = this.subjectService.listAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectResDTO> updateSubject(@PathVariable int id, @RequestBody CreateSubjectReqDTO request) {
        var subject = this.subjectService.updateSubject(id, request);
        return ResponseEntity.ok(subject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable int id) {
        this.subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
