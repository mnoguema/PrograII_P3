/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;

/**
 * Atributs de la classe Article: id: identificador únic que consisteix en un
 * codi alfanumèric nom: una cadena de text que descriu el seu nom preu: preu
 * unitari del article admetUrgent: poden admetre (True) o no enviament urgent
 * (False) tempsEnviament: temps fins a l’enviament expressat en segons
 *
 * @author Marina
 */
public class Article implements Serializable {

    private String id;
    private String nom;
    private float preu;
    private boolean enviamentUrgent;
    private int tempsEnviament;

    public Article(String id, String nom, float preu, boolean enviamentUrgent, int tempsEnviament) {
        this.id = id;
        this.nom = nom;
        this.preu = preu;
        this.enviamentUrgent = enviamentUrgent;
        this.tempsEnviament = tempsEnviament;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the preu
     */
    public float getPreu() {
        return preu;
    }

    /**
     * @param preu the preu to set
     */
    public void setPreu(float preu) {
        this.preu = preu;
    }

    /**
     * @return the enviamentUrgent
     */
    public boolean isEnviamentUrgent() {
        return enviamentUrgent;
    }

    /**
     * @param enviamentUrgent the enviamentUrgent to set
     */
    public void setEnviamentUrgent(boolean enviamentUrgent) {
        this.enviamentUrgent = enviamentUrgent;
    }

    /**
     * @return the tempsEnviament
     */
    public int getTempsEnviament() {
        return tempsEnviament;
    }

    /**
     * @param tempsEnviament the tempsEnviament to set
     */
    public void setTempsEnviament(int tempsEnviament) {
        this.tempsEnviament = tempsEnviament;
    }

    @Override
    public String toString() {
        return "Id=" + getId()
                + ", Nom=" + getNom()
                + ", Preu=" + getPreu()
                + ", Temps fins enviament=" + getTempsEnviament()
                + ", Enviament Urgent=" + isEnviamentUrgent() + "\n";
    }

}
