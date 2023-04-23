/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.adaptador;

import java.util.ArrayList;
import java.util.Iterator;
import prog2.model.Article;
import prog2.model.Client;
import prog2.model.Comanda;
import prog2.model.Dades;
import prog2.vista.MercatException;

/**
 *
 * @author Marina
 */
public class Adaptador {

    private Dades dades = new Dades();

    public void afegirArticle(String id, String nom, float preu, boolean enviamentUrgent, int tempsEnviament) throws MercatException {
        dades.afegirArticle(id, nom, preu, tempsEnviament, enviamentUrgent);
    }

    public ArrayList<String> llistarArticles() {
        ArrayList<String> llistaArticles = new ArrayList<>();
        Iterator<Article> it = dades.recuperaArticles().iterator();
        while (it.hasNext()) {
            llistaArticles.add(it.next().toString());
        }

        return llistaArticles;
    }

    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        dades.afegirClient(email, nom, adreca, esPremium);
    }

    public ArrayList<String> llistarClients() {
        ArrayList<String> llistaClients = new ArrayList<>();
        Iterator<Client> it = dades.recuperaClients().iterator();
        while (it.hasNext()) {
            llistaClients.add(it.next().toString());
        }

        return llistaClients;
    }

    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        dades.afegirComanda(articlePos, clientPos, quantitat, esUrgent);
    }

    public void cancelarComanda(int position) throws MercatException {
        dades.cancelarComanda(position);
    }

    public ArrayList<String> llistarComandes(String tipus) {
        ArrayList<String> llistaComandes = new ArrayList<>();
        Iterator<Comanda> it = tipus.equals("totes") ? dades.recuperaComandes().iterator() : dades.recuperaComandesCancelades().iterator();
        while (it.hasNext()) {
            llistaComandes.add(it.next().toString());

        }
        return llistaComandes;
    }
}
