package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by One on 04.06.2018.
 */
public class ColorBoxes extends JFrame {
    private int grid = 6;
    private int pause = 50;
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public ColorBoxes(){
        setLayout(new GridLayout(grid, grid));
        for (int i = 0; i < grid*grid; i++) {
            CBox cb = new CBox(pause);
            add(cb);
            exec.execute(cb);
        }
    }

    public static void main(String[] args) {
        ColorBoxes boxes = new ColorBoxes();
        //run(boxes, 500, 400);
        SwingUtilities.invokeLater(() -> {
            boxes.setSize(500, 400);
            boxes.setVisible(true);
        });
    }
}

class CBox extends JPanel implements Runnable{
    private int pause;
    private static Random rand = new Random();
    private Color color = new Color(0);
    public void paintComponent(Graphics g){
        g.setColor(color);
        Dimension s = getSize();
        g.fillRect(0,0,s.width,s.height);
    }
    public CBox(int pause){
        this.pause = pause;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                color = new Color(rand.nextInt(0xFFFFFF));
                repaint();
                TimeUnit.MILLISECONDS.sleep(pause);
            }
        }
        catch (InterruptedException e){

        }
    }
}
