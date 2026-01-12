package com.vanguard.graphic;
import com.vanguard.entities.Background;
import com.vanguard.entities.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable {
    final public int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final public int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight(); 
    final public int gamewidth = (int)(width*0.285);
    final public int gameheight = (int)(height*0.926);
    int fps = 60; 

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);
    Background background = new Background(this);


    
    public GamePanel() {
        this.setPreferredSize(new Dimension(gamewidth, gameheight));
        this.setBackground(Color.black);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            // Game loop logic will go here
            //System.out.println("Game is running...");
            update();
            repaint();
            try {
                Thread.sleep(1000 / fps);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        // Update game state
        player.update(); 
        background.update();
    }

        public void paintComponent(Graphics g) {
        super.paintComponent(g);// Add this line
    
        Graphics2D g2 = (Graphics2D)g;
        background.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}