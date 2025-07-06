package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;

		SingleLinkedListNode<T> atual = head;

		while (!atual.isNIL()) {
			size++;
			atual = atual.getNext();
		}

		return size;
	}

	@Override
	public T search(T element) {

		T elementoRetornado = null;

		if (element != null) {

			SingleLinkedListNode<T> atual = head;

			while (!atual.isNIL()) {

				if (atual.getData().equals(element)) {
					elementoRetornado = element;
					break;
				}

				atual = atual.getNext();
			}
		}

		return elementoRetornado;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> auxHead = head;
			
			if (head.isNIL()) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
				head = newHead;
			} else {
				while (!auxHead.getNext().isNIL()) {
					auxHead = auxHead.getNext();
				}
				auxHead.setData(element);
				auxHead.setNext(new SingleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element != null && !isEmpty()) {

			SingleLinkedListNode<T> previous = head;
			SingleLinkedListNode<T> atual = previous.getNext();

			if (previous.getData().equals(element)) {

				this.head = atual;

			} else {

				while (!atual.isNIL()) {

					if (atual.getData().equals(element)) {

						previous.setNext(atual.getNext());
						break;
					}

					previous = atual;
					atual = atual.getNext();
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		int size = size();
		T[] array = (T[]) new Object[size];

		SingleLinkedListNode<T> atual = head;

		for (int i = 0; i < size; i++) {
			array[i] = atual.getData();
			atual = atual.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
}