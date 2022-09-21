import java.awt.*;
import javax.swing.*;


public class graph extends JFrame {
    int id = 0;
    public node[ ] nodes;
    graph(int maxNodes) {
        super("canvas");
        nodes = new node[maxNodes];
    }

    public void crNode(int x,int y,int[] arr){
        nodes[id] = new node(id, x,y, arr);
        id = id + 1;
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


