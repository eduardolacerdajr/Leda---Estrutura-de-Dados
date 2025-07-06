package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a
	 * estrategia
	 * de usar o selection sem modificar o array original. Note que seu algoritmo
	 * vai
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de
	 * ordem
	 * desejada sem modificar o array original.
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o aray original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e
	 * utilizado.
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 * elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar
	 * um elemento
	 * usando a ideia do selection sort).
	 * - Considere que k varia de 1 a N
	 * - Você pode implementar métodos auxiliares, desde que seja apenas nesta
	 * classe.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		T statics = null;
		if (array != null && k > 0 && k <= array.length) {
			statics = orderStatistics(array, k, 0, array.length - 1);
		}

		return statics;
	}

	private T orderStatistics(T[] array, int k, int left, int right) {
		int min = selectMin(array, left, right);
		for (int i = 1; i < k; i++) {
			min = selectProxMin(array, left, right, min);
		}
		T out = array[min];
		return out;

	}

	private int selectMin(T[] array, int left, int right) {
		int iMin = left;
		if (left < right) {
			int nextMin = selectMin(array, left + 1, right);
			if (array[nextMin].compareTo(array[iMin]) < 0) {
				iMin = nextMin;
			}
		}

		return iMin;

	}

	private int selectProxMin(T[] array, int left, int right, int previous) {
		int iMin = -1;
		if (left <= right) {
			iMin = selectProxMin(array, left + 1, right, previous);

			if (array[left].compareTo(array[previous]) > 0) {

				if (iMin == -1 || array[left].compareTo(array[iMin]) < 0) {
					iMin = left;
				}

			}
		}

		return iMin;
	}
}
