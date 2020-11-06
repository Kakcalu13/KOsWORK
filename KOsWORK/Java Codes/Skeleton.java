package skeleton;

import javax.swing.JFrame;

public class Skeleton extends JFrame {

    public Skeleton() {
        add(new Board());
        setTitle("Skeleton");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args) {
        new Skeleton();
    }
}