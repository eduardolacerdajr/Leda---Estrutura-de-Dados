package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;
		if (array != null) {
			for (Integer value : array) {
				this.insert(value);
			}
			floor = this.floorRecursive(numero, floor);
		}
		return floor;
	}

	private Integer floorRecursive(double number, Integer floor) {
		Integer root = this.extractRootElement();

		if (root != null)
			if (number >= root && (floor == null || root >= floor))
				floor = this.floorRecursive(number, root);
			else
				floor = this.floorRecursive(number, floor);

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		if (array != null) {
			for (Integer value : array) {
				this.insert(value);
			}
			ceil = this.ceilRecursive(numero, ceil);
		}
		return ceil;
	}

	private Integer ceilRecursive(double number, Integer ceil) {
		Integer root = this.extractRootElement();

		if (root != null)
			if (number <= root && (ceil == null || root <= ceil))
				ceil = this.ceilRecursive(number, root);
			else
				ceil = this.ceilRecursive(number, ceil);

		return ceil;
	}
}
