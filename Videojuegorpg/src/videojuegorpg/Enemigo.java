/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;
import java.lang.Math;

/**
 * Clase que gestiona las acciones y caracteristicas de los enemigos
 * @version 1.0
 * @author Pablo Gordo González y Javier Ariza Pulido 
 */
public class Enemigo {

    private String nombre;
    private int PS, PSMax, armor, PA, vel, gold, nivel;

    /**
     * Constructor por parametros de la clase Enemigo
     * @param nombre Introduce un valor para inicializar el atributo nombre de la clase Enemigo
     * @param nivel Introduce un valor para inicializar el atributo nivel de la clase Enemigo
     */
    public Enemigo(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    /**
     * Método Getter del atriubto nombre de la clase Enemigo
     * @return Devuelve el valor del atributo nombre de la clase Enemigo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método Setter del atributo nombre de la clase Enemigo
     * @param nombre Introduce un valor para modificar el atributo nombre de la clase Enemigo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método Getter del atributo PSMax de la clase Enemigo
     * @return Devuelve el valor del atributo de la clase Enemigo
     */
    public int getPSMax() {
        return PSMax;
    }

    /**
     * Método Setter del atributo PSMax de la clase Enemigo
     * @param PSMax Introduce un valor para modificar el atributo de la clase Enemigo
     */
    public void setPSMax(int PSMax) {
        this.PSMax = PSMax;
    }

    /**
     * Método Getter del atributo nivel de la clase Enemigo
     * @return Devuelve el valor del atributo nivel de la clase Enemigo
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Método Setter del atributo nivel de la clase Enemigo
     * @param nivel Introduce un valor para modificar el atributo nivel de la clase Enemigo
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Método Getter del atributo PS de la clase Enemigo
     * @return Devuelve el valor del atributo PS de la clase Enemigo
     */
    public int getPS() {
        return PS;
    }

    /**
     * Método Setter del atributo PS de la clase Enemigo
     * @param PS Introduce un valor para modificar el atributo PS de la clase Enemigo
     */
    public void setPS(int PS) {
        this.PS = PS;
    }

    /**
     * Método Getter del atributo armor de la clase Enemigo
     * @return Deveulve el valor del atributo armor de la clase Enemigo
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Método Setter del atributo armor de la clase Enemigo 
     * @param armor Introduce un valor para modificar el atributo armor de la clase Enemigo
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * Método Getter del atributo PA de la clase Enemigo
     * @return Devuelve el valor del atributo PA de la clase Enemigo
     */
    public int getPA() {
        return PA;
    }

    /**
     * Método Setter del atributo PA de la clase Enemigo
     * @param PA introduce un valor para modificar el atributo Pa de la clase Enemigo
     */
    public void setPA(int PA) {
        this.PA = PA;
    }

    /**
     * Método Getter del atributo vel de la clase Enemigo
     * @return Devuelve el valor del atributo vel de la clase Enemigo
     */
    public int getVel() {
        return vel;
    }

    /**
     * Método Setter del atributo vel de la clase Enemigo
     * @param vel Introduce un valor para modificar el atributo vel de la clase Enemigo
     */
    public void setVel(int vel) {
        this.vel = vel;
    }

    /**
     * Método Getter del atributo gold de la clase Enemigo
     * @return Deveuelve el valor del atributo gold de la clase Enemigo
     */
    public int getGold() {
        return gold;
    }

    /**
     * Método Setter del atributo gold de la clase Enemigo
     * @param gold Introduce un valor para modificar el atributo gold de la clase Enemigo
     */
    public void setGold(int gold) {
        this.gold = gold;
    }
    
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
     * Método toString de la clase Enemigo
     * @return Devuelve un resumen de las caracteristicas del enemigo
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
     * Método que calcula estadisticas del enemigo en funcion del nivel del jugador
     * @param j1 Objeto de la clase Jugador para comparar su nivel 
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
     * Método que permite al Enemigo realizar un ataque básico
     * @param j1 Objeto de la clase Jugador para atacar
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
     * Método que establece que cantidad de oro suelta el enemigo al morir
     * @param j1 Objeto de la clase Jugador que va a obtener el oro soltado del enemigo 
     */
    public void dropGold(Jugador j1) {

        int j1Gold = j1.getGold();
        System.out.println(nombre + "ha soltado " + gold + " de oro");
        j1Gold += gold;
        j1.setGold(j1Gold);
    }

}
