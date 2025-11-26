/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Clase Musica que permite gestionar fragmentos de audio
 * @version 1.0
 * @author Pablo Gordo González y Javier Ariza Pulido 
 */
public class Musica {
    private Clip clipFondo;

    /**
     * Método que permite reproducir un clip permanentemente
     * @param nombreArchivo Introduce la ruta del archivo a reproducir
     */
    public void reproducirMusicaFondo(String nombreArchivo) {
        try {
            URL url = getClass().getResource(nombreArchivo);
            if (url == null) {
                System.out.println("No se encontró el archivo: " + nombreArchivo);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            clipFondo = AudioSystem.getClip();
            clipFondo.open(audioStream);
            clipFondo.loop(Clip.LOOP_CONTINUOUSLY);
            clipFondo.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que detiene la musica que esta sonando 
     */
    public void detenerMusicaFondo() {
        if (clipFondo != null && clipFondo.isRunning()) {
            clipFondo.stop();
            clipFondo.close();

        }
    }

    /**
     * Método que permite reproducir efectos de sonido 
     * @param nombreArchivo
     */
    public void reproducirEfecto(String nombreArchivo) {
        try {
            URL url = getClass().getResource(nombreArchivo);
            if (url == null) {
                System.out.println("No se encontró el archivo: " + nombreArchivo);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
