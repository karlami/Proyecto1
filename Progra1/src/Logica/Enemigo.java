
package Logica;

public class Enemigo extends Coordenada{
    
    private float largo;
    private float ancho;
    
    public Enemigo(){
        super();
        this.largo = 0;
        this.ancho = 0;
    }
    public Enemigo(Coordenada cor, float x, float y){
       super(cor);
       this.largo = x;
       this.ancho = y;
    }
    public Enemigo(Enemigo nuevo){
        super(nuevo.getX(), nuevo.getY());
        this.largo = nuevo.largo;
        this.ancho = nuevo.ancho;
    }
}
