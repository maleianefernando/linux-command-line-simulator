
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

public class Diretorio extends SistemaDeFicheiros {
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
	}

	public String modificacao(){
		LocalDate data = LocalDate.now();
		LocalTime hora = LocalTime.now();
		String r = data + "  " + hora;
		return r;
	}
}

