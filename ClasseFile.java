
class ClasseFile{
	public static void main(String[] args){
		String dir = "Diretorio";
		java.io.File diretorio = new java.io.File(dir);
		boolean statusDir = diretorio.mkdir();
		System.out.println(statusDir);
		//diretorio.delete();
		
//Criando um arquivo
		java.io.File arquivo = new java.io.File("./Diretorio/arquivo.txt");
		try {
			boolean statusArq = arquivo.createNewFile();
			System.out.println(statusArq);
		} catch (java.io.IOException e) {
			
		}

//verificando a existencia de um diretorio
		if(diretorio.exists()){
			System.out.println("O diretorio existe");
			if(arquivo.exists()){
				System.out.println("O arquivo existe");
			}
		}
		
//lista de diretorios
		java.io.File atual = new java.io.File("./");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String path = sc.next();
		atual = new java.io.File(path);

		for(java.io.File file: atual.listFiles()){
			System.out.println(file);
		}

//renomeando diretorios
		java.io.File arq2 = new java.io.File("./Diretorio/arquivoDeTexto.txt");
		boolean statusRen = arquivo.renameTo(arq2);
		System.out.println("Renomeado: " + statusRen + "novo nome: Arquivo de texto");
		
	}
}