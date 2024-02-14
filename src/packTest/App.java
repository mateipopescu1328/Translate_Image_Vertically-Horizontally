// ----------------------------------------------
// Clasa App este clasa de start a aplicatiei
// care initializeaza obiectele Producer si Consumer
// si incepe executia acestora.
// ----------------------------------------------
package packTest;

import java.io.IOException;

import packWork.ImageTranslate;
import packWork.Producer;
import packWork.Buffer;
import packWork.Consumer;

public class App extends ImageTranslate {
    public static void main(String[] args) throws IOException {

        // Initializarea unui obiect Buffer pentru comunicatia Producer-Consumer
        Buffer b = new Buffer();
        // Initializarea obiectelor Producer si Consumer
        Producer p = new Producer(b, "producer");
        Consumer c = new Consumer(b, "consumer");

        // Pornirea thread-urilor Producer si Consumer
        p.start();
        c.start();
    }
}
