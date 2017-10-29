package Subir;
/*
	@author Raquel Contreras Rosa <Tucorreo>
 */
public class Analizador {
	public static String masCercano(double ratio) {
			if (ratio < 1) {                      // aprox 1.0
				return "1";
			} else if (1 <= ratio && ratio < 2.4) { // aprox 2.0
				return "N";
			} else if (2.4 <= ratio && ratio < 4.32) { // aprox 4.0
				return "N2";
			} else if (4.32 <= ratio && ratio < 9) { // aprox 8.0
				return "N3";
			} else { 								 // otras
				return "NF";
			}
	}

	public static long execution(Temporizador t, int value, int times){
		int retValue = 0;
		for (int i = 0; i < times; i++) {
			t.iniciar();
			Algoritmo.f(value);
			t.parar();
			retValue += t.tiempoPasado();
		}
		retValue = retValue/times;
		return Math.abs(retValue);
	}
	public static void main(String arg[]) {
		int[] n = {1, 2, 3, 4, 10, 20, 40, 80, 100, 200, 400, 800, 1000, 4000, 4000, 8000,
				10000, 20000, 30000, 60000};
		int i = 0, arrLen = n.length;
		double ratio;
		Temporizador t = new Temporizador();
		long t1;
		long t2;
		long totalTime = 0;
		long maxTime = 10000000000L;

		long testTime1 = execution(t,n[1],1);
		long testTime2 = execution(t, n[6], 1);
		if (testTime2-testTime1 > 500000) arrLen -= 8;

		do{
			t1 = execution(t,n[i], 5);
			totalTime += t1;
			i++;

			t.reiniciar();
			t2 = execution(t, n[i],5);
			totalTime += t2;
			i++;
			if (t2 > t1)ratio = (double)t2/t1;
			else ratio = (double)t1/t2;
		}while (totalTime < maxTime && i < arrLen);
		System.out.println(masCercano(ratio));
	}
}
