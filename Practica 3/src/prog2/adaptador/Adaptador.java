/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.adaptador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public void guardaDades(String camiDesti) throws MercatException, FileNotFoundException, IOException {
        try {
            FileOutputStream fout = new FileOutputStream(camiDesti);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this.dades);
            oos.close();
            fout.close();
        } catch (FileNotFoundException ex) {
            throw new MercatException("Fitxer no trobat");
        } catch (IOException ex) {
            throw new MercatException("IO error");
        }
    }

    public void recuperaDades(String camiOrigen) throws MercatException, FileNotFoundException, IOException {
        if (camiOrigen == null) {
            throw new MercatException("Cami al fitxer no valid");
        }
        File fitxer = new File(camiOrigen);
        Dades dades = null;
        FileInputStream fin = null;

        try {
            fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);
            dades = (Dades) ois.readObject();
        } catch (ClassNotFoundException ex) {
            throw new MercatException("Error, no trobat");
        } catch (FileNotFoundException ex) {
            throw new MercatException("Error de fitxer");
        } catch (IOException ex) {
            throw new MercatException("Error de IO");
        } finally {
            if (fin == null) {
                throw new MercatException("Fin = null");
            } else {
                fin.close();
            }
        }
    }

    public void afegirArticle(String id, String nom, float preu, boolean enviamentUrgent, int tempsEnviament) throws MercatException {
        dades.afegirArticle(id, nom, preu, tempsEnviament, enviamentUrgent);
    }

    public ArrayList<String> llistarArticles() {
        ArrayList<String> llista = new ArrayList<>();
        Iterator<Article> it = dades.recuperaArticles().iterator();
        int i = 1;
        while (it.hasNext()) {
            llista.add("[" + i + "]" + it.next().toString());
            i++;
        }
        return llista;

    }

    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        dades.afegirClient(email, nom, adreca, esPremium);
    }

    public ArrayList<String> llistarClients() {
        ArrayList<String> llista = new ArrayList<>();
        Iterator<Client> it = dades.recuperaClients().iterator();
        int i = 1;
        while (it.hasNext()) {
            llista.add("[" + i + "]" + it.next().toString());
            i++;
        }
        return llista;
    }

    /*    public String llistarClients() {
        String frase = "";
        int i = 1;
        Iterator<Client> it = dades.recuperaClients().iterator();
        while (it.hasNext()) {
          frase += "[" + i + "]";
            frase += it.next().toString();
            i++;
        }

        return frase;
    }*/
    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        dades.afegirComanda(articlePos + 1, clientPos + 1, quantitat, esUrgent);
    }

    public void cancelarComanda(int position) throws MercatException {
        dades.cancelarComanda(position);
    }

    public ArrayList<String> llistarComandes(String tipus) {
        ArrayList<String> llista = new ArrayList<>();
        Iterator<Comanda> it = tipus.equals("totes") ? dades.recuperaComandes().iterator() : dades.recuperaComandesCancelades().iterator();
        int i = 1;
        while (it.hasNext()) {
            llista.add("[" + i + "]" + it.next().toString());
            i++;
        }
        return llista;

    }

}
