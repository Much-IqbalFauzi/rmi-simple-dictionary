/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.userinterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;
import tools.koneksi;

/**
 *
 * @author JESSI
 */
public class userimplementation extends UnicastRemoteObject implements userinterface{

    private Connection con = null;
    
    
    public userimplementation() throws RemoteException {
        this.con = new koneksi().getkoneksi();
    }

    
    @Override
    public boolean isUserExist(String username) throws RemoteException {
        if (getUserByUsername(username)==null){
            return false;
        }
        return true;
    }

    @Override
    public boolean isUserValid(String username, String password) throws RemoteException {
        User user = getUserByUsername(username);
        boolean result = false ;
        if (user.getPassword().equalsIgnoreCase(password)) {
            return true;
        }
        
        return result ;
    }

    @Override
    public User getUserByUsername(String username) throws RemoteException {
        User user = null;
        String query = "SELECT * FROM user WHERE username= ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                user = new User(hasil.getString("username"), hasil.getString("nama"), hasil.getString("email"), hasil.getString("password"), hasil.getString("bio"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;   
    }

    @Override
    public boolean updateUser(User user) throws RemoteException {
        
        boolean result = false;
        String query = "UPDATE user SET nama=?, bio=? WHERE username=? ";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, user.getNama());
            statement.setString(2, user.getBio());
            statement.setString(3, user.getUsername());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean insertUser(User user) throws RemoteException {
      boolean result = false;
        String query = "INSERT INTO user VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getNama());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getBio());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<User> getAllUser() throws RemoteException {
       
     List<User> data = new ArrayList<>();
        String query = "SELECT * from user";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                User user = new User(hasil.getString(1), hasil.getString(2), hasil.getString(3), hasil.getString(4), hasil.getString(5));
                data.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    
    }

  
    
    
    
}
