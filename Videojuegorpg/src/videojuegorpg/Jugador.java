/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;

import java.lang.Math;
import java.util.Scanner;

/**
 *  Clase que define y gestiona las acciones del jugador y sus estadisticas 
 *  version 1.0
 * @author Pablo Gordo González
 */   



public class Jugador {

    private String nombre, clases;      
    private int PS, PSMax, PA, PM, PMMax, vel, gold, armor, nivel;
    private int[] inventario;
    private boolean turno, quemado;


    /**
     * Constructor por defecto que inicializa las estadisticas del jugador 
     * @param nombre Define el valor del atributo nombre del jugador
     * @param clase Define el valor del atributo clase del jugador
     */
    public Jugador(String nombre, String clase) {
        this.nombre = nombre;
        this.nivel = 1;
        this.clases = clase;
        this.gold = 2;
        this.PS = 20;
        this.PSMax = 20;
        this.turno = false;
        this.quemado = false;
        this.inventario = new int[10];

    }

    /**
     * Método Getter del atributo inventario
     * @return Devuelve el array del inventario 
     */
    public int[] getInvetario() {
        return inventario;
    }

    /**
     * Método Setter del inventario
     * @param invetario Introduce un array para cambiar el atributo del jugador
     */
    public void setInvetario(int[] invetario) {
        this.inventario = invetario;
    }

    /**
     * Método Getter del atributo nombre
     * @return Devuelve el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método Setter del atributo nombre
     * @param nombre Introduce un valor para poner al atributo nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método Getter del atributo PS
     * @return Devuelve el valor de los PS actuales del jugador
     */
    public int getPS() {
        return PS;
    }

    /**
     * Método Setter del atributo PS 
     * @param PS Introduce un valor para modificar los PS actuales del jugador
     */
    public void setPS(int PS) {
        this.PS = PS;
    }

    /**
     * Método Getter del atributo PA
     * @return Devuelve el valor del atributo PA del jugador
     */
    public int getPA() {
        return PA;
    }

    /**
     * Método Setter del atributo PA
     * @param PA Introduce un valor para modificar el atributo PA del jugador
     */
    public void setPA(int PA) {
        this.PA = PA;
    }

    /**
     * Método Getter del atributo PM
     * @return Devuelve valor de los PM actuales del jugador
     */
    public int getPM() {
        return PM;
    }

    /**
     * Método Setter del atributo PM
     * @param PM Introduce un valor para modificar los PM actuales del jugador
     */
    public void setPM(int PM) {
        this.PM = PM;
    }

    /**
     * Método Getter del atributo vel 
     * @return Devuelve el valor del atributo vel del jugador
     */
    public int getVel() {
        return vel;
    }

    /**
     * Método Setter del atributo vel 
     * @param vel Introduce un valor para modificar el atributo vel del jugador
     */
    public void setVel(int vel) {
        this.vel = vel;
    }

    /**
     * Método Getter del atributo gold
     * @return Devuelve el valor del atributo gold del jugador
     */
    public int getGold() {
        return gold;
    }

    /**
     * Método Setter del atributo gold
     * @param gold Introduce un valor para modificar el atributo gold del jugador
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Método Getter del atributo armor
     * @return Devuelve el valor del atributo gold del jugador
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Método Setter del atributo armor del jugador 
     * @param armor Introduce un valor para modificar el atributo gold del jugador 
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * Método Getter del atributo clases 
     * @return Devuelve el valor del atributo clases del jugador
     */
    public String getClases() {
        return clases;
    }

    /**
     * Método Setter del atributo clases
     * @param clases Introduce un valor para modificar el atributo clases del jugador
     */
    public void setClases(String clases) {
        this.clases = clases;
    }

    /**
     * Método Getter del atributo PSMax
     * @return Devuelve el valor del atributo PSMax del jugador
     */
    public int getPSMax() {
        return PSMax;
    }

