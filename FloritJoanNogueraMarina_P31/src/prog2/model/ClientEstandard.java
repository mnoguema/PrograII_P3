/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

/**
 *
 * @author Marina
 */
public class ClientEstandard extends Client {

    public ClientEstandard(String correu, String nom, String adreca) {
        super(correu, nom, adreca);
    }

    @Override
    public String tipusClient() {
        return "Estàndard";
    }

    /**
     * Els clients estàndard no paguen cap mensualitat
     *
     * @return
     */
    @Override
    public float calcMensual() {
        return 0;
    }

    /**
     * Els clients estandard no tenen cap descompte en l'enviament
     *
     * @return
     */
    @Override
    public float descompteEnv() {
        return 0;
    }
}
