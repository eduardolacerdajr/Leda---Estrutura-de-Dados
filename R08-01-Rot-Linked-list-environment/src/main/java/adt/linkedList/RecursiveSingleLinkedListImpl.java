package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {

		return this.data == null;
	}

	@Override
	public int size() {
		if (isEmpty())
			return 0;
		return 1 + next.size();
	}

	@Override
	public T search(T element) {

		T elementoRetornado = null;
		if (element != null && !isEmpty()) {
			if (this.data.equals(element)) {
				elementoRetornado = element;

			} else {
				elementoRetornado = next.search(element);
			}
		}
		return elementoRetornado;
	}

	@Override
	public void insert(T element) {

		if (element != null) {
			if (isEmpty()) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<T>();

			} else {
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element != null && !isEmpty()) {
			if (this.data.equals(element)) {
				this.data = next.getData();
				this.next = next.getNext();

			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		List<T> array = new ArrayList<>();
		toArray(array);

		return (T[]) array.toArray();
	}

	private void toArray(List<T> array) {

		if (!isEmpty()) {

			array.add(this.data);
			next.toArray(array);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
}