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
public class LlistaArticles extends Llista<Article> implements Serializable {

    @Override
    public void afegir(Article article) throws MercatException {
        Iterator<Article> it = this.llista.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(article.getId())) {
                throw new MercatException("No es poden afegir dos articles amb el mateix identificador");
            }
        }
        super.afegir(article);
    }

}
