package org.example.Component;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class Chart_Panel extends JPanel {
    private ChartPanel panelchart1;
    private ChartPanel panelchart2;
    private ChartPanel panelchart3;
    public Chart_Panel(){
        setLayout(new BorderLayout());

         panelchart1 = new ChartPanel(null);
         panelchart1.setPreferredSize(new Dimension(200 , 200));
         panelchart2 = new ChartPanel(null);
         panelchart2.setPreferredSize(new Dimension(200 , 200));
         panelchart3 = new ChartPanel(null);
         panelchart3.setPreferredSize(new Dimension(200 , 200));

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("A" , 1);

        JFreeChart chart = ChartFactory.createRingChart("Product 1", dataset , false , false , false);
        JFreeChart chart2 = ChartFactory.createRingChart("Product 2 ", dataset , false , false , false);
        JFreeChart chart3 = ChartFactory.createRingChart("Product 2 ", dataset , false , false , false);

        panelchart1.setChart(chart);
        panelchart2.setChart(chart2);
        panelchart3.setChart(chart3);

        JPanel ChartMain = new JPanel();
        ChartMain.setLayout(new FlowLayout());
        ChartMain.add(panelchart1);
        ChartMain.add(Box.createHorizontalStrut(20)) ;
        ChartMain.add(panelchart2);
        ChartMain.add(Box.createHorizontalStrut(20)) ;
        ChartMain.add(panelchart3);

        add(ChartMain , BorderLayout.CENTER);
    }
}
