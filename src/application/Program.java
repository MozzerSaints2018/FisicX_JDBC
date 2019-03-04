package application;

import entitites.Aluno;
import entitites.Pessoa;

public class Program {

	public static void main(String[] args) {

		Pessoa pes = new Pessoa();
		Aluno alu = new Aluno();
		
		pes.inserePessoas();
		System.out.println();
		alu.insereAlunos();
		
	}

}
