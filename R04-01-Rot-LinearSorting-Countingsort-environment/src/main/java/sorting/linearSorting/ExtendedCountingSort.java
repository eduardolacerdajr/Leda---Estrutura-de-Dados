package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex && array != null && leftIndex >= 0 && rightIndex < array.length) {

			Integer max = getBig(array, leftIndex, rightIndex);
			Integer min = getMin(array, leftIndex, rightIndex);

			int[] frequency = new int[max - min + 1];
			Integer[] aux = new Integer[rightIndex - leftIndex + 1];

			// count the frequency
			for (int i = leftIndex; i <= rightIndex; i++) {
				frequency[array[i] - min]++;
			}

			// cumulative calculation
			for (int i = 1; i < frequency.length; i++) {
				frequency[i] += frequency[i - 1];
			}

			// adding order
			for (int i = rightIndex; i >= leftIndex; i--) {
				aux[frequency[array[i] - min] - 1] = array[i];
				frequency[array[i] - min] -= 1;
			}

			// array update
			for (int i = leftIndex, j = 0; i <= rightIndex; i++, j++) {
				array[i] = aux[j];
			}

		}
	}

	private int getBig(Integer[] array, int leftIndex, int rightIndex) {
		int index = leftIndex;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[index] < array[i]) {
				index = i;
			}
		}
		return array[index];
	}

	private int getMin(Integer[] array, int leftIndex, int rightIndex) {
		int index = leftIndex;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[index] > array[i]) {
				index = i;
			}
		}
		return array[index];
	}
}
