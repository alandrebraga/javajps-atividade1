/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAO.FinanceDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class teste {

    public static void main(String[] args) throws JsonProcessingException {
        ArrayList<Finance> finance = FinanceDAO.getAllRecords();
        ObjectMapper mapper = new ObjectMapper();
        String financeJSON = mapper.writeValueAsString(finance);
        System.out.println(financeJSON);
    }
}
