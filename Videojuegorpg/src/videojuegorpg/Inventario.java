/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que gestiona e implementa objetos a un inventario
 *
 * @author Pablo Gordo Gonzalez
 */
public class Inventario implements Serializable {

    private HashMap<String, Integer> objetosAtaque = new HashMap<>();
    private HashMap<String, Integer> objetosVida = new HashMap<>();
    private HashMap<String, Integer> cantidadObjetos = new HashMap<>();
    private static final long serialVersionUID = 1L;


    public Inventario() {
    }

    @Override
    public String toString() {
        return "Inventario{" + "objetosAtaque=" + objetosAtaque + ", objetosVida=" + objetosVida + ", cantidadObjetos=" + cantidadObjetos + '}';
    }

    public void agregarObjetoAtaque(String clave, int valor) {
        
        if (objetosAtaque.containsKey(clave)) {
            cantidadObjetos.put(clave, (cantidadObjetos.get(clave) + 1));
        } else {
            cantidadObjetos.put(clave, (1));
            objetosAtaque.put(clave, valor);
        }

    }

    public void agregarObjetosVida(String clave, int valor) {

        if (objetosVida.containsKey(clave)) {
            cantidadObjetos.put(clave, (cantidadObjetos.get(clave) + 1));
        } else {
            cantidadObjetos.put(clave, (1));
            objetosVida.put(clave, valor);
        }

    }

    public void mostrarInventario() {
        for (Map.Entry<String, Integer> iterador : cantidadObjetos.entrySet()) {
            if (objetosAtaque.containsKey(iterador.getKey())) {
                System.out.println("Nombre: " + iterador.getKey() + " ,Cantidad: " + iterador.getValue() + " Valor: " + objetosAtaque.get(iterador.getKey()));
            } else {
                System.out.println("Nombre: " + iterador.getKey() + " ,Cantidad: " + iterador.getValue() + " Valor: " + objetosVida.get(iterador.getKey()));
            }
        }
    }

    public void usarObjeto(Jugador j1, String clave) {
        if (cantidadObjetos.containsKey(clave)) {
            if (objetosAtaque.containsKey(clave)) {
                switch (clave) {
                    case "ESPADA":
                        j1.setPA(j1.getPA() + objetosAtaque.get(clave));
                        if (cantidadObjetos.get(clave) == 1) {
                            cantidadObjetos.remove(clave);
                            objetosAtaque.remove(clave);
                        } else {
                            cantidadObjetos.put(clave, (cantidadObjetos.get(clave) - 1));
                        }

                        break;
                    case "ARMADURA":
                        j1.setArmor(j1.getArmor() + objetosAtaque.get(clave));
                        if (cantidadObjetos.get(clave) == 1) {
                            cantidadObjetos.remove(clave);
                            objetosAtaque.remove(clave);
                        } else {
                            cantidadObjetos.put(clave, (cantidadObjetos.get(clave) - 1));
                        }

                        break;
                    case "BOTAS":
                        j1.setVel(j1.getVel() + objetosAtaque.get(clave));
                        if (cantidadObjetos.get(clave) == 1) {
                            cantidadObjetos.remove(clave);
                            objetosAtaque.remove(clave);
                        } else {
                            cantidadObjetos.put(clave, (cantidadObjetos.get(clave) - 1));
                        }
                        break;
                    default:
                        System.out.println("ERROR");
                        break;
                }

            } else {
                switch (clave) {
                    case "COLLAR VIDA":
                        j1.setPSMax(objetosVida.get(clave) + j1.getPSMax());
                        if (cantidadObjetos.get(clave) == 1) {
                            cantidadObjetos.remove(clave);
                            objetosVida.remove(clave);
                        } else {
                            cantidadObjetos.put(clave, (cantidadObjetos.get(clave) - 1));
                        }

                        break;
                    case "ANILLO MAGICO":
                        j1.setPMMax(objetosVida.get(clave) + j1.getPMMax());
                        if (cantidadObjetos.get(clave) == 1) {
                            cantidadObjetos.remove(clave);
                            objetosVida.remove(clave);
                        } else {
                            cantidadObjetos.put(clave, (cantidadObjetos.get(clave) - 1));
                        }
                        break;
                    case "POCION VIDA":
                        System.out.println("Te has bebido una pocion de vida \n");
                        if (cantidadObjetos.get(clave) == 1) {
                            cantidadObjetos.remove(clave);
                            objetosVida.remove(clave);
                        } else {
                            cantidadObjetos.put(clave, (cantidadObjetos.get(clave) - 1));
                        }
                        if (j1.getPS() + 10 > j1.getPSMax()) {
                            j1.setPS(j1.getPSMax());
                        } else {
                            j1.setPS(j1.getPS() + 10);
                        }

                        break;
                    case "POCION MANA":
                        System.out.println("Te has bebido una pocion de mana \n");
                        if (cantidadObjetos.get(clave) == 1) {
                            cantidadObjetos.remove(clave);
                            objetosVida.remove(clave);
                        } else {
                            cantidadObjetos.put(clave, (cantidadObjetos.get(clave) - 1));
                        }
                        if (j1.getPM() + 15 > j1.getPMMax()) {
                            j1.setPM(j1.getPMMax());

                        } else {
                            j1.setPM(j1.getPM() + 15);
                        }
                        break;
                    case "POCION FUEGO":
                        System.out.println("Te has bebido una pocion antiquemaduras \n");
                        if (cantidadObjetos.get(clave) == 1) {
                            cantidadObjetos.remove(clave);
                            objetosVida.remove(clave);
                        } else {
                            cantidadObjetos.put(clave, (cantidadObjetos.get(clave) - 1));
                        }
                        j1.setQuemado(false);

                        break;

                }
            }
        } else {
            System.out.println("Error , el jugador no tiene ese objeto:");
        }
    }
}
