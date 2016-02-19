/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Servidor extends Thread implements Serializable{
    private ServerSocket server = null;
    public int contadora = 1;
    public DataInputStream streamIn[] = null;
    public DataOutputStream outstrean[] = null;
    private int puerto;
    boolean continua;
    public int contador;
    public ClienteThread clienteThread[];
    private int x = 0;
    //private Image imagenes[];
    private String imagenes[];
    private Lock gameLock;
    Thread mithread = null;
    public Socket cliente[];
    public String cliente1 = "";
    public String cliente2 = "";
    public Servidor() {
        contador = 0;
        cliente = new Socket[2];
        gameLock = new ReentrantLock();
        streamIn = new DataInputStream[2];
        outstrean = new DataOutputStream[2];
        
       //generarvector();
        clienteThread = new ClienteThread[8];
        puerto = 3552;
        this.start();
    }
    
    @Override
    public void run() {
        System.out.println("Iniciando servidor...");
        
        try {
            server = new ServerSocket(puerto);
            
            System.out.println(puerto);
            for (int k = 0; k < 2; k++) {
                 cliente[k] =  server.accept();
                 streamIn[k] = new DataInputStream(cliente[k].getInputStream());
                outstrean[k] = new DataOutputStream(cliente[k].getOutputStream());
                clienteThread[k]  = new ClienteThread(this, cliente[k]);
                Thread t = (Thread) clienteThread[k];
                t.start();
                System.out.println("Cliente#" + k + " aceptado...");
                contador++;
        } 
        }
            catch (IOException ex) {
            System.err.println("ServerSocket(puerto)..." + ex.getMessage());
            }
    }

    

    public int getcont(){
        return contador;
    }
    public Socket getsocket(int i){
        return cliente[i];
    }

    public void close(Socket sktCliente) throws IOException {
        if (sktCliente != null) {
            sktCliente.close();
            contador--;
        }
        if (streamIn != null) {
            //streamIn.close();
        }
    }
    
    public static void main(String[] args) {
        new Servidor();  
    }
}