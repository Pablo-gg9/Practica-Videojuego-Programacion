/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;

/**
 *
 * @author Javier Ariza
 */
public class JefeFinal{

    private String nombre;
    private int PS, PSMax, PA, vel, armor, nivel;

    /**
     *
     */
    public JefeFinal() {
        nombre = "JAVIER DUEÑAS";
        PS = 200;
        PSMax = 200;
        vel = 90;
        armor = 10;
        nivel = 10;
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

        String barra = "||";
        for (int i = 0; i < longitud; i++) {
            if (i < llenos) {
                barra += "=";   // parte llena
            } else {
                barra += "-";   // parte vacía
            }
        }
        barra += "||";
        return barra;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String texto = "\n                        =================================================== JEFE FINAL ===================================================\n";
        texto += "                        Nombre: " + nombre + "   Nv. " + nivel + "\n";
        texto += "                        HP: " + generarBarra(PS, PSMax, 120) + " " + PS + "/" + PSMax + "\n";
        texto += "                        ATK: " + PA
                + "   DEF: " + armor
                + "   VEL: " + vel + "\n";
        return texto;
    }

    /**
     *
     * @return
     */
    public int Atacar() {

        int PARandom = (int) (Math.random() * 10) + 20;
        PA = PARandom;

       return (int) (Math.random() * 3)+1; // Esto elegira que ataque va a hacer el jefe   
       
    }

    /**
     *
     * @param opcion
     * @param j1
     */
    public void habilidades(int opcion, Jugador j1) {
        int j1PS = j1.getPS();
        boolean j1Quemado = j1.isQuemado();

        switch (opcion) {
            case 1:

                System.out.println("Dueñas ha usado 'x + 2' ");

                j1PS -= PA + 2;
                j1.setPS(j1PS);
                break;

            case 2:

                System.out.println("Dueñas ha usado 'Tetraedro del Fuego' ");

                j1PS -= PA - 5;
                j1.setPS(j1PS);

                int quemadoRandom = (int) (Math.random() * 2)+1;
                 System.out.println(quemadoRandom);
                if (quemadoRandom == 2) {
                    j1Quemado = true;
                    j1.setQuemado(j1Quemado);
                    System.out.println("Has sido quemado");
                }

                break;

            case 3:

                System.out.println("Dueñas ha usado 'Se va pudiendo' ");
                System.out.println("");
                System.out.println("Dueñas ha aumentado su armadura");
                armor += 3;

                break;

            case 4:

                System.out.println("Dueñas ha usado '¿Sabes lo que es un videojuego, verdad?' ");

                j1PS -= PA % 10;
                j1.setPS(j1PS);
                int confusoRandom = (int) (Math.random() * 2)+1;
                if (confusoRandom == 2) {
                      j1.setTurno(false);
                }

                break;
        }

    }

}
