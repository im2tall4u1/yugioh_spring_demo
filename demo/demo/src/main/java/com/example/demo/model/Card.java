package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
    @Id
    private int id;
    private String name;
    private int atkPoints;
    private int defPoints;
    
    
    public Card(int id, String name, int atkPoints, int defPoints) {
        this.id = id;
        this.name = name;
        this.atkPoints = atkPoints;
        this.defPoints = defPoints;
    }
    
    public Card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtkPoints() {
        return atkPoints;
    }

    public void setAtkPoints(int atkPoints) {
        this.atkPoints = atkPoints;
    }

    public int getDefPoints() {
        return defPoints;
    }

    public void setDefPoints(int defPoints) {
        this.defPoints = defPoints;
    }

    @Override
    public String toString() {
        return "Card [atkPoints=" + atkPoints + ", defPoints=" + defPoints + ", id=" + id + ", name=" + name + "]";
    }
    
    
}
