import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Plot extends JFrame {
    public Plot(String path){
        initPlot(path);
    }
    private void initPlot(String path) {
        XYDataset dataset = createDataset(path);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset(String path){
        Colors data = new Colors();
        data.convert(path);

        HashMap<Integer, Integer> red = data.getRed();
        HashMap<Integer, Integer> blue = data.getBlue();
        HashMap<Integer, Integer> green = data.getGreen();

        var series1 = new XYSeries("Red");
        for (int i = 0; i < 256; i++){
            series1.add(i, red.get(i));
        }

        var series2 = new XYSeries("Blue");
        for (int i = 0; i < 256; i++){
            series2.add(i, blue.get(i));
        }

        var series3 = new XYSeries("Green");
        for (int i = 0; i < 256; i++){
            series3.add(i, green.get(i));
        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset){
        JFreeChart chart = ChartFactory.createXYLineChart(
                "RGB Histogram",
                "Value",
                "Quantity",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);


        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);


        return chart;

    }
}
