/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import prog2.vista.MercatException;
import java.util.Date;

/**
 *
 * @author Marina
 */
public class Dades implements InDades, Serializable {

    private LlistaArticles llistaArticles = new LlistaArticles();
    private LlistaClients llistaClients = new LlistaClients();
    private LlistaComandes llistaComandes = new LlistaComandes();

    @Override
    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException {
        Article nouArticle = new Article(id, nom, preu, admetUrgent, temps);
        llistaArticles.afegir(nouArticle);
    }

    @Override
    public ArrayList<Article> recuperaArticles() {
        return this.llistaArticles.getArrayList();

    }

    @Override
    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        if (esPremium) {
            ClientPremium nouClient = new ClientPremium(email, nom, adreca);
            llistaClients.afegir(nouClient);
        } else {
            ClientEstandard nouClient = new ClientEstandard(email, nom, adreca);
            llistaClients.afegir(nouClient);
        }
    }

    @Override
    public ArrayList<Client> recuperaClients() {
        return this.llistaClients.getArrayList();

    }

    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        Article article = this.llistaArticles.getAt(articlePos);
        Client client = this.llistaClients.getAt(clientPos);
        Date data = new Date();

        Comanda novaComanda = esUrgent ? new ComandaUrgent(client, article, quantitat, data) : new ComandaNormal(client, article, quantitat, data);
        this.llistaComandes.afegir(novaComanda);
    }

    public void cancelarComanda(int position) throws MercatException {
        Comanda comanda = this.llistaComandes.getAt(position);
        comanda.setCancelada(true);
    }

    public ArrayList<Comanda> recuperaComandes() {
        return this.llistaComandes.getArrayList();

    }

    public ArrayList<Comanda> recuperaComandesCancelades() {
        ArrayList<Comanda> comandesCancelades = new ArrayList<>();

        for (Iterator<Comanda> i = this.llistaComandes.getArrayList().iterator(); i.hasNext();) {
            Comanda aquestaComanda = i.next();
            if (aquestaComanda.isCancelada()) {
                comandesCancelades.add(aquestaComanda);
            }

        }
        return comandesCancelades;
    }
}
