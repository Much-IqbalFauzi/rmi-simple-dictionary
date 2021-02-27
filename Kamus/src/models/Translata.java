/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author iqbalfauzi
 */
public class Translata {
    private int id;
    private String en, spain;
    
    public Translata(int id, String en, String spains) {
        this.id = id;
        this.en = en;
        this.spain = spains;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getSpain() {
        return spain;
    }

    public void setSpain(String spain) {
        this.spain = spain;
    }
    
    
}
