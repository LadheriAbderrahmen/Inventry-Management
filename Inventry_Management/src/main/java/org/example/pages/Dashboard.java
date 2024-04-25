package org.example.pages;

import org.example.Component.Chart_Panel;
import org.example.Component.StateExecutionsChart;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel {
    public Dashboard(){

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JLabel title = new JLabel("Dashboard");
        title.setFont(new Font(Font.MONOSPACED ,Font.BOLD  , 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Component
        Chart_Panel MainChartPanel = new Chart_Panel();
        MainChartPanel.setVisible(true);
        //Component
        StateExecutionsChart stateExecutionsChart = new StateExecutionsChart();
        stateExecutionsChart.setVisible(true);


        JPanel marginpanel = new JPanel();
        marginpanel.setLayout(new BoxLayout(marginpanel , BoxLayout.Y_AXIS));
        marginpanel.add(Box.createRigidArea(new Dimension(getWidth() , 20)));
        marginpanel.add(title);
        marginpanel.add(Box.createRigidArea(new Dimension(getWidth() , 20)));

        JPanel DashMain = new JPanel();
        DashMain.setLayout(new BoxLayout(DashMain , BoxLayout.Y_AXIS));
        DashMain.add(MainChartPanel);
        DashMain.add(stateExecutionsChart);

        add(marginpanel , BorderLayout.NORTH);
        add(DashMain , BorderLayout.CENTER);
    }
}
