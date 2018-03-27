
package Ejecuciones;
import Logica.*;
import EstructurasDatos.*;
import java.awt.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Ventana ventana = new Ventana("Invaders");
        ListaSimple listaDeObjetos = new ListaSimple();
        
        PanelFiguras panel = new PanelFiguras(listaDeObjetos);
        ventana.add(panel);
        ventana.setSize(500,400);
        ventana.setVisible(true);
        
        ListaSimple li = new ListaSimple();
        li.add(5);
        li.add(6);
        li.add(8);
        li.add(2);
        li.add(3);
        li.add(6);
        li.add(6);
        li.print();
        li.delete(9);
        li.print();
        li.get(2);
        li.getNode(5);
        li.print();
    }
    
}