
package videojuegorpg;

import java.lang.Math;


/**
 *
 * @author Alumno
 */
public class Jugador {
    private String nombre,clases;
    private int PS,PSMax,PA,PM,PMMax,vel,gold,armor,nivel;
    private boolean turno,quemado,confuso;

     // Atacar enemigo y jefe final y getter y setter de bolean, cuando ataca quemado quita daño
     
    public Jugador(String nombre,String clase){
    this.nombre=nombre;
    this.clases=clase;
    this.gold=2;
    this.PS=20;
    this.PSMax=20;
    this.PM = 0;
    this.PMMax = 0;
    this.turno=false;
    this.quemado=false;
    this.confuso=false;
    
    }

    public boolean isConfuso() {
        return confuso;
    }

    public void setConfuso(boolean confuso) {
        this.confuso = confuso;
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
        
        String texto = "JUGADOR: " + nombre + " (" + clases + ")   Nv. " + nivel + "\n" ;
        texto += "HP " + generarBarra(PS, PSMax, 25) + " " + PS + "/" + PSMax  + "\n";
        texto += "MP " + generarBarra(PM, PMMax, 25) + " " + PM + "/" + PMMax  + "\n";
        texto += "ATK: " + PA +
                 "   DEF: " + armor +
                 "   VEL: " + vel +
                 "   GOLD: " + gold  + "\n";
        texto += "------------------------------------------" + "\n";
        return texto;
    }
    
    public void iniciarClase(){
        if("Mago".equals(clases)){
          PMMax = 20; PM=20;
          int PArandom= (int)(Math.random()*7)+3; 
          int velrandom= (int)(Math.random()*7)+3;
          int armorrandom= (int)(Math.random()*7)+3;
          PA=PArandom;
          vel=velrandom;
          armor=armorrandom;
          
        }
        else if("Guerrero".equals(clases)){
          int PArandom= (int)(Math.random()*7)+7; 
          int velrandom= (int)(Math.random()*7)+3;
          int armorrandom= (int)(Math.random()*7)+3;
          PA=PArandom;
          vel=velrandom;
          armor=armorrandom;
        
        }
        else if("Picaro".equals(clases)){
          vel=100;
          int PArandom= (int)(Math.random()*7)+3; 
          int velrandom= (int)(Math.random()*7)+3;
          int armorrandom= (int)(Math.random()*7)+3;
          PA=PArandom;
          vel=velrandom;
          armor=armorrandom;
        }
        else if("Tanque".equals(clases)){
          armor=15;
          int PArandom= (int)(Math.random()*7)+3; 
          int velrandom= (int)(Math.random()*7)+3;
          int armorrandom= (int)(Math.random()*7)+3;
          PA=PArandom;
          vel=velrandom;
          armor=armorrandom;
        }
        else if("Clerigo".equals(clases)){
          armor=10;
          PMMax=10; PM = 10;
          int PArandom= (int)(Math.random()*7)+3; 
          int velrandom= (int)(Math.random()*7)+3;
          int armorrandom= (int)(Math.random()*7)+3;
          PA=PArandom;
          vel=velrandom;
          armor=armorrandom;
        }
    
    }
   
}
