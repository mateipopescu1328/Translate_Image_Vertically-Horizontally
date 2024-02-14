// ----------------------------------------------
// Clasa Image extinde ExecutionTime si adauga
// atribute specifice pentru inaltime si latime.
// ----------------------------------------------
package packWork;

public class Image extends ExecutionTime {
    static int height;
    static int width;

    // Metoda pentru afisarea atributelor clasei
    public void afisareAtribute() {
        System.out.println(this.getStartTime() + " " + this.getEndTime() + " " + height + " " + width);
    }

    // Suprascrierea metodei abstracte din clasa de baza
    @Override
    public void method() {
        System.out.println("clasa Photo");
    }
}
