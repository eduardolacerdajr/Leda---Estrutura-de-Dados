package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex < array.length && leftIndex < rightIndex) {

			Integer max = getBig(array, leftIndex, rightIndex);

			int[] frequency = new int[max + 1];
			Integer[] aux = new Integer[rightIndex - leftIndex + 1];

			// count the frequency
			for(int i = leftIndex; i <= rightIndex; i++) {
				frequency[array[i]]++;
			}

			// cumulative calculation
			for(int i = 1; i < frequency.length; i++) {
				frequency[i] += frequency[i - 1];
			}

			// adding order
			for(int i = rightIndex; i >= leftIndex; i--) {
				aux[frequency[array[i]] - 1] = array[i];
				frequency[array[i]] -= 1;
			}

			// array update
			for(int i = leftIndex, j = 0; i <= rightIndex; i++, j++ ) {
				array[i] = aux[j];
			}


			}
		}

		private int getBig(Integer[]array, int leftIndex, int rightIndex) {
			int index = leftIndex;
			for(int i = leftIndex; i <= rightIndex; i++) {
				if(array[index] < array[i]) {
					index = i;
				}
			}
			return array[index];
		}
	}
