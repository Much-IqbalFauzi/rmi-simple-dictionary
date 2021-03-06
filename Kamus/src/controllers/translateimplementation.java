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
        String query = "SELECT * FROM en_spain WHERE en LIKE ? ";
        
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, "%" + targetText + "%");
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
    
    @Override
    public List<Translata> DataByKeyReverse(String targetText) throws RemoteException {
        List<Translata> data = new ArrayList<>();
        String query = "SELECT * FROM en_spain WHERE spain LIKE ? ";
        
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, "%" + targetText + "%");
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
    
}
