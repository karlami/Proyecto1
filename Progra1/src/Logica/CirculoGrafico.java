
package Logica;

import java.awt.Color;
import java.awt.Graphics;

public class CirculoGrafico extends Bala implements Dibujable{
    
    Color color;
    
    public CirculoGrafico(Coordenada cor, float radio, Color color){
        super(cor, radio);
        this.color = color;
    }

    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        dw.fillOval((int)(this.getX()-this.getRadio()), (int)(this.getY()-this.getRadio()), (int)(2*this.getRadio()), (int)(2*this.getRadio()));
        
    }
    
    
}
