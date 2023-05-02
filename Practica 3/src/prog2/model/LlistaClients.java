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
public class LlistaClients extends Llista<Client> implements Serializable {

    @Override
    public void afegir(Client client) throws MercatException {
        Iterator<Client> it = this.llista.iterator();
        while (it.hasNext()) {
            if (it.next().getCorreu().equals(client.getCorreu())) {
                throw new MercatException("No es poden afegir dos articles amb el mateix identificador");
            }
        }
        super.afegir(client);
    }
}
