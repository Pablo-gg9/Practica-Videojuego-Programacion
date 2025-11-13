/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author Alumno
 */
public class Jugador {
    private String nombre,clase;
    private int PS,PA,PM,vel,gold,armor;

     
     
    public Jugador(String nombre,String clase){
    this.nombre=nombre;
    this.clase=clase;
    this.gold=2;
    this.PS=20;
    
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

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", PS=" + PS + ", PA=" + PA + ", PM=" + PM + ", vel=" + vel + ", gold=" + gold + ", armor=" + armor + '}';
    }
    
    
    public void iniciarClase(){
        if("Mago".equals(clase)){
           PM=20;
        
        }
        else if("Guerrero".equals(clase)){
           PA=20; 
        
        }
        else if("Picaro".equals(clase)){
            vel=100;
        }
        else if("Tanque".equals(clase)){
            armor=15;
        }
        else if("Clerigo".equals(clase)){
            armor=10;
            PM=10;
        }
    
    }
   
}
