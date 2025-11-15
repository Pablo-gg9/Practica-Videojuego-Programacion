
package pruebas;

/**
 *
 * @author Javier Ariza
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        JugadorPrueba j = new JugadorPrueba("Artemis", "Mag", 18, 7, 100, 25, 40, 80, 18, 120, 10);
     
        Enemigo e = new Enemigo("Yasi" , 1);
        e.calcularEstadisticasEnemigo();
        mostrarCombate(j, e);
        do{
        
        
        e.atacar(j);
        mostrarCombate(j, e);
        }while(j.getPs() > 0);
        ;
    }
    
    
    public static void mostrarCombate(JugadorPrueba jugador, Enemigo enemigo) {

    

    System.out.println();
    System.out.println("==================================================================");

    // ENEMIGO (arriba derecha)
   
        System.out.println(enemigo.toString());
    System.out.println("                           O");
    System.out.println("                          /|\\");
    System.out.println("                          / \\");
        System.out.println("                        ------------------------------------------");
    
    System.out.println();
    System.out.println("--------------------------------------------------");
    System.out.println();

    // JUGADOR (abajo izquierda)
        System.out.println("------------------------------------------");
    System.out.println("   O");
    System.out.println("  /|\\");
    System.out.println("  / \\");
    System.out.println(jugador.toString());
    

        System.out.println("==================================================================");
    System.out.println();
}

    
}


