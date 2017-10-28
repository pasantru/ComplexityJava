package main;

public class Analizador {
	
	/* 
	 * NOTA IMPORTANTE
	 * 
	 * Esta clase se proporciona solamente para ilustrar el formato de
	 * salida que deberia tener la solucion a este ejericio.
	 * Esta clase debe modificarse completamente para cumplir 
	 * mínimamente los requisitos de esta practica.
	 * Notese que ni siquiera esta completa......
	 */
	//TODO change the ratios for the execution of the algorithms
	//TODO make the ratios
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
		Temporizador t = new Temporizador();
		long t1;
		long t2;
		long totalTime = 0;
		long maxTime = 10000000000L;

		//Test the time for an algorithm and limit the array size to execute
		long testTime1 = execution(t,n[1],1);
		long testTime2 = execution(t, n[6], 1);
		if (testTime2-testTime1 > 500000) arrLen -= 8;
		//TODO make a value to limit the numbers that the arguments can take depending on the complexity it has
		//Start the complexity check
		do{
			//TODO change the times value to correspond to an automatic calculation for larger complexity algorithms
			t1 = execution(t,n[i], 5);
			totalTime += t1;
			i++;

			System.out.println("Doing shtuff!!");
			t.reiniciar();
			//TODO change the times value to correspond to an automatic calculation for larger complexity algorithms
			t2 = execution(t, n[i],5);
			totalTime += t2;
			i++;
			double ratio;
			if (t2 > t1)ratio = (double)t2/t1;
			else ratio = (double)t1/t2;
			System.out.println("Tiempo pasado: (t1): " + t1 + " (t2): " + t2);
			System.out.println("Ratio: " + ratio);
			System.out.println(masCercano(ratio));
			System.out.println("-------------------------------------------------\n");
		}while (totalTime < maxTime && i < arrLen);
	}
}
