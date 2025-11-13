/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;

/**
 *
 * @author Javier Ariza
 */
public class JefeFinal {
    
    private String nombre;
    private int PS, PA, vel,armor;

    public JefeFinal() {
        nombre = "Javier Dueñas";
        PS = 200;
        vel = 90;
        armor = 10;
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

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "JefeFinal{" + "nombre=" + nombre + ", PS=" + PS + ", PA=" + PA + ", vel=" + vel + ", armor=" + armor + '}';
    }
    
    public int Atacar(){
        
        int PARandom = (int) (Math.random()*10) + 10;
        PA = PARandom;
        
       return (int) (Math.random()*4); // Esto elegira que ataque va a hacer el jefe   
    }
    
    public void habilidades(int opcion, Jugador j1) {
        switch(opcion)
        {
            case 1:
                
                System.out.println("Dueñas ha usado 'ataque basico' ");
                int j1PS = j1.getPS();
                
                j1PS -= PA;
                j1.setPS(j1PS);
                break;
                
            case 2:
                
                 System.out.println("Dueñas ha usado 'Tetraedro del Fuego' ");
                
                break;
                
            case 3:
                
                 System.out.println("Dueñas ha usado 'Se va pudiendo' ");
                
                break;
                
            case 4:
                
                 System.out.println("Dueñas ha usado '¿Sabes lo que es un videojuego, verdad?' ");
                
                break;
        }
        
    }
    
    
    
    
}
