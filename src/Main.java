import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int PHILOSOPHER_COUNT = 5;

    public static void main(String[] args) {
        List<Fork> forkList = new ArrayList<>(PHILOSOPHER_COUNT);
        List<Philosopher> philosophers = new ArrayList<>(PHILOSOPHER_COUNT);

        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
            forkList.add(new Fork());
        }

        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
            int leftIndex = i;
            int rightIndex = i == PHILOSOPHER_COUNT - 1 ? 0: i + 1;
            Philosopher philosopher = new Philosopher(String.format("%s: %s, %s", i, leftIndex, rightIndex),
                    forkList.get(leftIndex),
                    forkList.get(rightIndex));

            new PhilosopherThread(philosopher).start();
        }
    }
}