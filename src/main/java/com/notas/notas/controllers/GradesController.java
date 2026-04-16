package com.notas.notas.controllers;

import com.notas.notas.domains.grades.dtos.request.CreateGradeReqDTO;
import com.notas.notas.domains.grades.dtos.resposne.GradeResDTO;
import com.notas.notas.domains.grades.services.IGradeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grades")
public class GradesController {
    private final IGradeService gradeService;

    public GradesController(IGradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public ResponseEntity<GradeResDTO> createGrade(@RequestBody @Valid CreateGradeReqDTO request) {
        GradeResDTO createdGrade = gradeService.createGrade(request);
        return ResponseEntity.ok(createdGrade);
    }

    @GetMapping
    public ResponseEntity<List<GradeResDTO>> getGradesBy(
            @RequestParam(required = true) String studentId,
            @RequestParam(required = true) Integer subjectId
    ) {
        List<GradeResDTO> grades = gradeService.getGradesByStudentAndSubject(studentId, subjectId);
        return ResponseEntity.ok(grades);
    }
}
