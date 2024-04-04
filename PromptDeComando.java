//package LinuxCommandLine;

import java.util.Scanner;
import java.lang.Thread;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;


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


abstract class SistemaDeFicheirosX {
	

	public void permissoes (int arg){
		//0 - permissoin = null
		//1 - permissiond = execute
		//2 - permission = write
		//4 - permissions = read

		int r, w, x;
		//r = Math.trunc(arg / 100);
		//w = ;
		x = arg % 10;


		}
}

abstract class SistemaDeFicheiros {
	protected File file;

	public abstract boolean criar (String d);
	public abstract boolean remover (String d);
	public abstract boolean copiar (String d);
	public abstract boolean mover (String a, String d);
	public abstract void lista (String d);
}

class Diretorio extends SistemaDeFicheiros {
	//File file;
	String ultimaModificacao = "";
	Diretorio () {
		
	}

	public boolean navegar(String d) {
		
		return true;
	}

	public boolean criar (String d) {
		file = new File(d);
		boolean status = false;

		if (file.exists()) {
			System.out.println("mkdir: cannot create directory \'" + file + "\': File exists");
			status = false;
		} else {
			status = file.mkdir();
			this.ultimaModificacao = modificacao();
		}
		return status;
	}

	public boolean remover (String d) {
		file = new File(d);
		boolean status = true;

		if (! file.exists()) {
			System.out.println("rm: cannot remove \'" + file.getName() + "\': No such file or directory");
		} else {
			status = file.delete();
		}
		return status;
	}

	public boolean copiar (String d) {
		return true;
	}

	public boolean mover (String a, String d) {
		File destino = new File(d);
		file = new File(a);

		return file.renameTo(destino);
	}

	public void lista (String d) {
		file = new File(d);
		try{
		for(File f: file.listFiles()) {
				if (f.isDirectory()) {
					System.out.print(f);
					System.out.print("\t\t<Directory>");
					System.out.println("\t\t" + this.ultimaModificacao);
				} else {
					System.out.print(f);
					System.out.print("\t\t");
					//System.out.println("\t\t" + ficheiro.ultimaModificacao());
				}
				System.out.println();
		}
		}catch(Exception e){
			System.out.println(d);
		}
	}

	public String modificacao(){
		LocalDate data = LocalDate.now();
		LocalTime hora = LocalTime.now();
		String r = data + "  " + hora;
		return r;
	}
}


class Ficheiro extends SistemaDeFicheiros {
	//File file;
	String ultimaModificacao = "";
	
	Ficheiro () {
		
	}

	
	public boolean criar (String d) {
		file = new File(d);
		boolean status = true;
		
		
		if(file.isDirectory()){
			System.out.println("bash: " + file + ": Is a directory");
			status = false;
		}
		else if (file.exists()) {
			this.editar(d);
			this.ultimaModificacao = modificacao();
			status = true;
		} else {
			try {
				status = file.createNewFile();
				this.ultimaModificacao = modificacao();
			} catch (java.io.IOException e) {
				
		}	}

		return status;
	}

	public boolean remover (String d) {
		File file = new File(d);
		boolean status = true;

		if (file.isDirectory()){
			System.out.println("rm: cannot remove \'" + file + "\': Is a directory");
			status = false;
		} else if(! (file.exists())) {
			System.out.println("rm: cannot remove \'" + file.getName() + "\': No such file or directory");
			status = false;
		} else {
			status = file.delete();
		}

		return status;
	}

	public boolean copiar (String d) {
		return true;
	}

	public boolean mover (String a, String d) {
		File destino = new File(d);
		file = new File(a);

		return file.renameTo(destino);
	}

	public void lista (String d) {

	}

	public boolean editar (String d) {
		boolean status = true;
		Scanner scanner = new Scanner (System.in);
		file = new File(d);
		
		String texto = "";
		
		if (! (file.exists())) {
			this.criar(d);
		}

	
		try {
			FileWriter ficheiro = new FileWriter(d, true);		//representa o ficheiro no qual vamos escrever
			PrintWriter escrever = new PrintWriter(ficheiro);	//a classe que que contem os metodos de escrita em arquivos
			
			texto = scanner.nextLine();
			escrever.println(texto);
			escrever.flush();
			escrever.close();
			this.ultimaModificacao = modificacao();
		} catch (IOException e) {
			
		}
		return status;
	}


