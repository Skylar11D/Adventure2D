package xyz.sk1.game.adventure2d.panels;

import xyz.sk1.game.adventure2d.player.Entity;
import xyz.sk1.game.adventure2d.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private final int FPS = 60;

    private Player player;

    private final int maxScreenCols = 16;
    private final int maxScreenRows = 12;

    private final int screenWidth;
    private final int screenHeight;

    private Thread gameLoop;


    public GamePanel(Entity player){

        //player settings starts

        this.player = (Player) player;

        this.player.setDefaults();

        this.screenWidth = maxScreenCols * this.player.getScaledSize();
        this.screenHeight = maxScreenRows * this.player.getScaledSize();

        this.player.setBorderLimit(screenWidth-32, screenHeight-32);

        this.addKeyListener(player.getControl());

        //player settings ends

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);

        this.setFocusable(true);

        //buffering or storing stuff in big chunks for performance
        this.setDoubleBuffered(true);
    }

    public void runGameLoop(){

        this.gameLoop = new Thread(this);

        this.gameLoop.start();

    }

    @Override
    public void run() {

        while (this.gameLoop != null){

            double interval = 1000000000 / FPS;

            double nextDraw = System.nanoTime() + interval;

            //game updates per frame
            this.updateTick();

            //applying updates
            repaint();



            try {

                double remains = nextDraw - System.nanoTime();

                if(remains <= 0)
                    remains = 0;

                Thread.sleep((long) (remains/1000000));

                nextDraw += interval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }





        }

    }

    private void updateTick() {

        this.player.navigate();

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D gPlayer = (Graphics2D) g;

        gPlayer.setColor(Color.GREEN);
        
        gPlayer.fillRect(player.getPosition().getX(), player.getPosition().getY(), player.getScaledSize(), player.getScaledSize());
        
        gPlayer.dispose();

    }
}
