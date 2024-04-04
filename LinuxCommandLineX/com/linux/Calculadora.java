import java.util.Scanner;

final class Calculadora{
	private double [] operando;
	private String operador = new String();

	public Calculadora () {
		Scanner cin = new Scanner (System.in);
		Integer i = 2, j;

		operando = new double [3];
	
		for (int k = 0; k < 3; k++) {
			operando[k] = 0;
		}
		operador = "";

		do {

			System.out.println ("\n\n\n\n==========================Calculadora========================");
			System.out.println ("1.Calculadora Aritmética\n2.Calculadora Científica\n3.Equação Quadrática\n4.Documentação");
			j = cin.nextInt();
			
			switch (j) {
				case 1: {
					System.out.println
("\n\n==========================Calculadora Aritmética========================\n");
					operador = cin.next();
					operando[0] = cin.nextDouble();
					operando[1] = cin.nextDouble();
					System.out.println("\n\n" + operando[0] + " " + operador + " " + operando[1] + " = " + operacoesAritmeticas (operando[0], operador, operando[1]));
				} break;
				case 2: {
					System.out.println
("\n\n==========================Calculadora Científica========================");
					operador = cin.next();
					operando[0] = cin.nextDouble();
					System.out.println ("\n\n" + operador + "(" + operando[0] + ") = " + operacoesCientificas(operador, operando[0]));
				} break;

				case 3: {
					System.out.println
("\n\n==========================Equação Quadrática========================");
					System.out.println ("\n\nInforme os valores dos coeficientes a, b e c");
					operando[0] = cin.nextDouble();
					operando[1] = cin.nextDouble();
					operando[2] = cin.nextDouble();

					System.out.println ("\na = " + operando[0] + ", b = "  + operando[1] + ", c = "  + operando[2]);
					System.out.println ("\nBinomio discriminante (Delta): " + delta(operando[0], operando[1], operando[2]));
					System.out.println("\nRaizes:\n" + eqQuadratica(operando[0], operando[1], operando[2]));
				}; break;

				case 4: {
					System.out.println
("\n\n==========================Calculadora Aritmética========================\n");
					System.out.println("Actualmente suporta operações aritméticas envolvendo apenas dois operandos.\nÉ composta pelas quatro operações aritméticas (adição(+), subtracção(-), multiplicação(*), divisão(/))\nPara usar, basta escrever primeiro o operador e depois os operandos.\nExemplo:\n+\n2\n3\nsaida: 2.0 + 3.0 = 5.0");

					System.out.println
("\n\n==========================Calculadora Científica========================");
					System.out.println("Operações suportadas: raíz quadrada (raizQ), raíz cúbica (raizC), logarítmo de base 10 (log), logarítmo natural (ln), seno (sen), cosseno (cos), tangente (tan).\nPara usar basta escrever primeiro a função e em seguida o seu argumento.\nExemplo:\nraizQ 9\nsaida: raizQ(9.0) = 3.0");
				
					System.out.println
("\n\n==========================Equação Quadrática========================");
					System.out.println("Para usar basta inserir os valores dos coeficientes a, b e c.\nExemplo:\n1\n5\n6\nsaida:\n\na = 1.0, b = 5.0, c = 6.0\n\nBinomio discriminante (Delta): 1.0\n\nRaizes:\nx1: 3.0\nx2 = 2.0");
				
				}; break;
			}
			System.out.println ("\n\nSair?\n[1].Sim\n[2].Nao");
			i = cin.nextInt();
		} while (i == 2);

	}


	private String operacoesAritmeticas (double a, String operador, double b) {
		Double resultado = 0.0;

		switch(operador) {
			case "+": resultado = a + b; break;
			case "-": resultado = a-b; break;
			case "*": resultado = a*b; break;
			case "/": resultado = a/b;
			default: {
				resultado = 0.0;
			}
		}

		return resultado.toString();
	}


	private double operacoesCientificas (String operador, double a) {
		double resultado = 0;
		double angulo_em_radianos = a*(Math.PI/180);

		switch (operador) {
			case "raizQ": resultado = Math.sqrt (a); break;
			case "raizC": resultado = Math.cbrt (a); break;
			case "sen": resultado = Math.sin (angulo_em_radianos); break;//o metodo sin revebe argumentos em radianos, daí a necessidade de converter a entrada do usuario em graus para radianos
			case "cos": resultado = Math.cos (angulo_em_radianos); break;
			case "tan": resultado = Math.tan (angulo_em_radianos); break;	
			case "ln": resultado = Math.log (a); break;
			case "log": resultado = Math.log10 (a); break;
		}

		return resultado;
	}
	
	private double delta (double a, double b, double c) {
		return (b*b)-(4*a*c);
	}

	private String eqQuadratica (double a, double b, double c) {
		double x1 = (b + Math.sqrt (delta(a, b, c)))/2*a;
		double x2 = (b - Math.sqrt (delta(a, b, c)))/2*a;
		String r = new String ("x1 = " + x1 + "\nx2 = " + x2);
		
		if (delta(a, b, c) < 0) {
			r = "A equação não tem raízes reais";
		}
		return r;
	}


}
