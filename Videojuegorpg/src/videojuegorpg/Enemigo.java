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
    private int PS, armor, PA, vel, gold, nivel;

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

    @Override
    public String toString() {
        return "Enemigo{" + "nombre=" + nombre + ", PS=" + PS + ", armor=" + armor + ", PA=" + PA + ", vel=" + vel + ", gold=" + gold + '}';
    }

    public void calcularEstadisticasEnemigo() {
        int PSRandom = (int) (Math.random() * 11) + 10 * nivel / 2;
        int velRandom = (int) (Math.random() * 10) * nivel;
        int armorRandom = (int) (Math.random() * 4) + nivel;
        int goldRandom = (int) (Math.random() * 4) + nivel;

        PS = PSRandom;
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
