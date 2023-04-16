/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class MainDAO {

    private static MainDAO instance;
    private Connection connection;

    private final String url = "jdbc:postgresql://localhost:5432/financa";
    private final String user = "postgres";
    private final String password = "admin";

    public static MainDAO getInstance() {
        if (instance == null) {
            instance = new MainDAO();
        }

        return instance;
    }

    private MainDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Logger.getLogger(MainDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Object execute(String sql, Object[] args) {
        return execute(sql, args, false);
    }

    public ResultSet executeQuery(String sql, Object[] args) {
        return (ResultSet) execute(sql, args, true);
    }

    public ResultSet executeQuery(String sql) {
        return (ResultSet) execute(sql, true);
    }

    private Object execute(String sql, Object[] args, boolean isQuery) {
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                pstm.setObject(i + 1, args[i]);
            }

            Object toReturn = null;
            if (isQuery) {
                toReturn = pstm.executeQuery();
            } else {
                toReturn = pstm.execute();
            }
            return toReturn;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object execute(String sql, boolean isQuery) {
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);

            Object toReturn = null;
            if (isQuery) {
                toReturn = pstm.executeQuery();
            } else {
                toReturn = pstm.execute();
            }
            return toReturn;
                
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
    }
}
