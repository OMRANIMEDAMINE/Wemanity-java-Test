/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author OMRANI
 */
public class Entretient {
    
    private int id;
    private Candidat candidat;
    private String date;
    private String heure;
    private String description;
    private String qualite;
    private String defaut;
    private String decision;    
    private int note;

    public Entretient() {
    }

    public Entretient(Candidat candidat, String date, String heure, String description, String qualite, String defaut, String decision, int note) {
        this.candidat = candidat;
        this.date = date;
        this.heure = heure;
        this.description = description;
        this.qualite = qualite;
        this.defaut = defaut;
        this.decision = decision;
        this.note = note;
    }

    public Entretient(int id, Candidat candidat, String date, String heure, String agent, String description, String qualite, String defaut, String decision, int note) {
        this.id = id;
        this.candidat = candidat;
        this.date = date;
        this.heure = heure;
        this.description = description;
        this.qualite = qualite;
        this.defaut = defaut;
        this.decision = decision;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }


    public String getDescription() {
        return description;
    }

    public String getQualite() {
        return qualite;
    }

    public String getDefaut() {
        return defaut;
    }

    public String getDecision() {
        return decision;
    }

    public int getNote() {
        return note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public void setDefaut(String defaut) {
        this.defaut = defaut;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public void setNote(int note) {
        this.note = note;
    }

   
    
}