    /**
     * Método Setter del atributo PSMax
     * @param PSMax Introduce un valor para modificar el atributo PSMax del jugador
     */
    public void setPSMax(int PSMax) {
        this.PSMax = PSMax;
    }

    /**
     * Método Getter del atributo PMMax
     * @return Devuelve el valor del atributo PMMax del jugador
     */
    public int getPMMax() {
        return PMMax;
    }

    /**
     * Método Setter del atributo PMMax
     * @param PMMax Introduce un valor para modificar el atributo PMMax del jugador
     */
    public void setPMMax(int PMMax) {
        this.PMMax = PMMax;
    }

    /**
     * Método Getter del atributo nivel
     * @return Devuelve el valor del atributo nivel del jugador
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Método Setter del atributo nivel
     * @param nivel Introduce un valor para modificar del atributo nivel del jugador
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Método Getter del atributo turno 
     * @return Develve el valor del atributo turno del jugador
     */
    public boolean isTurno() {
        return turno;
    }

    /**
     * Método Setter del atributo turno 
     * @param turno Introduce un valor para modificar el atributo turno del jugador
     */
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    /**
     * Método Getter del atributo quemado
     * @return Devuelve el valor del atributo quemado del jugador
     */
    public boolean isQuemado() {
        return quemado;
    }

    /**
     * Método Setter del atributo quemado
     * @param quemado Introduce un valor para modificar el atributo quemado del jugador
     */
    public void setQuemado(boolean quemado) {
        this.quemado = quemado;
    }

    /**
     * Declaracion de un Scanner para utilizar en varias funciones personalizadas
     */
    public static Scanner teclado = new Scanner(System.in);

   /**
    *  Método que calcula los espacios llenos y vacios dentro de una estadistica en funcion de su valor actual y el maximo
    * @param actual  Valor del atributo actual 
    * @param max Valor del atributo maximo
    * @param longitud Valor de longitud de la barra de estadistica
    * @return Devuelve un string con la barra actualizada 
    */
    private String generarBarra(int actual, int max, int longitud) {
        if (max <= 0) {
            max = 1;  // evitar división por cero
        }
        int llenos = (int) ((double) actual / max * longitud);
        if (llenos < 0) {
            llenos = 0;
        }
        if (llenos > longitud) {
            llenos = longitud;
        }

        String barra = "[";
        for (int i = 0; i < longitud; i++) {
            if (i < llenos) {
                barra += "#";   // parte llena
            } else {
                barra += "-";   // parte vacía
            }
        }
        barra += "]";
        return barra;
    }

    /**
     * Método toString del jugador
     * @return Devuelve todos los valores del jugador ordenados por estadisticas e inventario de consumibles
     */
    @Override
    public String toString() {
        String texto = "JUGADOR: " + nombre + " (" + clases + ")   Nv. " + nivel + "\n";
        texto += "HP " + generarBarra(PS, PSMax, 60) + " " + PS + "/" + PSMax + "\n";
        texto += "MP " + generarBarra(PM, PMMax, 60) + " " + PM + "/" + PMMax + "\n";

        texto += "ATK: " + PA
                + "   ARMOR: " + armor
                + "   VEL: " + vel
                + "   QUEMADO: " + quemado
                + "   GOLD: " + gold + "\n";

        texto += "POTIONS:   VIDA: x" + inventario[0]
                + "   MANA: x" + inventario[1]
                + "   FUEGO: x" + inventario[2] + "\n";

        texto += "------------------------------------------\n";

        return texto;
    }

