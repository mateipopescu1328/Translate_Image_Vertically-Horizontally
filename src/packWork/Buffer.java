// ----------------------------------------------
// Clasa Buffer reprezinta un buffer sincronizat pentru
// comunicarea Producer-Consumer. Implementeaza metode
// de punere si preluare a datelor in mod sincronizat.
// ----------------------------------------------
package packWork;

public class Buffer {
    private int number = -1;
    private boolean available = false;

    // Metoda pentru preluarea unui numar din buffer
    public synchronized int get() {
        while (!available) {
            try {
                wait(); // Asteapta producatorul sa puna o valoare
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return number;
    }

    // Metoda pentru punerea unui numar in buffer
    public synchronized void put(int number) {
        while (available) {
            try {
                wait(); // Asteapta consumatorul sa preia valoarea
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.number = number;
        available = true;
        notifyAll();
    }
}
