import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        graph g = new graph(10);
        for (int i = 0; i < 10; i++) {
            int[] arr = new int[ThreadLocalRandom.current().nextInt(1, 3 + 1)];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = ThreadLocalRandom.current().nextInt(0, 9 + 1);
            }
            int x = ThreadLocalRandom.current().nextInt(50, 450 + 1);
            int y = ThreadLocalRandom.current().nextInt(50, 450 + 1);
            g.crNode(x, y, arr);
        }
        g.draw();
    }
}
