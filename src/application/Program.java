package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entitites.Aluno;
import entitites.Avaliador;
import entitites.Pessoa;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("----------------------------------------------------------");
			System.out.println("---------------------DADOS PESSOAIS-----------------------");

			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Idade: ");
			int idade = sc.nextInt();
			System.out.print("Sexo (M / F) : ");
			char sexo = sc.nextLine().charAt(0);
			System.out.print("CPF: ");
			String cpf = sc.nextLine();
			System.out.print("Logradouro: ");
			String logradouro = sc.nextLine();
			System.out.print("Nº Logradouro: ");
			int numeroLogra = sc.nextInt();
			System.out.print("Cidade: ");
			sc.nextLine();
			String cidade = sc.nextLine();
			System.out.print("Bairro: ");
			String bairro = sc.nextLine();
			System.out.println();
			Pessoa pessoa = new Pessoa(nome, cpf, logradouro, numeroLogra, cidade, bairro, idade, sexo);

			System.out.println("Avaliador ou Aluno");
			String decision = sc.nextLine();
			if (decision.equals("aluno")) {
				// --------------------//---------------------||---------------------------\\------------\\

				System.out.println("----------------------------------------------------------");
				System.out.println("--------------------DADOS INICIAIS------------------------");
				System.out.print("Peso: ");
				double peso = sc.nextDouble();
				System.out.print("Altura: ");
				int altura = sc.nextInt();

				// --------------------//---------------------||---------------------------\\------------\\

				System.out.println("----------------------------------------------------------");
				System.out.println("---------------------ANTROPOMETRIA------------------------");
				System.out.print("Tricipital: ");
				double tricipital = sc.nextDouble();
				System.out.print("Bicipital: ");
				double bicipital = sc.nextDouble();
				System.out.print("Toraxica: ");
				double toraxica = sc.nextDouble();
				System.out.print("Axilar Média: ");
				double axmedia = sc.nextDouble();
				System.out.print("Subscapular: ");
				double subscapular = sc.nextDouble();
				System.out.print("Supra - Iliaca: ");
				double suiliaca = sc.nextDouble();
				System.out.print("Femural Média: ");
				double peitmedia = sc.nextDouble();
				System.out.print("Abdominal: ");
				double abdominal = sc.nextDouble();
				System.out.print("Panturrilha: ");
				double panturrilha = sc.nextDouble();

				// --------------------//---------------------||---------------------------\\------------\\

				System.out.println("----------------------------------------------------------");
				System.out.println("----------------------PERIMETRIA--------------------------");
				System.out.print("Pescoço: ");
				double pescoco = sc.nextDouble();
				System.out.print("Ombro: ");
				double ombro = sc.nextDouble();
				System.out.print("Braço Direito: ");
				double bradireito = sc.nextDouble();
				System.out.print("Braço Esquerdo: ");
				double braesquerdo = sc.nextDouble();
				System.out.print("Anti - Braço Direito: ");
				double antibradireito = sc.nextDouble();
				System.out.print("Anti - Braço Esquerdo: ");
				double antibraesquerdo = sc.nextDouble();
				System.out.print("Torax: ");
				double torax = sc.nextDouble();
				System.out.print("Cintura: ");
				double cintura = sc.nextDouble();
				System.out.print("Abdomen: ");
				double abdomen = sc.nextDouble();
				System.out.print("Quadril: ");
				double quadril = sc.nextDouble();
				System.out.print("Coxa Direita: ");
				double coxdireita = sc.nextDouble();
				System.out.print("Coxa Esquerda: ");
				double coxesquerda = sc.nextDouble();
				System.out.print("Panturrilha Direita: ");
				double pandireita = sc.nextDouble();
				System.out.print("Panturrilha Esquerda: ");
				double panesquerda = sc.nextDouble();

				Aluno aluno = new Aluno(altura, peso, pescoco, ombro, bradireito, braesquerdo, antibradireito,
						antibraesquerdo, torax, cintura, abdomen, quadril, coxdireita, coxesquerda, pandireita,
						panesquerda, tricipital, bicipital, toraxica, axmedia, subscapular, suiliaca, peitmedia,
						abdominal, panturrilha);

				System.out.println("Impressos: " + aluno.getAbdomen() + " , " + pessoa.getCpf());
			} else if(decision.equals("avaliador")){
				System.out.println("Insira o novo código: ");
				String codigoAvaliador = sc.nextLine();
				Avaliador aval = new Avaliador(codigoAvaliador);				
			}else {
				throw new DomainException("Tipo de usuário não localizado");
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Valor Inválido!");
		}
		catch(DomainException e){
			System.out.println(e);
		}
		finally{
			if(sc != null) {
				sc.close();
			}
			System.out.println("Executed!");
		}
	}

}
