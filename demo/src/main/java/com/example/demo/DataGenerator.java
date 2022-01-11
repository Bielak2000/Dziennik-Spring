package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataGenerator {
    List<Student> listaS = new ArrayList<>();
    List<Student> listaS1 = new ArrayList<>();
    ObservableList<Subject2> listaPrzedmiotowG;
    ObservableList<Subject2> listaPrzedmiotowG1 = FXCollections.observableArrayList();

    public List<Student> uzupelnijListeStudentow(){
        Student s = new Student("2", "Kacper1", "X", StudentCondition.current, 2000, 2.3);
        Student s1 = new Student("3", "Kacper", "Bielak1", StudentCondition.belated, 2000, 5);
        Student s2 = new Student("3", "Kacper", "X", StudentCondition.current, 2000, 2.3);
        Student s3 = new Student("3", "Kacper3", "X", StudentCondition.current, 2000, 2.3);
        Student s4 = new Student("3", "Kacper4", "X", StudentCondition.current, 2000, 2.3);
        Student s5 = new Student("3", "Kacper5", "X", StudentCondition.current, 2000, 2.3);
        Student s6 = new Student("3", "Kacper6", "X", StudentCondition.current, 2000, 2.3);
        Student s7 = new Student("3", "Kacper7", "X", StudentCondition.current, 2000, 2.3);
        Student s8 = new Student("3", "Kacper8", "X", StudentCondition.current, 2000, 2.3);
        Student s9 = new Student("3", "Kacper9", "X", StudentCondition.current, 2000, 2.3);
        Student s10 = new Student("3", "Kacper11", "X", StudentCondition.current, 2000, 2.3);
        Student s11 = new Student("3", "Kacper12", "X", StudentCondition.current, 2000, 2.3);
        Student s12 = new Student("3", "Kacper13", "X", StudentCondition.current, 2000, 2.3);
        Student s13 = new Student("3", "Kacper14", "X", StudentCondition.current, 2000, 2.3);
        Student s14 = new Student("3", "Kacper15", "X", StudentCondition.current, 2000, 2.3);
        Student s15 = new Student("3", "Kacper116", "X", StudentCondition.current, 2000, 2.3);
        Student s16 = new Student("3", "Kacper1167", "X", StudentCondition.current, 2000, 2.3);
        List<Student> listaStudentow = new ArrayList<>();
        listaStudentow.add(s);
        listaStudentow.add(s1);
        listaStudentow.add(s2);
        listaStudentow.add(s3);
        listaStudentow.add(s4);
        listaStudentow.add(s5);
        listaStudentow.add(s6);
        listaStudentow.add(s7);
        listaStudentow.add(s8);
        listaS = listaStudentow;
        return listaStudentow;
    }

    public List<Student> uzupelnijListeStudentow2(){
        Student s = new Student("2", "Kacper1", "X", StudentCondition.current, 2000);
        Student s1 = new Student("3", "Kacper", "Bielak1", StudentCondition.belated, 2000);
        Student s2 = new Student("3", "Kacper", "X", StudentCondition.current, 2000);
        Student s3 = new Student("3", "Kacper3", "X", StudentCondition.current, 2000);
        Student s4 = new Student("3", "Kacper4", "X", StudentCondition.current, 2000);
        Student s5 = new Student("3", "Kacper5", "X", StudentCondition.current, 2000);
        Student s6 = new Student("3", "Kacper6", "X", StudentCondition.current, 2000);
        Student s7 = new Student("3", "Kacper7", "X", StudentCondition.current, 2000);
        Student s8 = new Student("3", "Kacper8", "X", StudentCondition.current, 2000);
        Student s9 = new Student("3", "Kacper9", "X", StudentCondition.current, 2000);
        Student s10 = new Student("3", "Kacper11", "X", StudentCondition.current, 2000);
        Student s11 = new Student("3", "Kacper12", "X", StudentCondition.current, 2000);
        Student s12 = new Student("3", "Kacper13", "X", StudentCondition.current, 2000);
        Student s13 = new Student("3", "Kacper14", "X", StudentCondition.current, 2000);
        Student s14 = new Student("3", "Kacper15", "X", StudentCondition.current, 2000);
        Student s15 = new Student("3", "Kacper116", "X", StudentCondition.current, 2000);
        Student s16 = new Student("3", "Kacper1167", "X", StudentCondition.current, 2000);
        List<Student> listaStudentow1 = new ArrayList<>();
        listaStudentow1.add(s);
        listaStudentow1.add(s1);
        listaStudentow1.add(s2);
        listaStudentow1.add(s3);
        listaStudentow1.add(s4);
        listaStudentow1.add(s5);
        listaStudentow1.add(s6);
        listaStudentow1.add(s7);
        listaStudentow1.add(s8);
        listaStudentow1.add(s9);
        listaStudentow1.add(s10);
        listaStudentow1.add(s11);
        listaStudentow1.add(s12);
        listaStudentow1.add(s13);
        listaStudentow1.add(s14);
        listaStudentow1.add(s15);
        listaStudentow1.add(s16);
        listaS1 = listaStudentow1;
        return listaStudentow1;
    }

    public ObservableList<Subject2> uzupelnijListePrzedmiotow(){
        ObservableList<Subject2> listaPrzedmiotow = FXCollections.observableArrayList(
                new Subject2("Analiza"),
                new Subject2("Algebra"),
                new Subject2("Analiza2"),
                new Subject2("Java")
        );
        //Subject2 s1 = new Subject2("Analiza");
        //Subject2 s2 = new Subject2("Algebra");
        //Subject2 s3 = new Subject2("Analiza2");
        //Subject2 s4 = new Subject2("Java");

        listaPrzedmiotow.get(0).addStudent(listaS1.get(0), "Zapisany");
        listaPrzedmiotow.get(0).addStudent(listaS1.get(1), "Zapisany");
        listaPrzedmiotow.get(0).addStudent(listaS1.get(2), "Zapisany");
        listaPrzedmiotow.get(0).addStudent(listaS1.get(3), "Zapisany");
        listaPrzedmiotow.get(0).addStudent(listaS1.get(4), "Zapisany");
        listaPrzedmiotow.get(0).addStudent(listaS1.get(5), "Zapisany");
        listaPrzedmiotow.get(0).addOcena(2, listaS1.get(0));
        listaPrzedmiotow.get(1).addOcena(3, listaS1.get(0));
        listaPrzedmiotow.get(2).addOcena(4, listaS1.get(0));
        listaPrzedmiotow.get(3).addOcena(2, listaS1.get(0));
        listaPrzedmiotow.get(1).addOcena(5, listaS1.get(0));
        listaPrzedmiotow.get(0).addOcena(3, listaS1.get(0));
        listaPrzedmiotow.get(3).addOcena(3, listaS1.get(0));
        listaPrzedmiotow.get(0).addOcena(4, listaS1.get(0));
        listaPrzedmiotow.get(2).addOcena(2, listaS1.get(0));
        listaPrzedmiotow.get(3).addOcena(3, listaS1.get(0));
        listaPrzedmiotow.get(1).addOcena(4, listaS1.get(0));
        listaPrzedmiotow.get(2).addOcena(2, listaS1.get(0));
        listaPrzedmiotow.get(0).addOcena(5, listaS1.get(0));
        listaPrzedmiotow.get(1).addOcena(3, listaS1.get(0));
        listaPrzedmiotow.get(2).addOcena(3, listaS1.get(0));
        listaPrzedmiotow.get(3).addOcena(4, listaS1.get(0));


        listaPrzedmiotow.get(1).addStudent(listaS1.get(0), "Zapisany");
        listaPrzedmiotow.get(1).addStudent(listaS1.get(1), "Zapisany");
        listaPrzedmiotow.get(1).addStudent(listaS1.get(2), "Zapisany");
        listaPrzedmiotow.get(1).addStudent(listaS1.get(3), "Zapisany");
        listaPrzedmiotow.get(1).addStudent(listaS1.get(4), "Zapisany");

        listaPrzedmiotow.get(2).addStudent(listaS1.get(0), "Zapisany");
        listaPrzedmiotow.get(2).addStudent(listaS1.get(1), "Zapisany");
        listaPrzedmiotow.get(2).addStudent(listaS1.get(2), "Zapisany");
        listaPrzedmiotow.get(2).addStudent(listaS1.get(3), "Zapisany");
        listaPrzedmiotow.get(2).addStudent(listaS1.get(4), "Zapisany");

        listaPrzedmiotow.get(3).addStudent(listaS1.get(0), "Zapisany");
        listaPrzedmiotow.get(3).addStudent(listaS1.get(1), "Zapisany");

        listaPrzedmiotowG=listaPrzedmiotow;

        return listaPrzedmiotow;
    }

    public void dodajStudentaDoPrzedmiotu(String nazwa, Student s){
        for(Subject2 su : listaPrzedmiotowG1){
            if(su.getName().equals(nazwa)){
                su.addStudent(s, "Oczekuje na zapisanie");
                break;
            }
        }
    }

    public void zmienDane(String imie, String nazwisko, Student s){
        for(Student st : listaS1){
            if(st.getName().equals(imie) && st.getSurname().equals(nazwisko)){
                st.setName(s.getName());
                st.setSurame(s.getSurname());
                st.setNumberOfAlbum(s.getNumberOfAlbum());
                st.setYearOfBirth(s.getYearOfBirth());
            }
        }
    }

    public void serialization() throws IOException, IllegalAccessException {
        /*ArrayList<Object> args = new ArrayList<Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            if(!field.isAnnotationPresent(DontSerialize.class)){
                field.set(this, field.get(this));
                //continue;
            }
            args.add(field.get(this));
        }

        ObjectOutputStream doZapisu = new ObjectOutputStream(new FileOutputStream("zapis.file"));
        doZapisu.writeObject(args);
        */

        List<Subject2> lista = new ArrayList<>();
        for(Subject2 s : listaPrzedmiotowG1) {
            lista.add(s);
        }
        ObjectOutputStream doZapisu = new ObjectOutputStream(new FileOutputStream("zapis.file"));
        doZapisu.writeObject(lista);
    }

    public void serializationStudents() throws IOException, IllegalAccessException {
        /*ArrayList<Object> args = new ArrayList<Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            if(!field.isAnnotationPresent(DontSerialize.class)){
                field.set(this, field.get(this));
                //continue;
            }
            args.add(field.get(this));
        }

        ObjectOutputStream doZapisu = new ObjectOutputStream(new FileOutputStream("zapis.file"));
        doZapisu.writeObject(args);
        */

        List<Student> lista = new ArrayList<>();
        for(Student s : listaS1) {
            lista.add(s);
        }
        //lista.add(new Student("2", "Kacper10", "X", StudentCondition.current, 2000));
        ObjectOutputStream doZapisu = new ObjectOutputStream(new FileOutputStream("zapisStudent.file"));
        doZapisu.writeObject(lista);
    }

    public List<Subject2> deseralization() throws IOException, ClassNotFoundException {
        // = new ArrayList<>();
        //System.out.println("PRZED");
        ObjectInputStream doWczytania = new ObjectInputStream(new FileInputStream(new File("zapis.file")));
        //System.out.println("PO");
        List<Subject2> listaTempSubject2 = (List<Subject2>) doWczytania.readObject();
        int i;
        for(Subject2 s : listaTempSubject2){
            i=0;
            for(String s1 : s.getStanyStudenta()) {
                s.setStan(i, "Oczekuje na dodanie");
                i++;
            }
        }
        for(Subject2 s : listaTempSubject2){
            listaPrzedmiotowG1.add(s);
        }

        return listaTempSubject2;
    }

    public List<Student> deseralizationStudents() throws IOException, ClassNotFoundException {
        List<Student> listaTempSubject2 = new ArrayList<>();
        ObjectInputStream doWczytania = new ObjectInputStream(new FileInputStream(new File("zapisStudent.file")));
        listaTempSubject2 = (List<Student>) doWczytania.readObject();
        listaS1 = listaTempSubject2;

        return listaTempSubject2;
    }

    public List<Subject2> wczytanieCSVSubject2() throws IOException {
        List<Subject2> listaP = new ArrayList<>();
        String fileSubject2 = "C:\\Users\\User\\Desktop\\Uczelnia\\Java\\Spring\\demo\\Subject2.csv";
        BufferedReader reader = null;
        String line = "";
        reader = new BufferedReader(new FileReader(fileSubject2));
        while((line=reader.readLine())!=null){
            String[] row = line.split(";");
            for(String x : row){
                Subject2 temp = new Subject2(x);
                listaP.add(temp);
            }
        }
        reader.close();

        String fileStudenci = "C:\\Users\\User\\Desktop\\Uczelnia\\Java\\Spring\\demo\\Studenci.csv";
        BufferedReader reader1 = null;
        reader1 = new BufferedReader(new FileReader(fileStudenci));
        int b=0;
        while((line=reader1.readLine())!=null){
            String[] row = line.split(";");
            int i = row.length;
            i = i/6;
            for(int j =0; j<i; j++) {
                Student s = new Student(row[0+j*5], row[1+j*5], row[2+j*5], Integer.parseInt(row[4+j*5]), Double.parseDouble(row[5+j*5]));
                s.setCondition(row[3+j*5]);
                listaP.get(b).addStudent(s);
            }
            b++;
        }
        reader1.close();

        String fileOceny = "C:\\Users\\User\\Desktop\\Uczelnia\\Java\\Spring\\demo\\Oceny.csv";
        BufferedReader reader2 = null;
        reader2 = new BufferedReader(new FileReader(fileOceny));
        b=0;
        Student s2 = new Student();
        while((line=reader2.readLine())!=null){
            String[] row = line.split(";");
            int i = row.length;
            i = i/3;
            for(int j =0; j<i; j++) {
                for(Student s : listaP.get(b).getStudenci()){
                    if(row[0+j*3].equals(s.getName()) && row[1+j*3].equals(s.getSurname())) {
                        s2 = s;
                        break;
                    }
                }
                listaP.get(b).addOcena(Double.parseDouble(row[2+j*3]), s2);

            }
            b++;
        }
        reader2.close();

        String fileStany = "C:\\Users\\User\\Desktop\\Uczelnia\\Java\\Spring\\demo\\Stany.csv";
        BufferedReader reader3 = null;
        reader3 = new BufferedReader(new FileReader(fileStany));
        b=0;
        while((line=reader3.readLine())!=null){
            String[] row = line.split(";");
            for(String x : row){
                Subject2 temp = new Subject2(x);
                listaP.get(b).addStan(x);
            }
            b++;
        }
        reader3.close();

        //listaOdczytana=listaP;

        return listaP;
    }

    public void zapiszDoBazyStudentow(){
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        e1.getTransaction().begin();
        for(Student s : listaS1){
            e1.persist(s);//save
        }
        e1.getTransaction().commit();
        e.close();
    }

    public void zapiszDoBazyPrzedmioty(){
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        Session session = e1.unwrap(Session.class);
        //e1.getTransaction().begin();
        session.getTransaction().begin();
        for(Subject2 s : listaPrzedmiotowG){
            session.saveOrUpdate(s);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void zapiszDoBazyPrzedmioty2(List<Subject2> lista){
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        Session session = e1.unwrap(Session.class);
        session.getTransaction().begin();
        for(Subject2 s : lista){
            session.merge(s);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void zapiszDoBazyPrzedmioty3(Subject2 przedmiot){
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        Session session = e1.unwrap(Session.class);
        session.getTransaction().begin();
        session.remove(session.contains(przedmiot) ? przedmiot : session.merge(przedmiot));
        session.getTransaction().commit();
        session.close();
    }

    public void zapiszDoBazyStudentow2(List<Student> lista){
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        Session session = e1.unwrap(Session.class);
        session.getTransaction().begin();
        for(Student s : lista){
            session.merge(s);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void zapiszDoBazyStudentow3(Student studentt){
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        Session session = e1.unwrap(Session.class);
        session.getTransaction().begin();
        session.remove(session.contains(studentt) ? studentt : session.merge(studentt));
        session.getTransaction().commit();
        session.close();
    }

    public List<Subject2> wczytajDaneZBazy(){
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        Session session = e1.unwrap(Session.class);
        List<Subject2> lista = session.createQuery("from Subject2", Subject2.class).getResultList();
        for(Subject2 s : lista){
            s.getStudenci();
            s.getName();
            s.getListaWszystkichOcen();
            s.getStanyStudenta();
            s.printAll();
        }
        session.close();
        return lista;
    }

    public List<Student> wczytajDaneZBazyStudenci(){
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        Session session = e1.unwrap(Session.class);
        List<Student> lista = session.createQuery("from Student", Student.class).getResultList();
        session.close();
        return lista;
    }

    //criteria
    public List<Student> wczytajDaneZBazyStudenci2(){
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        CriteriaBuilder builder = e1.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> root = criteria.from(Student.class);
        criteria.select(root);
        List<Student> lista = e1.createQuery(criteria).getResultList();
        return lista;
    }

    public void zapiszDoBazyRating(Rating r){
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        Session session = e1.unwrap(Session.class);
        session.getTransaction().begin();
        session.merge(r);
        session.getTransaction().commit();
        session.close();
    }

    public void exportToCSVDB() throws IOException {
        EntityManagerFactory e = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager e1 = e.createEntityManager();
        Session session = e1.unwrap(Session.class);
        List<Subject2> listad = session.createQuery("from Subject2", Subject2.class).getResultList();
        for(Subject2 s : listad){
            s.getStudenci();
            s.getName();
            s.getListaWszystkichOcen();
            s.getStanyStudenta();
            s.printAll();
        }
        session.close();

        FileWriter csvFile = new FileWriter("Subject2.csv");
        BufferedWriter out = new BufferedWriter(csvFile);
        FileWriter csvFile1 = new FileWriter("Oceny2.csv");
        BufferedWriter out1 = new BufferedWriter(csvFile1);
        FileWriter csvFile2 = new FileWriter("Stany2.csv");
        BufferedWriter out2 = new BufferedWriter(csvFile2);
        FileWriter csvFile3 = new FileWriter("Studenci2.csv");
        BufferedWriter out3 = new BufferedWriter(csvFile3);
        for(Subject2 s : listad){
            s.saveToCSV(out,out1,out2,out3);
        }
        out.close();
        out1.close();
        out2.close();
        out3.close();
    }

    public List<Student> exportToCSVDBStudents() throws IOException {
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

        FileWriter csvFile3 = new FileWriter("Studenci5.csv");
        BufferedWriter out3 = new BufferedWriter(csvFile3);

        for(Student s : listaStudentow10) {
            out3.append(s.getNumberOfAlbum() + ";" + s.getName() + ";" + s.getSurname() + ";" + s.getCondition().toString() + ";" + s.getYearOfBirth() + ";" + s.getPoints() + "\n");
        }

        out3.close();

        return listaStudentow10;
    }
}