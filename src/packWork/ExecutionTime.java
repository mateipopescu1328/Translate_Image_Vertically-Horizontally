// ----------------------------------------------
// Clasa ExecutionTime extinde AbstractClass si
// masoara timpul de executie intre doua puncte.
// ----------------------------------------------
package packWork;

public class ExecutionTime extends AbstractClass {
    private long startTime;
    private long endTime;

    // Metoda pentru obtinerea timpului de inceput
    public long getStartTime() {
        return startTime;
    }

    // Metoda pentru setarea timpului de inceput
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    // Metoda pentru obtinerea timpului de sfarsit
    public long getEndTime() {
        return endTime;
    }

    // Metoda pentru setarea timpului de sfarsit
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    // Metoda pentru afisarea atributelor clasei
    public void afisareAtribute() {
        System.out.println(startTime + " " + endTime);
    }

    // Suprascrierea metodei abstracte din clasa de baza
    @Override
    public void method() {
        System.out.println("clasa ExecutionTime");
    }
}
