package adt.linkedList;

import java.util.Arrays;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {

		if (element != null) {
			if (isEmpty()) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<T>();
				((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;

				if (previous == null) {
					this.previous = new RecursiveDoubleLinkedListImpl<T>();
					this.previous.next = this;
				}

			} else {
				next.insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {

		if (element != null) {
			if (isEmpty()) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<T>();
				this.previous = new RecursiveDoubleLinkedListImpl<T>();

				((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;
				this.previous.next = this;

			} else {
				RecursiveDoubleLinkedListImpl<T> auxNode = new RecursiveDoubleLinkedListImpl<T>();
				auxNode.data = this.data;
				auxNode.next = this.next;
				auxNode.previous = this;

				((RecursiveDoubleLinkedListImpl<T>) this.next).previous = auxNode;

				this.data = element;
				this.next = auxNode;
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element != null && !isEmpty()) {
			if (this.data.equals(element)) {
				if (this.previous.isEmpty()) {
					removeFirst();

				} else {
					this.previous.next = next;
					((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this.previous;
				}

			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public void removeFirst() {

		if (!isEmpty()) {
			if (this.next.isEmpty()) {
				this.data = null;
				this.previous = null;
				this.next = null;

			} else {
				this.data = next.data;
				this.next = next.next;
				((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;
			}
		}
	}

	@Override
	public void removeLast() {

		if (!isEmpty()) {
			if (this.previous.isEmpty() && this.next.isEmpty()) {
				removeFirst();

			} else if (this.next.isEmpty()) {
				this.data = null;
				this.next = null;
			} else {
				((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return Arrays.toString(toArray());
	}
}