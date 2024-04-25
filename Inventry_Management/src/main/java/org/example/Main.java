package org.example;

import org.example.Component.Login;
import org.example.DashboardLayout.DashboardLayout;

import javax.swing.*;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        try {
//            UIManager.setLookAndFeel(new FlatLightLaf());
//        } catch (Exception ex) {
//            System.err.println("Failed to initialize FlatLaf");
//        }

        Login login = new Login();
        login.setVisible(true);
        login.setSize(1200 , 700);
    }
}