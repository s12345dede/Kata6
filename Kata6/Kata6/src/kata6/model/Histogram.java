package kata6.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Histogram<T> {
	
	private Map<T, Integer> map;
	
	public Histogram(final Iterator<T> iterator) {
		map = new HashMap<>();
		iterator.forEachRemaining(e -> increment(e));
	}
	
	public Histogram(final Iterable<T> iterable) {
		this(iterable.iterator());
	}

	public Integer get(T key) {
		return map.get(key);
	}
	
	public Set<T> keySet() {
		return map.keySet();
	}
	
	public void increment(T key) {
		map.put(key, map.containsKey(key) ? map.get(key)+1:1);
	}
	
	public void increment(T key, int times) {
		map.put(key, map.containsKey(key) ? map.get(key)+times:times);
	}
	
}