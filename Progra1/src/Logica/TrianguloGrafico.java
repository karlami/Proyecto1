
package Logica;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Polygon;

public class TrianguloGrafico extends NaveJugador implements Dibujable{
    
    Color color;
    
    public TrianguloGrafico(Coordenada a, Coordenada b, Coordenada c, Color color){
        super(a,b,c);
        this.color = color;
    }
    
    /**
     * Se usa para dibujar un poligono que ocupa todas las coordenas en "x"
     * y todas las coordenadas en "y" y de cuantos lados sera
     * @param dw para dibujar el triangulo
     */
    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        int []x = {(int)this.getX(),(int)this.cor2.getX(), (int)this.cor1.getX()};
        int []y = {(int)this.getY(),(int)this.cor1.getY(), (int)this.cor1.getY()};
        
        Polygon p = new Polygon(x,y,3);
        dw.fillPolygon(p);
    }
    
    
}
