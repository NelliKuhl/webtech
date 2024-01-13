package com.example.demo.ListenPacket;

import com.example.demo.ZutatenPacket.Zutaten;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Listen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String owner;

    @JsonIgnore
    @OneToMany(mappedBy = "listen" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Zutaten> zutaten = new HashSet<>();
    public Listen(){}
    //Konstruktor
    public Listen(String name, String owner){
        this.name = name;
        this.owner = owner;
    }

    //getter und setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {return owner;}

    public void setOwner(String owner) {this.owner = owner;}

    public Set<Zutaten> getZutaten() {
        return zutaten;
    }

    public void setZutaten(Set<Zutaten> zutaten) {
        this.zutaten = zutaten;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Listen)) return false;

        Listen listen = (Listen) o;

        if (getId() != null ? !getId().equals(listen.getId()) : listen.getId() != null) return false;
        return getName() != null ? getName().equals(listen.getName()) : listen.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Listen{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                '}';
    }
}
