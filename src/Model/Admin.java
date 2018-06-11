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
public class Admin {
    private int idU;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private int tel;
    private String email;
    
    public Admin() {
        
    }

    public Admin(int idU, String nom, String prenom, String login, String password, int tel, String email) {
        this.idU = idU;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.tel = tel;
        this.email = email;
    }

    public Admin(String nom, String prenom, String login, String password, int tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.tel = tel;
        this.email = email;
    }

    public int getIdU() {
        return idU;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
