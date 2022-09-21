import java.util.concurrent.ThreadLocalRandom;

public class node {
    public int x = ThreadLocalRandom.current().nextInt(50, 450 + 1);
    public int y = ThreadLocalRandom.current().nextInt(50, 450 + 1);
    public int id;
    public int[] conect;

    node(int id,int x, int y, int[] conect) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.conect = conect;
        System.out.println(id + ", x: " + x + ", y: " + y);
    }
}
