
package Logica;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.*;
public class Ventana extends JFrame implements WindowListener{
    
    /**
     * Constructor de la clase Ventana
     * Llama al constructor del padre: JFrame y le manda el nombre del titulo
     * @param titulo que contiene el nombre del titulo del juego
     */
    
    public Ventana(String titulo){
        super(titulo);
        setSize(750,750);
        addWindowListener(this);
        setBackground(Color.DARK_GRAY);
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }
    
    /**
     * Nos permite cerrar la ventana
     * @param e 
     */

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    
}
