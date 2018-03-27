/**
 * Donde salen los dibujos en pantalla
 */
package Logica;
import EstructurasDatos.ListaSimple;
import java.awt.*;
import javax.swing.JPanel;
public class Panel extends JPanel{
    
    ListaSimple lista;
    
    /**
     * Constructor de la clase Panel
     * @param v todos los objetos a dibujar en panel que recibe del Main
     */
    
    public Panel(ListaSimple v){
        
        this.lista = v;
        
    }
    /**
     * Crea objeto de tipo Dibujable y dbuja a medida
     * que recorre la lista de objetos
     * @param g 
     */
    public void paint(Graphics g){
        
        Dibujable dib;
        for(int i=0;i<lista.getSize();i++){
            /**
             * Se transforma la lista en objeto dibujable
             * para poderlo asignar
             */
            dib = (Dibujable)lista.get(i);
            dib.dibujar(g);
        }
    }
    
}