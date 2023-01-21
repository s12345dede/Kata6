package kata6.gui;

import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import kata6.model.Histogram;

public class HistogramDisplay<T extends Comparable<T>> extends ApplicationFrame {

	private static final long serialVersionUID = -7765227026124211524L;

	private final Histogram<T> histogram;
	
	public HistogramDisplay(final Histogram<T> histogram) {
		super("Histograma");
		this.histogram = histogram;
	}
	
	private JPanel createPanel() {
		JPanel panel = new ChartPanel(createChart(createDataSet()));
		panel.setPreferredSize(new Dimension(500,400));
		return panel;
	}
	
	private JFreeChart createChart(DefaultCategoryDataset dataset) {
		return ChartFactory.createBarChart("Frecuencias",
				"Tamaño de archivo", "Frecuencia", dataset,
				PlotOrientation.VERTICAL, false, false, false);
	}
	
	private DefaultCategoryDataset createDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		histogram.keySet().forEach(k -> {
			dataset.addValue(histogram.get(k), "", k);
		});
		return dataset;
	}

	public void execute() {
		
		JPanel root = createPanel();
		
		setContentPane(root);
		
		pack();
		
		setLocationRelativeTo(null);
		
		setVisible(true);

	}
	
}