    /**
     * Método que inicializa las estadisticas del jugador en funcion de la clase elegida
     */
    public void iniciarClase() {
        if ("Mago".equals(clases)) {
            PM = 40;
            PMMax = 40;
            int PArandom = (int) (Math.random() * 7) + 3;
            int velrandom = (int) (Math.random() * 7) + 3;
            int armorrandom = (int) (Math.random() * 7);
            PA = PArandom;
            vel = velrandom;
            armor = armorrandom;

        } else if ("Guerrero".equals(clases)) {
            PM = 15;
            PMMax = 15;
            int PArandom = (int) (Math.random() * 7) + 6;
            int velrandom = (int) (Math.random() * 7) + 3;
            int armorrandom = (int) (Math.random() * 7) + 3;
            PA = PArandom;
            vel = velrandom;
            armor = armorrandom;

        } else if ("Picaro".equals(clases)) {
            PMMax = 20;
            PM = 20;
            int PArandom = (int) (Math.random() * 7) + 5;
            int velrandom = (int) (Math.random() * 7) + 10;
            int armorrandom = (int) (Math.random() * 7) + 3;
            PA = PArandom;
            vel = velrandom;
            armor = armorrandom;
        } else if ("Tanque".equals(clases)) {
            PM = 15;
            PMMax = 15;
            int PArandom = (int) (Math.random() * 7) + 4;
            int velrandom = (int) (Math.random() * 7) + 3;
            int armorrandom = (int) (Math.random() * 7) + 9;
            PA = PArandom;
            vel = velrandom;
            armor = armorrandom;
        } else if ("Clerigo".equals(clases)) {
            PMMax = 20;
            PM = 20;
            int PArandom = (int) (Math.random() * 7) + 4;
            int velrandom = (int) (Math.random() * 7) + 3;
            int armorrandom = (int) (Math.random() * 7) + 3;
            PA = PArandom;
            vel = velrandom;
            armor = armorrandom;
        }

    }

    /**
     * Método que permite utilizar un ataque basico o ataque especial en funcion de la clase para atacar a un enemigo
     * @param e1 Objeto de la clase enemigo 
     * @param a1 Valor para la opcion del ataque
     */
    public void atacarEnemigo(Enemigo e1, boolean a1) {
        int PARandom = (int) (Math.random() * 6) + PA;
        int psEnemigo = e1.getPS();
        int armorEnemigo = e1.getArmor();
        switch (clases) {

            case "Mago":
                if (a1 || PM < 15) {
                    if (a1 == false) {
                        System.out.println("No tienes suficiente mana");
                    }
                    System.out.println("Has usado MISIL MAGICO BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    if (armorEnemigo < PARandom) {
                        psEnemigo -= PARandom - armorEnemigo;
                        e1.setPS(psEnemigo);
                    } else {
                        e1.setPS(psEnemigo);
                    }

                } else {
                    if (PM >= 15) {
                        System.out.println("Has usado BOLA DE FUEGO");
                        PM -= 15;

                        psEnemigo -= 20 * nivel / 2;
                        e1.setPS(psEnemigo);
                    }
                }
                break;
            case "Guerrero":
                if (a1 || PM < 10) {
                    if (a1 == false) {
                        System.out.println("No tienes suficiente mana");
                    }
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    if (armorEnemigo < PARandom) {
                        psEnemigo -= PARandom - armorEnemigo;
                        e1.setPS(psEnemigo);
                    } else {
                        e1.setPS(psEnemigo);
                    }

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado TAJO GITANO");
                        PM -= 10;
                        int tirada = (int) (Math.random() * 6) + PA;

                        System.out.println("Has sacado un " + PARandom + " (+ un " + tirada + ")");
                        if (armorEnemigo < PARandom) {
                            psEnemigo -= PARandom + tirada - armorEnemigo;
                            e1.setPS(psEnemigo);
                        } else {
                            e1.setPS(psEnemigo);
                        }
                    }

                }
                break;

            case "Tanque":
                if (a1 || PM < 10) {
                    if (a1 == false) {
                        System.out.println("No tienes suficiente mana");
                    }
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    if (armorEnemigo < PARandom) {
                        psEnemigo -= PARandom - armorEnemigo;
                        e1.setPS(psEnemigo);
                    } else {
                        e1.setPS(psEnemigo);
                    }

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado PERSE");
                        PM -= 10;

                        armor += 3;
                    }
                }
                break;
            case "Picaro":
                if (a1 || PM < 30) {
                    if (a1 == false) {
                        System.out.println("No tienes suficiente mana");
                    }
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    if (armorEnemigo < PARandom) {
                        psEnemigo -= PARandom - armorEnemigo;
                        e1.setPS(psEnemigo);
                    } else {
                        e1.setPS(psEnemigo);
                    }

                } else {
                    if (PM >= 30) {
                        System.out.println("Has usado GANG");
                        PM -= 30;

                        System.out.println("Has sacado un " + PARandom + " x 2");
                        if (armorEnemigo < PARandom) {
                            psEnemigo -= (PARandom * 2) - armorEnemigo;
                            e1.setPS(psEnemigo);
                        } else {
                            e1.setPS(psEnemigo);
                        }
                    }
                }
                break;

