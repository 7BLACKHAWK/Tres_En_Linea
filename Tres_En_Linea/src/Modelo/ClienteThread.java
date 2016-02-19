/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
;


public class ClienteThread extends Thread {

    private final Servidor servidor;
    private final Socket sktCliente;
    private int cont;
    boolean continuar = true;
    public int aciertos = 0;
     private DataInputStream streamIn = null;
     private DataOutput streamout = null;
     
     int primeravez = 0;
    public ClienteThread(Servidor servidor, Socket sktCliente) {
        this.servidor = servidor;
        this.sktCliente = sktCliente;
        
    }
    public void iniciarServidorThread() {
        start();
    }

    @Override
    public void run() {   
        try {
            streamIn = new DataInputStream((sktCliente.getInputStream()));
            streamout = new DataOutputStream(sktCliente.getOutputStream());
            while(true){
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ClienteThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}