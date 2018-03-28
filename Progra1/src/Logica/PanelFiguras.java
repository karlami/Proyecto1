/**
 * Donde salen los dibujos en pantalla
 */
package Logica;
import EstructurasDatos.ListaSimple;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
public class PanelFiguras extends JPanel implements KeyListener{
    
    ListaSimple lista;
    
    TrianguloGrafico nave;
    Coordenada movimientoIzq = new Coordenada(-25,0); //mov x en izquierda
    Coordenada movimientoDer = new Coordenada(25,0); //mov x en izquierda
    Coordenada movimientoNulo = new Coordenada(0,0); //mov x nulo
    /**
     * Constructor de la clase PanelFiguras
     * @param v todos los objetos a dibujar en panel que recibe del Main
     */
    
    public PanelFiguras(ListaSimple v){
        
        this.lista = v;
        this.addKeyListener(this);
        setFocusable(true);
        
    }
    /**
     * Crea objeto de tipo Dibujable y dbuja a medida
     * que recorre la lista de objetos
     * @param g 
     */
    @Override
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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        
        if(tecla == KeyEvent.VK_LEFT){
            this.nave.pintar(this.getGraphics(), Color.black);
            this.nave.mover(movimientoIzq);
            this.nave.pintar(this.getGraphics(), Color.pink);
        }
        if(tecla == KeyEvent.VK_RIGHT){
            this.nave.pintar(this.getGraphics(), Color.black);
            this.nave.mover(movimientoDer);
            this.nave.pintar(this.getGraphics(), Color.pink);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();
        
        if(tecla == KeyEvent.VK_LEFT){
            
            this.nave.mover(movimientoNulo);
            
        }
        if(tecla == KeyEvent.VK_RIGHT){
            
            this.nave.mover(movimientoNulo);
            
        }
    }
    
    public void refNave(TrianguloGrafico n){
        this.nave = n;
    }
    
}