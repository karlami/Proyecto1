
package Ejecuciones;
import Logica.*;
import EstructurasDatos.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaSimple li = new ListaSimple();
        li.add(5);
        li.add(6);
        li.add(8);
        li.add(2);
        li.add(3);
        li.add(6);
        li.add(6);
        li.print();
        li.delete(9);
        li.print();
    }
    
}