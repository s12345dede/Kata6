package kata6;

import java.io.File;

import kata6.gui.HistogramDisplay;
import kata6.model.Histogram;
import kata6.model.filesystem.Directory;
import kata6.model.filesystem.FileLengthIterator;
import kata6.model.filesystem.FileLengthIterator.LengthUnit;

public class Kata6 {

	public static void main(String[] args) {
		
		Directory root = new Directory(new File("/"));
		
		Histogram<Float> hist = new Histogram<>(
				new FileLengthIterator(root, LengthUnit.KB));
		
		new HistogramDisplay<Float>(hist).execute();

	}

}
