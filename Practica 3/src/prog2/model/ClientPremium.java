/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Marina
 */
public class ClientPremium extends Client {

    public ClientPremium(String correu, String nom, String adreca) {
        super(correu, nom, adreca);
    }

    @Override
    public String tipusClient() {
        return "Premium";
    }

    /**
     * els clients prèmium paguen una mensualitat de 4 euros al mes
     *
     * @return
     */
    @Override
    public float calcMensual() {
        return 4;
    }

    /**
     * els clients prèmium reben un descompte del 20% en les despeses
     * d'enviament
     *
     * @return
     */
    @Override
    public float descompteEnv() {
        return 20;
    }
}