            case "Clerigo":
                if (a1 || PM < 10) {
                    if (a1 == false) {
                        System.out.println("No tienes suficiente mana");
                    }
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    if (armorEnemigo < PARandom) {
                        psEnemigo -= PARandom - armorEnemigo;
                        e1.setPS(psEnemigo);
                    } else {
                        e1.setPS(psEnemigo);
                    }

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado SIRI CURAME");
                        PM -= 10;

                        if (PS + 10 > PSMax) {
                            PS = PSMax;
                        } else {
                            PS += 10;
                        }
                    }
                }
                break;

        }

    }

    /**
     * Método que permite utilizar un ataque basico o ataque especial en función de la clase para atacar a el jefe final
     * @param e1 Objeto de la clase JefeFinal
     * @param a1 Valor para elegir la opcion del ataque
     */
    public void atacarJefe(JefeFinal e1, boolean a1) {
        int PARandom = (int) (Math.random() * 6) + PA;
        int psJefe = e1.getPS();
        int armorJefe = e1.getArmor();
        switch (clases) {

            case "Mago":
                if (a1) {
                    System.out.println("Has usado MISIL MAGICO BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    if (armorJefe < PARandom) {
                        psJefe -= PARandom - armorJefe;
                        e1.setPS(psJefe);
                    } else {
                        e1.setPS(psJefe);
                    }

                    estarQuemado();

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado BOLA DE FUEGO");
                        PM -= 15;
                        psJefe -= 20 * nivel / 2;
                        e1.setPS(psJefe);
                        estarQuemado();
                    } else {
                        System.out.println("No tienes PM necesarios para usar el ataque especial, has usado misil magico basico");
                        System.out.println("Has sacado un " + PARandom);
                        if (armorJefe < PARandom) {
                            psJefe -= PARandom - armorJefe;
                            e1.setPS(psJefe);
                        } else {
                            e1.setPS(psJefe);
                        }
                        estarQuemado();

                    }
                }
                break;
            case "Guerrero":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    if (armorJefe < PARandom) {
                        psJefe -= PARandom - armorJefe;
                        e1.setPS(psJefe);
                    } else {
                        e1.setPS(psJefe);
                    }
                    estarQuemado();

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado TAJO GITANO");
                        PM -= 10;
                        int tirada = (int) (Math.random() * 6) + PA;

                        System.out.println("Has sacado un " + PARandom + " (+ un " + tirada + ")");
                        if (armorJefe < PARandom) {
                            psJefe -= PARandom + tirada - armorJefe;
                            e1.setPS(psJefe);
                        } else {
                            e1.setPS(psJefe);
                        }
                        estarQuemado();
                    } else {
                        System.out.println("No tienes PM para realizar el ataque especial, has usado ATAQUE BASICO");
                        System.out.println("Has sacado un " + PARandom);
                        if (armorJefe < PARandom) {
                            psJefe -= PARandom - armorJefe;
                            e1.setPS(psJefe);
                        } else {
                            e1.setPS(psJefe);
                        }
                        estarQuemado();
                    }

                }
                break;

            case "Tanque":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    if (armorJefe < PARandom) {
                        psJefe -= PARandom - armorJefe;
                        e1.setPS(psJefe);
                    } else {
                        e1.setPS(psJefe);
                    }
                    estarQuemado();

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado PERSE");
                        PM -= 10;

                        armor += 3;
                        estarQuemado();
                    } else {
                        System.out.println("No tienes PM para usar el ataque especial has usado ATAQUE BASICO");
                        System.out.println("Has sacado un " + PARandom);
                        if (armorJefe < PARandom) {
                            psJefe -= PARandom - armorJefe;
                            e1.setPS(psJefe);
                        } else {
                            e1.setPS(psJefe);
                        }
                        estarQuemado();
                    }
                }
                break;
            case "Picaro":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    if (armorJefe < PARandom) {
                        psJefe -= PARandom - armorJefe;
                        e1.setPS(psJefe);
                    } else {
                        e1.setPS(psJefe);
                    }
                    estarQuemado();

                } else {
                    if (PM >= 30) {
                        System.out.println("Has usado GANG");
                        PM -= 30;
                        if (armorJefe < PARandom) {
                            psJefe -= (PARandom * 2) - armorJefe;
                            e1.setPS(psJefe);
                        } else {
                            e1.setPS(psJefe);
                        }
                        estarQuemado();
                    } else {

                        System.out.println("Has usado ATAQUE BASICO");
                        System.out.println("Has sacado un " + PARandom);
                        if (armorJefe < PARandom) {
                            psJefe -= PARandom - armorJefe;
                            e1.setPS(psJefe);
                        } else {
                            e1.setPS(psJefe);
                        }
                        estarQuemado();
                    }
                }
            case "Clerigo":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    if (armorJefe < PARandom) {
                        psJefe -= PARandom - armorJefe;
                        e1.setPS(psJefe);
                    } else {
                        e1.setPS(psJefe);
                    }
                    estarQuemado();

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado SIRI CURAME");
                        PM -= 10;

                        if (PS + 10 > PSMax) {
                            PS = PSMax;
                            estarQuemado();
                        } else {
                            PS += 10;
                            estarQuemado();
                        }
                    } else {
                        System.out.println("Has usado ATAQUE BASICO");
                        System.out.println("Has sacado un " + PARandom);
                        if (armorJefe < PARandom) {
                            psJefe -= PARandom - armorJefe;
                            e1.setPS(psJefe);
                        } else {
                            e1.setPS(psJefe);
                        }
                        estarQuemado();
                    }
                }
                break;

        }

    }

    /**
     * Método que permite al jugador subir sus estadisticas en funcion de su nivel 
     * @param j1 Objeto de la clase Jugador para llamar al método toString
     */
    public void lvlUP(Jugador j1) {
        int subidaStats = (int) (Math.random() * 6) + nivel;

        System.out.println("===================================================");
        System.out.println("                  SUBIDA DE ESTADISTICAS");
        System.out.println("===================================================\n");

        System.out.println("                                                       \n"
                + " __    _____ _____ _____ __       _____ _____      _   \n"
                + "|  |  |   __|  |  |   __|  |     |  |  |  _  |   _| |_ \n"
                + "|  |__|   __|  |  |   __|  |__   |  |  |   __|  |_   _|\n"
                + "|_____|_____|\\___/|_____|_____|  |_____|__|       |_|  \n"
                + "                                                       ");

        System.out.println("                     LEVEL UP");
        System.out.println("===================================================");
        System.out.println("                                                  COSTE:");
        System.out.println("   (1)  PS MAXIMOS      - Aumenta tu vida maxima    -1");
        System.out.println("   (2)  PM MAXIMOS      - Aumenta tu mana maxima    -1");
        System.out.println("   (3)  PODER DE ATAQUE - Incrementa tu daño        -2");
        System.out.println("   (4)  ARMADURA        - Incrementa la defensa     -2");
        System.out.println("   (5)  VELOCIDAD       - Te permite actuar antes   -1");
        System.out.println("===================================================\n");
        System.out.println(j1 + "\n");
        do {
            System.out.println("Te quedan " + subidaStats + " puntos de estadisticas");
            System.out.print("Ingresa una opcion (1-5): \n");

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    if (subidaStats >= 1) {
                        PSMax += 5;
                        PS = PSMax;
                        subidaStats--;

                        System.out.println(j1 + "\n");
                        break;
                    } else {
                        System.out.println("No tienes suficientes puntos de estadistica");
                        break;
                    }
                case 2:
                    if (subidaStats >= 1) {
                        PMMax += 5;
                        PM = PMMax;
                        subidaStats--;
                        System.out.println(j1 + "\n");
                        break;
                    } else {
                        System.out.println("No tienes suficientes puntos de estadistica");
                        break;
                    }
                case 3:
                    if (subidaStats >= 2) {
                        PA += 1;
                        subidaStats -= 2;
                        System.out.println(j1 + "\n");
                        break;
                    } else {
                        System.out.println("No tienes suficientes puntos de estadistica");
                        break;
                    }
                case 4:
                    if (subidaStats >= 2) {
                        armor += 1;
                        subidaStats -= 2;
                        System.out.println(j1 + "\n");
                        break;
                    } else {
                        System.out.println("No tienes suficientes puntos de estadistica");
                        break;
                    }

                case 5:
                    if (subidaStats >= 1) {
                        vel += 2;
                        subidaStats--;
                        System.out.println(j1 + "\n");
                        break;
                    } else {
                        System.out.println("No tienes suficientes puntos de estadistica");
                        break;
                    }

                default:
                    System.out.println("Esa opcion no esta disponible");

            }
        } while (subidaStats > 0);
        nivel++;

    }

    /**
     * Método que permite
     */
    public void usarObjeto() {

        System.out.println("===============================================");
        System.out.println("  ___                      _             _       \n"
                + " |_ _|_ ____   _____ _ __ | |_ __ _ _ __(_) ___  \n"
                + "  | || '_ \\ \\ / / _ \\ '_ \\| __/ _` | '__| |/ _ \\ \n"
                + "  | || | | \\ V /  __/ | | | || (_| | |  | | (_) |\n"
                + " |___|_| |_|\\_/ \\___|_| |_|\\__\\__,_|_|  |_|\\___/ \n"
                + "                                                 ");
        System.out.println("===============================================\n");
        System.out.println(
                " [0] POCION DE VIDA(" + inventario[0] + ")         [1] POCION DE MANA(" + inventario[1] + ")          [2] POCION ANTIQUEMADURAS(" + inventario[2] + ")\n"
                + "       (~~)                         (~~)                           (~~)\n"
                + "      (    )                       (    )                         (    )\n"
                + "      ( VV )                       ( MM )                         ( FF )\n"
                + "      (____)                       (____)                         (____)\n"
                + "                                                              \n"
        );
        int objeto = teclado.nextInt();

        switch (objeto) {
            case 1:
                if (inventario[0] > 0) {
                    System.out.println("Te has bebido una pocion de vida \n");
                    if (PS + 10 > PSMax) {
                        PS = PSMax;
                    } else {
                        PS += 10;
                    }
                    inventario[0]--;
                } else {
                    System.out.println("No tienes pociones de vida \n");
                }

                break;
            case 2:
                if (inventario[1] > 0) {
                    System.out.println("Te has bebido una pocion de mana \n");
                    if (PM + 15 > PMMax) {
                        PM = PMMax;

                    } else {
                        PM += 15;
                    }
                    inventario[1]--;
                } else {
                    System.out.println("No tienes pociones de vida \n");
                }

                break;

            case 3:
                if (inventario[2] > 0) {
                    System.out.println("Te has bebido una pocion antiquemaduras \n");
                    quemado = false;
                    inventario[2]--;
                } else {
                    System.out.println("No tienes pociones antiquemaduras \n");
                }

                break;

            default:
                System.out.println("Eso no es una pocion, es una monster vacia \n");

                break;

        }

    }

    /**
     *
     */
    public void estarQuemado() {
        int dañoQuemado = (int) (Math.random() * 5) + PSMax / 5;
        if (quemado == true) {
            PS -= dañoQuemado;
            System.out.println("Has sufrido " + dañoQuemado + " de daño por quemadura \n");
        }

    }

    /**
     *
     * @param opcion
     */
    public void comprar(int opcion) {
        switch (opcion) {
            case 1:
                if (gold > (5 + nivel)) {
                    inventario[4]++;
                    PA += inventario[4];
                    gold -= (5 + nivel);
                    System.out.println("Compraste una espada (Gold: " + gold + ")");
                    System.out.println("ATK(" + PA + "+" + inventario[4] + ")\n");

                } else {
                    System.out.println("Te fartan pollas de moneas \n");
                }
                break;

            case 2:
                if (gold > (7 + nivel)) {

                    inventario[5]++;
                    PSMax += 3 + inventario[5];
                    gold -= (7 + nivel);
                    System.out.println("Compraste un colgante con forma de corazon (Gold: " + gold + ")");
                    System.out.println("PSMax(" + PSMax + "+" + inventario[5] + ")\n");

                } else {
                    System.out.println("Te fartan pollas de moneas \n");
                }
                break;

            case 3:
                if (gold > (10 + nivel)) {

                    inventario[6]++;
                    armor += inventario[6];
                    gold -= (10 + nivel);
                    System.out.println("Compraste una armadura (Gold: " + gold + ")");
                    System.out.println("Armor(" + armor + "+" + inventario[6] + ")\n");

                } else {
                    System.out.println("Te fartan pollas de moneas \n");
                }
                break;

            case 4:
                if (gold > (6 + nivel)) {

                    inventario[7]++;
                    vel += 2 + inventario[7];
                    gold -= (6 + nivel);
                    System.out.println("Compraste unas botas (Gold: " + gold + ")");
                    System.out.println("VEL(" + vel + "+" + inventario[7] + ")\n");

                } else {
                    System.out.println("Te fartan pollas de moneas \n");
                }
                break;
            case 5:
                if (gold > (10 + nivel)) {

                    inventario[8]++;
                    PMMax += 5 + inventario[8];
                    gold -= (10 + nivel);
                    System.out.println("Compraste un anillo magico (Gold: " + gold + ")");
                    System.out.println("PMMax(" + PMMax + "+" + inventario[8] + ")\n");

                } else {
                    System.out.println("Te fartan pollas de moneas \n");
                }
                break;
            case 6:
                if (gold > (8 + nivel)) {
                    inventario[0]++;
                    gold -= (8 + nivel);
                    System.out.println("Compraste una pocion de vida (Gold: " + gold + ")");
                } else {
                    System.out.println("Te fartan pollas de moneas \n");
                }
                break;
            case 7:
                if (gold > (12 + nivel)) {
                    inventario[1]++;
                    gold -= (12 + nivel);
                    System.out.println("Compraste una pocion de mana (Gold: " + gold + ")");
                } else {
                    System.out.println("Te fartan pollas de moneas \n");
                }
                break;

            case 8:
                if (gold > (15 + nivel)) {

                    inventario[2]++;
                    gold -= (15 + nivel);
                    System.out.println("Compraste una pocion de resistencia al fuego (Gold: " + gold + ")");
                } else {
                    System.out.println("Te fartan pollas de moneas \n");
                }

                break;
            default:
                System.out.println("Tu ereh tonto amego o que te pasa? \n");
                break;

        }

    }

    /**
     *
     * @param e1
     * @return
     */
    public boolean escapar(Enemigo e1) {

        if (vel > e1.getVel()) {
            System.out.println("==== HAS ESCAPADO ====\n");

            return true;
        } else {
            int probEscapar = (int) (Math.random() * 5);
            if (probEscapar == 3) {
                System.out.println("==== HAS ESCAPADO ====\n");
                return true;
            }
            return false;
        }

    }

}
