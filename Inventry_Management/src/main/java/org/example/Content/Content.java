package org.example.Content;

import org.example.pages.Dashboard;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {

    public static JPanel mainPanel;
    public Content(){
       setLayout(new BorderLayout());

       mainPanel = new Dashboard();

       add(mainPanel , BorderLayout.CENTER);


    }

    public static void changePanel(JPanel p){
        if(mainPanel != null){
            Content content = (Content) SwingUtilities.getAncestorOfClass(Content.class , mainPanel);
            if(content != null){
                content.remove(mainPanel);
                content.add(p , BorderLayout.CENTER);
                content.revalidate();
                content.repaint();
                mainPanel = p;
            }
        }
    }

}
