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

public class Enemigo {

    private String nombre;
    private int PS, PSMax , armor, PA, vel, gold, nivel;

    public Enemigo(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     public int getPSMax() {
        return PSMax;
    }

    public void setPSMax(int PSMax) {
        this.PSMax = PSMax;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPS() {
        return PS;
    }

    public void setPS(int PS) {
        this.PS = PS;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getPA() {
        return PA;
    }

    public void setPA(int PA) {
        this.PA = PA;
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

    private String generarBarra(int actual, int max, int longitud) {
        if (max <= 0) max = 1;  // evitar división por cero
        int llenos = (int) ((double) actual / max * longitud);
        if (llenos < 0) llenos = 0;
        if (llenos > longitud) llenos = longitud;

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
        String texto = "                        ------------------------------------------" + "\n";
        texto += "                        JUGADOR: " + nombre + "   Nv. " + nivel + "\n" ;
        texto += "                        HP " + generarBarra(PS, PSMax, 25) + " " + PS + "/" + PSMax + "\n";
        texto += "                        ATK: " + PA +
                 "   DEF: " + armor +
                 "   VEL: " + vel + "\n";
        
        return texto;
    }

   

    public void calcularEstadisticasEnemigo() {
        
        int PARandom = (int) (Math.random() * 10) + 2 * nivel;
        int PSMaxRandom = (int) (Math.random() * 11) + 10 * nivel / 2;
        int velRandom = (int) (Math.random() * 10) * nivel;
        int armorRandom = (int) (Math.random() * 4) + nivel;
        int goldRandom = (int) (Math.random() * 4) + nivel;

        PA = PARandom;
        PSMax = PSMaxRandom;
        PS = PSMaxRandom;
        vel = velRandom;
        armor = armorRandom;
        gold = goldRandom;
    }

    public void atacar(Jugador j1) {
        
        System.out.println(nombre + " ha usado 'ataque basico' ");
        int j1PS = j1.getPS();

        j1PS -= PA;
        j1.setPS(j1PS);

    }

}
