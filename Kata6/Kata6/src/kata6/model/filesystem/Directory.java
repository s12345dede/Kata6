package kata6.model.filesystem;

import java.io.File;
import java.util.Iterator;

public class Directory implements Iterable<File> {

	private File root;

	public Directory(File root) {
		this.root = root;
	}

	@Override
	public Iterator<File> iterator() {
		return new FileIterator();
	}

	private class FileIterator implements Iterator<File> {

		private Iterator<File> subdir;
		private File[] files = root.listFiles();
		private int index = 0;

		@Override
		public boolean hasNext() {
			return subdir == null 
					? index < files.length 
							: subdir.hasNext() || index+1 < files.length;
		}

		@Override
		public File next() {

			File next = null;

			if(files[index].isDirectory()) {

				if(subdir == null) {
					subdir = new Directory(files[index]).iterator();
					if(!subdir.hasNext()) {
						subdir = null;
						return files[index++];
					}

					next = files[index];

				} else if(subdir.hasNext()) {

					next = subdir.next();

					if(!subdir.hasNext()) {
						subdir = null;
						index++;
					}

				}


			} else {

				next = files[index++];

			}

			return next;

		}

	}



}
