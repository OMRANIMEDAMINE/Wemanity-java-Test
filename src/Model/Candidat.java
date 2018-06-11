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
public class Candidat {
    private int id;
    private String nom;
    private String prenom;
    private String datenaissance;
    private String pays;
    private String ville;  
    private String activite; 
    private String etat;
    private String tel;
    private String mail;

    public Candidat() {
    }

    public Candidat(int id, String nom, String prenom, String datenaissance, String pays, String ville, String activite, String etat, String tel, String mail) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.pays = pays;
        this.ville = ville;
        this.activite = activite;
        this.etat = etat;
        this.tel = tel;
        this.mail = mail;
    }
    
    

    public Candidat(String nom, String prenom, String datenaissance, String pays, String ville, String activite, String etat, String tel, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.pays = pays;
        this.ville = ville;
        this.activite = activite;
        this.etat = etat;
        this.tel = tel;
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getActivite() {
        return activite;
    }

    public String getEtat() {
        return etat;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public int getId() {
        return id;
    }

    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
