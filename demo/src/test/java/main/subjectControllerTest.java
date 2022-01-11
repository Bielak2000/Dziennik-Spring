package main;


import com.example.demo.*;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

public class subjectControllerTest {

    @Test
    public void function_CorrectList_True(){
        Subject2Controller s = new Subject2Controller();
        DataGenerator data = new DataGenerator();

        List<Subject2> lista = data.wczytajDaneZBazy();
        List<Subject2> lista1 = s.getSubjects();

        //assertEquals(lista,lista1);

        int i=0;
        for(Subject2 s1 : lista){
            assertEquals(s1.getName(), lista1.get(i).getName());
            i++;
        }

    }

    @Test
    public void function_CorrectSubject_True(){
        Subject2Controller s = new Subject2Controller();
        DataGenerator data = new DataGenerator();

        List<Subject2> lista = data.wczytajDaneZBazy();
        Subject2 przedmiot = s.getSinglePrzedmiot(1);


        assertEquals(przedmiot.getName(), lista.get(0).getName());
    }

    @Test
    public void function_CorrectSubject_ThrowException(){
        Subject2Controller s = new Subject2Controller();

        ResponseStatusException r = Assertions.assertThrows(ResponseStatusException.class, ()->{
            s.getSinglePrzedmiot(100);
        });

        Assertions.assertEquals("404 NOT_FOUND \"Nie znaleziono przedmiotu o tym id\"; nested exception is exception.SubjectNotFoundException: Nie znaleziono przedmiotu o id 100", r.getMessage());
    }

    @Test
    public void function_CorrectStudents_True(){
        Subject2Controller s = new Subject2Controller();
        DataGenerator data = new DataGenerator();

        List<Subject2> lista = data.wczytajDaneZBazy();
        List<Student> listaStudentow = s.getStudents(1);

        List<Student> listaS = lista.get(1).getStudenci();

        int i=0;
        for(Student st : listaS){
            assertEquals(listaStudentow.get(i).getNumberOfAlbum(), st.getNumberOfAlbum());
            i++;
        }
    }

    @Test
    public void function_CorrectStudents_ThrowException(){
        Subject2Controller s = new Subject2Controller();

        ResponseStatusException r = Assertions.assertThrows(ResponseStatusException.class, ()->{
            s.getStudents(100);
        });

        Assertions.assertEquals("404 NOT_FOUND \"Nie znaleziono przedmiotu o tym id\"; nested exception is exception.SubjectNotFoundException: Nie znaleziono przedmiotu o id 100", r.getMessage());
    }

    @Test
    public void function_CorrectStudentsCSV_True() throws IOException {
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        Session session = e1.unwrap(Session.class);
        List<Subject2> listad = session.createQuery("from Subject2", Subject2.class).getResultList();
        List<Student> listaStudentow10= new ArrayList<>();
        boolean temp;
        for(Subject2 s : listad){
            s.getStudenci();
            s.getName();
            s.getListaWszystkichOcen();
            temp=false;
            for(Student s3 : s.getStudenci()) {
                for (Student s2 : listaStudentow10) {
                    if (s3.getName().equals(s2.getName()) && s3.getSurname().equals(s2.getSurname())){
                        temp=true;
                    }
                }
                if(!temp){
                    listaStudentow10.add(s3);
                }
            }
            s.getStanyStudenta();
            s.printAll();
        }
        session.close();

        Subject2Controller s = new Subject2Controller();
        List<Student> listaStudentow = s.getStudents();
        int i=0;
        for(Student st : listaStudentow){
            assertEquals(listaStudentow10.get(i).getNumberOfAlbum(), st.getNumberOfAlbum());
            i++;
        }

    }

    @Test
    public void function_CorrectOceny_True(){
        Subject2Controller s = new Subject2Controller();
        DataGenerator data = new DataGenerator();

        List<Subject2> lista = data.wczytajDaneZBazy();
        List<Oceny> listaOcen = s.getOceny(1,1);
        Subject2 przedmiot = new Subject2();
        for(Subject2 su : lista){
            if(su.getId()==1){
                przedmiot = su;
            }
        }
        List<Oceny> listaOcen1 = przedmiot.getListaWszystkichOcen();
        for(Oceny o : listaOcen1){
            System.out.println(o.getS().getName() + " " + o.getS().getSurname());
        }
        Student student = new Student();
        for(Student st : lista.get(1).getStudenci()){
            if(st.getId()==1){
                student = st;
            }
        }
        List<Oceny> listaOcen2 = new ArrayList<>();
        for(Oceny o : listaOcen1){
            if(o.getS().getSurname().equals(student.getSurname()) && o.getS().getName().equals(student.getName())) {
                listaOcen2.add(o);
            }
        }
        int i=0;
        for(Oceny o : listaOcen){
            assertEquals(listaOcen2.get(i).getOcena(), o.getOcena());
            i++;
        }
    }

