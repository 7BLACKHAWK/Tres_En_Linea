/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Vista.Juego;
import java.awt.Color;
import java.net.URL;
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
    
    public static int v=0;
    public static int i=0;
    public static int n=0;
    public static int n1=0;
    public static int n2=0;
    public static int n3=0;
    public static int numero;
    
    public static void inicializarAtributos() {
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

            //validarTurno();

        } else {
//           if(txRecJ2.getText().equals("PC")){
//             RandomN();      
//            }else{
            JOptionPane.showMessageDialog(null, "La casilla esta ocupada \n intente con otra");
            //}
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
            ImageIcon icon = new ImageIcon("../imagenes/repeat_opt.png.jpg");
            int seleccion = JOptionPane.showConfirmDialog(null,"                   Juego empatado \n \n"+ 
            "            Quiere jugar otra partida?", "EMPATE", JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, icon);
            if (seleccion == 0) {
//            dispose();
//            MenuPrincipal principal1 = new MenuPrincipal();
//            principal1.setVisible(true);
//            principal1.Inicio();
            } else {

                
                System.exit(0);
            }
        }
    }
    
    public static void ganador() {
        
        int seleccion; 
        JuegoLogico.ganador = true;
        if (turno) {
//           Juego.SumadorJ1();
//           Juego.RestadorJ2();
//           Juego.listar();
////           Juego.ordenar();
////           Juego.listar();
//           Juego.Guardar();
           
           
            v=1;
//            this.lbInfo.setForeground(Color.red);
//            this.lbInfo.setText(txRecJ1.getText() + " has Ganado FELICITACIONES!");

            
           
            Juego.jb_Q.setEnabled(false);
            Juego.jb_W.setEnabled(false);
            Juego.jb_E.setEnabled(false);
            Juego.jb_A.setEnabled(false);
            Juego.jb_S.setEnabled(false);
            Juego.jb_D.setEnabled(false);
            Juego.jb_Z.setEnabled(false);
            Juego.jb_X.setEnabled(false);
            Juego.jb_C.setEnabled(false);
            
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
//            Juego.SumadorJ2();
//            Juego.RestadorJ1();
//            Juego.listar();
//            Juego.Guardar();

//            ImageIcon icon = new ImageIcon("../imagenes/repeat_opt.png.jpg");
            seleccion = JOptionPane.showConfirmDialog(null, 
            Juego.jt_J2.getText() + "\n has Ganado FELICITACIONES \n \n Quiere jugar otra partida?",
            "GANADOR JUGADOR 2", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

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

//            Juego.dispose();
            String j1 = Juego.jt_J1.getText();
            String j2 = Juego.jt_J2.getText();         
            Juego j = new Juego();
            j.setVisible(true);
            Juego.jt_J1.setText(j1);
            Juego.jt_J2.setText(j2);
//            icJ1.setIcon(MenuPrincipal.lbI1.getIcon());
//            icJ2.setIcon(MenuPrincipal.lbI2.getIcon());

            
        } else {
//            dispose();
//            MenuPrincipal m = new MenuPrincipal();
//            m.setVisible(true);
//            m.Inicio();
        }

    }
    
    
}
