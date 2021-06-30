package Main;

import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame("Some Game I don't know the name of: ");
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
}
