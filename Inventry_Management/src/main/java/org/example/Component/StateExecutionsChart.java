package org.example.Component;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class StateExecutionsChart extends JPanel {
    public StateExecutionsChart(){

        setLayout(new BorderLayout());

        DefaultCategoryDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createBarChart(
                "State Executions", // chart title
                "State",            // domain axis label
                "Executions",       // range axis label
                dataset,            // data
                PlotOrientation.VERTICAL, // orientation
                true,               // include legend
                true,               // tooltips
                false               // URLs
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(getWidth(), 300)); // Set preferred size for the chart panel

        JPanel mainStatePanel = new JPanel(new BorderLayout());
        mainStatePanel.add(Box.createRigidArea(new Dimension(getWidth() , 50)) , BorderLayout.NORTH);
        mainStatePanel.add(Box.createRigidArea(new Dimension(100, getHeight())) , BorderLayout.WEST);
        mainStatePanel.add(chartPanel, BorderLayout.CENTER); // Add the chart panel to the main panel
        add(mainStatePanel, BorderLayout.CENTER);
        mainStatePanel.add(Box.createRigidArea(new Dimension(100 , getHeight())) , BorderLayout.EAST);
        mainStatePanel.add(Box.createRigidArea(new Dimension(getWidth() , 50)) , BorderLayout.SOUTH);

    }
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Sample data - Replace with your actual data
        dataset.addValue(10, "Executions", "State 1");
        dataset.addValue(20, "Executions", "State 2");
        dataset.addValue(15, "Executions", "State 3");
        dataset.addValue(25, "Executions", "State 4");
        dataset.addValue(30, "Executions", "State 5");

        return dataset;
    }
}
