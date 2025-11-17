/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videojuegorpg;

/**
 *
 * @author Javier Ariza
 */
public class Videojuegorpg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JefeFinal j = new JefeFinal();
        Enemigo e = new Enemigo("Yasi" , 1);
        Jugador j1 = new Jugador("Javi" , "Mago");
        j1.iniciarClase();
        e.calcularEstadisticasEnemigo();
        
       
        do{
            
            mostrarCombate(j1, e);
            if(e.getPS() > 0)e.atacar(j1);
            mostrarCombate(j1,e);
            if(j1.getPS() > 0) j1.atacarEnemigo(e, false);
            
        }while(j1.getPS() > 0 && e.getPS() > 0);
            mostrarCombate(j1, e);
            if(j1.getPS() <= 0)  mostrarGameOver();
            else mostrarCombateDerrotaEnemigo(j1, e);
        
        // TODO code application logic here
    }
    
    
    
    
    
    public static void mostrarCombate(Jugador jugador, Enemigo enemigo) {

    

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
    
    public static void mostrarCombateDerrotaEnemigo(Jugador jugador, Enemigo enemigo) {

    System.out.println();
    System.out.println("==================================================");

    System.out.println(enemigo.toString());
    System.out.println("                           .-.");
    System.out.println("                          (X X)");
    System.out.println("                           \\_/");
    System.out.println("                        ------------------------------------------");
   
    
    System.out.println();
    System.out.println("--------------------------------------------------");
    System.out.println();


    System.out.println("------------------------------------------");
    System.out.println("   O");
    System.out.println("  /|\\");
    System.out.println("  / \\");
    System.out.println(jugador.toString());

    System.out.println("==================================================");
    System.out.println();
}
    
    public static void mostrarGameOver() {
    System.out.println();
    System.out.println("   _____          __  __ ______    ______      ________ _____  ");
    System.out.println("  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ ");
    System.out.println(" | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |");
    System.out.println(" | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / ");
    System.out.println(" | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ ");
    System.out.println("  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\");
    System.out.println();
}


    
}
