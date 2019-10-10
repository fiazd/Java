package cmsc256;
import java.util.*;

public class ArrayBasedStack<T>  implements StackInterface<T> {

	private T[] data;
	private int topOfStack;
	//Default value
	private static final int INITIAL_CAPACITY = 5;

	public ArrayBasedStack(int capacity) {
		if(capacity <= 0) {
			throw new IllegalArgumentException("Array initial size error.");
		}
		clear();
	}

	public ArrayBasedStack() {
		data = (T[]) new Object[INITIAL_CAPACITY];
	}

	private void expandArray() {
		data = Arrays.copyOf(data, data.length * 2);
	}

	private boolean isArrayFull() {
		if(topOfStack + 1 >= data.length) {
			return true;
		}
		return false;
	}

	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		if (isArrayFull()) {
			expandArray();
		}
		topOfStack++;
		data[topOfStack] = newEntry;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyStackException("Empty stack Exception");
		}
		T temp = data[topOfStack];
		data[topOfStack] = null;
		topOfStack--;
		return temp;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyStackException("Empty stack Exception");
		}
		return data[topOfStack];
	}

	@Override
	public boolean isEmpty() {
		if(topOfStack <= 0) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		@SuppressWarnings("unchecked") T[] tempStack = (T[])new Object[INITIAL_CAPACITY];
		data = tempStack;
		topOfStack = -1;
	}

}
