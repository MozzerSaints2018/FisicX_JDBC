package entitites;

public class Pessoa {

	private String nome;
	private String cpf;
	private String logradouro;
	private int numeroLogra;
	private String cidade;
	private String bairro;
	private int idade;
	private char sexo;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, String logradouro, int numeroLogra,
			String cidade, String bairro, int idade, char sexo) {
		this.nome = nome;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numeroLogra = numeroLogra;
		this.cidade = cidade;
		this.bairro = bairro;
		this.idade = idade;
		this.sexo = sexo;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setNome(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumeroLogra() {
		return numeroLogra;
	}

	public void setNumeroLogra(int numeroLogra) {
		this.numeroLogra = numeroLogra;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
