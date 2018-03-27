
package Logica;

import java.awt.Color;
import java.awt.Graphics;

public class RectanguloGrafico extends Enemigo implements Dibujable{
    Color color;
    
    public RectanguloGrafico(Coordenada cor, float x, float y, Color color){
        super(cor, x, y);
        this.color = color;
    }{
        
    }
    /**
     * Recibe un objeto de tipo Graphics para que se dibuje
     * @param dw de tipo Graphics
     */

    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        dw.fillRect((int)this.getX(), (int)this.getY(), (int)this.getLargo(), (int)this.getAncho());
        
        
     
    }
    
}
