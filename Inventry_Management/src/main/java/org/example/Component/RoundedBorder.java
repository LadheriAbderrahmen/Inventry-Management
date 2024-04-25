package org.example.Component;

import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    public int radius;
    public RoundedBorder(int radius){
        this.radius = radius;
    }
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y , width-1 , height-1 , radius , radius);
        g.setColor(Color.GREEN);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius+1 , radius+1 , radius+2 , radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
