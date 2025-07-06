package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes:
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais)
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearchImpl implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array == null | array == 0) {
			return null;
		}

		return floorRec(array, x, 0, array.length - 1, null);

	}

	private Integer floorRec(Integer[] array, int x, int left, int right, Integer floor) {
		if (left > right) {
			return floor;
		}

		int meio = (left + right) / 2;
		if (array[meio] == x) {
			return array[meio];
		} else if (array[meio] > x) {
			return floorRec(array, x, left, meio - 1, floor);
		} else {
			return floorRec(array, x, meio + 1, right, array[meio]);
		}

	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		if(array == null || array.length == 0) {
			return null;
		}

		return ceilRec(array, x, 0, array.length, null); 

		}

	private Integer ceil(Integer[] array, int x, int left, int right, Integer ceil) {
		if (left > right) {
			return ceil;
		}

		int meio = (left + right) / 2;

		if (array[meio] == x) {
			return meio;

		} else if (array[meio] < x) {
			return ceilRec(array, x, meio + 1, right, ceil);
		} else {
			return ceilRec(array, x, left, meio - 1, ceil);
		}

	}

}
