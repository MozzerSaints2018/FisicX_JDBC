package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;



import db.DB;
import db.DbException;
import entitites.Pessoa;

public class Program {

	public static void main(String[] args) {

		
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");*/
		Connection conn = null; /* Realiza a conexão com o banco de dados recebendo valores do Properties*/
		PreparedStatement st = null; /* Classe para inserir os comandos SQLs a serem executados no banco*/
		Scanner sc = new Scanner(System.in);
		
		
		try {
			
			conn = DB.getConnection();
			
			System.out.println("----------------------------------------------------------");
			System.out.println("---------------------DADOS PESSOAIS-----------------------");

			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Endereço: ");
			String endereco = sc.nextLine();
			
			System.out.print("Bairro: ");
			String bairro = sc.nextLine();
			
			System.out.print("Cidade: ");
			String cidade = sc.nextLine();
			
			System.out.print("CEP: ");
			String cep = sc.nextLine();
			
			System.out.print("CPF: ");
			String cpf = sc.nextLine();
			
			System.out.print("Data de Nascimento: ");			
			String dataNascimento = sc.nextLine();
			
			System.out.print("Login: ");
			String login = sc.nextLine();
			
			System.out.println("Senha: ");
			String senha = sc.nextLine();
			
			
			st = conn.prepareStatement(
					"INSERT INTO FX_Pessoa"
					+ "(pes_Nome, pes_Endereco, pes_Bairro, pes_Cidade, pes_CEP,"
					+ "pes_CPF, pes_DataNascimento, pes_Login, pes_Senha, pes_TipoAcesso, pes_Atibo) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS );
			
			st.setString(1, nome);
			st.setString(2, endereco);
			st.setString(3, bairro);
			st.setString(4, cidade);
			st.setString(5, cep);
			st.setString(6, cpf);
			st.setString(7, dataNascimento);
			st.setString(8, login);
			st.setString(9, senha);
			st.setInt(10, 1);
			st.setInt(11, 1);
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys(); /* Chamada de função getGeneratedKey retorna um ResultSet com o código da linha inserida.*/
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! ID: " + id);
				}
			}
			else {
				System.out.println("No rows affected");
			}
			
	}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeConnection();
			DB.closeStatement(st);
			sc.close();
		}
	}

}
