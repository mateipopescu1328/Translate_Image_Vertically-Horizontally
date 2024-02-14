// ----------------------------------------------
// Clasa ImageTranslate extinde Image si implementeaza
// Interfata pentru obtinerea timpului curent si contine
// metode pentru translatarea imaginilor si afisarea acestora.
// ----------------------------------------------
package packWork;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageTranslate extends Image implements Interface {

    // Metoda pentru obtinerea timpului curent
    @Override
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    // Metoda pentru translatarea imaginii in sus sau in jos
    public static BufferedImage translateVertically(BufferedImage img, int y) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage translatedImg = new BufferedImage(width, height, img.getType());
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int newY = j + y;
                if (newY >= 0 && newY < height) {
                    translatedImg.setRGB(i, j, img.getRGB(i, newY));
                } else {
                    // set the pixel to a default color
                    translatedImg.setRGB(i, j, 0xFFFFFF);
                }
            }
        }
        return translatedImg;
    }

    // Metoda pentru translatarea imaginii la stanga sau la dreapta
    public static BufferedImage translateHorizontally(BufferedImage img, int x) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage translatedImg = new BufferedImage(width, height, img.getType());
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int newX = i + x;
                if (newX >= 0 && newX < width) {
                    translatedImg.setRGB(i, j, img.getRGB(newX, j));
                } else {
                    // set the pixel to a default color
                    translatedImg.setRGB(i, j, 0xFFFFFF);
                }
            }
        }
        return translatedImg;
    }

    // Metoda pentru afisarea imaginilor
    public static void showImages(BufferedImage originalImage, BufferedImage translatedImage) {
        // create frame
        JFrame frame = new JFrame("Original and Translated Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLayout(new FlowLayout());

        // create labels for images
        JLabel originalLabel = new JLabel(new ImageIcon(originalImage));
        JLabel translatedLabel = new JLabel(new ImageIcon(translatedImage));

        // add labels to frame
        frame.add(originalLabel);
        frame.add(translatedLabel);
        frame.setVisible(true);
    }
}
