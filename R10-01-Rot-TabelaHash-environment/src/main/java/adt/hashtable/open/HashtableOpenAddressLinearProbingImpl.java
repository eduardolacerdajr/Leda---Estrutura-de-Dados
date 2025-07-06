package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (indexOf(element) == -1 && !isFull()) {
			int probeIndex = 0;
			int hash;
			boolean inserted = false;

			while (!inserted) {
				hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probeIndex);

				if (table[hash] != null && !table[hash].equals(deletedElement)) {
					probeIndex++;
					COLLISIONS++;
				} else {
					table[hash] = element;
					inserted = true;
					elements++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		int indexOnTable = indexOf(element);

		if (indexOnTable != -1) {
			table[indexOnTable] = new DELETED();
			elements--;
		}
	}

	@Override
	public T search(T element) {
		T result = null;

		if (!isEmpty() && element != null) {
			int indexOnTable = indexOf(element);

			if (indexOnTable != -1) {
				result = (T) table[indexOnTable];
			}
		}

		return result;
	}

	@Override
	public int indexOf(T element) {
		int indexElement = -1;

		if (element != null && !isEmpty()) {
			int hash;
			int probeIndex = 0;
			boolean found = false;

			while (!found && probeIndex < table.length) {
				hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, probeIndex);

				if (table[hash] == null) {
					found = true;
				} else if (table[hash].equals(element)) {
					indexElement = hash;
					found = true;
				} else {
					probeIndex++;
				}
			}
		}

		return indexElement;
	}

}
