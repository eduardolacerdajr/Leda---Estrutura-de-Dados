package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T top = null;
		if(!isEmpty()){
			top = this.array[this.top];
		}
		return top;
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return this.top == (array.length-1);
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()){
			throw new StackOverflowException();
		}
		if (element!= null) {
			array[++this.top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()){
			throw new StackUnderflowException();
		}			
		return this.array[this.top--];
	}
}