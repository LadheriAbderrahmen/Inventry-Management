package org.example.leftside;

import org.example.Component.RoundedBorder;
import org.example.Content.Content;
import org.example.pages.About;
import org.example.pages.Dashboard;
import org.example.pages.ManageProduct;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class LeftSide extends JPanel {
    public JButton btn;
    public JButton btn2;
    public JButton btn3;
    public ChartPanel chartpanel;
    public LeftSide(){
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));


        JLabel username = new JLabel("Abderrahmen Ladheri");
        username.setAlignmentX(Component.CENTER_ALIGNMENT);
        username.setBorder(BorderFactory.createEmptyBorder(30 , 20, 0, 0));

        btn = new JButton("Dashboard");
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(67,125,255));
        btn.setMaximumSize(new Dimension(200 , 35));

        btn2 = new JButton("Gerer Produit");
        btn2.setBorderPainted(false);
        btn2.setFocusPainted(false);
        btn2.setBackground(new Color(67,125,255));
        btn2.setMaximumSize(new Dimension(200 , 35));


        btn3 = new JButton("About");
        btn3.setBorderPainted(false);
        btn3.setFocusPainted(false);
        btn3.setBackground(new Color(67,125,255));
        btn3.setMaximumSize(new Dimension(200 , 35));

        JPanel Menu = new JPanel();
        Menu.setLayout(new BoxLayout(Menu , BoxLayout.Y_AXIS));
        Menu.setBackground(new Color(67,125,255));
        Menu.add(btn);
        Menu.add(btn2);
        Menu.add(btn3);

        Menu.setAlignmentX(Component.CENTER_ALIGNMENT);
        Menu.setBorder(BorderFactory.createEmptyBorder(30 ,  0 ,  30 ,  0 ));


        add(username);
        add(Menu);

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                btn.setBackground(new Color(221,255,214));
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                btn.setBackground(null);
            }
        });

        btn2.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                btn2.setBackground(new Color(221,255,214));
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                btn2.setBackground(null);
            }
        });

        btn3.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                btn3.setBackground(new Color(221,255,214));
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                btn3.setBackground(null);
            }
        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Content.changePanel(new Dashboard());
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Content.changePanel(new ManageProduct());
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Content.changePanel(new About());
            }
        });

    }

}
