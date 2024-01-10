package com.example.demo.ZutatenPacket;

import com.example.demo.ListenPacket.Listen;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "zutaten")
public class Zutaten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zutat;
    private int menge;
    private String einheit;
    @ManyToOne
    @JoinColumn(name="liste_id", referencedColumnName = "id")
    private Listen listen;

    public Zutaten(){}

    //Konstruktor
    public Zutaten(String zutat, int menge, String einheit){
        this.zutat = zutat;
        this.menge = menge;
        this.einheit = einheit;
    }

    //getter und setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZutat() {
        return zutat;
    }

    public void setZutat(String zutat) {
        this.zutat = zutat;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }

    public Listen getListen() {
        return listen;
    }

    public void setListen(Listen listen) {
        this.listen = listen;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zutaten)) return false;
        Zutaten zutaten = (Zutaten) o;
        return Objects.equals(id, zutaten.id) &&
                Objects.equals(zutat, zutaten.zutat) &&
                Objects.equals(menge, zutaten.menge) &&
                Objects.equals(einheit, zutaten.einheit);
    }

    public int hashCode() {
        return Objects.hash(id, zutat, menge, einheit);
    }

    @Override
    public String toString() {
        return "Zutat{" +
                "ID=" + id +
                ", Zutat='" + zutat + '\'' +
                ", Menge=" + menge +
                ", Einheit='" + einheit + '\'' +
                '}';
    }
}