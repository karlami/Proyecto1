
package Logica;

public class Bala extends Coordenada{
    private float radio;
    
    public Bala(){
        super();
        this.radio = 0;
    }
    
    public Bala(Coordenada nueva, float radio){
        super(nueva);
        this.radio = radio;
    }
    public Bala(Bala bala){
        super(bala);
        this.radio = bala.radio;
        
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
    /**
     * Devolver la posicion del objeto situado
     * @return la coordenada con el centro del circulo
     */
    public Coordenada getCentro(){
        Coordenada centro = new Coordenada(this.getX(), this.getY());
        return centro;
    }
    
}
