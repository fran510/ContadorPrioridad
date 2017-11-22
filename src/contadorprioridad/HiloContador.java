/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contadorprioridad;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class HiloContador extends Thread {
    
    PanelContadores p;
    int cont;
    
    public HiloContador(PanelContadores p){
        this.p=p;
        cont=0;
    }
    
    public void run(){
        while(!this.isInterrupted()){
            try {
                cont++;
                System.out.println("En el Hilo");
                p.repaint();
            
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                //Logger.getLogger(HiloContador.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Ha ocurrido una excepción");
                Thread.currentThread().interrupt();
            }
        }   
        System.out.println("Fin del hilo");
        
    }
    
    public void interrumpir(){
        interrupt();
    }

    public int getCont() {
        return cont;
    }
    
    
}
