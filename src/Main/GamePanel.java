package Main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable,KeyListener{
    public static final int WIDTH =640 ;
    public static final int HEIGHT = 480;
    public static final int SCALE = 2;


    private Thread thread;
    private boolean running ;
    private int FPS = 60;
    private long targetTime = 1000/FPS;

    //image
    private BufferedImage image;
    private Graphics2D g;

    public GamePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();
        if(thread == null){
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    private void init(){
        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) g;
        running = true;
    }

    public void run(){
        init();

        //gonna need 3 timers
        long start;
        long elapsed;
        long wait;

        while(running){

            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;
            wait = targetTime- elapsed/1000000;

            try{
                Thread.sleep(wait);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

    private void update(){}
    private void draw(){}
    private void drawToScreen(){
        Graphics g2 = getGraphics();
        g2.drawImage(image,0,0,null);
        g2.dispose();

    }

    public void keyTyped(KeyEvent key){};
    public void keyPressed(KeyEvent key){};
    public void keyReleased(KeyEvent key){};

}
