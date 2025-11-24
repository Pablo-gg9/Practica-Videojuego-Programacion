package tema_6;

public class Main {
    public static void main(String[] args) {
        // Crea una instancia de la clase que maneja la música
        Musica sonido = new Musica();

        // Inicia la música de fondo
        sonido.reproducirMusicaFondo("Fondo.wav");

        try {
            // Espera 5 segundos mientras suena la música
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // No hacemos nada si se interrumpe
        }

        // Detiene la música antes de reproducir el efecto
        sonido.detenerMusicaFondo();

        // Reproduce el sonido de compra
        sonido.reproducirEfecto("Comprar.wav");

        try {
            // Espera 2 segundos para que se escuche el efecto antes de terminar
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}



