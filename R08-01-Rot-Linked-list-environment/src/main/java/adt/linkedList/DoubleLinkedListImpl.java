package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		last = new DoubleLinkedListNode<T>();
		head = last;

	}

	@Override
	public void insert(T element) {

		if (element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
			newNode.setData(element);
			newNode.setPrevious(last);
			last.setNext(newNode);
			if (isEmpty()) {
				head = newNode;
			}
			last = newNode;
			DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
			last.setNext(nil);
			nil.setPrevious(last);
		}
	}
	
	@Override
	public void insertFirst(T element) {

		if (element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>();
			newNode.setData(element);
			newNode.setNext(head);

			((DoubleLinkedListNode<T>) head).setPrevious(newNode);

			if (isEmpty()) {
				last = newNode;
			}
			
			head = newNode;
			DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
			((DoubleLinkedListNode<T>) head).setPrevious(nil);
			nil.setNext(head);

		}
	}

	@Override
	public void remove(T element) {

		if (element != null && !isEmpty()) {
			if (head.getData().equals(element)) {
				removeFirst();
			} else {

				DoubleLinkedListNode<T> atual = (DoubleLinkedListNode<T>) head;

				while (!atual.isNIL()) {
					if (atual.getData().equals(element)) {
						DoubleLinkedListNode<T> anterior = atual.getPrevious();
						DoubleLinkedListNode<T> proximo = (DoubleLinkedListNode<T>) atual.getNext();

						anterior.setNext(proximo);
						proximo.setPrevious(anterior);

						if (proximo.isNIL()) {
							last = anterior;
						}
						break;
					}
					atual = (DoubleLinkedListNode<T>) atual.getNext();
				}
			}
		}
	}

	@Override
	public void removeFirst() {

		if (!isEmpty()) {

			DoubleLinkedListNode<T> atual = (DoubleLinkedListNode<T>) head;

			head = atual.getNext();
			((DoubleLinkedListNode<T>) head).setPrevious(atual.getPrevious());

			if (head.isNIL()) {
				last = new DoubleLinkedListNode<T>();
				head = last;
			}
		}
	}

		@Override
	public void removeLast() {
	
		if (!isEmpty()) {
				DoubleLinkedListNode<T> auxNode = last;

				last = auxNode.getPrevious();
				last.setNext(auxNode.getNext());
	
			if (last.isNIL()) {
					last = new DoubleLinkedListNode<T>();
				head = last;
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
