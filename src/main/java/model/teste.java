/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.FinanceDAO;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 *
 * @author andre
 */
public class teste {

    public static void main(String[] args) throws JsonProcessingException {
        Finance finance = FinanceDAO.getRecordById(29);
        System.out.println(finance.getName());
        
        
        finance = FinanceDAO.getRecordById(29);
        
        System.out.println(finance.getName());
    }
}
