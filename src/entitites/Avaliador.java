package entitites;

public class Avaliador extends Pessoa{
	
	private String codigoAvaliador;

	
	public Avaliador() {
	}
	
	public Avaliador(String codigoAvaliador) {
		super();
		this.codigoAvaliador = codigoAvaliador;
	}

	public String getCodigoAvaliador() {
		return codigoAvaliador;
	}

	public void setCodigoAvaliador(String codigoAvaliador) {
		this.codigoAvaliador = codigoAvaliador;
	}
}
