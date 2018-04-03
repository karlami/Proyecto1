
package Logica;

import java.awt.Color;
import java.awt.Graphics;

public class RectanguloGrafico extends Enemigo implements Dibujable{
    Color color;
    
    public RectanguloGrafico(Coordenada cor, float x, float y, Color color){
        super(cor, x, y);
        this.color = color;
    }
    
    /**
     * Mediante dos numeros enteros se crea rango que sera usado
     * para tomar un entero random entre ese rango
     * @param Max forma parte del extremo del rango, debe ser el maximo
     * @param Min forma parte del extremo del rango, debe ser el minimo
     * @return 
     */
    public static int aleatorio(int Max, int Min)
    {
        return (int) (Math.random() *(Max-Min));
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
    /**
     * Toma la coordenada del enemigo en "y" para sumarla
     * @param mov para poder cambiar la velocidad de los enemigos
     */
    public void cicloR(int mov){
        float y = this.getY();
        this.setY(y += mov);
    }
    
    public void pintarR(Color color){
        this.color = color;
    }
}
