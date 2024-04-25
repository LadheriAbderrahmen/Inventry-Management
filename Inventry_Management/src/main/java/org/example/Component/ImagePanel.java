package org.example.Component;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    public Image BackgroudImg;
    public ImagePanel(String imgPath){
        this.BackgroudImg = new ImageIcon(imgPath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(BackgroudImg , 0, 0 ,getWidth() , getHeight() , this);
    }

    public void setBackgroundImg(Image img){
        this.BackgroudImg = img;
        repaint();
    }

}
