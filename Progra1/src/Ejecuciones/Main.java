
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
        Coordenada cor1 = new Coordenada(250,250);
        RectanguloGrafico enemigo = new RectanguloGrafico(cor1,50,50,Color.blue);
        Coordenada cor2 = new Coordenada(500,250);
        //nave
        Coordenada cor3 = new Coordenada(475,500);
        Coordenada cor4 = new Coordenada(425,575);
        Coordenada cor5 = new Coordenada(525,575);
        TrianguloGrafico nave = new TrianguloGrafico(cor3,cor4,cor5,Color.pink);
        
        CirculoGrafico bala = new CirculoGrafico(cor2,50,Color.BLACK);
        
        //listaDeObjetos.add(enemigo);
        //listaDeObjetos.add(bala);
        listaDeObjetos.add(nave);
        
        PanelFiguras panel = new PanelFiguras(listaDeObjetos);
        panel.refNave(nave);
        ventana.add(panel);
        ventana.setSize(800,600);
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