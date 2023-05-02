/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import java.util.Iterator;
import prog2.vista.MercatException;

/**
 *
 * @author Marina
 */
public class LlistaComandes extends Llista<Comanda> implements Serializable {

    @Override
    public void afegir(Comanda comanda) throws MercatException {
        if (!comanda.getArticle().isEnviamentUrgent() && comanda instanceof ComandaUrgent) {
            throw new MercatException("Comanda incorrecta, l'article esmentat no admet enviament urgent.");
        }
        super.afegir(comanda);
    }
}
