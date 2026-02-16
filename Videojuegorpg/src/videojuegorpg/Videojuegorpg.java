/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videojuegorpg;

import java.io.FileOutputStream;
import java.io.*;
import java.io.ObjectOutputStream;
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

    public static String opcionInventario() {
        String opcion;
        teclado.nextLine();
        System.out.println("Introduce una opcion de los objetos disponibles");
        opcion = teclado.nextLine();
        opcion=opcion.toUpperCase();
        System.out.println("La opcion es: " +opcion);
        return opcion;
    }
    
    public static void comprar(String opcion,Inventario i1,Jugador j1){
    if(opcion.equals("ESPADA")||opcion.equals("ARMADURA")||opcion.equals("BOTAS")){
    
        j1.setGold(j1.getGold()-7);
        i1.agregarObjetoAtaque(opcion, 2);
        i1.mostrarInventario();
    }
    else if(opcion.equals("COLLAR VIDA")||opcion.equals("ANILLO MAGICO")||opcion.equals("POCION VIDA")||opcion.equals("POCION MANA")||opcion.equals("POCION FUEGO")){
    
        j1.setGold(j1.getGold()-7);
        i1.agregarObjetosVida(opcion, 2);
    }
        
        
        
    }

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        //Declaracion de variables, la mayoria son enteros para elegir opciones en los switches
        Musica musica1 = new Musica();
        int opcion, opcion2;
        int compra;
        int ataque;
        int ataqueJefe;
        String nombreJ, opcionInvent;
        int numeroClase;
        String[] nombreClase = {"Mago", "Guerrero", "Picaro", "Tanque", "Clerigo"}; //Esta variable me permite elegir clase seleccionando su pusicion para que el usuario no se equivque al escribirla
        boolean escapar = false;
        int contadorCombates = 1;
        Jugador j1 = null;
        Inventario i1 = null;

        String[] nombresE = {"Yasi", "Guille", "Cham", "Javi", "Pablo", "Katherine", "Tomas", "Fernando"}; //Este array me guarda los nombre de los enemigos

        System.out.println(" ___       ________  ________  ________          ________  ________      _________  ___  ___  _______           ___       ________  ___       __   ________      \n"
                + "|\\  \\     |\\   __  \\|\\   __  \\|\\   ___ \\        |\\   __  \\|\\  _____\\    |\\___   ___\\\\  \\|\\  \\|\\  ___ \\         |\\  \\     |\\   __  \\|\\  \\     |\\  \\|\\   ____\\     \n"
                + "\\ \\  \\    \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\       \\ \\  \\|\\  \\ \\  \\__/     \\|___ \\  \\_\\ \\  \\\\\\  \\ \\   __/|        \\ \\  \\    \\ \\  \\|\\  \\ \\  \\    \\ \\  \\ \\  \\___|_    \n"
                + " \\ \\  \\    \\ \\  \\\\\\  \\ \\   _  _\\ \\  \\ \\\\ \\       \\ \\  \\\\\\  \\ \\   __\\         \\ \\  \\ \\ \\   __  \\ \\  \\_|/__       \\ \\  \\    \\ \\   __  \\ \\  \\  __\\ \\  \\ \\_____  \\   \n"
                + "  \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\\\  \\\\ \\  \\_\\\\ \\       \\ \\  \\\\\\  \\ \\  \\_|          \\ \\  \\ \\ \\  \\ \\  \\ \\  \\_|\\ \\       \\ \\  \\____\\ \\  \\ \\  \\ \\  \\|\\__\\_\\  \\|____|\\  \\  \n"
                + "   \\ \\_______\\ \\_______\\ \\__\\\\ _\\\\ \\_______\\       \\ \\_______\\ \\__\\            \\ \\__\\ \\ \\__\\ \\__\\ \\_______\\       \\ \\_______\\ \\__\\ \\__\\ \\____________\\____\\_\\  \\ \n"
                + "    \\|_______|\\|_______|\\|__|\\|__|\\|_______|        \\|_______|\\|__|             \\|__|  \\|__|\\|__|\\|_______|        \\|_______|\\|__|\\|__|\\|____________|\\_________\\\n"
                + "                                                                                                                                                     \\|_________|\n"
                + "                                                                                                                                                                 \n"
                + "                                                                                                                                                                 ");

        do {
            System.out.println("1.NUEVA PARTIDA");
            System.out.println("2.CARGAR PARTIDA");
            System.out.println("");

            opcion2 = teclado.nextInt();
        } while (opcion2 != 1 && opcion2 != 2);

        if (opcion2 == 1) {

            System.out.println("                                             _______________________\n"
                    + "   _______________________-------------------                       `\\\n"
                    + " /:--__                                                              |\n"
                    + "||< > |                                   ___________________________/\n"
                    + "| \\__/_________________-------------------                         |\n"
                    + "|                                                                  |\n"
                    + " |                       THE LORD OF THE LAWS                       |\n"
                    + " |                                                                  |\n"
                    + " |    \"Hola viajero, sentimos informarle de que ha sido sentenciado |\n"
                    + "  |      a muerte por el poder y derecho del Señor Ausente, usted     |\n"
                    + "  |      al igual que otros muchos ha sido convocado al aula 2.1      |\n"
                    + "  |        donde le espera una larga y agonica disputa por su vida,   |\n"
                    + "  |         pero nuestro poderoso señor le ha concedido una pequeña  |\n"
                    + "   |       oportunidad para conservar la vida, tendra que pelear     |\n"
                    + "   |       contra sus hordas de monstruos de DAM, el los llama      |\n"
                    + "   |     'programadores', criaturas que no saben lo que es la luz.    |\n"
                    + "  |       Si sobrevive, tendra el placer de perecer ante el amo.     |\n"
                    + "  |        Buena suerte.                         ____________________|_\n"
                    + "  |  ___________________-------------------------                      `\\\n"
                    + "  |/`--_                                                                 |\n"
                    + "  ||[ ]||                                            ___________________/\n"
                    + "   \\===/___________________--------------------------\n");

            System.out.print("Introduce tu nombre: ");
            nombreJ = teclado.nextLine();
            do {
                System.out.println("                                                                                                                                                             .                                                           \n"
                        + "                                                                                                                                                            /.\\                                                          \n"
                        + "                                                                                                                                                            |.|                                                          \n"
                        + "                                                                                                                                                            |.|                                                          \n"
                        + "                                                                                                                                                            |.|                                                          \n"
                        + "                                                                                                                                                            |.|   ,'`.                                                   \n"
                        + "                                                                                                                                                            |.|  ;\\  /:                                                  \n"
                        + "                                                                                                                                                            |.| /  \\/  \\                                                 \n"
                        + "                                                                                                                                                            |.|<.<_\\/_>,>                                                \n"
                        + "                                  ....                                                                                                                      |.| \\`.::,'/                                   \\ : /         \n"
                        + "                                .'' .'''                                                                              .;;,.                                 |.|,'.'||'/.                                      '-: __ :-' \n"
                        + ".                             .'   :                                                                                ; '\" ;\\ \\//                          ,-'|.|.`.____,'`.                                    -:  )(_ :--\n"
                        + "\\                          .:    :                                                                                 \\|a (a|7 \\//                        ,' .`|.| `.____,;/ \\                                   -' |r-_i'- \n"
                        + " \\                        _:    :       ..----.._                                                                  j| ..  | ||/                       ,'=-.`|.|\\ .   \\ |,':                           ,sSSSSs,   (2-,7   \n"
                        + "  \\                    .:::.....:::.. .'         ''.                          ;_.JL___;                           //'.--.')\\-,/                      /_   :)|.|.`.___:,:,'|.                          sS';:'`Ss   )-j    \n"
                        + "   \\                 .'  #-. .-######'     #        '.                        F\"-/\\_-7L                         .-||- '' ||/  `-.                   (  `-:;\\|.|.`.)  |.`-':,\\                        ;K e (e s7  /  (    \n"
                        + "    \\                 '.##'/ ' ################       :                       | a/ e | \\                       ;  | \\ |/ |/ L.  ,|                  /.   /  ;.:--'   |    | ,`.                       S, ''  SJ (  ;/    \n"
                        + "     \\                  #####################         :                      ,L,c;,.='/;,                      f\\ |\\| Y  || \\ '._\\                 / _>-'._.'-'.     |.   |' / )._                    sL_~~_;(S_)  _7    \n"
                        + "      \\               ..##.-.#### .''''###'.._        :                   _,-;;S:;:S;;:' '--._                j | \\|     (| |   | |               :.'    ((.__;/     |    |._ /__ `.___   |,          'J)_.-' />'-' `Z   \n"
                        + "       \\             :--:########:            '.    .' :                 ;. \\;;s:::s;;: .'   /\\              |  L_\\         L.__: |               `.>._.-' |)=(      |.   ;  '--.._,`-.`. j J         /-;-A'-'|'--'-j\\   \n"
                        + "        \\..__...--.. :--:#######.'   '.         '.     :                /  \\  ;::::;;  /    /  \\              \\(  '-.,-,    |   ; |                        ',--'`-._ | _,:          `='`'  L L        )  |/   :    /  \\  \n"
                        + "        :     :  : : '':'-:'':'::        .         '.  .'              / ,  k ;S';;'S.'    j __,l              |'-.'.L_rr>  f--f  |                        /_`-. `..`:'/_.\\                 \\ \\       | | |    '._.'|  L \n"
                        + "        '---'''..: :    ':    '..'''.      '.        :'             ,---/| /  /S   /S '.   |'   ; .-=,,______,--------- J-. ;  ;__                        :__``--..\\\\_/_..:                  \\ \\      | | |       | \\  J \n"
                        + "           \\  :: : :     '      ''''''.     '.      .:             ,Ljjj |/|.' s .' s   \\  L    |    ``\"-,__   |  |      h  |  f  '--.__                  |  ``--..,:;\\__.|                   \\ \\    _/ | |       |  ',| \n"
                        + "            \\ ::  : :     '            '.      '      :            LL,_ ]( \\    /    '.  '.||   ;        `--;;--,_       h  f-j   |   __;==-.             |`--..__/:;  :__|                    \\ L.,' | | |       |   |/ \n"
                        + "             \\::   : :           ....' ..:       '     '.          ||\\ > /  ;-.'_.-.___\\.-'(|==\"(             / `-''-,,__J,'  \\_..--:'-'     '            `._____:-;_,':__;                   _;-r-<_.| \\=\\    __.;  _/  \n"
                        + "              \\::  : :    .....####\\ .~~.:.             :          JJ,\" /   |_  [   ]     _]|   /             | |    `' --L7//'-'`|                        |:'    /::'  `|                      {_}\"  L-'  '--'   / /|   \n"
                        + "               \\':.:.:.:'#########.===. ~ |.'-.   . '''.. :         LL\\/   ,' '--'-'-----'  \\  (              | ,     ||  h    |  (                        |,---.:  :,-'`;                            |   ,      |  \\|   \n"
                        + "                \\    .'  ########## \\ \\ _.' '. '-.       '''.       ||     ;      |          |  >             | ;     | \\ J    j   |                       : __  )  ;__,'\\                            |   |      |   \")  \n"
                        + "                :\\  :     ########   \\ \\      '.  '-.        :      JJ     |      |\\         |,/              | L__   | |  L_.'    |                       \\' ,`/   \\__  :                            L   ;|     |   /|  \n"
                        + "               :  \\'    '   #### :    \\ \\      :.    '-.      :      LL    |      ||       ' |                |   |'-.| L.'h  |  : |                       :. |,:   :  `./                           /|    ;     |  / |  \n"
                        + "              :  .'\\   :'  :     :     \\ \\       :      '-.    :     ||    |      ||       . |                |;  \\     |  J ; : : |                       | `| |   |   |:                          | |    ;     |  ) |  \n"
                        + "             : .'  .\\  '  :      :     :\\ \\       :        '.   :    JJ    /_     ||       ;_|                | :  (    \\  'L| : : |                       |  | |   |   ||                         |  |    ;|    | /  |  \n"
                        + "             ::   :  \\'  :.      :     : \\ \\      :          '. :     LL   L \"==='|i======='_|                | ;   \\'.--|    \\  : |                       |  | |   |   ||                         | ;|    ||    | |  |  \n"
                        + "             ::. :    \\  : :      :    ;  \\ \\     :           '.:     ||    i----' '-------';                 | | : \\    \\-, /`\\ : |                       |  | |   '   ||                         L-'|____||    )/   |  \n"
                        + "              : ':    '\\\\ :  :     :     :  \\:\\     :        ..'      JJ    ';-----.------,-'                 L-'-;__\\   \\\\ '  | | |                       |  : |    \\  ||                             % %/ '-,- /    /  \n"
                        + "                 :    ' \\ :        :     ;  \\|      :   .'''           LL     L_.__J,'---;'                           ;   \\\\   |'L_j                       |  ; :    :  ||                     snd     |% |   \\%/_    |  \n"
                        + "                 '.   '  \\:                         :.''               ||      |   ,|    (                            _>  _|   |                           | / ,;    |\\,'`.                         ___%  (   )% |'-; |  \n"
                        + "                  .:..... \\:       :            ..''                   JJ     .'=  (|  ,_|                           <___/ /-  \\                           ;-.(,'    '-._,-`.                     C;.---..'   >%,(   \"'  \n"
                        + "                 '._____|'.\\......'''''''.:..'''                        LL   /    .'L_    \\                               /    /                         ,'-.//          `--'                                /%% /       \n"
                        + "                            \\                                           ||   '---'    '.___>                              '---'                          `---'                                              Cccc'        ");
                System.out.println("                          === Mago(0)===                                 ===Guerrero(1)===                     ===Picaro(2)===                            ===Tanque(3)===                            ===Clerigo(4)=== ");
                System.out.println("                      Ataque Especial: 15 mana                        Ataque Especial: 10 mana              Ataque Especial: 20 mana                   Ataque Especial: 10 mana                  Ataque Especial: 10 mana");
                System.out.println("                      Ignora armadura                                 Hacer doble tirada                    Hace doble de daño                         Sube su armadura                          Se cura");
                System.out.println("Introduce tu clase: ");
                numeroClase = teclado.nextInt();

                System.out.println("");
                if ((numeroClase < 0 || numeroClase > 4)) {
                    System.out.println("Esta opcion no esta disponible");
                }
            } while (numeroClase < 0 || numeroClase > 4);

            j1 = new Jugador(nombreJ, nombreClase[numeroClase]);
            j1.iniciarClase();
            i1 = new Inventario();
        } else {
            try {
                ObjectInputStream cargar = new ObjectInputStream(new FileInputStream("partidaguardada.dat"));
                j1 = (Jugador) cargar.readObject();
                i1 = (Inventario) cargar.readObject();
            } catch (IOException e) {
                System.err.println("Error al cargar la partida" + e.toString());
            }
        }
        JefeFinal d = new JefeFinal();
        do {
            musica1.detenerMusicaFondo();
            musica1.reproducirMusicaFondo("Sonidos/Fondo_1.wav");

            System.out.println("==================================================================================");
            System.out.println("  __  __                        _                         _                       \n"
                    + " |  \\/  | ___ _ __  _   _    __| | ___    ___  _ __   ___(_) ___  _ __   ___  ___ \n"
                    + " | |\\/| |/ _ \\ '_ \\| | | |  / _` |/ _ \\  / _ \\| '_ \\ / __| |/ _ \\| '_ \\ / _ \\/ __|\n"
                    + " | |  | |  __/ | | | |_| | | (_| |  __/ | (_) | |_) | (__| | (_) | | | |  __/\\__ \\\n"
                    + " |_|  |_|\\___|_| |_|\\__,_|  \\__,_|\\___|  \\___/| .__/ \\___|_|\\___/|_| |_|\\___||___/\n"
                    + "                                              |_|                                 ");
            System.out.println("==================================================================================");

            System.out.println("                                                                                    \n"
                    + " ___        __            _                                               _         \n"
                    + "|_  |      |  |   _ _ ___| |_ ___ ___    ___ ___ ___    ___ ___ ___ _____|_|___ ___ \n"
                    + " _| |_ _   |  |__| | |  _|   | .'|  _|  |  _| . |   |  | -_|   | -_|     | | . | . |\n"
                    + "|_____|_|  |_____|___|___|_|_|__,|_|    |___|___|_|_|  |___|_|_|___|_|_|_|_|_  |___|\n"
                    + "                                                                           |___|    ");
            System.out.println("                                                                                       \n"
                    + " ___      _____         _                          _         _ _     _   _             \n"
                    + "|_  |    |     |___ ___| |_ ___ ___ ___    ___ ___| |_ ___ _| |_|___| |_|_|___ ___ ___ \n"
                    + "|  _|_   | | | | . |_ -|  _|  _| .'|  _|  | -_|_ -|  _| .'| . | |_ -|  _| |  _| .'|_ -|\n"
                    + "|___|_|  |_|_|_|___|___|_| |_| |__,|_|    |___|___|_| |__,|___|_|___|_| |_|___|__,|___|\n"
                    + "                                                                                       ");
            System.out.println("                                                                              \n"
                    + " ___      _____ _           _          _        __ __ _____ _____ _____ _____ \n"
                    + "|_  |    |_   _|_|___ ___ _| |___    _| |___   |  |  |  _  |   __|   __| __  |\n"
                    + "|_  |_     | | | | -_|   | . | .'|  | . | -_|  |_   _|     |__   |   __|    -|\n"
                    + "|___|_|    |_| |_|___|_|_|___|__,|  |___|___|    |_| |__|__|_____|_____|__|__|\n"
                    + "                                                                              ");
            System.out.println("                                                  \n"
                    + " ___      _____                 _           _     \n"
                    + "| | |    |     |___ _ _ ___ ___| |_ ___ ___|_|___ \n"
                    + "|_  |_   |-   -|   | | | -_|   |  _| .'|  _| | . |\n"
                    + "  |_|_|  |_____|_|_|\\_/|___|_|_|_| |__,|_| |_|___|\n"
                    + "                                                  "
                    + "                                         ");
            System.out.println("                                                                                               _                              _   \n"
                    + " ___      __            _                          _                 __ _____ _____ _____    _|_|    _         _    ___   ___|_|_ \n"
                    + "|  _|    |  |   _ _ ___| |_ ___ ___    ___ ___ ___| |_ ___ ___    __|  |   __|   __|   __|  | |  ___|_|_ _ ___| |  |_  | |   | | |\n"
                    + "|_  |_   |  |__| | |  _|   | .'|  _|  |  _| . |   |  _|  _| .'|  |  |  |   __|   __|   __|  | | |   | | | | -_| |   _| |_| | | | |\n"
                    + "|___|_|  |_____|___|___|_|_|__,|_|    |___|___|_|_|_| |_| |__,|  |_____|_____|__|  |_____|  |_|_|_|_|_|\\_/|___|_|  |_____|___|_|_|\n"
                    + "                                                                                              |_|                            |_|  ");
            System.out.println("                            \n"
                    + " ___      _____     _ _     \n"
                    + "|  _|    |   __|___| |_|___ \n"
                    + "| . |_   |__   | .'| | |  _|\n"
                    + "|___|_|  |_____|__,|_|_|_|  \n"
                    + "                            ");

            opcion = teclado.nextInt();

            try {
                ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream("partidaguardada.dat"));
                guardar.writeObject(j1);
                guardar.writeObject(i1);
            } catch (IOException e) {

                System.err.println("Error al guardar" + e.toString());

            }

            switch (opcion) {

                // La primera opcion es luchar contra un enemigo
                case 1:
                    Thread.sleep(500);
                    musica1.detenerMusicaFondo();
                    musica1.reproducirMusicaFondo("Sonidos/Fondo_Enemigo.wav");
                    int enemigoRandom = (int) (Math.random() * 7); //Escojo uno de los 7 nombre al azar
                    Enemigo e = new Enemigo(nombresE[enemigoRandom], 1); //Creo el objeto enemigo

                    System.out.println();
                    System.out.println("--------------------------------------------");
                    System.out.println("Has iniciado un nuevo combate contra " + e.getNombre());
                    System.out.println();
                    Thread.sleep(1500);

                    e.calcularEstadisticasEnemigo(j1);

                    //Despues de calcular sus estadisticas de manera aleatoria se mostrara el combate
                    do {
                        mostrarCombate(j1, e);
                        Thread.sleep(1500);

                        // Depende de la velocidad el jugador o el enemigo atacara primero
                        if (j1.getVel() > e.getVel()) {

                            // --- JUGADOR ATACA PRIMERO ---
                            if (j1.getPS() > 0) {

                                System.out.print("1. Ataque Basico");
                                System.out.println("   2. Ataque Especial");
                                System.out.print("3. Usar Objetos");
                                System.out.println("    4. Huir");
                                ataque = teclado.nextInt();

                                switch (ataque) {
                                    case 1:
                                        musica1.reproducirEfecto("Sonidos/Basico.wav");
                                        j1.atacarEnemigo(e, true);
                                        Thread.sleep(2000);
                                        break;
                                    case 2:
                                        switch (j1.getClases()) {
                                            case "Mago":
                                                musica1.reproducirEfecto("Sonidos/Mago.wav");
                                                break;
                                            case "Guerrero":
                                                musica1.reproducirEfecto("Sonidos/Especial_Guerrero.wav");
                                                break;
                                            case "Picaro":
                                                musica1.reproducirEfecto("Sonidos/Picaro.wav");
                                                break;
                                            case "Tanque":
                                                musica1.reproducirEfecto("Sonidos/Tanque.wav");
                                                break;
                                            case "Clerigo":
                                                musica1.reproducirEfecto("Sonidos/Clerigo.wav");
                                                break;

                                        }
                                        j1.atacarEnemigo(e, false);
                                        Thread.sleep(2000);
                                        break;
                                    case 3:
                                        musica1.reproducirEfecto("Sonidos/Pocion.wav");
                                        i1.mostrarInventario();

                                        opcionInvent = opcionInventario();
                                        i1.usarObjeto(j1, opcionInvent);
                                        Thread.sleep(2000);
                                        break;
                                    case 4:
                                        musica1.reproducirEfecto("Sonidos/Huir.wav");
                                        escapar = j1.escapar(e);
                                        Thread.sleep(2000);
                                        break;
                                    default:
                                        musica1.reproducirEfecto("Sonidos/Error.wav");
                                        System.out.println("Esta opcion no esta disponible");
                                        Thread.sleep(1200);
                                        break;
                                }

                                mostrarCombate(j1, e);
                                Thread.sleep(1500);
                            }

                            if (e.getPS() > 0 && !escapar) {
                                e.atacar(j1);
                                musica1.reproducirEfecto("Sonidos/Basico.wav");
                                Thread.sleep(2000);
                            }

                        } else if (j1.getVel() < e.getVel()) {

                            // --- ENEMIGO ATACA PRIMERO ---
                            if (e.getPS() > 0) {
                                e.atacar(j1);
                                musica1.reproducirEfecto("Sonidos/Basico.wav");
                                Thread.sleep(2000);
                            }

                            mostrarCombate(j1, e);
                            Thread.sleep(1500);

                            if (j1.getPS() > 0) {

                                System.out.print("1. Ataque Basico");
                                System.out.println("   2. Ataque Especial");
                                System.out.print("3. Usar Objetos");
                                System.out.println("    4. Huir");
                                ataque = teclado.nextInt();

                                switch (ataque) {
                                    case 1:
                                        musica1.reproducirEfecto("Sonidos/Basico.wav");
                                        j1.atacarEnemigo(e, true);
                                        Thread.sleep(2000);
                                        break;
                                    case 2:
                                        switch (j1.getClases()) {
                                            case "Mago":
                                                musica1.reproducirEfecto("Sonidos/Mago.wav");
                                                break;
                                            case "Guerrero":
                                                musica1.reproducirEfecto("Sonidos/Especial_Guerrero.wav");
                                                break;
                                            case "Picaro":
                                                musica1.reproducirEfecto("Sonidos/Picaro.wav");
                                                break;
                                            case "Tanque":
                                                musica1.reproducirEfecto("Sonidos/Tanque.wav");
                                                break;
                                            case "Clerigo":
                                                musica1.reproducirEfecto("Sonidos/Clerigo.wav");
                                                break;

                                        }
                                        j1.atacarEnemigo(e, false);
                                        Thread.sleep(2000);
                                        break;
                                    case 3:
                                        musica1.reproducirEfecto("Sonidos/Pocion.wav");
                                        i1.mostrarInventario();
                                        opcionInvent = opcionInventario();
                                        i1.usarObjeto(j1, opcionInvent);
                                        Thread.sleep(2000);
                                        break;
                                    case 4:
                                        musica1.reproducirEfecto("Sonidos/Huir.wav");
                                        escapar = j1.escapar(e);
                                        Thread.sleep(2000);
                                        break;
                                    default:
                                        musica1.reproducirEfecto("Sonidos/Error.wav");
                                        System.out.println("Esta opcion no esta disponible");
                                        Thread.sleep(1200);
                                        break;
                                }
                            }

                        } else {

                            // --- IGUAL VELOCIDAD --- entonces genero un boleano aleatorio para ver quien empieza antes
                            if (new java.util.Random().nextBoolean()) {

                                // --- JUGADOR PRIMERO ---
                                if (j1.getPS() > 0) {

                                    System.out.print("1. Ataque Basico");
                                    System.out.println("   2. Ataque Especial");
                                    System.out.print("3. Usar Objetos");
                                    System.out.println("    4. Huir");
                                    ataque = teclado.nextInt();

                                    switch (ataque) {
                                        case 1:
                                            musica1.reproducirEfecto("Sonidos/Basico.wav");
                                            j1.atacarEnemigo(e, true);
                                            Thread.sleep(2000);
                                            break;
                                        case 2:
                                            switch (j1.getClases()) {
                                                case "Mago":
                                                    musica1.reproducirEfecto("Sonidos/Mago.wav");
                                                    break;
                                                case "Guerrero":
                                                    musica1.reproducirEfecto("Sonidos/Especial_Guerrero.wav");
                                                    break;
                                                case "Picaro":
                                                    musica1.reproducirEfecto("Sonidos/Picaro.wav");
                                                    break;
                                                case "Tanque":
                                                    musica1.reproducirEfecto("Sonidos/Tanque.wav");
                                                    break;
                                                case "Clerigo":
                                                    musica1.reproducirEfecto("Sonidos/Clerigo.wav");
                                                    break;

                                            }
                                            j1.atacarEnemigo(e, false);
                                            Thread.sleep(2000);
                                            break;
                                        case 3:
                                            musica1.reproducirEfecto("Sonidos/Pocion.wav");
                                            i1.mostrarInventario();
                                            opcionInvent = opcionInventario();
                                            i1.usarObjeto(j1, opcionInvent);
                                            Thread.sleep(2000);
                                            break;
                                        case 4:
                                            musica1.reproducirEfecto("Sonidos/Huir.wav");
                                            escapar = j1.escapar(e);
                                            Thread.sleep(2000);
                                            break;
                                        default:
                                            musica1.reproducirEfecto("Sonidos/Error.wav");
                                            System.out.println("Esta opcion no esta disponible");
                                            Thread.sleep(1200);
                                            break;
                                    }
                                }

                                mostrarCombate(j1, e);
                                Thread.sleep(1500);

                                if (e.getPS() > 0 && !escapar) {
                                    e.atacar(j1);
                                    musica1.reproducirEfecto("Sonidos/Basico.wav");
                                    Thread.sleep(2000);
                                }

                            } else {

                                // --- ENEMIGO PRIMERO ---
                                if (e.getPS() > 0) {
                                    e.atacar(j1);
                                    musica1.reproducirEfecto("Sonidos/Basico.wav");
                                    Thread.sleep(2000);
                                }

                                mostrarCombate(j1, e);
                                Thread.sleep(1500);

                                if (j1.getPS() > 0) {

                                    System.out.print("1. Ataque Basico");
                                    System.out.println("   2. Ataque Especial");
                                    System.out.print("3. Usar Objetos");
                                    System.out.println("    4. Huir");
                                    ataque = teclado.nextInt();

                                    switch (ataque) {
                                        case 1:
                                            musica1.reproducirEfecto("Sonidos/Basico.wav");
                                            j1.atacarEnemigo(e, true);
                                            Thread.sleep(2000);
                                            break;
                                        case 2:
                                            switch (j1.getClases()) {
                                                case "Mago":
                                                    musica1.reproducirEfecto("Sonidos/Mago.wav");
                                                    break;
                                                case "Guerrero":
                                                    musica1.reproducirEfecto("Sonidos/Especial_Guerrero.wav");
                                                    break;
                                                case "Picaro":
                                                    musica1.reproducirEfecto("Sonidos/Picaro.wav");
                                                    break;
                                                case "Tanque":
                                                    musica1.reproducirEfecto("Sonidos/Tanque.wav");
                                                    break;
                                                case "Clerigo":
                                                    musica1.reproducirEfecto("Sonidos/Clerigo.wav");
                                                    break;

                                            }
                                            j1.atacarEnemigo(e, false);
                                            Thread.sleep(2000);
                                            break;
                                        case 3:
                                            musica1.reproducirEfecto("Sonidos/Pocion.wav");
                                            i1.mostrarInventario();
                                            opcionInvent = opcionInventario();
                                            i1.usarObjeto(j1, opcionInvent);
                                            Thread.sleep(2000);
                                            break;
                                        case 4:
                                            musica1.reproducirEfecto("Sonidos/Huir.wav");
                                            escapar = j1.escapar(e);
                                            Thread.sleep(2000);
                                            break;
                                        default:
                                            musica1.reproducirEfecto("Sonidos/Error.wav");
                                            System.out.println("Esta opcion no esta disponible");
                                            Thread.sleep(1200);
                                            break;
                                    }
                                }
                            }
                        }

                    } while (j1.getPS() > 0 && e.getPS() > 0 && !escapar);

                    //Aqui se acaba el combate, depende de si se le ha quitado toda la vida al enemigo o te han derrotado saldra una pantalla u otra
                    if (j1.getPS() <= 0) {
                        Thread.sleep(100);
                        musica1.detenerMusicaFondo();
                        mostrarCombate(j1, e);
                        musica1.reproducirMusicaFondo("Sonidos/Muerte.wav");
                        Thread.sleep(7500);
                        mostrarGameOver();
                    } else if (e.getPS() <= 0) {
                        mostrarCombateDerrotaEnemigo(j1, e);
                        Thread.sleep(1500);
                        musica1.reproducirEfecto("Sonidos/Comprar.wav");
                        e.dropGold(j1);
                        if (contadorCombates % 2 == 0) { //Aqui calculamos que cada dos combates se subira de nivel
                            Thread.sleep(100);
                            musica1.detenerMusicaFondo();
                            musica1.reproducirMusicaFondo("Sonidos/Subir_Stats.wav");
                            j1.lvlUP(j1);
                        }
                        contadorCombates++;
                        break;
                    }

                    break;

                case 2: // En la opcion dos solo puedes mirar tus estadisticas
                    System.out.println(j1);
                    break;
                case 3: // En la opcion tres se te muestra una tienda con objetos que te suben las estadisticas
                    // cuantos mas objetos de la misma categoria tengas mas estadisticas te daran pero estos aumentan
                    // de precio cada nivel que subas
                    musica1.detenerMusicaFondo();
                    musica1.reproducirEfecto("Sonidos/Bienvenida_yasi.wav");
                    System.out.println("===================================================================================");
                    System.out.println("  _____ _                _             _       __   __ _    ____  _____ ____  \n"
                            + " |_   _(_) ___ _ __   __| | __ _    __| | ___  \\ \\ / // \\  / ___|| ____|  _ \\ \n"
                            + "   | | | |/ _ \\ '_ \\ / _` |/ _` |  / _` |/ _ \\  \\ V // _ \\ \\___ \\|  _| | |_) |\n"
                            + "   | | | |  __/ | | | (_| | (_| | | (_| |  __/   | |/ ___ \\ ___) | |___|  _ < \n"
                            + "   |_| |_|\\___|_| |_|\\__,_|\\__,_|  \\__,_|\\___|   |_/_/   \\_\\____/|_____|_| \\_\\\n");

                    System.out.println("===================================================================================\n");

                    System.out.println("                  O");
                    System.out.println("                 /|\\   <- YASI");
                    System.out.println("                 / \\ \n");

                    System.out.println("Objetos disponibles:\n");
                    System.out.println("Illo si no quieres na vete. (pulsa 0)\n");

                    System.out.println(
                            "    1.ESPADA            2.COLLAR VIDA              3.ARMADURA                  4.BOTAS\n"
                            + "   (" + (7) + " de oro)            (" + (7) + " de oro)                (" + (7) + " de oro)                (" + (6 + j1.getNivel()) + " de oro)\n"
                            + "     />                   __\\/__                    /========\\                ___     ___\n"
                            + " (===(============>      /      \\                  |  [____]  |              |   |   |   |\n"
                            + "     \\>                 |   <3   |                 |  |    |  |              |___|   |___|\n"
                            + "                         \\______/                  |  |____|  |              (___)   (___)\n"
                            + "                                                    \\________/                      \n"
                    );

                    System.out.println(
                            " 5.ANILLO MAGICO        6.POCION VIDA              7.POCION MANA               8.POCION  FUEGO\n"
                            + "  (" + (7) + " de oro)            (" + (7) + " de oro)                 (" + (7) + " de oro)                (" + (15 + j1.getNivel()) + " de oro) \n"
                            + "     ____                   (~~)                      (~~)                         (~~)\n"
                            + "   /      \\                (    )                    (    )                       (    )\n"
                            + "  |  (  )  |               ( VV )                    ( MM )                       ( FF )\n"
                            + "   \\______/                (____)                    (____)                       (____)\n"
                    );

                    do {
                        System.out.println("Oro actual: " + j1.getGold());
                        System.out.println("Introduce la opcion escrita a mano:");
                        opcionInvent=opcionInventario();
                        comprar(opcionInvent,i1,j1);
                        
                        
                        
                        
                    } while (opcionInvent.equals("salir"));
                    musica1.reproducirEfecto("Sonidos/Gracias_yasi.wav");
                    System.out.println("===============================================");
                    System.out.println("     ¡Gracias por visitar la tienda de YASER!");
                    System.out.println("===============================================\n");

                    break;
                case 4:
                    musica1.reproducirEfecto("Sonidos/Pocion.wav");
                    i1.mostrarInventario();
                    opcionInvent = opcionInventario();
                    i1.usarObjeto(j1, opcionInvent);
                    break;
                case 5: // Aqui se repite lo mismo que con el enemigo pero no puedes enfrentarte al jefe hasta alcanzar cierto nivel

                    if (j1.getNivel() < 10) {
                        musica1.reproducirEfecto("Sonidos/Error.wav");
                        System.out.println("==== NO TIENES NIVEL PARA ENFRENTARTE AL JEFE(te destruiria con un solo tetraedro del fuego) ====");
                        break;
                    } else {
                        musica1.detenerMusicaFondo();
                        System.out.println("");
                        System.out.println("--------------------------------------------");
                        System.out.println("Despues de muchas batallas, amigos perdidos, y mentores sacrificados, llegas al ultimo de ellos, el mas temido y poderoso rival, un genio en retorica y artes oscuras, \n"
                                + "has llegado AL AULA DE " + d.getNombre());

                        musica1.reproducirEfecto("Sonidos/Intro_Jefe.wav");
                        System.out.println("-Preparaos para enfrentaros a javi dueñas mejor morir que permanecer a medias");
                        Thread.sleep(5000);
                        musica1.reproducirMusicaFondo("Sonidos/Fondo_Dueñas.wav");
                        System.out.println("");

                        do {
                            mostrarCombateFinal(j1, d);
                            Thread.sleep(1500);

                            if (j1.getVel() > d.getVel()) {

                                // --- JUGADOR ATACA PRIMERO ---
                                if (j1.getPS() > 0) {
                                    System.out.print("1. Ataque Basico");
                                    System.out.println("   2. Ataque Especial");
                                    System.out.print("3. Usar Objetos");
                                    System.out.println("    4. Huir");
                                    ataque = teclado.nextInt();

                                    switch (ataque) {
                                        case 1:
                                            musica1.reproducirEfecto("Sonidos/Basico.wav");
                                            j1.atacarJefe(d, true);
                                            Thread.sleep(2000);
                                            break;
                                        case 2:
                                            j1.atacarJefe(d, false);
                                            switch (j1.getClases()) {
                                                case "Mago":
                                                    musica1.reproducirEfecto("Sonidos/Mago.wav");
                                                    break;
                                                case "Guerrero":
                                                    musica1.reproducirEfecto("Sonidos/Especial_Guerrero.wav");
                                                    break;
                                                case "Picaro":
                                                    musica1.reproducirEfecto("Sonidos/Picaro.wav");
                                                    break;
                                                case "Tanque":
                                                    musica1.reproducirEfecto("Sonidos/Tanque.wav");
                                                    break;
                                                case "Clerigo":
                                                    musica1.reproducirEfecto("Sonidos/Clerigo.wav");
                                                    break;

                                            }
                                            Thread.sleep(2000);
                                            break;
                                        case 3:
                                            i1.mostrarInventario();
                                            opcionInvent=opcionInventario();
                                            i1.usarObjeto(j1,opcionInvent);
                                            musica1.reproducirEfecto("Sonidos/Pocion.wav");
                                            Thread.sleep(2000);
                                            break;
                                        case 4:
                                            System.out.println("=== NO PUEDES ESCAPAR DE MI ===");
                                            Thread.sleep(2000);
                                            break;
                                        default:
                                            System.out.println(" ¿Srto/a " + j1.getNombre() + " estas viendo la caja tonta? (Esta opcion no esta disponible)");
                                            Thread.sleep(1200);
                                            break;
                                    }

                                    mostrarCombateFinal(j1, d);
                                    Thread.sleep(1500);
                                }

                                if (d.getPS() > 0 && !escapar) {
                                    ataqueJefe = d.Atacar();
                                    switch (ataqueJefe) {
                                        case 1:
                                            musica1.reproducirEfecto("Sonidos/x+2.wav");
                                            break;
                                        case 2:
                                            musica1.reproducirEfecto("Sonidos/Tetraedro.wav");
                                            break;
                                        case 3:
                                            musica1.reproducirEfecto("Sonidos/Se_va_pudiendo.wav");
                                            break;
                                        case 4:
                                            musica1.reproducirEfecto("Sonidos/Sabeis_verdad.wav");
                                            break;

                                    }
                                    d.habilidades(ataqueJefe, j1);
                                    Thread.sleep(4000);
                                }

                            } else if (j1.getVel() < d.getVel()) {

                                // --- JEFE ATACA PRIMERO ---
                                if (d.getPS() > 0) {
                                    ataqueJefe = d.Atacar();
                                    switch (ataqueJefe) {
                                        case 1:
                                            musica1.reproducirEfecto("Sonidos/x+2.wav");
                                            break;
                                        case 2:
                                            musica1.reproducirEfecto("Sonidos/Tetraedro.wav");
                                            break;
                                        case 3:
                                            musica1.reproducirEfecto("Sonidos/Se_va_pudiendo.wav");
                                            break;
                                        case 4:
                                            musica1.reproducirEfecto("Sonidos/Sabeis_verdad.wav");
                                            break;

                                    }
                                    d.habilidades(ataqueJefe, j1);
                                    Thread.sleep(4000);
                                }

                                mostrarCombateFinal(j1, d);
                                Thread.sleep(1500);

                                if (j1.getPS() > 0) {
                                    System.out.print("1. Ataque Basico");
                                    System.out.println("   2. Ataque Especial");
                                    System.out.print("3. Usar Objetos");
                                    System.out.println("    4. Huir");
                                    ataque = teclado.nextInt();

                                    switch (ataque) {
                                        case 1:
                                            musica1.reproducirEfecto("Sonidos/Basico.wav");

                                            j1.atacarJefe(d, true);
                                            Thread.sleep(2000);
                                            break;
                                        case 2:
                                            j1.atacarJefe(d, false);

                                            switch (j1.getClases()) {
                                                case "Mago":
                                                    musica1.reproducirEfecto("Sonidos/Mago.wav");
                                                    break;
                                                case "Guerrero":
                                                    musica1.reproducirEfecto("Sonidos/Especial_Guerrero.wav");
                                                    break;
                                                case "Picaro":
                                                    musica1.reproducirEfecto("Sonidos/Picaro.wav");
                                                    break;
                                                case "Tanque":
                                                    musica1.reproducirEfecto("Sonidos/Tanque.wav");
                                                    break;
                                                case "Clerigo":
                                                    musica1.reproducirEfecto("Sonidos/Clerigo.wav");
                                                    break;

                                            }
                                            Thread.sleep(2000);
                                            break;
                                        case 3:
                                            i1.mostrarInventario();
                                              opcionInvent=opcionInventario();
                                        i1.usarObjeto(j1,opcionInvent);
                                            musica1.reproducirEfecto("Sonidos/Pocion.wav");
                                            Thread.sleep(2000);
                                            break;
                                        case 4:
                                            System.out.println("=== NO PUEDES ESCAPAR DE MI ===");
                                            Thread.sleep(2000);
                                            break;
                                        default:
                                            System.out.println(" ¿Srto/a " + j1.getNombre() + " estas viendo la caja tonta? (Esta opcion no esta disponible)");
                                            Thread.sleep(1200);
                                            break;
                                    }
                                }

                            } else {

                                // Igual velocidad entonces es aleatorio
                                if (new java.util.Random().nextBoolean()) {

                                    // --- JUGADOR PRIMERO ---
                                    if (j1.getPS() > 0) {
                                        System.out.print("1. Ataque Basico");
                                        System.out.println("   2. Ataque Especial");
                                        System.out.print("3. Usar Objetos");
                                        System.out.println("    4. Huir");
                                        ataque = teclado.nextInt();

                                        switch (ataque) {
                                            case 1:
                                                musica1.reproducirEfecto("Sonidos/Basico.wav");

                                                j1.atacarJefe(d, true);
                                                Thread.sleep(2000);
                                                break;
                                            case 2:
                                                switch (j1.getClases()) {
                                                    case "Mago":
                                                        musica1.reproducirEfecto("Sonidos/Mago.wav");
                                                        break;
                                                    case "Guerrero":
                                                        musica1.reproducirEfecto("Sonidos/Especial_Guerrero.wav");
                                                        break;
                                                    case "Picaro":
                                                        musica1.reproducirEfecto("Sonidos/Picaro.wav");
                                                        break;
                                                    case "Tanque":
                                                        musica1.reproducirEfecto("Sonidos/Tanque.wav");
                                                        break;
                                                    case "Clerigo":
                                                        musica1.reproducirEfecto("Sonidos/Clerigo.wav");
                                                        break;

                                                }
                                                j1.atacarJefe(d, false);
                                                Thread.sleep(2000);
                                                break;
                                            case 3:
                                                i1.mostrarInventario();
                                                 opcionInvent=opcionInventario();
                                        i1.usarObjeto(j1,opcionInvent);
                                                musica1.reproducirEfecto("Sonidos/Pocion.wav");
                                                Thread.sleep(2000);
                                                break;
                                            case 4:
                                                System.out.println("=== NO PUEDES ESCAPAR DE MI ===");
                                                Thread.sleep(2000);
                                                break;
                                            default:
                                                System.out.println(" ¿Srto/a " + j1.getNombre() + " estas viendo la caja tonta? (Esta opcion no esta disponible)");
                                                Thread.sleep(1200);
                                                break;
                                        }
                                    }

                                    mostrarCombateFinal(j1, d);
                                    Thread.sleep(1500);

                                    if (d.getPS() > 0 && !escapar) {
                                        ataqueJefe = d.Atacar();
                                        switch (ataqueJefe) {
                                            case 1:
                                                musica1.reproducirEfecto("Sonidos/x+2.wav");
                                                break;
                                            case 2:
                                                musica1.reproducirEfecto("Sonidos/Tetraedro.wav");
                                                break;
                                            case 3:
                                                musica1.reproducirEfecto("Sonidos/Se_va_pudiendo.wav");
                                                break;
                                            case 4:
                                                musica1.reproducirEfecto("Sonidos/Sabeis_verdad.wav");
                                                break;

                                        }
                                        d.habilidades(ataqueJefe, j1);
                                        Thread.sleep(4000);
                                    }

                                } else {

                                    // --- JEFE PRIMERO ---
                                    if (d.getPS() > 0) {
                                        ataqueJefe = d.Atacar();
                                        switch (ataqueJefe) {
                                            case 1:
                                                musica1.reproducirEfecto("Sonidos/x+2.wav");
                                                break;
                                            case 2:
                                                musica1.reproducirEfecto("Sonidos/Tetraedro.wav");
                                                break;
                                            case 3:
                                                musica1.reproducirEfecto("Sonidos/Se_va_pudiendo.wav");
                                                break;
                                            case 4:
                                                musica1.reproducirEfecto("Sonidos/Sabeis_verdad.wav");
                                                break;

                                        }
                                        d.habilidades(ataqueJefe, j1);
                                        Thread.sleep(4000);
                                    }

                                    mostrarCombateFinal(j1, d);
                                    Thread.sleep(1500);

                                    if (j1.getPS() > 0) {
                                        System.out.print("1. Ataque Basico");
                                        System.out.println("   2. Ataque Especial");
                                        System.out.print("3. Usar Objetos");
                                        System.out.println("    4. Huir");
                                        ataque = teclado.nextInt();

                                        switch (ataque) {
                                            case 1:
                                                musica1.reproducirEfecto("Sonidos/Basico.wav");

                                                j1.atacarJefe(d, true);
                                                Thread.sleep(2000);
                                                break;
                                            case 2:

                                                switch (j1.getClases()) {
                                                    case "Mago":
                                                        musica1.reproducirEfecto("Sonidos/Mago.wav");
                                                        break;
                                                    case "Guerrero":
                                                        musica1.reproducirEfecto("Sonidos/Especial_Guerrero.wav");
                                                        break;
                                                    case "Picaro":
                                                        musica1.reproducirEfecto("Sonidos/Picaro.wav");
                                                        break;
                                                    case "Tanque":
                                                        musica1.reproducirEfecto("Sonidos/Tanque.wav");
                                                        break;
                                                    case "Clerigo":
                                                        musica1.reproducirEfecto("Sonidos/Clerigo.wav");
                                                        break;

                                                }
                                                j1.atacarJefe(d, false);
                                                Thread.sleep(2000);
                                                break;
                                            case 3:
                                                i1.mostrarInventario();
                                                  opcionInvent=opcionInventario();
                                        i1.usarObjeto(j1,opcionInvent);;
                                                musica1.reproducirEfecto("Sonidos/Pocion.wav");
                                                Thread.sleep(2000);
                                                break;
                                            case 4:
                                                System.out.println("=== NO PUEDES ESCAPAR DE MI ===");
                                                Thread.sleep(2000);
                                                break;
                                            default:
                                                System.out.println("Esta opcion no esta disponible");
                                                Thread.sleep(1200);
                                                break;
                                        }
                                    }
                                }
                            }

                        } while (j1.getPS() > 0 && d.getPS() > 0 && !escapar);

                        if (j1.getPS() <= 0) {
                            musica1.detenerMusicaFondo();
                            mostrarCombateFinal(j1, d);
                            musica1.reproducirEfecto("Sonidos/Muerte.wav");
                            Thread.sleep(4500);
                            mostrarGameOver();
                        } else if (d.getPS() <= 0) {

                            musica1.detenerMusicaFondo();
                            mostrarCombateFinal(j1, d);
                            musica1.reproducirEfecto("Sonidos/Duda,consulta,propina.wav");
                            Thread.sleep(4500);
                            mostrarFinal();
                        }

                    }
                    break;

                case 6:

                    System.out.println("ABANDONASTE");

                    break;

                default:
                    System.out.println("------------------------------");
                    System.out.println("Esta opcion no esta disponible");
                    System.out.println("------------------------------\n");
                    break;

            }
        } while (j1.getPS() > 0 && opcion != 6 && d.getPS() > 0);
    }

    // TODO ESTO SON FUNCIONES PARA LLAMAR AL APARTADO VISUAL
    public static void mostrarCombate(Jugador jugador, Enemigo enemigo) {

        System.out.println();
        System.out.println("==================================================================");

        // ENEMIGO (arriba derecha)
        System.out.println(enemigo.toString());
        enemigo.mostrarClases();
        System.out.println("-------------------------------------------------------------------------");
        jugador.mostrarClases();
        System.out.println(jugador.toString());

        System.out.println("==================================================================");
    }

    public static void mostrarCombateDerrotaEnemigo(Jugador jugador, Enemigo enemigo) {

        System.out.println();
        System.out.println("==================================================");

        System.out.println(enemigo.toString());
        enemigo.mostrarClases();

        System.out.println("-------------------------------------------------------------------------");
        jugador.mostrarClases();
        System.out.println(jugador.toString());
        System.out.println("HAS DERROTADO A " + enemigo.getNombre());
        System.out.println("==================================================");
        System.out.println();
    }

    public static void mostrarCombateFinal(Jugador jugador, JefeFinal jefe) {

        System.out.println("                              " + jefe.toString());

        jefe.mostrarClases();
        System.out.println("===================================================================================================================================");
        System.out.println();

        jugador.mostrarClases();
        System.out.println(jugador.toString());

        System.out.println("==================================================================");
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

    public static void mostrarFinal() {
        System.out.println("                            .     @$* @$3\n"
                + "                            '$Nueeed$$ed$$eeec$$\n"
                + "         ,            4$Lze@*$C2$b* ed(he*rb$CC$*$bc@$r\n"
                + "   /@ |~~            .e$$\"W$$B$B$**  ^$  e\"\"##d?$Bd$$$Nc. ..      @\\/~\\                                     Tras una ardua pelea y tras haber derrotado                              \n"
                + "   \\==|         4$kd*Cr$6F#\"`  **   .*==      # '\"**F#$I$b$*       |   I                                    al Señor Ausente has logado salvar al reino                               \n"
                + "      |         d$5N@$$\"   ....eu$$$$$$N$*$zbeuu     #$d$$$$b.     / @/                                     de DAM y has podido devolver la cordura a                                 \n"
                + "     @/     . z$Ted*\"$P zue$*9d$$$@#       W$e@B$$L.    \"#@$E$b@N                                           los programadores (cosa que no hara que                                 \n"
                + "           #d$Id*P#  'Nd$$B$**\"       .*,     \"#*N$$b$c   $$$*$$c                                           salgan de casa tampoco), todo el mundo te                                 \n"
                + "          .d#+C6J   @@$B$*\"          -***-        \"#$$$$c   *$$$#$u                                         esta eternamente agradecido y seras recordado                                \n"
                + "       ..u$l4@\"^\"zJ$7W*\"              '*`            ^*$@$$$r \"$$E$@B>                                      en todas las eras que quedan por venir                                \n"
                + "       *@$l$P\"+Rd$$N#\"          *     /|\\     *        '\"$$$c.. ?E$*b                                       hasta que esta historia se convierta en leyenda                                \n"
                + "       z$ \"*.  .Jz$\"           ***   / | \\   ***         '*@N$b   d**N                                      y esa leyenda se convierta en mito.                                \n"
                + "     .z$JBR^bs@$$#          *   *   /  |  \\   *  *         \"$l*9N \"bN$Nee                                                                     \n"
                + "    4$$.C*   dB@\"          ***    _/  /^\\  \\_   ***         '$$$z> 3$b$$#                                     THE END.                                \n"
                + "     $\"$e$  @*$\"        *   *     \\\\^|   |^//    *   *        $$$u.^*$N$c                                                                    \n"
                + "    JPd$%  @@d\"        ***        ***********       ***       '$Ni$  $EP$                                                                       \n"
                + "  :e$\"*$  :et$          *         ***********        *         ^$$E  4$N$be                                                                     \n"
                + "  ')$ud\"  @6$                                                   9$$   $*@$\"                                                                    \n"
                + "   @F*$   *4P                       ./                          '$m#   .$$.                                                                      \n"
                + "u*\"\"\"\"\"\"\"\"\"\"\"\"h                     ##=====                    e#\"\"\"\"\"\"\"\"\"\"#                                               \n"
                + "E +e       ue. N                 ___##_______                 4F e=c     z*c                                                                     \n"
                + "#e$@e.. ..z6+6d\"                #*************/               ^*cBe$u.  .$$@                                                                    \n"
                + "   $ ^\"\"\"\" 4F\"  ze=eu              ********              z***hc ^\"$ \"\"*\"\" $                                                            \n"
                + "   $       ^F :*    3r                                  @\"  e \"b  $       $                                                                    \n"
                + " .e$        N $  'be$L...                            ...?be@F  $F $       9F                                                                     \n"
                + "4\" $        $ $.  zm$*****h.                      ue\"\"\"\"*h6   J$\" $       4%                                                               \n"
                + "$  $        $ $$u5e\" .     \"k                    d\"       #$bu$F  $       4F                                                                  \n"
                + "\"N $        $ ^d%P  dF      $  .            .e   $     -c  \"N$F  .$       4F                                                                   \n"
                + " #$$        $  $4*. \"N.    zP  3r ..    ..  $c   *u     $  u$K$  4F       4L                                                                    \n"
                + "  ^N$e.     3  F$k*. \"*C$$$# .z$\" '$    4L  \"$c. '#$eeedF  $$$9r JF       J$                                                                  \n"
                + "   $'\"$$eu. 4  F3\"K$ .e=*CB$$$$L .e$    '$bc.u$***hd6C\"\"  4kF$4F $F     u@$F\n"
                + "   $   '\"*$*@u N'L$B*\"z*\"\"     \"$F\" 4k 4c '7$\"      \"*$eu 4'L$J\" $   .e$*\"4F\n"
                + "   $      '\"hC*$ \"$#.P\"          $me$\"  #$*$       .  ^*INJL$\"$  $e$$*#   4F\n"
                + "   $         $b\"h \".F     $\"     ^F        $       9r   #L#$FJEd#C@\"      4L\n"
                + "  .$         $Jb   J\"..  4b      uF        *k      J%    #c^ $\" d$        4L\n"
                + " :\"$         $k9   $ $%4c $Bme.ze$         '*$+eee@*$\"  :r$    @L$        4$\n"
                + " $ $         $$Jr  $d\" '$r \"*==*\"            \"#**\"\" $r  4$3r  db$F        4F\n"
                + " $c$         $'*F  $\"   '$            /\\            $    *(L  $$$F         k\n"
                + " #i*e.       $ 4>  $  ue $         \\`.||.'/         'L c  $$ .L$d         .$\n"
                + "  \"b.\"*e.    4 4   $  $%db=eL     `.<\\||/>.'      e*+$/$r  $ '$\"$       .d$$\n"
                + "   $^#+cC*mu 4r4   4r:6@F  $$    -----++-----    <$. \"N?N  F  $ $    ud$$* $\n"
                + "   $    \"*eJ\"@L4   4k*3Ic.*\"      .'`.      #*5.J$$..F  $ $ ue#2*\"   $\n"
                + "   $       \"N.\"@r  4Fd\" '$r        /.'||`.\\        4$ '\"N*d\"  9.$#Ce*\"     $\n"
                + "   $         \"e^\"  'd\" uz$%           \\/           '$czr\"k#\"  4Pu@\"        $");

        System.out.println("   ____              _ _ _              \n"
                + "  / ___|_ __ ___  __| (_) |_ ___  ___ _ \n"
                + " | |   | '__/ _ \\/ _` | | __/ _ \\/ __(_)\n"
                + " | |___| | |  __/ (_| | | || (_) \\__ \\_ \n"
                + "  \\____|_|  \\___|\\__,_|_|\\__\\___/|___(_)\n"
                + "                                        ");

        System.out.println("      _             _                _         _            ____        _ _     _                 ____       _     _          ____               _          ____                      _          \n"
                + "     | | __ ___   _(_) ___ _ __     / \\   _ __(_)______ _  |  _ \\ _   _| (_) __| | ___    _   _  |  _ \\ __ _| |__ | | ___    / ___| ___  _ __ __| | ___    / ___| ___  _ __  ______ _| | ___ ____\n"
                + "  _  | |/ _` \\ \\ / / |/ _ \\ '__|   / _ \\ | '__| |_  / _` | | |_) | | | | | |/ _` |/ _ \\  | | | | | |_) / _` | '_ \\| |/ _ \\  | |  _ / _ \\| '__/ _` |/ _ \\  | |  _ / _ \\| '_ \\|_  / _` | |/ _ \\_  /\n"
                + " | |_| | (_| |\\ V /| |  __/ |     / ___ \\| |  | |/ / (_| | |  __/| |_| | | | (_| | (_) | | |_| | |  __/ (_| | |_) | | (_) | | |_| | (_) | | | (_| | (_) | | |_| | (_) | | | |/ / (_| | |  __// / \n"
                + "  \\___/ \\__,_| \\_/ |_|\\___|_|    /_/   \\_\\_|  |_/___\\__,_| |_|    \\__,_|_|_|\\__,_|\\___/   \\__, | |_|   \\__,_|_.__/|_|\\___/   \\____|\\___/|_|  \\__,_|\\___/   \\____|\\___/|_| |_/___\\__,_|_|\\___/___|\n"
                + "                                                                                          |___/                                                                                                  ");

    }
}
