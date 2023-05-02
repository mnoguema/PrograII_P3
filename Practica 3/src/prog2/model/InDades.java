/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.ArrayList;
import java.util.List;
import prog2.vista.MercatException;

/**
 *
 * @author dortiz
 */
public interface InDades {

    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException;

    public ArrayList<Article> recuperaArticles();

    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException;

    public ArrayList<Client> recuperaClients();

    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException;

    public void cancelarComanda(int position) throws MercatException;

    public ArrayList<Comanda> recuperaComandes();

    public ArrayList<Comanda> recuperaComandesCancelades();
}
