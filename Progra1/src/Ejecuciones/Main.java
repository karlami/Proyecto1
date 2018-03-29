
package Ejecuciones;
import Logica.*;
import EstructurasDatos.*;
import java.awt.*;

public class Main {
    
    public static int aleatorio(int max, int min){
        return (int)(Math.random() * (max-min));
    }

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
        
        int rango = aleatorio(800,50);
        Coordenada salida = new Coordenada(rango,0);
        RectanguloGrafico enemigo1 = new RectanguloGrafico(salida,25,25,Color.red);
        
        int rango2 = aleatorio(800,50);
        Coordenada salida2 = new Coordenada(rango2,0);
        RectanguloGrafico enemigo2 = new RectanguloGrafico(salida2,25,25,Color.red);
        
        int rango3 = aleatorio(800,50);
        Coordenada salida3 = new Coordenada(rango3,0);
        RectanguloGrafico enemigo3 = new RectanguloGrafico(salida3,25,25,Color.red);
        
        int rango4 = aleatorio(800,50);
        Coordenada salida4 = new Coordenada(rango4,0);
        RectanguloGrafico enemigo4 = new RectanguloGrafico(salida4,25,25,Color.red);
        
        int rango5 = aleatorio(800,50);
        Coordenada salida5 = new Coordenada(rango5,0);
        RectanguloGrafico enemigo5 = new RectanguloGrafico(salida5,25,25,Color.red);
        
        listaDeObjetos.add(nave);
        listaDeObjetos.add(enemigo1);
        listaDeObjetos.add(enemigo2);
        listaDeObjetos.add(enemigo3);
        listaDeObjetos.add(enemigo4);
        listaDeObjetos.add(enemigo5);
        
        PanelFiguras panel = new PanelFiguras(listaDeObjetos);
        panel.refNave(nave);
        panel.refEnem(enemigo1, enemigo2, enemigo3, enemigo4, enemigo5);
        ventana.add(panel);
        ventana.setSize(800,600);
        ventana.setVisible(true);
        panel.iniciar();
        
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