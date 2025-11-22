/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;

import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Jugador {

    private String nombre, clases;
    private int PS, PSMax, PA, PM, PMMax, vel, gold, armor, nivel;
    private int[] inventario;
    private boolean turno, quemado;

    // Atacar enemigo y jefe final y getter y setter de bolean, cuando ataca quemado quita daño
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

    public int[] getInvetario() {
        return inventario;
    }

    public void setInvetario(int[] invetario) {
        this.inventario = invetario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPS() {
        return PS;
    }

    public void setPS(int PS) {
        this.PS = PS;
    }

    public int getPA() {
        return PA;
    }

    public void setPA(int PA) {
        this.PA = PA;
    }

    public int getPM() {
        return PM;
    }

    public void setPM(int PM) {
        this.PM = PM;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getClases() {
        return clases;
    }

    public void setClases(String clases) {
        this.clases = clases;
    }

    public int getPSMax() {
        return PSMax;
    }

    public void setPSMax(int PSMax) {
        this.PSMax = PSMax;
    }

    public int getPMMax() {
        return PMMax;
    }

    public void setPMMax(int PMMax) {
        this.PMMax = PMMax;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public boolean isQuemado() {
        return quemado;
    }

    public void setQuemado(boolean quemado) {
        this.quemado = quemado;
    }

    public static Scanner teclado = new Scanner(System.in);

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

    @Override
    public String toString() {
        String texto = "JUGADOR: " + nombre + " (" + clases + ")   Nv. " + nivel + "\n";
        texto += "HP " + generarBarra(PS, PSMax, 60) + " " + PS + "/" + PSMax + "\n";
        texto += "MP " + generarBarra(PM, PMMax, 60) + " " + PM + "/" + PMMax + "\n";

        texto += "ATK: " + PA
                + "   ARMOR: " + armor
                + "   VEL: " + vel
                + "   GOLD: " + gold + "\n";

        texto += "POTIONS:   VIDA: x" + inventario[0]
                + "   MANA: x" + inventario[1]
                + "   FUEGO: x" + inventario[2] + "\n";

        texto += "------------------------------------------\n";

        return texto;
    }

    public void iniciarClase() {
        if ("Mago".equals(clases)) {
            PM = 20;
            PMMax = 20;
            int PArandom = (int) (Math.random() * 7) + 3;
            int velrandom = (int) (Math.random() * 7) + 3;
            int armorrandom = (int) (Math.random() * 7) + 3;
            PA = PArandom;
            vel = velrandom;
            armor = armorrandom;

        } else if ("Guerrero".equals(clases)) {
            PA = 20;
            int PArandom = (int) (Math.random() * 7) + 3;
            int velrandom = (int) (Math.random() * 7) + 3;
            int armorrandom = (int) (Math.random() * 7) + 3;
            PA = PArandom;
            vel = velrandom;
            armor = armorrandom;

        } else if ("Picaro".equals(clases)) {
            vel = 100;
            int PArandom = (int) (Math.random() * 7) + 3;
            int velrandom = (int) (Math.random() * 7) + 3;
            int armorrandom = (int) (Math.random() * 7) + 3;
            PA = PArandom;
            vel = velrandom;
            armor = armorrandom;
        } else if ("Tanque".equals(clases)) {
            armor = 15;
            int PArandom = (int) (Math.random() * 7) + 3;
            int velrandom = (int) (Math.random() * 7) + 3;
            int armorrandom = (int) (Math.random() * 7) + 3;
            PA = PArandom;
            vel = velrandom;
            armor = armorrandom;
        } else if ("Clerigo".equals(clases)) {
            armor = 10;
            PM = 10;
            int PArandom = (int) (Math.random() * 7) + 3;
            int velrandom = (int) (Math.random() * 7) + 3;
            int armorrandom = (int) (Math.random() * 7) + 3;
            PA = PArandom;
            vel = velrandom;
            armor = armorrandom;
        }

    }

    public void atacarEnemigo(Enemigo e1, boolean a1) {
        int PARandom = (int) (Math.random() * 6) + PA;
        int psEnemigo = e1.getPS();
        int psMaxEnemigo = e1.getPSMax();
        int armorEnemigo = e1.getArmor();
        switch (clases) {

            case "Mago":
                if (a1) {
                    System.out.println("Has usado MISIL MAGICO BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    psEnemigo -= PARandom - armorEnemigo;
                    if (psEnemigo > psMaxEnemigo) {
                        psEnemigo = psMaxEnemigo;
                    }
                    e1.setPS(psEnemigo);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado BOLA DE FUEGO");
                        PM -= 15;

                        psEnemigo -= 20 * nivel / 2;
                        e1.setPS(psEnemigo);
                    } else {
                        System.out.println("No tienes PM necesarios para usar el ataque especial, has usado misil magico basico");
                        System.out.println("Has sacado un " + PARandom);
                        psEnemigo -= PARandom - armorEnemigo;
                        if (psEnemigo > psMaxEnemigo) {
                            psEnemigo = psMaxEnemigo;
                        }
                        e1.setPS(psEnemigo);

                    }
                }
                break;
            case "Guerrero":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    psEnemigo -= PARandom - armorEnemigo;
                    e1.setPS(psEnemigo);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado TAJO GITANO");
                        PM -= 10;
                        int tirada = (int) (Math.random() * 6) + PA;

                        System.out.println("Has sacado un " + PARandom + " (+ un " + tirada + ")");
                        psEnemigo -= PARandom + tirada - armorEnemigo;
                        if (psEnemigo > psMaxEnemigo) {
                            psEnemigo = psMaxEnemigo;
                        }
                        e1.setPS(psEnemigo);
                    } else {
                        System.out.println("No tienes PM para realizar el ataque especial, has usado ATAQUE BASICO");
                        System.out.println("Has sacado un " + PARandom);
                        psEnemigo -= PARandom - armorEnemigo;
                        if (psEnemigo > psMaxEnemigo) {
                            psEnemigo = psMaxEnemigo;
                        }
                        e1.setPS(psEnemigo);
                    }

                }
                break;

            case "Tanque":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    psEnemigo -= PARandom - armorEnemigo;
                    if (psEnemigo > psMaxEnemigo) {
                        psEnemigo = psMaxEnemigo;
                    }
                    e1.setPS(psEnemigo);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado PERSE");
                        PM -= 10;

                        armor += 3;
                    } else {
                        System.out.println("No tienes PM para usar el ataque especial has usado ATAQUE BASICO");
                        System.out.println("Has sacado un " + PARandom);
                        psEnemigo -= PARandom - armorEnemigo;
                        if (psEnemigo > psMaxEnemigo) {
                            psEnemigo = psMaxEnemigo;
                        }
                        e1.setPS(psEnemigo);
                    }
                }
                break;
            case "Picaro":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    psEnemigo -= PARandom - armorEnemigo;
                    if (psEnemigo > psMaxEnemigo) {
                        psEnemigo = psMaxEnemigo;
                    }
                    e1.setPS(psEnemigo);

                } else {
                    if (PM >= 30) {
                        System.out.println("Has usado GANG");
                        PM -= 30;

                        System.out.println("Has sacado un " + PARandom + " x 2");
                        psEnemigo -= (PARandom * 2) - armorEnemigo;
                        if (psEnemigo > psMaxEnemigo) {
                            psEnemigo = psMaxEnemigo;
                        }
                        e1.setPS(psEnemigo);
                    } else {

                        System.out.println("Has usado ATAQUE BASICO");
                        System.out.println("Has sacado un " + PARandom);
                        psEnemigo -= PARandom - armorEnemigo;
                        e1.setPS(psEnemigo);
                    }
                }
            case "Clerigo":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    psEnemigo -= PARandom - armorEnemigo;
                    if (psEnemigo > psMaxEnemigo) {
                        psEnemigo = psMaxEnemigo;
                    }
                    e1.setPS(psEnemigo);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado SIRI CURAME");
                        PM -= 10;

                        if (PS + 10 > PSMax) {
                            PS = PSMax;
                        } else {
                            PS += 10;
                        }
                    } else {
                        System.out.println("Has usado ATAQUE BASICO");
                        System.out.println("Has sacado un " + PARandom);
                        psEnemigo -= PARandom - armorEnemigo;
                        if (psEnemigo > psMaxEnemigo) {
                            psEnemigo = psMaxEnemigo;
                        }
                        e1.setPS(psEnemigo);
                    }
                }
                break;

        }

    }

    public void atacarJefe(JefeFinal e1, boolean a1) {
        int PARandom = (int) (Math.random() * 6) + PA;
        int psJefe = e1.getPS();
        int psMaxJefe = e1.getPSMax();
        int armorJefe = e1.getArmor();
        switch (clases) {

            case "Mago":
                if (a1) {
                    System.out.println("Has usado MISIL MAGICO BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    psJefe -= PARandom - armorJefe;
                    if (psJefe > psMaxJefe) {
                        psJefe = psMaxJefe;
                    }
                    e1.setPS(psJefe);
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
                        psJefe -= PARandom - armorJefe;
                        if (psJefe > psMaxJefe) {
                            psJefe = psMaxJefe;
                        }
                        e1.setPS(psJefe);
                        estarQuemado();

                    }
                }
                break;
            case "Guerrero":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    psJefe -= PARandom - armorJefe;
                    if (psJefe > psMaxJefe) {
                        psJefe = psMaxJefe;
                    }
                    e1.setPS(psJefe);
                    estarQuemado();

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado TAJO GITANO");
                        PM -= 10;
                        int tirada = (int) (Math.random() * 6) + PA;

                        System.out.println("Has sacado un " + PARandom + " (+ un " + tirada + ")");
                        psJefe -= PARandom + tirada - armorJefe;
                        if (psJefe > psMaxJefe) {
                            psJefe = psMaxJefe;
                        }
                        e1.setPS(psJefe);
                        estarQuemado();
                    } else {
                        System.out.println("No tienes PM para realizar el ataque especial, has usado ATAQUE BASICO");
                        System.out.println("Has sacado un " + PARandom);
                        psJefe -= PARandom - armorJefe;
                        if (psJefe > psMaxJefe) {
                            psJefe = psMaxJefe;
                        }
                        e1.setPS(psJefe);
                        estarQuemado();
                    }

                }
                break;

            case "Tanque":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    psJefe -= PARandom - armorJefe;
                    if (psJefe > psMaxJefe) {
                        psJefe = psMaxJefe;
                    }
                    e1.setPS(psJefe);
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
                        psJefe -= PARandom - armorJefe;
                        if (psJefe > psMaxJefe) {
                            psJefe = psMaxJefe;
                        }
                        e1.setPS(psJefe);
                        estarQuemado();
                    }
                }
                break;
            case "Picaro":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    psJefe -= PARandom - armorJefe;
                    if (psJefe > psMaxJefe) {
                        psJefe = psMaxJefe;
                    }
                    e1.setPS(psJefe);
                    estarQuemado();

                } else {
                    if (PM >= 30) {
                        System.out.println("Has usado GANG");
                        PM -= 30;

                        psJefe -= (PARandom * 2) - armorJefe;
                        if (psJefe > psMaxJefe) {
                            psJefe = psMaxJefe;
                        }
                        e1.setPS(psJefe);
                        estarQuemado();
                    } else {

                        System.out.println("Has usado ATAQUE BASICO");
                        System.out.println("Has sacado un " + PARandom);
                        psJefe -= PARandom - armorJefe;
                        if (psJefe > psMaxJefe) {
                            psJefe = psMaxJefe;
                        }
                        e1.setPS(psJefe);
                        estarQuemado();
                    }
                }
            case "Clerigo":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    System.out.println("Has sacado un " + PARandom);
                    psJefe -= PARandom - armorJefe;
                    if (psJefe > psMaxJefe) {
                        psJefe = psMaxJefe;
                    }
                    e1.setPS(psJefe);
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
                        psJefe -= PARandom - armorJefe;
                        if (psJefe > psMaxJefe) {
                            psJefe = psMaxJefe;
                        }
                        e1.setPS(psJefe);
                        estarQuemado();
                    }
                }
                break;

        }

    }

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
        System.out.println("   (1)  PS MAXIMOS      - Aumenta tu vida maxima");
        System.out.println("   (2)  PM MAXIMOS      - Aumenta tu mana maxima");
        System.out.println("   (3)  PODER DE ATAQUE - Incrementa tu dano");
        System.out.println("   (4)  ARMADURA        - Incrementa la defensa");
        System.out.println("   (5)  VELOCIDAD       - Te permite actuar antes");
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

                        System.out.println(j1 + "\n");;
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
                        System.out.println(j1 + "\n");;
                        break;
                    } else {
                        System.out.println("No tienes suficientes puntos de estadistica");
                        break;
                    }
                case 3:
                    if (subidaStats >= 1) {
                        PA += 1;
                        subidaStats--;
                        System.out.println(j1 + "\n");;
                        break;
                    } else {
                        System.out.println("No tienes suficientes puntos de estadistica");
                        break;
                    }
                case 4:
                    if (subidaStats >= 2) {
                        armor += 1;
                        subidaStats -= 2;
                        System.out.println(j1 + "\n");;
                        break;
                    } else {
                        System.out.println("No tienes suficientes puntos de estadistica");
                        break;
                    }

                case 5:
                    if (subidaStats >= 2) {
                        vel += 2;
                        subidaStats -= 2;
                        System.out.println(j1 + "\n");;
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
                " [1] POCION DE VIDA(" + inventario[0] + ")         [2] POCION DE MANA(" + inventario[1] + ")          [3] POCION ANTIQUEMADURAS(" + inventario[2] + ")\n"
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

    public void estarQuemado() {
        int dañoQuemado = (int) (Math.random() * 5) + PSMax / 5;
        if (quemado == true) {
            PS -= dañoQuemado;
            System.out.println("Has sufrido " + dañoQuemado + " de daño por quemadura \n");
        }

    }

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
