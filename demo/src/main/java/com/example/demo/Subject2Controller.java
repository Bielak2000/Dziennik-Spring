package com.example.demo;

import exception.EmptyData;
import exception.SubjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Subject2Controller {

    @Autowired
    private SubjectService subjectService = new SubjectService();

    @GetMapping("/przedmioty")
    public List<Subject2> getSubjects(){
        List<Subject2> lista = subjectService.getSubjects();
        return lista;
    }

    @GetMapping("/przedmioty/{id}")
    public Subject2 getSinglePrzedmiot(@PathVariable int id){
        try {
            return subjectService.getSingleSubject(id);
        }catch (SubjectNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie znaleziono przedmiotu o tym id", e);
        }
    }

    @GetMapping("/przedmioty/{id}/studenci")
    public List<Student> getStudents(@PathVariable int id){
        try{
        return subjectService.getStudents(id);
    }catch (SubjectNotFoundException e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie znaleziono przedmiotu o tym id", e);
    }
    }

    @GetMapping("/przedmioty/studenci/csv")
    public List<Student> getStudents() throws IOException {
        return subjectService.getStudentsCSV();
    }

    @GetMapping("/przedmioty/{id}/studenci/{id1}/grade")
    public List<Oceny> getOceny(@PathVariable int id,@PathVariable int id1){
        try {
            return subjectService.getOceny(id, id1);
        }catch (SubjectNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie znaleziono przedmiotu lub studenta!", e);
        }
    }

    @PostMapping("/przedmioty")
    public Subject2 addSubject(@RequestBody Subject2 s){
        try {
            return subjectService.addSubject(s);
        }catch(EmptyData e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nie podano nazwy przedmiotu!", e);
        }
    }

    @PostMapping("/studenci")
    public Student addStudent(@RequestBody Student s){
        try{
        return subjectService.addStudent(s);
        }catch(EmptyData e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nie podano numeru albumu!", e);
        }
    }

    @PostMapping("/komentarz")
    public Rating addKom(@RequestBody Rating s){
        try{
            return subjectService.addKom(s);
        }catch(EmptyData e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nie podano oceny lub nazwy przedmiotu!", e);
        }
    }

    @DeleteMapping("/przedmioty/{id}")
    public Subject2 deleteSubject(@PathVariable int id){
        try{
            return subjectService.deleteSubject(id);
        }catch (SubjectNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie znaleziono przedmiotu o tym id", e);
        }
    }

    @DeleteMapping("/studenci/{id}")
    public Student deleteStudent(@PathVariable int id){
        try{
        return subjectService.deleteStudent(id);
    }catch (SubjectNotFoundException e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie znaleziono studenta o tym id", e);
    }
    }
}
