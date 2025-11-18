/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videojuegorpg;

import java.util.Scanner;

/**
 *
 * @author Javier Ariza
 */
public class Videojuegorpg {

    /**
     * @param args the command line arguments
     */
    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        int compra;
        int ataque;
        int objeto;
        String nombreJ;
        String[] nombresE = {"Yasi", "Guille", "Cham", "Javi", "Pablo", "Katherine", "Tomas", "Fernando"};
        JefeFinal j = new JefeFinal();
        Enemigo e = new Enemigo("Yasi", 1);
        Jugador j1 = new Jugador("Javi", "Mago");
        j1.iniciarClase();

        do {
            System.out.println("----MENU DE OPCIONES----");
            System.out.println("1. Luchar con un enemigo");
            System.out.println("2. Mostrar Estadisticas");
            System.out.println("3. Tienda der Yaser");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("");
                    System.out.println("--------------------------------------------");
                    System.out.println("Has iniciado un nuevo combate contra " + e.getNombre());
                    System.out.println("");
                    e.calcularEstadisticasEnemigo();

                    do {
                        mostrarCombate(j1, e);

                        //Depende de la velocidad pegara uno antes u otro
                        if (j1.getVel() > e.getVel()) {

                            // --- JUGADOR ATACA PRIMERO ---
                            if (j1.getPS() > 0) {
                                System.out.print("1. Ataque Basico");
                                System.out.println("   2. Ataque Especial");
                                System.out.println("3. Usar Objetos");
                                ataque = teclado.nextInt();
                                switch (ataque) {
                                    case 1:
                                        j1.atacarEnemigo(e, true);
                                        break;
                                    case 2:
                                        j1.atacarEnemigo(e, false);
                                        break;
                                    case 3:
                                        j1.usarObjeto();
                                        break;
                                }
                                mostrarCombate(j1, e);
                            }

                            if (e.getPS() > 0) {
                                e.atacar(j1);
                            }

                        } else if (j1.getVel() < e.getVel()) {

                            // --- ENEMIGO ATACA PRIMERO ---
                            if (e.getPS() > 0) {
                                e.atacar(j1);
                            }
                            mostrarCombate(j1, e);

                            if (j1.getPS() > 0) {
                                System.out.print("1. Ataque Basico");
                                System.out.println("   2. Ataque Especial");
                                System.out.println("3. Usar Objetos");
                                ataque = teclado.nextInt();
                                switch (ataque) {
                                    case 1:
                                        j1.atacarEnemigo(e, true);
                                        break;
                                    case 2:
                                        j1.atacarEnemigo(e, false);
                                        break;
                                    case 3:
                                        j1.usarObjeto();
                                        break;
                                }
                            }

                        } else {
                            // Esto genera un booleano seudo aleatorio para decidir quien ataca primero
                            if (new java.util.Random().nextBoolean()) {

                                // --- JUGADOR PRIMERO ---
                                if (j1.getPS() > 0) {
                                    System.out.print("1. Ataque Basico");
                                    System.out.println("   2. Ataque Especial");
                                    System.out.println("3. Usar Objetos");
                                    ataque = teclado.nextInt();
                                    switch (ataque) {
                                        case 1:
                                            j1.atacarEnemigo(e, true);
                                            break;
                                        case 2:
                                            j1.atacarEnemigo(e, false);
                                            break;
                                        case 3:
                                            j1.usarObjeto();
                                            break;
                                    }
                                }
                                mostrarCombate(j1, e);

                                if (e.getPS() > 0) {
                                    e.atacar(j1);
                                }

                            } else {

                                // --- ENEMIGO PRIMERO ---
                                if (e.getPS() > 0) {
                                    e.atacar(j1);
                                }
                                mostrarCombate(j1, e);

                                if (j1.getPS() > 0) {
                                    System.out.print("1. Ataque Basico");
                                    System.out.println("   2. Ataque Especial");
                                    System.out.println("3. Usar Objetos");
                                    ataque = teclado.nextInt();
                                    switch (ataque) {
                                        case 1:
                                            j1.atacarEnemigo(e, true);
                                            break;
                                        case 2:
                                            j1.atacarEnemigo(e, false);
                                            break;
                                        case 3:
                                            j1.usarObjeto();
                                            break;
                                        default:
                                            System.out.println("");
                                           
                                    }
                                }
                            }
                        }

                    } while (j1.getPS() > 0 && e.getPS() > 0);

                    if (j1.getPS() <= 0) {
                        mostrarGameOver();
                    } else if (e.getPS() <= 0) {
                        mostrarCombateDerrotaEnemigo(j1, e);
                        e.dropGold(j1);
                        break;
                    }

                    break;
                case 2:
                    System.out.println(j1);
                    break;
                case 3:
                    System.out.println("===============================================");
                    System.out.println("                 TIENDA DER YASER");
                    System.out.println("===============================================\n");

                    System.out.println("                  O");
                    System.out.println("                 /|\\   <- YASI");
                    System.out.println("                 / \\ \n");

                    System.out.println("Objetos disponibles:\n");
                    System.out.println("Illo si no quieres na vete. (pulsa 0)\n");

                    System.out.println(
                            "   1.ESPADA             2.COLLAR VIDA               3.ARMADURA                  4.BOTAS\n"
                            + "     />                   __\\/__                    /========\\                ___     ___\n"
                            + " (===(============>      /      \\                  |  [____]  |              |   |   |   |\n"
                            + "     \\>                 |   <3   |                 |  |    |  |              |___|   |___|\n"
                            + "                         \\______/                  |  |____|  |              (___)   (___)\n"
                            + "                                                    \\________/                      \n"
                    );

                    System.out.println(
                            "   5.ANILLO MAGICO        6.POCION VIDA            7.POCION MANA              8.POCION RESIST. FUEGO\n"
                            + "     ____                   (~~)                      (~~)                         (~~)\n"
                            + "   /      \\                (    )                    (    )                       (    )\n"
                            + "  |  (  )  |               ( VV )                    ( MM )                       ( FF )\n"
                            + "   \\______/                (____)                    (____)                       (____)\n"
                    );

                    do {
                        compra = teclado.nextInt();
                        j1.comprar(compra);
                    } while (compra != 0);

                    System.out.println("===============================================");
                    System.out.println("     ¡Gracias por visitar la tienda de YASER!");
                    System.out.println("===============================================\n");

                    break;

            }
        } while (j1.getPS() > 0 && opcion != 6);
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
        System.out.println("HAS DERROTADO A " + enemigo.getNombre());
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
