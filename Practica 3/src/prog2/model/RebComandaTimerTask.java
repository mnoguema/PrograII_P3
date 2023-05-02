/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author joanf
 */
public class RebComandaTimerTask extends TimerTask {
    
    private Comanda comanda;
    
    public RebComandaTimerTask(Comanda comanda) {
        this.comanda = comanda;
    }
    
    public void run() {
        if (!this.comanda.isCancelada()) {
            this.comanda.setRebuda(true);
            System.out.println("Comanda Rebuda: " + this.comanda);
        }
    }
}
