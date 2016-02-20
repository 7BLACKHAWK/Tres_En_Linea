/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Vista.Juego;
import static Vista.Juego.isIndividual;
import Vista.Menu_Principal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Marvin
 */
public class JuegoLogico {
    public static URL  fichaX = null;
    public static URL  fichaO = null;
    public static boolean ganador;//cuando hay un ganador sera verdadero
    public static int empate;
    public static boolean turno;//turnos true = jugador1 ; false = jugador2
    public static JButton btnNumero[];
    public static int contador;
    
    
    public static Juego JN1;
    public static int v=0;
    public static int i=0;
    public static int n=0;
    public static int n1=0;
    public static int n2=0;
    public static int n3=0;
    public static int numero;
    
    public static cliente cliente;
    public static Thread mythread;
     static int turnox = 0;
     static ImageIcon cup;
    
    public static void inicializarAtributos(Juego JN) {
        JuegoLogico.ganador = false;
        JuegoLogico.empate = 1;
        JuegoLogico.turno = true;
        JuegoLogico.btnNumero = new JButton[9];
        JuegoLogico.btnNumero[0] = Juego.jb_Q;
        JuegoLogico.btnNumero[1] = Juego.jb_W;
        JuegoLogico.btnNumero[2] = Juego.jb_E;
        JuegoLogico.btnNumero[3] = Juego.jb_A;
        JuegoLogico.btnNumero[4] = Juego.jb_S;
        JuegoLogico.btnNumero[5] = Juego.jb_D;
        JuegoLogico.btnNumero[6] = Juego.jb_Z;
        JuegoLogico.btnNumero[7] = Juego.jb_X;
        JuegoLogico.btnNumero[8] = Juego.jb_C;
        for (int x = 0; x < btnNumero.length; x++) {
            JuegoLogico.btnNumero[x].setName(Integer.toString(x + 1));
            
        }
        JN1=JN;

    }

    
    
    
    public static  void numeroClikeado(int numeroLbl) {

        int numeroAuxiliar = (int) (numeroLbl + 1);
        //Numero auxiliar para comparar el Numero string del 'name' de los botones

        if (JuegoLogico.btnNumero[numeroLbl].getName().equals(Integer.toString(numeroAuxiliar))) {

            if (turno) {
                fichaX = JuegoLogico.class.getResource("../imagenes/fichaX.png");
                ImageIcon fichX;
                fichX = new ImageIcon(fichaX);
                JuegoLogico.btnNumero[numeroLbl].setName("X");
                JuegoLogico.btnNumero[numeroLbl].setText("");
                JuegoLogico.btnNumero[numeroLbl].setIcon(fichX);

                hayGanador();

                empate++;

                turno = false;

            } else {
                fichaO = JuegoLogico.class.getResource("../imagenes/fichaO.png");
                ImageIcon fichO;
                fichO = new ImageIcon(fichaO);
                JuegoLogico.btnNumero[numeroLbl].setName("O");
                JuegoLogico.btnNumero[numeroLbl].setText("");
                JuegoLogico.btnNumero[numeroLbl].setIcon(fichO);
                 
                hayGanador();

                empate++;

                turno = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "La casilla esta ocupada \n intente con otra");
        }
    }
    
    
    
