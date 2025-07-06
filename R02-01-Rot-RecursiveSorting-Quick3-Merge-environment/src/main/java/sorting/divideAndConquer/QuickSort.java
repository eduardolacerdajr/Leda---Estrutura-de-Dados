package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int pivot = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}

	}

	private int partition(T[]array, int leftIndex, int rightIndex) {
		final int target = leftIndex;
		int i = target;
		T pivot = array[target];
		for(int j = target + 1; j <= rightIndex; ++j) {
			if(pivot.compareTo(array[j]) < 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, target, i);
		return i;
	}

}
