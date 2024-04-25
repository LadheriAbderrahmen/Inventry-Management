package org.example.DashboardLayout;

import org.example.Content.Content;
import org.example.leftside.LeftSide;

import javax.swing.*;
import java.awt.*;

public class DashboardLayout extends JFrame {
    public  DashboardLayout(){

        JPanel Layout = new JPanel();
        Layout.setLayout(new BorderLayout());

        LeftSide leftSide = new LeftSide();
        leftSide.setVisible(true);
        leftSide.setPreferredSize(new Dimension(200 , getHeight()));
        leftSide.setBackground(new Color(67,125,255));

        Content content = new Content();
        content.setVisible(true);

        Layout.add(leftSide , BorderLayout.WEST);
        Layout.add(content , BorderLayout.CENTER);

        add(Layout);

    }
}
