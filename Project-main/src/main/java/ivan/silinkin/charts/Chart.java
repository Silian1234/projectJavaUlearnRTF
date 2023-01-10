package ivan.silinkin.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Map;

public class Chart {

   public static void AverageGlobalSalesChart(Map<String, Double> map) {
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       for (var  i : map.entrySet()) {
           dataset.setValue(i.getValue(), "Платформы", i.getKey());
       }
       JFreeChart chart = ChartFactory.createBarChart("Средние глобальные продажи", "Платформы", "Средние глобальные продажи", dataset);
       CategoryPlot plot = (CategoryPlot) chart.getPlot();
       NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
       rangeAxis.setNumberFormatOverride(NumberFormat.getIntegerInstance());
       try {
           ChartUtils.saveChartAsPNG(new File("ChartAverageSales.png"), chart, 1500, 600);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
}
