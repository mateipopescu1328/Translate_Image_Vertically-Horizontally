// ----------------------------------------------
// Clasa Consumer este un thread care preia date
// din buffer si le proceseaza, inclusiv afisarea si
// translatarea imaginilor.
// ----------------------------------------------
package packWork;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import javax.imageio.ImageIO;

import static packWork.ImageTranslate.*;

public class Consumer implements Runnable {
    private Buffer buffer;
    private Thread t;

    // Constructorul clasei Consumer
    public Consumer(Buffer b, String s) {
        buffer = b;
        t = new Thread(this, s);
    }

    // Metoda pentru pornirea thread-ului Consumer
    public void start() {
        t.start();
    }

    // Metoda run care contine logica de procesare a datelor
    public void run() {
        int width, height;
        width = buffer.get();
        height = buffer.get();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int a = buffer.get();
                image.setRGB(i, j, a);
            }
        }

        System.out.println("Introduceti numele imaginii dupa translatare cu extensia dorita:  ");
        Scanner scan1 = new Scanner(System.in);
        String str_input1 = scan1.nextLine();
        BufferedImage translated = new BufferedImage(width, height, image.getType());

        int ok = 0;
        while (ok == 0) {
            System.out.println("Va rog specificati 'orizontala' sau 'verticala'");
            Scanner scan = new Scanner(System.in);
            String str_input = scan.nextLine();
            ImageTranslate pt = new ImageTranslate();
            if (Objects.equals(str_input, "orizontala")) {
                ok = 1;
                long startTime = pt.getCurrentTime();
                translated = translateHorizontally(image, 120);
                long endTime = pt.getCurrentTime();
                long duration = (endTime - startTime);
                System.out.println("Precesare finalizata - timp (milisecunde) " + duration);
            } else if (Objects.equals(str_input, "verticala")) {
                ok = 1;
                long startTime = pt.getCurrentTime();
                translated = translateVertically(image, 120);
                long endTime = pt.getCurrentTime();
                long duration = (endTime - startTime);
                System.out.println("Precesare finalizata - timp (milisecunde) " + duration);
            } else {
                System.out.println("Axa invalida.");
            }
        }

        try {
            ImageIO.write(translated, "bmp", new File(str_input1));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        showImages(image, translated);
    }
}
