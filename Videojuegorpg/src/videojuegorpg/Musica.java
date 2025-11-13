/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videojuegorpg;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Musica {
    private Clip clipFondo;

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
            System.out.println("Reproduciendo música de fondo...");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void detenerMusicaFondo() {
        if (clipFondo != null && clipFondo.isRunning()) {
            clipFondo.stop();
            clipFondo.close();
            System.out.println("Música detenida.");
        }
    }

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
            System.out.println("Reproduciendo efecto de sonido...");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