    public static void hayGanador() {
               
        //------COMPARACIONES HORIZONTALES----\\
        if (Juego.jb_Q.getName().equals(Juego.jb_W.getName()) && Juego.jb_Q.getName().equals(Juego.jb_E.getName())) {
            JuegoLogico.ganador = true;
        }
        if (Juego.jb_A.getName().equals(Juego.jb_S.getName()) && Juego.jb_A.getName().equals(Juego.jb_D.getName())) {
            JuegoLogico.ganador = true;
        }
        if (Juego.jb_Z.getName().equals(Juego.jb_X.getName()) && Juego.jb_Z.getName().equals(Juego.jb_C.getName())) {
            JuegoLogico.ganador = true;
        }

        //------COMPARACIONES VERTICALES----\\
        if (Juego.jb_Q.getName().equals(Juego.jb_A.getName()) && Juego.jb_Q.getName().equals(Juego.jb_Z.getName())) {

            JuegoLogico.ganador = true;
        }
        if (Juego.jb_W.getName().equals(Juego.jb_S.getName()) && Juego.jb_W.getName().equals(Juego.jb_X.getName())) {

            JuegoLogico.ganador = true;
        }
        if (Juego.jb_E.getName().equals(Juego.jb_D.getName()) && Juego.jb_E.getName().equals(Juego.jb_C.getName())) {

            JuegoLogico.ganador = true;
        }

        //------COMPARACIONES DIAGONALES----\\
        if (Juego.jb_Q.getName().equals(Juego.jb_S.getName()) && Juego.jb_Q.getName().equals(Juego.jb_C.getName())) {

            JuegoLogico.ganador = true;
        }
        if (Juego.jb_Z.getName().equals(Juego.jb_S.getName()) && Juego.jb_Z.getName().equals(Juego.jb_E.getName())) {

            JuegoLogico.ganador = true;
        }

        if (JuegoLogico.ganador) {
            ganador();

        }
        if (JuegoLogico.empate == 9 && ganador == false) {

            //Se empieza una nueva partida
            turno = !turno;
            int seleccion = JOptionPane.showConfirmDialog(null,"Juego empatado \n \n"+ 
            "Quiere jugar otra partida?", "EMPATE", JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE);
            if (seleccion == 0) {
            boolean ind = JN1.isIndividual();
            JN1.dispose();
            String j1 = Juego.jt_J1.getText();
            String j2 = Juego.jt_J2.getText();
            
            String ptsf1 = Juego.jt_Pj1.getText();
            String ptsf2 = Juego.jt_Pj2.getText();
            Juego j = new Juego(ind);
            j.setVisible(true);
            Juego.jt_J1.setText(j1);
            Juego.jt_J2.setText(j2);
            Juego.jt_Pj1.setText(ptsf1);
            Juego.jt_Pj2.setText(ptsf2);
            } else {
                System.exit(0);
            }
        }
    }
    
    public static void ganador() {
        
        int seleccion; 
        JuegoLogico.ganador = true;
        if (turno) {
            v=1;
            Juego.jb_Q.setEnabled(false);
            Juego.jb_W.setEnabled(false);
            Juego.jb_E.setEnabled(false);
            Juego.jb_A.setEnabled(false);
            Juego.jb_S.setEnabled(false);
            Juego.jb_D.setEnabled(false);
            Juego.jb_Z.setEnabled(false);
            Juego.jb_X.setEnabled(false);
            Juego.jb_C.setEnabled(false);
            
            int a= Integer.parseInt(Juego.jt_Pj1.getText());
            int b= Integer.parseInt(Juego.jt_Pj1.getText());
            a++;
            b--;
            
            String pt1= Integer.toString(a);
            String pt2 =Integer.toString(b);
            Juego.jt_Pj1.setText(pt1);
            Juego.jt_Pj2.setText(pt2);
            
//            ImageIcon icon = new ImageIcon("../imagenes/repeat_opt.png.jpg");
            seleccion = JOptionPane.showConfirmDialog(null, 
            Juego.jt_J1.getText() + "\n has Ganado FELICITACIONES \n \n Quiere jugar otra partida?",
            "GANADOR JUGADOR 1", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            Juego.jb_Q.setEnabled(false);
            Juego.jb_W.setEnabled(false);
            Juego.jb_E.setEnabled(false);
            Juego.jb_A.setEnabled(false);
            Juego.jb_S.setEnabled(false);
            Juego.jb_D.setEnabled(false);
            Juego.jb_Z.setEnabled(false);
            Juego.jb_X.setEnabled(false);
            Juego.jb_C.setEnabled(false);
            turno=true;
        
        } else {
            seleccion = JOptionPane.showConfirmDialog(null, 
            Juego.jt_J2.getText() + "\n has Ganado FELICITACIONES \n \n Quiere jugar otra partida?",
            "GANADOR JUGADOR 2", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            int a= Integer.parseInt(Juego.jt_Pj1.getText());
            int b= Integer.parseInt(Juego.jt_Pj2.getText());
            a--;
            b++;
            
            String pt1= Integer.toString(a);
            String pt2 =Integer.toString(b);
            Juego.jt_Pj1.setText(pt1);
            Juego.jt_Pj2.setText(pt2);

            Juego.jb_Q.setEnabled(false);
            Juego.jb_W.setEnabled(false);
            Juego.jb_E.setEnabled(false);
            Juego.jb_A.setEnabled(false);
            Juego.jb_S.setEnabled(false);
            Juego.jb_D.setEnabled(false);
            Juego.jb_Z.setEnabled(false);
            Juego.jb_X.setEnabled(false);
            Juego.jb_C.setEnabled(false);   
        }
        if (seleccion == 0) {
            boolean ind = JN1.isIndividual();
            JN1.dispose();
            String j1 = Juego.jt_J1.getText();
            String j2 = Juego.jt_J2.getText();
            
            String ptsf1 = Juego.jt_Pj1.getText();
            String ptsf2 = Juego.jt_Pj2.getText();
            Juego j = new Juego(ind);
            j.setVisible(true);
            Juego.jt_J1.setText(j1);
            Juego.jt_J2.setText(j2);
            Juego.jt_Pj1.setText(ptsf1);
            Juego.jt_Pj2.setText(ptsf2);
        }else{
            System.exit(0);
        }
    }

    public static void inicializarAtributos(cliente client) {
        cliente = client;
        contador = -1;
        while(cliente.turnox == 0){}
        turnox = cliente.turnox;
        if(turnox == 1 )turno = true;
        else turno = false;
        mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                mithread();
            }
        });
        mythread.start();
    
