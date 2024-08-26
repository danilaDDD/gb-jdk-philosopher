public class PhilosopherThread extends Thread{
    private Philosopher philosopher;

    public PhilosopherThread(Philosopher philosopher) {
        this.philosopher = philosopher;
    }

    @Override
    public void run() {
        while(philosopher.getNumberOfMeals() < 3){
            philosopher.meal();
            philosopher.think();
        }
    }
}
