/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author JESSI
 */
public class History implements Serializable{

    private String language_id_from, language_id_to, message_from, message_to, user, datetime;
    private int id;

    public History( int id, String language_id_from, String language_id_to, String message_from, String message_to, String user, String datetime) {
        this.language_id_from = language_id_from;
        this.language_id_to = language_id_to;
        this.message_from = message_from;
        this.message_to = message_to;
        this.user = user;
        this.id = id;
        this.datetime = datetime;
    }
    
       public History( String language_id_from, String language_id_to, String message_from, String message_to, String user) {
        this.language_id_from = language_id_from;
        this.language_id_to = language_id_to;
        this.message_from = message_from;
        this.message_to = message_to;
        this.user = user;
    }

    public String getLanguage_id_from() {
        return language_id_from;
    }

    public void setLanguage_id_from(String language_id_from) {
        this.language_id_from = language_id_from;
    }

    public String getLanguage_id_to() {
        return language_id_to;
    }

    public void setLanguage_id_to(String language_id_to) {
        this.language_id_to = language_id_to;
    }

    public String getMessage_from() {
        return message_from;
    }

    public void setMessage_from(String message_from) {
        this.message_from = message_from;
    }

    public String getMessage_to() {
        return message_to;
    }

    public void setMessage_to(String message_to) {
        this.message_to = message_to;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    
}