	public boolean ler (String d) {
		boolean status = true;

		file = new File(d);
		
		if(file.isDirectory()){
			System.out.println("cat: " + file + ": Is a directory");
		} else if(! file.exists()){
			System.out.println("cat: " + file + ": No such file or directory");
		}
		else {
			try {
				FileReader ficheiro = new FileReader(d);
				BufferedReader leitura = new BufferedReader(ficheiro);
				String linha = "";
		
				while ((linha = leitura.readLine()) != null) {
					System.out.println(linha);
				}
			} catch(IOException e) {
				
			}
		}
		
		return status;
	}
	
	public String modificacao(){
		LocalDate data = LocalDate.now();
		LocalTime hora = LocalTime.now();
		String r = data + "  " + hora;
		return r;
	}
}



public class PromptDeComando {
	private Scanner cursor;
	private String cmd, arg, arg2;
	//private Calculadora c;
	private File f;

	public PromptDeComando(){
		cursor = new Scanner(System.in);
		f = new File("./");

		do {
			System.out.print("fernando@fernando-VirtualBox:~$ ");
			cmd = cursor.next();
			
			if (cmd.equals("shutdown") || cmd.equals("exit")) {
				arg = "-";
			}
 
			else if(cmd.equals("dir")) {
				arg = ".";
			}

			else if (cmd.equals("date") || cmd.equals("time")) {
				arg = "";
			}

			else if (cmd.equals("gcalccmd")) {
				arg ="";
			}

			else if (cmd.equals("mv")) {
				arg = cursor.next();
				arg2 = cursor.next();
			}

			else {
				arg = cursor.next();
			}


		} while(comando(cmd));
	}

	
	private boolean comando (String cmd){
		boolean r = true;

		switch(cmd) {
			case "cd": {

			}; break;

			case "ls": {
				Diretorio d = new Diretorio();
				d.lista(arg);
			}; break;

			case "dir": {
				Diretorio d = new Diretorio();
				d.lista(arg);				
			}; break;

			case "mkdir": {
				Diretorio d = new Diretorio();
				if (d.criar(arg)){
					
				} else {
					System.out.println();
				}
			}; break;

			case "rm-r": {
				Diretorio d = new Diretorio();
				if (d.remover(arg)) {
					
				} else {
					System.out.println("");
				}
			}; break;

			case "rm": {
				Ficheiro d = new Ficheiro();

				if (d.remover(arg)) {
					
				} else {
					System.out.println();
				}
			}; break;

			case "cp": {
				
			}; break;

			case "mv": {
				File f = new File(arg);

				if (! (f.exists())) {
					System.out.println("mv: cannot stat \'" + arg + "\' No such file or directory");
				}
				else if (f.isDirectory()) {
					Diretorio d = new Diretorio();
					if (d.mover(arg, arg2)) {
						
					} else {
						System.out.println();
					}
					//System.out.println("Dir");
				}
				else if (f.isFile()){
					Ficheiro d = new Ficheiro();
					if (d.mover(arg, arg2)) {

					} else {
						System.out.println();
					}
					//System.out.println("File");
				}

			}; break;

			case "cat>": {
				Ficheiro d = new Ficheiro();
				
				if (d.editar(arg)) {
					System.out.println("\n^Z\n[1]+\tStopped\t\t\tcat > "/* + d.getName()*/);
				} else {
					System.out.println();
				}
			}; break;

			case "cat": {
				Ficheiro d = new Ficheiro();
				
				if (d.ler(arg)) {
					
				} else {
					System.out.println();
				}
			}; break;

			case "nano": {
				Ficheiro d = new Ficheiro();

				if (d.criar(arg)) {
					
				} else {
					System.out.println();
				}
			}; break;

			case "date": {
				LocalDate date = LocalDate.now();
				System.out.println(date);
			}; break;
			
			case "time": {
				LocalTime time = LocalTime.now();
				System.out.println(time);
			}; break;

			case "cal": {
				
			}; break;

			case "gcalccmd": {
				new Calculadora();
			}; break;

			case "clear": {
				
			}; break;

			case "shutdown": {
				shutdown();
				r = false;
			}; break;
			case "exit": {
				//shutdown();
				r = false;
			}; break;
			default: {
				System.out.println(cmd + ": command not found");
			}
		}
		return r;
	}
	
	private void shutdown()	{
		int ms = 1000;
		
		System.out.println("\t\t\t\t\t\t\tShutting down your pc");
		System.out.print("\t\t\t\t\t\t\t");
		
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(ms - i*50);
				System.out.print(" .");
				Thread.sleep(ms/2 - i*50);
				System.out.print(" .");
			}
			
			System.out.print("\n");
			System.exit(0);
		} catch (InterruptedException e) {
			
		}
	}

	public static void main(String[] args){
		new PromptDeComando();
	}

}
