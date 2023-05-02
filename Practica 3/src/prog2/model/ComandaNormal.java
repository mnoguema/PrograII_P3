/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;
import java.util.Date;
/**
 *
 * @author joanf
 */
public class ComandaNormal extends Comanda {
    
    public ComandaNormal(Client client, Article article, int quantitat, Date data) {
        super(client, article, quantitat, data);
    }
    
    @Override
    public int tempsEnviament() {
        return getArticle().getTempsEnviament();
    }

    @Override
    public int tempsRebuda() {
        return 120;
    }
    
    @Override
    public String tipusComanda() {
        return "Normal";
    }
    
    @Override
    public boolean comandaEnviada() {
        return isEnviada() == true;
    }

    @Override
    public boolean comandaRebuda() {
        return isRebuda() == true;
    }

    @Override
    public float preuEnviament() {
        return 1;
    }
    
}
