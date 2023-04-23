/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;

/**
 *
 * @author Marina
 */
public abstract class Client implements Serializable {

    private String correu;
    private String nom;
    private String adreca;

    public Client(String correu, String nom, String adreca) {
        this.correu = correu;
        this.nom = nom;
        this.adreca = adreca;
    }

    /**
     * @return the correu
     */
    public String getCorreu() {
        return correu;
    }

    /**
     * @param correu the correu to set
     */
    public void setCorreu(String correu) {
        this.correu = correu;
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
     * @return the adreca
     */
    public String getAdreca() {
        return adreca;
    }

    /**
     * @param adreca the adreca to set
     */
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public abstract String tipusClient();

    public abstract float calcMensual();

    public abstract float descompteEnv();

    @Override
    public String toString() {
        return "Tipus= " + tipusClient()
                + ", Email= " + getCorreu()
                + ", Nom =" + getNom()
                + ", Adreça= " + getAdreca()
                + ", Descompte Enviament=" + descompteEnv()
                + ", Mensualitat=" + calcMensual();
    }
}
