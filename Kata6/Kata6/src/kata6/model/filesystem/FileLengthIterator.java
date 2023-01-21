package kata6.model.filesystem;

import java.io.File;
import java.util.Iterator;

public class FileLengthIterator implements Iterator<Float> {
	
	public enum LengthUnit {
		
		BYTES(1),
		KB(1024),
		MB(KB.size*1024),
		GB(MB.size*1024),
		TB(GB.size*1024);
		
		final float size;
		
		private LengthUnit(final float size) {
			this.size = size;
		}

	}

	private final Iterator<File> supplier;
	private final LengthUnit unit;
	
	public FileLengthIterator(final Iterable<File> dir, final LengthUnit unit) {
		this(dir.iterator(), unit);
	}
	
	public FileLengthIterator(final Iterator<File> it, final LengthUnit unit) {
		supplier = it;
		this.unit = unit;
	}

	@Override
	public boolean hasNext() {
		return supplier.hasNext();
	}

	@Override
	public Float next() {
		return (float) (supplier.next().length() / unit.size);
	}


}