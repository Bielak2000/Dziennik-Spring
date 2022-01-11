package com.example.demo;
import javax.persistence.*;

@Entity
@Table(name = "StudenciCritera")
public class Studenci {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imie;
    private String nazwisko;
    private String numerAlbumu;

    public Studenci() {
    }

    Studenci(String n, String i, String na){
        imie=n;
        nazwisko=i;
        numerAlbumu=na;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNumerAlbumu() {
        return numerAlbumu;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNumerAlbumu(String numerAlbumu) {
        this.numerAlbumu = numerAlbumu;
    }
}