        JuegoLogico.ganador = false;
        JuegoLogico.empate = 1;
        //JuegoLogico.turno = true;
        JuegoLogico.btnNumero = new JButton[9];
        JuegoLogico.btnNumero[0] = Juego.jb_Q;
        JuegoLogico.btnNumero[1] = Juego.jb_W;
        JuegoLogico.btnNumero[2] = Juego.jb_E;
        JuegoLogico.btnNumero[3] = Juego.jb_A;
        JuegoLogico.btnNumero[4] = Juego.jb_S;
        JuegoLogico.btnNumero[5] = Juego.jb_D;
        JuegoLogico.btnNumero[6] = Juego.jb_Z;
        JuegoLogico.btnNumero[7] = Juego.jb_X;
        JuegoLogico.btnNumero[8] = Juego.jb_C;
        for (int x = 0; x < btnNumero.length; x++) {
            JuegoLogico.btnNumero[x].setName(Integer.toString(x + 1));
        }
    }
    public static void mithread(){
        while(true){
            System.out.print("a");
            if(cliente.getserver() != -1 && contador != cliente.getserver()){
                System.out.print("as");
                try {
                    contador = cliente.getserver();
                    fichaX = new URL(cliente.getcliente());
                    ImageIcon cup;
                    cup = new ImageIcon(fichaX);
                    JuegoLogico.btnNumero[cliente.getserver()].setName("X");
                    JuegoLogico.btnNumero[cliente.getserver()].setText("");
                    JuegoLogico.btnNumero[cliente.getserver()].setIcon(cup);
                    
                    empate++;
                    
                    turno = true;
                } catch (MalformedURLException ex) {
                    Logger.getLogger(JuegoLogico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static  void numeroClikeado1(int numeroLbl) {

        int numeroAuxiliar = (int) (numeroLbl + 1);
        //Numero auxiliar para comparar el Numero string del 'name' de los botones

        if (JuegoLogico.btnNumero[numeroLbl].getName().equals(Integer.toString(numeroAuxiliar))) {

            if (turno) {
                if(turnox == 1){
                fichaX = JuegoLogico.class.getResource("../imagenes/fichaX.png");
                cup = new ImageIcon(fichaX);
                }
                else{
                fichaX = JuegoLogico.class.getResource("../imagenes/fichaO.png");
                cup = new ImageIcon(fichaX); 
                }
                JuegoLogico.btnNumero[numeroLbl].setName("X");
                JuegoLogico.btnNumero[numeroLbl].setText("");
                JuegoLogico.btnNumero[numeroLbl].setIcon(cup);
                cliente.enviarMsj(fichaX.toString());
                cliente.enviarMsj(numeroLbl);
                //hayGanador();

                empate++;

                turno = false;

            }

        } else {
            JOptionPane.showMessageDialog(null, "la casilla esta ocupada\nintente con otra");
        }
    }
    
    
   public static void juegaPC(){
        if(ganador==false){        
            if(turno==false){
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="O"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[1].getName()&&JuegoLogico.btnNumero[2].getName().equals(Integer.toString(3))){
                    numeroClikeado(2);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="O"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[2].getName()&&JuegoLogico.btnNumero[1].getName().equals(Integer.toString(2))){
                    numeroClikeado(1);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[2].getName()=="O"&&JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[1].getName()&&JuegoLogico.btnNumero[0].getName().equals(Integer.toString(1))){
                    numeroClikeado(0);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="O"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[4].getName()&&JuegoLogico.btnNumero[8].getName().equals(Integer.toString(9))){
                    numeroClikeado(8);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="O"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[8].getName()&&JuegoLogico.btnNumero[4].getName().equals(Integer.toString(5))){
                    numeroClikeado(4);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[4].getName()=="O"&&JuegoLogico.btnNumero[4].getName()==JuegoLogico.btnNumero[8].getName()&&JuegoLogico.btnNumero[0].getName().equals(Integer.toString(1))){
                    numeroClikeado(0);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="O"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[3].getName()&&JuegoLogico.btnNumero[6].getName().equals(Integer.toString(7))){
                    numeroClikeado(6);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="O"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[6].getName()&&JuegoLogico.btnNumero[3].getName().equals(Integer.toString(4))){
                    numeroClikeado(3);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[3].getName()=="O"&&JuegoLogico.btnNumero[3].getName()==JuegoLogico.btnNumero[6].getName()&&JuegoLogico.btnNumero[0].getName().equals(Integer.toString(1))){
                    numeroClikeado(0);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[1].getName()=="O"&&JuegoLogico.btnNumero[1].getName()==JuegoLogico.btnNumero[4].getName()&&JuegoLogico.btnNumero[7].getName().equals(Integer.toString(8))){
                    numeroClikeado(7);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[1].getName()=="O"&&JuegoLogico.btnNumero[1].getName()==JuegoLogico.btnNumero[7].getName()&&JuegoLogico.btnNumero[4].getName().equals(Integer.toString(5))){
                    numeroClikeado(4);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[4].getName()=="O"&&JuegoLogico.btnNumero[4].getName()==JuegoLogico.btnNumero[7].getName()&&JuegoLogico.btnNumero[1].getName().equals(Integer.toString(2))){
                    numeroClikeado(1);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[2].getName()=="O"&&JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[5].getName()&&JuegoLogico.btnNumero[8].getName().equals(Integer.toString(9))){
                    numeroClikeado(8);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[2].getName()=="O"&&JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[8].getName()&&JuegoLogico.btnNumero[5].getName().equals(Integer.toString(6))){
                    numeroClikeado(5);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[5].getName()=="O"&&JuegoLogico.btnNumero[5].getName()==JuegoLogico.btnNumero[8].getName()&&JuegoLogico.btnNumero[2].getName().equals(Integer.toString(3))){
                    numeroClikeado(2);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[3].getName()=="O"&&JuegoLogico.btnNumero[3].getName()==JuegoLogico.btnNumero[4].getName()&&JuegoLogico.btnNumero[5].getName().equals(Integer.toString(6))){
                    numeroClikeado(5);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[3].getName()=="O"&&JuegoLogico.btnNumero[3].getName()==JuegoLogico.btnNumero[5].getName()&&JuegoLogico.btnNumero[4].getName().equals(Integer.toString(5))){
                    numeroClikeado(4);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[4].getName()=="O"&&JuegoLogico.btnNumero[4].getName()==JuegoLogico.btnNumero[5].getName()&&JuegoLogico.btnNumero[3].getName().equals(Integer.toString(4))){
                    numeroClikeado(3);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[6].getName()=="O"&&JuegoLogico.btnNumero[6].getName()==JuegoLogico.btnNumero[7].getName()&&JuegoLogico.btnNumero[8].getName().equals(Integer.toString(9))){
                    numeroClikeado(8);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[6].getName()=="O"&&JuegoLogico.btnNumero[6].getName()==JuegoLogico.btnNumero[8].getName()&&JuegoLogico.btnNumero[7].getName().equals(Integer.toString(8))){
                    numeroClikeado(7);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[8].getName()=="O"&&JuegoLogico.btnNumero[8].getName()==JuegoLogico.btnNumero[7].getName()&&JuegoLogico.btnNumero[6].getName().equals(Integer.toString(7))){
                    numeroClikeado(6);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[2].getName()=="O"&&JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[4].getName()&&JuegoLogico.btnNumero[6].getName().equals(Integer.toString(7))){
                    numeroClikeado(6);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[2].getName()=="O"&&JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[6].getName()&&JuegoLogico.btnNumero[4].getName().equals(Integer.toString(5))){
                    numeroClikeado(4);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[4].getName()=="O"&&JuegoLogico.btnNumero[4].getName()==JuegoLogico.btnNumero[6].getName()&&JuegoLogico.btnNumero[2].getName().equals(Integer.toString(3))){
                    numeroClikeado(2);
                }else{}
                
                
                
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="X"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[1].getName()&&JuegoLogico.btnNumero[2].getName().equals(Integer.toString(3))){
                    numeroClikeado(2);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="X"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[2].getName()&&JuegoLogico.btnNumero[1].getName().equals(Integer.toString(2))){
                    numeroClikeado(1);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[2].getName()=="X"&&JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[1].getName()&&JuegoLogico.btnNumero[0].getName().equals(Integer.toString(1))){
                    numeroClikeado(0);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="X"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[4].getName()&&JuegoLogico.btnNumero[8].getName().equals(Integer.toString(9))){
                    numeroClikeado(8);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[8].getName()=="X"&&JuegoLogico.btnNumero[8].getName()==JuegoLogico.btnNumero[0].getName()&&JuegoLogico.btnNumero[4].getName().equals(Integer.toString(5))){
                    numeroClikeado(4);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[8].getName()=="X"&&JuegoLogico.btnNumero[8].getName()==JuegoLogico.btnNumero[4].getName()&&JuegoLogico.btnNumero[0].getName().equals(Integer.toString(1))){
                    numeroClikeado(0);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="X"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[3].getName()&&JuegoLogico.btnNumero[6].getName().equals(Integer.toString(7))){
                    numeroClikeado(6);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[0].getName()=="X"&&JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[6].getName()&&JuegoLogico.btnNumero[3].getName().equals(Integer.toString(4))){
                    numeroClikeado(3);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[3].getName()=="X"&&JuegoLogico.btnNumero[3].getName()==JuegoLogico.btnNumero[6].getName()&&JuegoLogico.btnNumero[0].getName().equals(Integer.toString(1))){
                    numeroClikeado(0);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[1].getName()=="X"&&JuegoLogico.btnNumero[1].getName()==JuegoLogico.btnNumero[4].getName()&&JuegoLogico.btnNumero[7].getName().equals(Integer.toString(8))){
                    numeroClikeado(7);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[1].getName()=="X"&&JuegoLogico.btnNumero[1].getName()==JuegoLogico.btnNumero[7].getName()&&JuegoLogico.btnNumero[4].getName().equals(Integer.toString(5))){
                    numeroClikeado(4);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[4].getName()=="X"&&JuegoLogico.btnNumero[4].getName()==JuegoLogico.btnNumero[7].getName()&&JuegoLogico.btnNumero[0].getName().equals(Integer.toString(1))){
                    numeroClikeado(1);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[2].getName()=="X"&&JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[5].getName()&&JuegoLogico.btnNumero[8].getName().equals(Integer.toString(9))){
                    numeroClikeado(8);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[2].getName()=="X"&&JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[8].getName()&&JuegoLogico.btnNumero[5].getName().equals(Integer.toString(6))){
                    numeroClikeado(5);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[5].getName()=="X"&&JuegoLogico.btnNumero[5].getName()==JuegoLogico.btnNumero[8].getName()&&JuegoLogico.btnNumero[2].getName().equals(Integer.toString(3))){
                    numeroClikeado(2);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[3].getName()=="X"&&JuegoLogico.btnNumero[3].getName()==JuegoLogico.btnNumero[4].getName()&&JuegoLogico.btnNumero[5].getName().equals(Integer.toString(6))){
                    numeroClikeado(5);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[3].getName()=="X"&&JuegoLogico.btnNumero[3].getName()==JuegoLogico.btnNumero[5].getName()&&JuegoLogico.btnNumero[4].getName().equals(Integer.toString(5))){
                    numeroClikeado(4);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[4].getName()=="X"&&JuegoLogico.btnNumero[4].getName()==JuegoLogico.btnNumero[5].getName()&&JuegoLogico.btnNumero[3].getName().equals(Integer.toString(4))){
                    numeroClikeado(3);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[6].getName()=="X"&&JuegoLogico.btnNumero[6].getName()==JuegoLogico.btnNumero[7].getName()&&JuegoLogico.btnNumero[8].getName().equals(Integer.toString(9))){
                    numeroClikeado(8);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[6].getName()=="X"&&JuegoLogico.btnNumero[6].getName()==JuegoLogico.btnNumero[8].getName()&&JuegoLogico.btnNumero[7].getName().equals(Integer.toString(8))){
                    numeroClikeado(7);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[7].getName()=="X"&&JuegoLogico.btnNumero[7].getName()==JuegoLogico.btnNumero[8].getName()&&JuegoLogico.btnNumero[6].getName().equals(Integer.toString(7))){
                    numeroClikeado(6);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[2].getName()=="X"&&JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[4].getName()&&JuegoLogico.btnNumero[6].getName().equals(Integer.toString(7))){
                    numeroClikeado(6);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[2].getName()=="X"&&JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[6].getName()&&JuegoLogico.btnNumero[4].getName().equals(Integer.toString(5))){
                    numeroClikeado(4);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[4].getName()=="X"&&JuegoLogico.btnNumero[4].getName()==JuegoLogico.btnNumero[6].getName()&&JuegoLogico.btnNumero[2].getName().equals(Integer.toString(3))){
                    numeroClikeado(2);
                }else{}
                
                
                
                if(turno==false&&JuegoLogico.btnNumero[4].getName().equals(Integer.toString(5))){
                    numeroClikeado(4);
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[4].getName()=="O"&&JuegoLogico.btnNumero[0].getName()=="X"&&
                JuegoLogico.btnNumero[0].getName()==JuegoLogico.btnNumero[8].getName()&&
                (JuegoLogico.btnNumero[1].getName().equals(Integer.toString(2))||JuegoLogico.btnNumero[7].getName().equals(Integer.toString(8))
                ||JuegoLogico.btnNumero[3].getName().equals(Integer.toString(4))||JuegoLogico.btnNumero[5].getName().equals(Integer.toString(6)))){
                    if(JuegoLogico.btnNumero[1].getName().equals(Integer.toString(2))&&turno==false){
                        numeroClikeado(1);
                    }
                    else if(JuegoLogico.btnNumero[7].getName().equals(Integer.toString(8))&&turno==false){
                        numeroClikeado(7);
                    }
                    else if(JuegoLogico.btnNumero[3].getName().equals(Integer.toString(4))&&turno==false){
                        numeroClikeado(3);
                    }
                    else if(JuegoLogico.btnNumero[5].getName().equals(Integer.toString(6))&&turno==false){
                        numeroClikeado(5);
                    }                    
                }else{}
                
                if(turno==false&&JuegoLogico.btnNumero[4].getName()=="O"&&JuegoLogico.btnNumero[2].getName()=="X"&&
                JuegoLogico.btnNumero[2].getName()==JuegoLogico.btnNumero[6].getName()&&
                (JuegoLogico.btnNumero[1].getName().equals(Integer.toString(2))||JuegoLogico.btnNumero[7].getName().equals(Integer.toString(8))
                ||JuegoLogico.btnNumero[3].getName().equals(Integer.toString(4))||JuegoLogico.btnNumero[5].getName().equals(Integer.toString(6)))){
                    if(JuegoLogico.btnNumero[1].getName().equals(Integer.toString(2))&&turno==false){
                        numeroClikeado(1);
                    }
                    else if(JuegoLogico.btnNumero[7].getName().equals(Integer.toString(8))&&turno==false){
                        numeroClikeado(7);
                    }
                    else if(JuegoLogico.btnNumero[3].getName().equals(Integer.toString(4))&&turno==false){
                        numeroClikeado(3);
                    }
                    else if(JuegoLogico.btnNumero[5].getName().equals(Integer.toString(6))&&turno==false){
                        numeroClikeado(5);
                    }                    
                }else{}
                
                
                
                if(turno==false&&JuegoLogico.btnNumero[0].getName().equals(Integer.toString(1))){
                    numeroClikeado(0);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[2].getName().equals(Integer.toString(3))){
                    numeroClikeado(2);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[8].getName().equals(Integer.toString(9))){
                    numeroClikeado(8);
                }else{}
                if(turno==false&&JuegoLogico.btnNumero[5].getName().equals(Integer.toString(6))){
                    numeroClikeado(5);
                }else{}                
            }
        }
    }    
    
}
