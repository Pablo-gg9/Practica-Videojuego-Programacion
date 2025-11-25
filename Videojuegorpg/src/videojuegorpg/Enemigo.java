/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;

/**
 *
 * @author Alumno
 */
import java.lang.Math;

/**
 *
 * @author Alumno
 */
public class Enemigo {

    private String nombre;
    private int PS, PSMax, armor, PA, vel, gold, nivel;

    /**
     *
     * @param nombre
     * @param nivel
     */
    public Enemigo(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getPSMax() {
        return PSMax;
    }

    /**
     *
     * @param PSMax
     */
    public void setPSMax(int PSMax) {
        this.PSMax = PSMax;
    }

    /**
     *
     * @return
     */
    public int getNivel() {
        return nivel;
    }

    /**
     *
     * @param nivel
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     *
     * @return
     */
    public int getPS() {
        return PS;
    }

    /**
     *
     * @param PS
     */
    public void setPS(int PS) {
        this.PS = PS;
    }

    /**
     *
     * @return
     */
    public int getArmor() {
        return armor;
    }

    /**
     *
     * @param armor
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     *
     * @return
     */
    public int getPA() {
        return PA;
    }

    /**
     *
     * @param PA
     */
    public void setPA(int PA) {
        this.PA = PA;
    }

    /**
     *
     * @return
     */
    public int getVel() {
        return vel;
    }

    /**
     *
     * @param vel
     */
    public void setVel(int vel) {
        this.vel = vel;
    }

    /**
     *
     * @return
     */
    public int getGold() {
        return gold;
    }

    /**
     *
     * @param gold
     */
    public void setGold(int gold) {
        this.gold = gold;
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String texto = "                        ------------------------------------------" + "\n";
        texto += "                        JUGADOR: " + nombre + "   Nv. " + nivel + "\n";
        texto += "                        HP " + generarBarra(PS, PSMax, 25) + " " + PS + "/" + PSMax + "\n";
        texto += "                        ATK: " + PA
                + "   DEF: " + armor
                + "   VEL: " + vel + "\n";

        return texto;
    }

    /**
     *
     * @param j1
     */
    public void calcularEstadisticasEnemigo(Jugador j1) {

        int nivelJugador = j1.getNivel();
        nivel = nivelJugador;
        int PARandom = (int) (Math.random() * 5) + 2 * nivel;
        int PSMaxRandom = (int) (Math.random() * 5) + 10 * nivel / 2;
        int velRandom = (int) (Math.random() * 10) + nivel;
        int armorRandom = (int) (Math.random() * 4) + nivel;
        int goldRandom = (int) (Math.random() * 6) + nivel;

        PA = PARandom;
        PSMax = PSMaxRandom;
        PS = PSMaxRandom;
        vel = velRandom;
        armor = armorRandom;
        gold = goldRandom;
    }

    /**
     *
     * @param j1
     */
    public void atacar(Jugador j1) {

        int PARandom = (int) (Math.random() * 6) + PA;

        System.out.println(nombre + " ha usado 'ataque basico' ");
        System.out.println("Ha sacado un " + PARandom);
        int j1PS = j1.getPS();
        int j1PSMax = j1.getPSMax();
        int j1Armor = j1.getArmor();

        j1PS -= PARandom - j1Armor;
        if (j1PS > j1PSMax) {
            j1PS = j1PSMax;
        }
        j1.setPS(j1PS);

    }

    /**
     *
     * @param j1
     */
    public void dropGold(Jugador j1) {

        int j1Gold = j1.getGold();
        System.out.println(nombre + "ha soltado " + gold + " de oro");
        j1Gold += gold;
        j1.setGold(j1Gold);
    }

}
