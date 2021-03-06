/**
 * Donde salen los dibujos en pantalla
 */
package Logica;
import EstructurasDatos.ListaSimple;
import static Logica.RectanguloGrafico.aleatorio;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
public class PanelFiguras extends JPanel implements KeyListener{
    
    ListaSimple lista;
    ListaSimple listaEnemigos = new ListaSimple();
    
    TrianguloGrafico nave;
    
    Coordenada movimientoIzq = new Coordenada(-25,0); //mov x en izquierda
    Coordenada movimientoDer = new Coordenada(25,0); //mov x en izquierda
    Coordenada movimientoNulo = new Coordenada(0,0); //mov x nulo

    int contadorEnemigos = 5;
    int score;
    int vidas = 3;
    int mov = 5;
    int maxEnem =5;
    
    TextoGrafico txtPuntos;
    TextoGrafico txtVida;
    TextoGrafico txtFinal;
    
    Boolean finJuego = true;
   
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
        
        listaEnemigos.add(a);
        listaEnemigos.add(b);
        listaEnemigos.add(c);
        listaEnemigos.add(d);
        listaEnemigos.add(e);
    }
    

    public void refPuntos(TextoGrafico puntos){
        this.txtPuntos = puntos;
    }
    
    public void refVida(TextoGrafico vida){
        this.txtVida = vida;
    }
    
    public void refFinal(TextoGrafico textFinal){
        this.txtFinal = textFinal;
    }
    
    /**
     * Identificar cuando las coordenadas de los objetos estan iguales
     * o cerca (cuando las coordenadas de los extremos estan casi igualadas)
     */
    public void colision(){
        for(int i=0;i < nave.balas.getSize();i++){
            CirculoGrafico bala = (CirculoGrafico) nave.balas.get(i);
            //cada bala se comprar con cada enemigo
            for(int j=0;j<listaEnemigos.getSize();j++){
                RectanguloGrafico enemigos = (RectanguloGrafico) listaEnemigos.get(j);
                Coordenada coorBala = new Coordenada(bala.getX(), bala.getY());
                
                Coordenada coorDerecha = new Coordenada(enemigos.getX()+30, enemigos.getY());
                Coordenada coorIzquierda = new Coordenada(enemigos.getX()-15, enemigos.getY());
                //coordenada del enemigo en "x" y "y"
                Coordenada coorMedio = new Coordenada(enemigos.getX(), enemigos.getY());
                //ver si las coordenadas de la bala chocan con las del enemigo
                if(coorBala.getX() > coorIzquierda.getX() && coorBala.getX() < coorDerecha.getX()
                         && coorBala.getY() < coorMedio.getY() && (coorBala.getY()+25) > coorMedio.getY()){
                    enemigos.pintarR(Color.DARK_GRAY);
                    bala.pintarB(Color.DARK_GRAY);
                    bala.setY(-100);
                    enemigos.setY(-100);
                    nave.balas.delete(bala);
                    listaEnemigos.delete(enemigos);
                    contadorEnemigos--;
                    score = score + 5;
                    txtPuntos.setColor(Color.DARK_GRAY);
                    String nuevoScore = "" + score;
                    TextoGrafico newPuntos = new TextoGrafico(nuevoScore, Color.RED, 1700, 500);
                    newPuntos.setSize(40);
                    txtPuntos = newPuntos;
                    lista.add(txtPuntos);
                }
                //475 punta de la nave
                if((coorMedio.getY() > 475 && coorMedio.getY() < 550) &&
                        (nave.cor1.getX() < coorMedio.getX()) && (nave.cor2.getX() > coorMedio.getX())){
                    score = score -5;
                    vidas --;
                    //concatena el String vacio y el nuevo score
                    String nuevoScore = "" + score;
                    String nuevasVidas = "" + vidas;
                    txtVida.setColor(Color.DARK_GRAY);
                    txtPuntos.setColor(Color.DARK_GRAY);
                    TextoGrafico newVidas = new TextoGrafico(nuevasVidas, Color.red, 1700, 300);
                    newVidas.setSize(40);
                    txtVida = newVidas;
                    lista.add(txtPuntos);
                    TextoGrafico newPuntos = new TextoGrafico(nuevoScore, Color.red, 1700, 500);
                    newPuntos.setSize(40);
                    txtPuntos = newPuntos;
                    lista.add(txtVida);
                    
                    
                    listaEnemigos.delete(enemigos);
                    enemigos.setY(2000);
                    contadorEnemigos--;
                }
               
            }
            
        }
    }
    
    /**
     * Intenta fijarse que si la lista de balas no esta vacia
     * las mueve pintandolas
     */
    public void iniciar(){
        while(finJuego){
            //para que salte una excepcion pero
            //que siga corriendo, por falta de memoria u otros
            try{
                if(!nave.balas.isEmpty()){
                    nave.ciclo();
                }
                for(int i=0;i<listaEnemigos.getSize();i++){
                    RectanguloGrafico rect = (RectanguloGrafico) listaEnemigos.get(i);
                    rect.cicloR(mov);
                    //Si coordenada en "Y" es mayor que 525, volver a empezar de 0
                    if(rect.getY() > 525){
                        int rango = aleatorio(800,50);
                        rect.setY(0);
                        rect.setX(rango);    
                    }  
                }
                //este no lo ocupo porque es hasta que el
                //jefe este muerto, no necesitan volver a crearse
            if(contadorEnemigos < maxEnem)  {
                int rango = aleatorio(800,50);
                Coordenada inicio = new Coordenada(rango,0);
                RectanguloGrafico nuevo = new RectanguloGrafico(inicio, 25, 25, Color.red);
                listaEnemigos.add(nuevo);
                lista.add(nuevo);
                nuevo.cicloR(mov);
                contadorEnemigos++;
            } 
            
            int nivel =1;
            String niveles = "" + nivel;
            TextoGrafico textoNivel = new TextoGrafico("Nivel",Color.white,1700,600);
            textoNivel.setSize(50);
            TextoGrafico numTxtNivel = new TextoGrafico(niveles,Color.red,1700,700);
            numTxtNivel.setSize(50);
            lista.add(numTxtNivel);
            lista.add(textoNivel);
            //aumenta nivel en 1 cuando llega a 50 puntos
            //pinta a los enemigos de amarillo
            if(score >= 50 && score < 100){
                nivel = 2;
                String newNivel = "" + nivel;
                numTxtNivel.setColor(Color.darkGray);
                TextoGrafico numNivel = new TextoGrafico(newNivel, Color.red, 1700,700);
                numNivel.setSize(40);
                numTxtNivel = numNivel;
                lista.add(numTxtNivel);
                mov = 7;
                maxEnem = 6;
                for(int i=0;i<listaEnemigos.getSize();i++){
                    RectanguloGrafico rect = (RectanguloGrafico) listaEnemigos.get(i);
                    rect.pintarR(Color.yellow);
                }
            }
            
            if(vidas <= 0){
                finJuego = false;
                lista.add(txtFinal);
            }
  
            colision(); 
                
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
