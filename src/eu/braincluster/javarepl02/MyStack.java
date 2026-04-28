package eu.braincluster.javarepl02;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

	private final List<T> items = new ArrayList<>();
	
	public void push(T value) {
		items.add(value);
	}
	
	public T pop() {
		if (items.isEmpty()) {
			throw new IllegalStateException("A stack üres!");
		}
		
		return items.remove(items.size() - 1);
	}
	
	public T peek() {
		if (items.isEmpty()) {
			throw new IllegalStateException("A stack üres!");
		}
		
		return items.get(items.size() - 1);
	}
	
	public void clear() {
		items.clear();
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	public int size() {
		return items.size();
	}
	
	@Override
	public String toString() {
		return items.toString();
	}
}
