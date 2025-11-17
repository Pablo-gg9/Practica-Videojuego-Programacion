/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;

import java.lang.Math;

/**
 *
 * @author Alumno
 */
public class Jugador {

    private String nombre, clases;
    private int PS, PSMax, PA, PM, PMMax, vel, gold, armor, nivel;
    private int[] invetario;
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
        this.invetario = new int[3];

    }

    public int[] getInvetario() {
        return invetario;
    }

    public void setInvetario(int[] invetario) {
        this.invetario = invetario;
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
        texto += "HP " + generarBarra(PS, PSMax, 25) + " " + PS + "/" + PSMax + "\n";
        texto += "MP " + generarBarra(PM, PMMax, 25) + " " + PM + "/" + PMMax + "\n";
        texto += "ATK: " + PA
                + "   DEF: " + armor
                + "   VEL: " + vel
                + "   GOLD: " + gold + "\n";
        texto += "------------------------------------------" + "\n";
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
        int psEnemigo;
        switch (clases) {

            case "Mago":
                if (a1) {
                    System.out.println("Has usado MISIL MAGICO BASICO");
                    psEnemigo = e1.getPS();
                    psEnemigo -= PARandom;
                    e1.setPS(psEnemigo);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado BOLA DE FUEGO");
                        PM -= 10;

                        psEnemigo = e1.getPS();
                        psEnemigo -= 20 * nivel / 2;
                        e1.setPS(psEnemigo);
                    } else {
                        System.out.println("No tienes PM necesarios para usar el ataque especial, has usado misil magico basico");
                        psEnemigo = e1.getPS();
                        psEnemigo -= PARandom;
                        e1.setPS(psEnemigo);

                    }
                }
                break;
            case "Guerrero":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    psEnemigo = e1.getPS();
                    psEnemigo -= PARandom;
                    e1.setPS(psEnemigo);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado TAJO GITANO");
                        PM -= 10;
                        int tirada = (int) (Math.random() * 6) + PA;

                        psEnemigo = e1.getPS();
                        psEnemigo -= PARandom + tirada;
                        e1.setPS(psEnemigo);
                    } else {
                        System.out.println("No tienes PM para realizar el ataque especial, has usado ATAQUE BASICO");
                        psEnemigo = e1.getPS();
                        psEnemigo -= PARandom;
                        e1.setPS(psEnemigo);
                    }

                }
                break;

            case "Tanque":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    psEnemigo = e1.getPS();
                    psEnemigo -= PARandom;
                    e1.setPS(psEnemigo);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado PERSE");
                        PM -= 10;

                        armor += 3;
                    } else {
                        System.out.println("No tienes PM para usar el ataque especial has usado ATAQUE BASICO");
                        psEnemigo = e1.getPS();
                        psEnemigo -= PA;
                        e1.setPS(psEnemigo);
                    }
                }
                break;
            case "Picaro":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    psEnemigo = e1.getPS();
                    psEnemigo -= PARandom;
                    e1.setPS(psEnemigo);

                } else {
                    if (PM >= 30) {
                        System.out.println("Has usado GANG");
                        PM -= 30;

                        psEnemigo = e1.getPS();
                        psEnemigo -= PARandom * 2;
                        e1.setPS(psEnemigo);
                    } else {

                        System.out.println("Has usado ATAQUE BASICO");
                        psEnemigo = e1.getPS();
                        psEnemigo -= PARandom;
                        e1.setPS(psEnemigo);
                    }
                }
            case "Clerigo":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    psEnemigo = e1.getPS();
                    psEnemigo -= PARandom;
                    e1.setPS(psEnemigo);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado SIRI CURAME");
                        PM -= 10;

                        if (PS + 10 > PSMax) {
                            PS = PSMax;
                        }
                    } else {
                        System.out.println("Has usado ATAQUE BASICO");
                        psEnemigo = e1.getPS();
                        psEnemigo -= PARandom;
                        e1.setPS(psEnemigo);
                    }
                }
                break;

        }

    }

    public void atacarJefe(JefeFinal e1, boolean a1) {
        int PARandom = (int) (Math.random() * 6) + PA;
        int psJefe;
        switch (clases) {

            case "Mago":
                if (a1) {
                    System.out.println("Has usado MISIL MAGICO BASICO");
                    psJefe = e1.getPS();
                    psJefe -= PARandom;
                    e1.setPS(psJefe);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado BOLA DE FUEGO");
                        PM -= 10;

                        psJefe = e1.getPS();
                        psJefe -= 20 * nivel / 2;
                        e1.setPS(psJefe);
                    } else {
                        System.out.println("No tienes PM necesarios para usar el ataque especial, has usado misil magico basico");
                        psJefe = e1.getPS();
                        psJefe -= PARandom;
                        e1.setPS(psJefe);

                    }
                }
                break;
            case "Guerrero":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    psJefe = e1.getPS();
                    psJefe -= PARandom;
                    e1.setPS(psJefe);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado TAJO GITANO");
                        PM -= 10;
                        int tirada = (int) (Math.random() * 6) + PA;

                        psJefe = e1.getPS();
                        psJefe -= PARandom + tirada;
                        e1.setPS(psJefe);
                    } else {
                        System.out.println("No tienes PM para realizar el ataque especial, has usado ATAQUE BASICO");
                        psJefe = e1.getPS();
                        psJefe -= PARandom;
                        e1.setPS(psJefe);
                    }

                }
                break;

            case "Tanque":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    psJefe = e1.getPS();
                    psJefe -= PARandom;
                    e1.setPS(psJefe);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado PERSE");
                        PM -= 10;

                        armor += 3;
                    } else {
                        System.out.println("No tienes PM para usar el ataque especial has usado ATAQUE BASICO");
                        psJefe = e1.getPS();
                        psJefe -= PA;
                        e1.setPS(psJefe);
                    }
                }
                break;
            case "Picaro":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    psJefe = e1.getPS();
                    psJefe -= PARandom;
                    e1.setPS(psJefe);

                } else {
                    if (PM >= 30) {
                        System.out.println("Has usado GANG");
                        PM -= 30;

                        psJefe = e1.getPS();
                        psJefe -= PARandom * 2;
                        e1.setPS(psJefe);
                    } else {

                        System.out.println("Has usado ATAQUE BASICO");
                        psJefe = e1.getPS();
                        psJefe -= PARandom;
                        e1.setPS(psJefe);
                    }
                }
            case "Clerigo":
                if (a1) {
                    System.out.println("Has usado ATAQUE BASICO");
                    psJefe = e1.getPS();
                    psJefe -= PARandom;
                    e1.setPS(psJefe);

                } else {
                    if (PM >= 10) {
                        System.out.println("Has usado SIRI CURAME");
                        PM -= 10;

                        if (PS + 10 > PSMax) {
                            PS = PSMax;
                        }
                    } else {
                        System.out.println("Has usado ATAQUE BASICO");
                        psJefe = e1.getPS();
                        psJefe -= PARandom;
                        e1.setPS(psJefe);
                    }
                }
                break;

        }

    }

    public void lvlUP(int opcion) {
        int subidaStats = (int) (Math.random() * 6) + PA;

        switch (opcion) {
            case 1:
                PSMax += subidaStats;
                break;
            case 2:
                PMMax += subidaStats;
                break;
            case 3:
                PA += subidaStats;
                break;
            case 4:
                armor += subidaStats;
                break;
            case 5:
                vel += subidaStats;
                break;

            default:
                System.out.println("Eres subnormal ELIGE UNA OPCION RETRASAO");

        }

    }

    public void usarObjeto(int opcion) {

        switch (opcion) {
            case 1:
                System.out.println("Te has bebido una pocion de vida");
                if (PS + 10 > PSMax) {
                    PS = PSMax;
                } else {
                    PS += 10;
                }
            case 2:
                System.out.println("Te has bebido una pocion de mana");
                if (PM + 15 > PMMax) {
                    PM = PMMax;

                } else {
                    PM += 15;
                }

            case 3:
                System.out.println("Te has bebido una pocion antiquemaduras");
                quemado = false;

        }

    }

    public void estarQuemado(boolean quemado) {
        int dañoQuemado = (int) (Math.random() * 5) + PSMax / 5;
        if (quemado == true) {
            PS -= dañoQuemado;
        }

    }

}
