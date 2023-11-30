package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Zutaten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zutat;
    private int menge;
    private String einheit;

    public Zutaten(){}

    //Konstruktor
    public Zutaten( String zutat, int menge, String einheit){
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
    public void setZutat(String name) {
        this.zutat = name;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zutaten zutat)) return false;

        if (getMenge() != zutat.getMenge()) return false;
        if (getEinheit() != zutat.getEinheit()) return false;
        if (getId() != null ? !getId().equals(zutat.getId()) : zutat.getId() != null) return false;
        return getZutat() != null ? getZutat().equals(zutat.getZutat()) : zutat.getZutat() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getZutat() != null ? getZutat().hashCode() : 0);
        result = 31 * result + getMenge();
        result = 31 * result + (getEinheit()!= null ? getZutat().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Zutat{" +
                "id=" + id +
                ", zutat='" + zutat + '\'' +
                ", menge=" + menge +
                '}';
    }
}