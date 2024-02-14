// ----------------------------------------------
// Clasa Producer este responsabila pentru citirea unei imagini dintr-un fisier,
// extragerea informatiilor despre latime si inaltime si plasarea pixelilor intr-un Buffer.
// Aceasta opereaza ca un Producer in modelul Producer-Consumer.
// ----------------------------------------------
package packWork;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Producer implements Runnable {
    private Buffer buffer;   
    private Thread t;        

    // Constructorul clasei
    public Producer(Buffer b, String s) {
        buffer = b;            
        t = new Thread(this, s);  
    }

    // Metoda pentru pornirea thread-ului
    public void start() {
        t.start();
    }

    // Metoda run() contine logica principala a producatorului
    public void run() {
        Scanner scanner = new Scanner(System.in);

        // Se asteapta introducerea numelui imaginii de catre utilizator
        System.out.print("Introduceti numele imaginii: ");
        String fileName = scanner.nextLine();
        File file = new File(fileName);

        int width, height;
        BufferedImage image = null;

        try {
            // Se citeste imaginea din fisier
            if (file.exists() && !file.isDirectory()) {
                image = ImageIO.read(file);
            } else {
                System.out.println("Imaginea nu exista sau nu poate fi accesata");
            }

            // Se obtine si se pune in buffer latimea si inaltimea imaginii
            width = image.getWidth();
            height = image.getHeight();
            buffer.put(width);
            buffer.put(height);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Se parcurg pixelii imaginii si se pun in buffer
        for (int i = 0; i < width; i++) {
            if (i == width / 4 || i == width / 2 || i == (3 * width) / 4 || i == width - 1) {
                try {
                    t.sleep(1000); 
                    System.out.println("Producatorul sta");
                } catch (InterruptedException e) {
                }
            }
            for (int j = 0; j < height; j++) {
                buffer.put(image.getRGB(i, j));  
                // System.out.println("Producatorul a pus :\t" + i);
            }
        }
    }
}
