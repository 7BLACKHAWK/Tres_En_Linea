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
     private DataOutput streamout = null;;
     int primeravez = 0;
    public ClienteThread(Servidor servidor, Socket sktCliente, int contador) {
        cont = contador;
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
            this.getStreamout().write(cont+1);
            System.out.println("enviando cont:" + cont);
            while(true){
                String ruta = getStreamIn().readUTF();
                int num = getStreamIn().read();
                if (getCont() == 0) {
            try {
                servidor.clienteThread[1].getStreamout().writeUTF(ruta);
                servidor.clienteThread[1].getStreamout().write(num);
                System.out.println("enviaado " + num + "   " + ruta);
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                servidor.clienteThread[0].getStreamout().writeUTF(ruta);
                servidor.clienteThread[0].getStreamout().write(num);
                System.out.println("enviaado " + num + "   " + ruta);
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                servidor.enviaracliente(this, ruta, num);
                System.out.println("numero: " + num + "url: " + ruta);
            }
        } catch (IOException ex) {
            Logger.getLogger(ClienteThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCont() {
        return cont;
    }

 
    public DataInputStream getStreamIn() {
        return streamIn;
    }


    public DataOutput getStreamout() {
        return streamout;
    }
}