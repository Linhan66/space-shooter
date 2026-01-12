package com.vanguard.entities;
import com.vanguard.graphic.GamePanel;
import com.vanguard.graphic.KeyHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImages();
    }
    public void setDefaultValues() {
        x = gp.gamewidth / 2 - 64; // Center the player horizontally
        z = (int) (gp.gameheight * 0.256); //set z to make a sepcific ratio
        y = gp.gameheight - z; // Center the player vertically
        speed = 6;
        System.out.println(y);
    }

    public void getPlayerImages() {
        // Load player images here
        try {
            Ship1A = ImageIO.read(getClass().getResourceAsStream("/player/Ship_1_A_Medium_NoLight.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        if (keyH.upPressed) {
            y -= speed;
        }
        if (keyH.downPressed) {
            y += speed;
        }
        if (keyH.leftPressed) {
            x -= speed;
        }
        if (keyH.rightPressed) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = Ship1A; //unless different ship is selected
        g2.drawImage(image, x, y, 128, 128, null); // Draw the player ship at its current position
    }
}