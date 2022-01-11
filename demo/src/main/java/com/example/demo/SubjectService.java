package com.example.demo;

import exception.EmptyData;
import exception.SubjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private DataGenerator data = new DataGenerator();

    public List<Subject2> getSubjects(){
        return data.wczytajDaneZBazy();
    }

    public Subject2 getSingleSubject(int id){
        List<Subject2> listaPrzedmiotow = data.wczytajDaneZBazy();
        Subject2 s = new Subject2();
        boolean temp=false;
        for(Subject2 s1 : listaPrzedmiotow){
            if(s1.getId()==id){
                s=s1;
                temp=true;
                break;
            }
        }
        if(temp)
            return s;
        else
            throw new SubjectNotFoundException(id);
    }

    public List<Student> getStudents(int id){
        List<Subject2> listaPrzedmiotow = data.wczytajDaneZBazy();
        Subject2 s = new Subject2();
        boolean temp=false;
        for(Subject2 s1 : listaPrzedmiotow){
            if(s1.getId()==id){
                s=s1;
                temp=true;
                break;
            }
        }
        if(temp)
            return s.getStudenci();
        else
            throw new SubjectNotFoundException(id);
    }

    public List<Student> getStudentsCSV() throws IOException {
        return data.exportToCSVDBStudents();
    }

    public List<Oceny> getOceny(int id, int id1){
        List<Subject2> listaPrzedmiotow = data.wczytajDaneZBazy();
        List<Oceny> listaOcen = new ArrayList<>();
        List<Student> listaStudentow = data.wczytajDaneZBazyStudenci();
        Subject2 s = new Subject2();
        boolean temp;
        boolean temp1 = false;
        boolean temp2 = false;
        Student student = new Student();
        for(Subject2 s1 : listaPrzedmiotow){
            if(s1.getId()==id){
                s=s1;
                temp1=true;
                break;
            }
        }

        for(Student s1 : listaStudentow){
            if(s1.getId()==id1) {
                temp2=true;
                student = s1;
                break;
            }
        }

        System.out.println("temp1" + temp1 + ", temp2"+temp2);

        if(temp1==true && temp2==true) {
            for (Oceny o : s.getListaWszystkichOcen()) {
                if (o.getS().getSurname().equals(student.getSurname()) && o.getS().getName().equals(student.getName()))
                    listaOcen.add(o);
            }
            return listaOcen;
        }
        else if(!temp1){
            throw new SubjectNotFoundException(id);
        }
        else if(!temp2)
            throw new SubjectNotFoundException(id1);
        else
            throw new SubjectNotFoundException(id, id1);
    }

    public Subject2 addSubject(Subject2 s) {
        if(s.getName()==null){
           throw new EmptyData("Brak nazwy przedmiotu..");
        }
        else {
            List<Subject2> listaPrzedmiotow = data.wczytajDaneZBazy();
            listaPrzedmiotow.add(s);
            data.zapiszDoBazyPrzedmioty2(listaPrzedmiotow);
            return s;
        }
    }

    public Student addStudent(Student s) {
        if(s.getNumberOfAlbum()==null){
            throw new EmptyData("Brak numeru albumu...");
        }
        else {
            List<Student> listaStudentow = data.wczytajDaneZBazyStudenci();
            listaStudentow.add(s);
            data.zapiszDoBazyStudentow2(listaStudentow);
            return s;
        }
    }

    public Rating addKom(Rating s) {
        if(s.getOcena()==0 || s.getPrzedmiot()==null){
            throw new EmptyData("Brak oceny lub nazwy przedmiotu...");
        }
        else {
            data.zapiszDoBazyRating(s);
            return s;
        }
    }

    public Subject2 deleteSubject(int id) {
        List<Subject2> listaPrzedmiotow = data.wczytajDaneZBazy();
        Subject2 s3 = null;
        boolean temp=false;
        for(Subject2 s : listaPrzedmiotow){
            if(s.getId()==id){
                s3=s;
                temp=true;
                break;
            }
        }
        if(temp) {
            data.zapiszDoBazyPrzedmioty3(s3);
            return s3;
        }
        else
            throw new SubjectNotFoundException(id);
    }

    public Student deleteStudent(int id) {
        List<Student> listaPrzedmiotow = data.wczytajDaneZBazyStudenci2();
        Student s3 = new Student();
        boolean temp=false;
        for(Student s : listaPrzedmiotow){
            if(s.getId()==id){
                s3=s;
                temp=true;
                break;
            }
        }
        if(temp) {
            data.zapiszDoBazyStudentow3(s3);
            return s3;
        }
        else
            throw new SubjectNotFoundException(id);
    }
}
