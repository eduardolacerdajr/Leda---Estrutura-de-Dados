package problems;

/**
 * Classe com metodos para calcular raiz n-esima de um numero com aproximacao
 * e para encontrar os limites que dividem um array em 3 partes de mesmo tamanho
 * 
 * @author adalbertocajueiro
 *
 */
public class RaizImpl implements Raiz {

	public double raiz(int numero, int raiz, double erro){
		double result = -1;
		if(numero > 0 && raiz >= 0) {
			result = raiz(numero, raiz, erro, 0, (double) numero);
		}
		return result;
	}

	private double raiz(int numero, int raiz, double erro, double left, double right) {
		double result = (left + right) / 2;
		double meio = (left + right) / 2;
		double potencia = pow(meio, raiz);

		if(abs(potencia - numero) <= erro) {
			result = meio;
		}

		else if (potencia > numero) {
			result = raiz(numero, raiz, erro, left, meio + 1);
		}

		else {
			result= raiz(numero, raiz, erro, meio + 1, right);
		}

		return result;

	}

	private double pow(double n, int p) {
		double result  = n;
		if(p != 0) {
			result = n * pow(n, p-1);
		} else {
			result = 1;
		}

		return result;
	}

	private double abs(double n) {
		double result = n;
		if (n < 0) {
			result = -n;
		}

		return result;
	}

}