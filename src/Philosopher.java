public class Philosopher{
    private int numberOfMeals = 0;
    private String name;
    private final Fork rightFork;
    private final Fork leftFork;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public void meal(){
        synchronized (leftFork){
            synchronized (rightFork){
                if(numberOfMeals < 3) {
                    try {
                        int time = 1000;
                        Thread.sleep(time);
                        numberOfMeals++;
                        System.out.println(String.format("%s already mealed %s ms", name, time));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void think(){
        try {
            int time = 500;
            Thread.sleep(time);
            System.out.println(String.format("%s already think %s ms", name, time));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
