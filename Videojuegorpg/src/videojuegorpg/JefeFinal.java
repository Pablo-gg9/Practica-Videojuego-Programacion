/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;

/**
 * Clase que define y gestiona las acciones del Jefe Final y sus características
 * @version 1.0
 * @author Pablo Gordo González y Javier Ariza Pulido
 */
public class JefeFinal{

    private String nombre;
    private int PS, PSMax, PA, vel, armor, nivel;

    /**
     * Constructor por defecto de la clase Jefe Final
     */
    public JefeFinal() {
        nombre = "JAVIER DUEÑAS";
        PS = 200;
        PSMax = 200;
        vel = 25;
        armor = 14;
        nivel = 10;
    }

    /**
     * Métofo Getter del atributo PSMax de la clase JefeFinal
     * @return Devuelve el valor de PSMax de la clase JefeFinal
     */
    public int getPSMax() {
        return PSMax;
    }

    /**
     * Método Setter del atributo PSMax de la clase JefeFinal
     * @param PSMax Introduce un valor para modificar el atributo PSMax de la clase JefeFinal
     */
    public void setPSMax(int PSMax) {
        this.PSMax = PSMax;
    }

    /**
     * Método Getter del atributo nivel de la clase JefeFinal
     * @return Devuelve el valor del atributo 
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Método Setter del atributo nivel de la clase JefeFinal
     * @param nivel Introduce un valor para modificar el atributo nivel de la clase JefeFinal
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Método Getter del atributo nombre de la clase JefeFinal
     * @return Devuelve el valor del atributo nombre de la clase JefeFinal
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método Setter del atributo nombre de la clase JefeFinal
     * @param nombre Introduce un valor para modificar el atributo nombre de la clase JefeFinal
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método Getter del atributo PS de la clase JefeFinal
     * @return Devuelve el valor del atributo PS de la clase JefeFinal
     */
    public int getPS() {
        return PS;
    }

    /**
     * Método Setter del atributo PS de la clase JefeFinal
     * @param PS Introduce un valor para modificar el atributo PS de la clase JefeFinal
     */
    public void setPS(int PS) {
        this.PS = PS;
    }

    /**
     * Método Getter del atributo PA de la clase JefeFinal
     * @return Devuelve el valor del atributo PA de la clase JefeFinal
     */
    public int getPA() {
        return PA;
    }

    /**
     * Método Setter del atributo PA de la clase JefeFinal
     * @param PA Introduce un valor para modificar el atributo PA de la clase JefeFinal
     */
    public void setPA(int PA) {
        this.PA = PA;
    }

    /**
     * Método Getter del atributo vel de la clase JefeFinal
     * @return Devuelve el valor del atriubuto vel de la clase JefeFinal
     */
    public int getVel() {
        return vel;
    }

    /**
     * Método Setter del atributo vel de la clase JefeFinal
     * @param vel Introduce un valor para modificar el atributo vel de la clase JefeFinal
     */
    public void setVel(int vel) {
        this.vel = vel;
    }

    /**
     * Método Getter del atributo armor de la clase JefeFinal
     * @return Devuelve el valor del atributo armor de la clase JefeFinal
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Método Setter del atributo armor de la clase JefeFinal
     * @param armor Introduce un valor para modificar el atributo armor de la clase JefeFinal
     */
    public void setArmor(int armor) {
        this.armor = armor;
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
     * Método toString de la clase JefeFinal
     * @return Devuelve un resumen de las estadisticas del objeto de la clase JefeFinal
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
     * Método que establece el daño aleatorio que va a aplicar el JefeFinal
     * @return Devuelve un valor aleatorio para que el JefeFinal elija una opcion de ataque
     */
    public int Atacar() {

        int PARandom = (int) (Math.random() * 10) + 20;
        PA = PARandom;

       return (int) (Math.random() * 3)+1; // Esto elegira que ataque va a hacer el jefe   
       
    }

    /**
     * Método que permite al JefeFinal atacar 
     * @param opcion Introduce una opcion aleatoria para que elija un ataque
     * @param j1 Introduce un jugador al cual atacar
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
