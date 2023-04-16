/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.FinanceDAO;

/**
 *
 * @author andre
 */
public class Finance {

    private int id;
    private String name;
    private String type;
    private double value;

    public Finance(String name, String type, double value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }
    
    public Finance(int id, String name, String type, double value) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
    }


    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
