
import java.io.File;

public abstract class SistemaDeFicheiros implements SistemaDeFicheirosX {
	protected File file;

	public abstract boolean criar (String d);
	public abstract boolean remover (String d);
	public abstract boolean copiar (String d);
	public abstract boolean mover (String a, String d);
	public abstract void lista (String d);

	public void permissoes (int arg){
		
	}
}