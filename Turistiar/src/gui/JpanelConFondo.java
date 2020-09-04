package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

 
public class JpanelConFondo extends JPanel {
 
	private Image image; 
	
    @Override
    public void paint(Graphics g) {
    	ImageIcon icon = new ImageIcon("src/images/Playa.jpg");
    	Image image = icon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
 
        setOpaque(false);
        super.paint(g);
    }
 
}