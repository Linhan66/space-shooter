package com.vanguard.graphic;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame() {
        this.setTitle("Vanguard: The Last Hope");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        ImageIcon icon = new ImageIcon("res/space2.png");
        this.setIconImage(icon.getImage());
        
    }
}
