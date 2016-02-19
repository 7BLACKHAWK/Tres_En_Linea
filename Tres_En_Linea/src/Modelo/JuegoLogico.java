/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Vista.Juego;
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
//    public static ImageIcon iconX = new ImageIcon("../imagenes/fichaX.png");
//    public static ImageIcon iconO = new ImageIcon("../imagenes/fichaO.png");
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
                ImageIcon cup;
                cup = new ImageIcon(fichaX);
                JuegoLogico.btnNumero[numeroLbl].setName("X");
                JuegoLogico.btnNumero[numeroLbl].setText("");
                JuegoLogico.btnNumero[numeroLbl].setIcon(cup);

                //hayGanador();

                empate++;

                turno = false;

            } else {
                fichaO = JuegoLogico.class.getResource("../imagenes/fichaO.png");
                ImageIcon cup2;
                cup2 = new ImageIcon(fichaO);
                JuegoLogico.btnNumero[numeroLbl].setName("O");
                JuegoLogico.btnNumero[numeroLbl].setText("");
                JuegoLogico.btnNumero[numeroLbl].setIcon(cup2);
                 
                //hayGanador();

                empate++;

                turno = true;
            }

            //validarTurno();

        } else {
//           if(txRecJ2.getText().equals("PC")){
//             RandomN();      
//            }else{
            JOptionPane.showMessageDialog(null, "la casilla esta ocupada\nintente con otra");
            //}
        }
    }
}
