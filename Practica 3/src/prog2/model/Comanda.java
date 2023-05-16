/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;

/**
 * La clase Comanda s'utilitza per gestionar les comandes. client: cliente que
 * realitza la comanda. article : article que demana el client quantitat.
 * quantitat d'articles del mateix tipus que s'inclouran en la comanda. data:
 * data de creació de la comanda
 *
 * @author dortiz
 */
public abstract class Comanda implements Serializable {

    private Client client;
    private Article article;
    private int quantitat;
    private Date data;
    private boolean enviada;
    private boolean rebuda;
    private boolean cancelada;

    public Comanda(Client client, Article article, int quantitat, Date data) {
        this.client = client;
        this.article = article;
        this.quantitat = quantitat;
        this.data = data;
    }

    public void processa() {
        boolean daemon = true;
        Timer timer = new Timer(daemon); // Create timer with a daemon thread to avoid blocking program termination
        long tempsEnvMilisegs = tempsEnviament() * 1000;
        timer.schedule(new EnvComandaTimerTask(this), tempsEnvMilisegs);
    }

    public void cancela() {
        this.cancelada = true;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the article
     */
    public Article getArticle() {
        return article;
    }

    /**
     * @param article the article to set
     */
    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     * @return the quantitat
     */
    public int getQuantitat() {
        return quantitat;
    }

    /**
     * @param quantitat the quantitat to set
     */
    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the enviada
     */
    public boolean isEnviada() {
        return enviada;
    }

    /**
     * @param enviada the enviada to set
     */
    public void setEnviada(boolean enviada) {
        this.enviada = enviada;
    }

    /**
     * @return the rebuda
     */
    public boolean isRebuda() {
        return rebuda;
    }

    /**
     * @param rebuda the rebuda to set
     */
    public void setRebuda(boolean rebuda) {
        this.rebuda = rebuda;
    }

    /**
     * @return the cancelada
     */
    public boolean isCancelada() {
        return cancelada;
    }

    /**
     * @param cancelada the cancelada to set
     */
    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public abstract int tempsEnviament();

    public abstract int tempsRebuda();

    public float calcPreu() {
        return getQuantitat() * article.getPreu();
    }

    public abstract String tipusComanda();

    public abstract boolean comandaEnviada();

    public abstract boolean comandaRebuda();

    public abstract float preuEnviament();

    public String toString() {
        return "Tipus=" + tipusComanda()
                + ", Article=" + getArticle()
                + ", Client=" + getClient().getNom()
                + ", Quantitat=" + getQuantitat()
                + ", Data de creació=" + getData().toString()
                + ", Enviada=" + isEnviada()
                + ", Rebuda=" + isRebuda()
                + ", Cancel·lada" + isCancelada()
                + ", Preu Articles=" + calcPreu()
                + ", Preu Enviament=" + preuEnviament() + "\n";
    }
}
