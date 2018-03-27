
package Logica;

public class Nave extends Coordenada{
    
    private float largo;
    private float ancho;
    
    public Nave(){
        super();
        this.largo = 0;
        this.ancho = 0;
    }
    public Nave(Coordenada cor, float x, float y){
       super(cor);
       this.largo = x;
       this.ancho = y;
    }
    public Nave(Nave nuevo){
        super(nuevo.getX(), nuevo.getY());
        this.largo = nuevo.largo;
        this.ancho = nuevo.ancho;
    }
}
