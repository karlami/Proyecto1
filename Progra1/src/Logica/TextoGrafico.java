
package Logica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class TextoGrafico implements Dibujable{
    
    String text;
    Color color;
    int anchoV;
    int altoV;
    int size;
    
    public TextoGrafico(String hola, Color color, int ancho, int alto){
        this.text = hola;
        this.color = color;
        this.size = 10;
        this.anchoV = ancho;
        this.altoV = alto;
    }
    
    public void borrarTexto(Graphics g, String txt){
        g.setColor(Color.darkGray);
        g.setFont(new Font("Algerian", Font.PLAIN, this.getSize()));
        int ancho = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
        int alto = (int) g.getFontMetrics().getAscent();
        int x = (this.anchoV/2 -ancho/2);
        int y = (this.altoV/2 + alto/4);
        g.drawString(txt, x, y);
    }
    
    public void pintarTexto(Graphics g, String txt){
        g.setColor(Color.blue);
        g.setFont(new Font("Algerian", Font.PLAIN, this.getSize()));
        int ancho = (int) g.getFontMetrics().getStringBounds(txt, g).getWidth();
        int alto = (int) g.getFontMetrics().getAscent();
        int x = (this.anchoV/2 -ancho/2);
        int y = (this.altoV/2 + alto/4);
        g.drawString(txt, x, y);
    }

    @Override
    public void dibujar(Graphics dw) {
        dw.setColor(color);
        dw.setFont(new Font("Monospaced", Font.PLAIN, this.getSize()));
        int ancho = (int) dw.getFontMetrics().getStringBounds(text, dw).getWidth();
        int alto = (int) dw.getFontMetrics().getAscent();
        int x = (this.anchoV/2 -ancho/2);
        int y = (this.altoV/2 + alto/4);
        dw.drawString(text, x, y);
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize(){
        return size;
    }
    public void setColor(Color color){
        this.color = color;
    }
}
