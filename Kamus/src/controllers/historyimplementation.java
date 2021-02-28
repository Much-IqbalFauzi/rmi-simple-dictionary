/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.historyinterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import models.History;
import tools.koneksi;

/**
 *
 * @author JESSI
 */
public class historyimplementation extends UnicastRemoteObject implements historyinterface {

    private Connection con = null;

    public historyimplementation() throws RemoteException {
        this.con = new koneksi().getkoneksi();
    }

    @Override
    public boolean insertHistory(History history) throws RemoteException {
        boolean result = false;
        String query = "INSERT INTO history VALUES (null, ?,?,?,?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, history.getLanguage_id_from());
            statement.setString(2, history.getLanguage_id_to());
            statement.setString(3, history.getMessage_from());
            statement.setString(4, history.getMessage_to());
            statement.setString(5, history.getUser());
            statement.setString(6, getDateNow());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<History> getHistoryByUsername(String username) throws RemoteException {
        List<History> data = new ArrayList<>();
        String query = "SELECT * FROM history WHERE user=? ORDER BY datetime DESC ";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                String datetime = convertDatetoString(hasil.getDate("datetime")) + " " + convertTimetoString(hasil.getTime("datetime"));
                History history = new History(hasil.getInt("id"), hasil.getString("language_id_from"), hasil.getString("language_id_to"), hasil.getString("message_from"),
                        hasil.getString("message_to"), hasil.getString("user"), datetime);
                data.add(history);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(data);
        return data;
    }

    @Override
    public List<History> getAllHistory() throws RemoteException {
        List<History> data = new ArrayList<>();
        String query = "SELECT * FROM history ORDER BY datetime DESC";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                String datetime = convertDatetoString(hasil.getDate("datetime")) + " " +convertTimetoString(hasil.getTime("datetime"));
                History history = new History(hasil.getInt("id"), hasil.getString("language_id_from"), hasil.getString("language_id_to"), hasil.getString("message_from"),
                        hasil.getString("message_to"), hasil.getString("user"), datetime);
                data.add(history);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public History getHistoryById(String id) throws RemoteException {
        History history = null;
        String query = "SELECT * FROM history WHERE id= ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, id);
            ResultSet hasil = statement.executeQuery();

            while (hasil.next()) {
                String datetime = convertDatetoString(hasil.getDate("datetime")) + " " + convertTimetoString(hasil.getTime("datetime"));
                history = new History(hasil.getInt("id"), hasil.getString("language_id_from"), hasil.getString("language_id_to"), hasil.getString("message_from"),
                        hasil.getString("message_to"), hasil.getString("user"), datetime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return history;
    }

    public String getDateNow() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/hh HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public String convertDatetoString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("hh/MM/yyyy");
        return formatter.format(date);
    }

    public String convertTimetoString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(date);
    }
}
