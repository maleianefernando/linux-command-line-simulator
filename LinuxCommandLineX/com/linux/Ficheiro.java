
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Ficheiro extends SistemaDeFicheiros {
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

