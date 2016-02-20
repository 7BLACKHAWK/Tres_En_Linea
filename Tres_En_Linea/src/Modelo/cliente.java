/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente extends Observable{

    private boolean continua = false;
    private Socket socket = null;
    private DataOutputStream streamOut = null;
    private DataInputStream streamin = null;
    int contador = 1;
    int primeravez = 0;
    String llega;
    int num;
    String ruta;
    String usuario = "usuario no registrado";
    boolean registrar = true;
    private Thread mythread = null;
    String host;
    int port;
    int turnox;
    
    public cliente(String ip, int puerto) {
        port = puerto;
        host = ip;
        num = -1;
        turnox = 0;
       ruta = "";
        inicializarcliente();
        
    }

    
    public String getusuario(){
       return usuario;
   }
   
        
    public String getcliente(){
        return ruta;
    }
    public int getserver(){
        return num;
    }
    public boolean existecliente(){
        if(ruta != ""){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void actualizar() {
        setChanged();
        notifyObservers();
    }
     public int getcontador(){
         return contador;
     }
   public void inicializarcliente(){
        System.out.println("Establishing connection. Please wait ...");
      try{
          System.out.println("host: "+ this.host + " port: "+ this.port);
         socket = new Socket(host, port);
         System.out.println("Connected: " + socket);
         continua = true;
         start();
         mythread = new Thread(new Runnable() {
             @Override
             public void run(){
                 
                 try {
                     System.out.println("enviaado1 " + num + "   " + ruta);
                     turnox = streamin.read();
                     System.out.println("enviaado1 " + num + "   " + ruta);
                     while(true){
                     System.out.println("enviaado1 " + num + "   " + ruta);
                     ruta = streamin.readUTF();
                     num = streamin.read();
                     System.out.println("enviaado2 " + num + "   " + ruta);
                     actualizar();
                     
                     }
                 } catch (IOException ex) {
                     Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
                 }
                }
             });
             mythread.start();
      }
      
      catch(UnknownHostException uhe)
      {  System.out.println("Host unknown: " + uhe.getMessage());
      }
      catch(IOException ioe)
      {  System.out.println("Unexpected exception: " + ioe.getMessage());
      }
   }
   public void enviarMsj(String ruta){
          try
         {    
            streamOut.writeUTF(ruta);
         }
         catch(IOException ioe)
         {  
             System.out.println("Sending error: " + ioe.getMessage());
         }
   }
   public void enviarMsj(int ruta){
          try
         {    
            streamOut.write(ruta);
         }
         catch(IOException ioe)
         {  
             System.out.println("Sending error: " + ioe.getMessage());
         }
   }
   public void start() throws IOException
   {        
       streamOut = new DataOutputStream(socket.getOutputStream());
       streamin = new DataInputStream(socket.getInputStream());
   }
    
    
    
    public void stop() {
        try {
            if (streamOut != null) {
                streamOut.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ioe) {
            System.out.println("Error closing ...");
        }
    }

    public boolean isContinua() {
        return continua;
    }

    public void setContinua(boolean continua) {
        this.continua = continua;
    }
}