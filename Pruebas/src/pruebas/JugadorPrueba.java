
package pruebas;

public class JugadorPrueba {
    private String nombre;
    private String clase;
    private int nivel;
    private int ps, psMax;
    private int pa;
    private int pm, pmMax;
    private int vel;
    private int gold;
    private int armor;

    public JugadorPrueba(String nombre, String clase, int nivel, int ps, int psMax,
                   int pa, int pm, int pmMax, int vel, int gold, int armor) {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
        this.ps = ps;
        this.psMax = psMax;
        this.pa = pa;
        this.pm = pm;
        this.pmMax = pmMax;
        this.vel = vel;
        this.gold = gold;
        this.armor = armor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getPsMax() {
        return psMax;
    }

    public void setPsMax(int psMax) {
        this.psMax = psMax;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public int getPmMax() {
        return pmMax;
    }

    public void setPmMax(int pmMax) {
        this.pmMax = pmMax;
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

   // Método para generar una barra tipo Pokémon
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
        
        String texto = "JUGADOR: " + nombre + " (" + clase + ")   Nv. " + nivel + "\n" ;
        texto += "HP " + generarBarra(ps, psMax, 25) + " " + ps + "/" + psMax  + "\n";
        texto += "MP " + generarBarra(pm, pmMax, 25) + " " + pm + "/" + pmMax  + "\n";
        texto += "ATK: " + pa +
                 "   DEF: " + armor +
                 "   VEL: " + vel +
                 "   GOLD: " + gold  + "\n";
        texto += "------------------------------------------" + "\n";
        return texto;
    }
}


