package org.example.Component;

import org.example.DashboardLayout.DashboardLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    public JButton loginbtn;
    public JTextField field1;
    public JTextField field2;
    public Login(){
        JLabel field1label = new JLabel("username");
        field1 = new JTextField();
        field1.setMaximumSize(new Dimension(500 , 30));
        JLabel field2label = new JLabel("passwword");
        field2 = new JTextField();
        field2.setMaximumSize(new Dimension(500 , 30));

        loginbtn = new JButton("Login");

        ImagePanel MainLoginPanel = new ImagePanel("assetes/bg.jpg");
        MainLoginPanel.setLayout(new BorderLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form , BoxLayout.Y_AXIS));
        form.setBackground(new Color(196,194,255));
        form.add(field1label);
        form.add(Box.createVerticalStrut(10));
        form.add(field1);
        form.add(Box.createVerticalStrut(10));
        form.add(field2label);
        form.add(Box.createVerticalStrut(10));
        form.add(field2);
        form.add(Box.createVerticalStrut(20));
        form.add(loginbtn);
        form.setPreferredSize(new Dimension(300 , 170));

        JPanel loginpanel = new JPanel();
        loginpanel.setBackground(new Color(196,194,255));
        loginpanel.setPreferredSize(new Dimension(300 , getHeight()));
        loginpanel.add(Box.createVerticalStrut(500));
        loginpanel.add(form);

        MainLoginPanel.add(loginpanel , BorderLayout.WEST);


        add(MainLoginPanel);

        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard();
            }
        });
    }
    public void Dashboard(){
        DashboardLayout dashboardLayout = new DashboardLayout();
        dashboardLayout.setVisible(true);
        dashboardLayout.setSize(1200 , 700);
        this.dispose();
    }
}
