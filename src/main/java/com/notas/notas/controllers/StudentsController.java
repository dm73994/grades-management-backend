package com.notas.notas.controllers;

import com.notas.notas.domains.students.dtos.request.CreateStudentReqDTO;
import com.notas.notas.domains.students.dtos.request.UpdateStudentReqDTO;
import com.notas.notas.domains.students.dtos.response.StudentResDTO;
import com.notas.notas.domains.students.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {
    private final IStudentService studentService;

    public StudentsController(
            IStudentService studentRepository
    ) {
        this.studentService = studentRepository;
    }


    @PostMapping
    public ResponseEntity<StudentResDTO> createStudent(@RequestBody @Valid CreateStudentReqDTO req) {
        var student = this.studentService.save(req);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResDTO> getStudentById(@PathVariable String id) {
        var student = this.studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<StudentResDTO>> listAllStudents() {
        var students = this.studentService.findAll();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResDTO> updateStudent(@PathVariable String id, @RequestBody @Valid UpdateStudentReqDTO req) {
        var student = this.studentService.update(id, req);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        this.studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
