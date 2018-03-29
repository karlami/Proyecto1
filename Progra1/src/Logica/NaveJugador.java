
package Logica;
import EstructurasDatos.ListaSimple;

public class NaveJugador extends Coordenada{
    
    public Coordenada cor1 = new Coordenada(); //Toma coordenada de la izquierda
    public Coordenada cor2 = new Coordenada(); //Toma coordenada de la derecha
    ListaSimple balas = new ListaSimple();
    
    /**
     * La coordenada que se hereda va a tomar el lugar
     * de la punta de la nave
     */
    public NaveJugador(){
        super();
        this.cor1.setX(0);
        this.cor1.setY(0);
        
        this.cor2.setX(0);
        this.cor2.setY(0);
        
    }
    
    public NaveJugador(Coordenada a, Coordenada b, Coordenada c){
        super(a.getX(),a.getY());
        this.cor1.setX(b.getX());
        this.cor1.setY(b.getY());
        
        this.cor2.setX(c.getX());
        this.cor2.setY(c.getY());
        
    }
    
    public NaveJugador(NaveJugador c){
        super(c.getX(),c.getY());
        
        this.cor1.setX(c.getX());
        this.cor1.setY(c.getY());
        
        this.cor2.setX(c.getX());
        this.cor2.setY(c.getY());
    }
    
    /**
     * Modificar la coordenada para volver a dibujarlo
     * @param nueva que indica la nueva posicion a moverse
     * @param lado modifica los lados para el movimiento
     */
    public void setVertice(Coordenada nueva, int lado){
        //Modifica la punta del triangulo
        if(lado == 1){
            this.setX(nueva.getX());
            this.setY(nueva.getY());
            
        }
        if(lado == 2){
            this.cor1.setX(nueva.getX());
            this.cor1.setY(nueva.getY());
            
        }
        if(lado == 3){
            this.cor2.setX(nueva.getX());
            this.cor2.setY(nueva.getY());
            
        }
    }
    
    public void mover(Coordenada nuevaCoord){
        //este metodo es el que se puede usar la logica para mantenerlos en el centro los enemigos
        setVertice(this.Suma(nuevaCoord), 1);
        setVertice(this.cor1.Suma(nuevaCoord), 2);
        setVertice(this.cor2.Suma(nuevaCoord), 3);
        
    }
}
