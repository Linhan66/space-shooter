package com.vanguard.entities;
import com.vanguard.graphic.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Background extends Entity {
    GamePanel gp;
    public Background(GamePanel gp) {
        this.gp = gp;
        defaultValues();
        getBackgroundImages();  
    }
    public void defaultValues() {
        by = 0; 
        speed = 4;
    }

    public void getBackgroundImages() {
        // Load background images here
        try {
            Background1 = ImageIO.read(getClass().getResourceAsStream("/background/background.png"));
            Background2 = ImageIO.read(getClass().getResourceAsStream("/background/background2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update() {
        by += speed;
        if (by >= gp.height) {
            by = 0;
        }
        if (by >= gp.gameheight) {
        by -= gp.gameheight; // Keeps any "over-travel" for a smoother transition
        }
        System.out.println("Background Y: " + by);
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = Background1; //unless different background is selected
        BufferedImage image2 = Background2;
        g2.drawImage(image, 0, by, gp.gamewidth, gp.gameheight, null); // Draw the background at its current position
        g2.drawImage(image2, 0, by - gp.gameheight, gp.gamewidth, gp.gameheight, null);
        
    }
}
