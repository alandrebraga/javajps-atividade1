/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Finance;

/**
 *
 * @author andre
 */
public class FinanceDAO {

    public static ArrayList<Finance> getAllRecords() {
        try {
            ResultSet rs = MainDAO.getInstance().executeQuery("SELECT * FROM financa");
            ArrayList<Finance> financesList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("tipo");
                double value = rs.getDouble("valor");
                financesList.add(new Finance(id, name, type, value));
            }
            return financesList;
        } catch (SQLException ex) {
            Logger.getLogger(FinanceDAO.class.getName()).log(Level.SEVERE, "Records not found", ex);
        }
        return null;
    }

    public static Finance getRecordById(int id) {
        try {
            ResultSet rs = MainDAO.getInstance().executeQuery("SELECT * FROM financa WHERE id = ?", new Object[]{id});

            if (rs.next()) {
                int fId = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("tipo");
                double value = rs.getDouble("valor");
                return new Finance(fId, name, type, value);
            }
        } catch (SQLException ex) { 
            Logger.getLogger(FinanceDAO.class.getName()).log(Level.SEVERE, "Records not found", ex);
        }
        return null;
    }

    public static void saveRecord(Finance finance) {
        String sql = "INSERT INTO financa (name, tipo, valor) VALUES (?, ?, ?);";
        MainDAO.getInstance().execute(sql, new Object[]{finance.getName(), finance.getType(), finance.getValue()});
    }
}