    @Test
    public void function_CorrectOceny_ThrowException(){
        Subject2Controller s = new Subject2Controller();

        ResponseStatusException r = Assertions.assertThrows(ResponseStatusException.class, ()->{
            s.getOceny(100,100);
        });

        Assertions.assertEquals("404 NOT_FOUND \"Nie znaleziono przedmiotu lub studenta!\"; nested exception is exception.SubjectNotFoundException: Nie znaleziono przedmiotu o id 100", r.getMessage());
    }

    @Test
    public void function_CorrectSubjectAdd_True(){
        Subject2Controller s = new Subject2Controller();

        Subject2 s2 = new Subject2("PR");

        assertEquals(s.addSubject(s2).getName(), s2.getName());
    }


    @Test
    public void function_CorrectSubjectAdd_ThrowException(){
        Subject2Controller s = new Subject2Controller();
        Subject2 s2 = new Subject2();

        ResponseStatusException r = Assertions.assertThrows(ResponseStatusException.class, ()->{
            s.addSubject(s2);
        });

        Assertions.assertEquals("400 BAD_REQUEST \"Nie podano nazwy przedmiotu!\"; nested exception is exception.EmptyData: Brak nazwy przedmiotu..", r.getMessage());
    }

    @Test
    public void function_CorrectStudentAdd_True(){
        Subject2Controller s = new Subject2Controller();

        Student st = new Student();
        st.setNumberOfAlbum("sdasdasd");

        assertEquals(s.addStudent(st).getNumberOfAlbum(), st.getNumberOfAlbum());
   }

   @Test
    public void function_CorrectStudentAdd_ThrowException(){
        Subject2Controller s = new Subject2Controller();
        Student st = new Student();

        ResponseStatusException r = Assertions.assertThrows(ResponseStatusException.class, ()->{
            s.addStudent(st);
        });

        Assertions.assertEquals("400 BAD_REQUEST \"Nie podano numeru albumu!\"; nested exception is exception.EmptyData: Brak numeru albumu...", r.getMessage());
    }

    @Test
    public void function_CorrectKomAdd_True(){
        Subject2Controller s = new Subject2Controller();

        Rating kom = new Rating();
        kom.setOcena(2);
        kom.setPrzedmiot("PR");

        assertEquals(s.addKom(kom).getOcena(), kom.getOcena());
    }

    @Test
    public void function_CorrectKomAdd_ThrowException(){
        Subject2Controller s = new Subject2Controller();
        Rating kom = new Rating();

        ResponseStatusException r = Assertions.assertThrows(ResponseStatusException.class, ()->{
            s.addKom(kom);
        });

        Assertions.assertEquals("400 BAD_REQUEST \"Nie podano oceny lub nazwy przedmiotu!\"; nested exception is exception.EmptyData: Brak oceny lub nazwy przedmiotu...", r.getMessage());
    }

    @Test
    public void function_DeleteSubject_ThrowException(){
        Subject2Controller s = new Subject2Controller();

        ResponseStatusException r = Assertions.assertThrows(ResponseStatusException.class, ()->{
            s.deleteSubject(100);
        });

        Assertions.assertEquals("404 NOT_FOUND \"Nie znaleziono przedmiotu o tym id\"; nested exception is exception.SubjectNotFoundException: Nie znaleziono przedmiotu o id 100", r.getMessage());
    }

    @Test
    public void function_DeleteStudent_ThrowException(){
        Subject2Controller s = new Subject2Controller();

        ResponseStatusException r = Assertions.assertThrows(ResponseStatusException.class, ()->{
            s.deleteStudent(100);
        });

        Assertions.assertEquals("404 NOT_FOUND \"Nie znaleziono studenta o tym id\"; nested exception is exception.SubjectNotFoundException: Nie znaleziono przedmiotu o id 100", r.getMessage());
    }

    @Test
    public void function_DeleteStudent_True(){
        Subject2Controller s = new Subject2Controller();

        Student st = s.deleteStudent(34);

        assertEquals(st.getId(), 34);
    }

    @Test
    public void function_DeleteSubject_True(){
        Subject2Controller s = new Subject2Controller();

        Subject2 st = s.deleteSubject(33);

        assertEquals(st.getId(), 33);
    }


}
