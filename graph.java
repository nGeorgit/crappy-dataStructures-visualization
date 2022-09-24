import java.awt.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;


public class graph extends JFrame {
    int id = 0;

    public node[ ] nodes;
    graph(int maxNodes) {
        super("canvas");
        nodes = new node[maxNodes];
    }

    public void crNode(int x,int y,int[] arr){
        nodes[id] = new node(id, x, y, arr);
        checkPos(x, y, 0);
        id = id + 1;
    }

    void checkPos(int x, int y, int n) { // n stores the times it has thied to find a better position
        //System.out.println(nodes[0]);
        for (node node : nodes) {
            if (node != null) {
                if (node.id != this.id) {
                    double dist = Math.sqrt((x - node.x)*(x - node.x) + (y - node.y)*(y - node.y));
                    System.out.println(dist);
                    if (dist <= 30 + 10 & n < 1000) {
                        nodes[id].x = ThreadLocalRandom.current().nextInt(50, 450 + 1);
                        nodes[id].y = ThreadLocalRandom.current().nextInt(50, 450 + 1);
                        n ++;
                        checkPos(nodes[id].x, nodes[id].y , n);
                    }
                }
            }
        }
    }

    public void draw() {
        
 
        // create a empty canvas
        Canvas c = new Canvas() {
 
            // paint the canvas
            public void paint(Graphics g)
            {
                Graphics2D g2d = (Graphics2D) g;
                
                for (int i = 0; i < nodes.length; i++) {
                    node node = nodes[i];
                    for (int j = 0; j < node.conect.length; j++) {
                        node node2 = nodes[node.conect[j]];
                        g2d.drawLine(node.x, node.y, node2.x, node2.y);
                    }
                    g2d.drawOval(node.x -15,node.y -15, 30, 30);
                    g.drawString(String.valueOf(node.id), node.x - 3, node.y + 6);

                }
                
            }
        };
 
        // set background
        c.setBackground(Color.gray);
 
        add(c);
        setSize(500, 500);
        show();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}


