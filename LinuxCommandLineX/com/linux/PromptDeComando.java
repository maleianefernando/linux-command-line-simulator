
import java.util.Scanner;
import java.lang.Thread;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.File;


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
}
