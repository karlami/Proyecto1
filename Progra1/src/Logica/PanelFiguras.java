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
    
    RectanguloGrafico enemigo1;
    RectanguloGrafico enemigo2;
    RectanguloGrafico enemigo3;
    RectanguloGrafico enemigo4;
    RectanguloGrafico enemigo5;
    
    
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
     * que recorre la lista de objetos, se pinta la imagen 
     * una vez dibujada
     * @param g 
     */
    @Override
    public void paint(Graphics g){
        //Contiene la dimension del grafico
        Dimension d = getSize();
        Image imagen = createImage(d.width,d.height);
        //Se le asignan los graficos de la imagen creada
        Graphics buff = imagen.getGraphics();
         
        Dibujable dib;
        for(int i=0;i<lista.getSize();i++){
            /**
             * Se transforma la lista en objeto dibujable
             * para poderlo asignar
             */
            dib = (Dibujable)lista.get(i);
            dib.dibujar(buff);
            g.drawImage(imagen, 0,0, null);
        }
            
        }
    
    @Override
    public void update(Graphics g){
        paint(g);
    }
    
            
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        
        if(tecla == KeyEvent.VK_LEFT){
            
            this.nave.mover(movimientoIzq);
            
        }
        if(tecla == KeyEvent.VK_RIGHT){
            
            this.nave.mover(movimientoDer);
          
        }
        //bala cada vez que se apreta espacio
        //se agrega a a lista de balas de la nave
        //y la lista de objtetos que se pinta
        if(tecla == KeyEvent.VK_Z){
            CirculoGrafico bala = nave.balaNave();
            nave.balas.add(bala);
            lista.add(bala);
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
        if(tecla == KeyEvent.VK_Z){}
    }
    
    public void refNave(TrianguloGrafico n){
        this.nave = n;
    }
    
    public void refEnem(RectanguloGrafico a,RectanguloGrafico b,RectanguloGrafico c,
    RectanguloGrafico d,RectanguloGrafico e){
        
        enemigo1 = a;
        enemigo2 = b;
        enemigo3 = c;
        enemigo4 = d;
        enemigo5 = e;
        
    }
    
    /*
    Intenta fijarse que si la lista de balas no esta vacia
    las mueve pintandolas
    */
    public void iniciar(){
        while(true){
            //para que salte una excepcion pero
            //que siga corriendo, por falta de memoria u otros
            try{
                if(!nave.balas.isEmpty()){
                    nave.ciclo();
                }
                enemigo5.setY(200);
                //se ejecute el while cada 50 miliseg (velocidad)
               Thread.sleep(50); 
            }catch(InterruptedException err)
            {
                System.out.println(err);
            }
            repaint();
            }
            
            
        }
    
    
    
}