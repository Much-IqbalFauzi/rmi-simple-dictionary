/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.translateinterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Translata;
import tools.koneksi;

/**
 *
 * @author iqbalfauzi
 */
public class translateimplementation extends UnicastRemoteObject implements translateinterface{
    private Connection con = null;

    public translateimplementation() throws RemoteException {
        this.con = new koneksi().getkoneksi();
    }

    @Override
    public List<Translata> DataByKey(String targetText) throws RemoteException {
        List<Translata> data = new ArrayList<>();
        String query = "SELECT * FROM en_spain WHERE en LIKE %?% ";
        
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, targetText);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                Translata tObj = new Translata(hasil.getInt("id"), hasil.getString("en"), hasil.getString("spain"));
                data.add(tObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    //server only
    public boolean AddKamus(Translata kamus) throws RemoteException {
        boolean result = false;
        String query = "INSERT INTO en_spain VALUES (null, ?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, kamus.getEn());
            statement.setString(2, kamus.getSpain());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public boolean EditKamus(Translata kamus) {
        boolean result = false;
        String query = "UPDATE en_spain SET en=?, spain=? WHERE id=? ";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, kamus.getEn());
            statement.setString(2, kamus.getSpain());
            statement.setInt(3, kamus.getId());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
}
