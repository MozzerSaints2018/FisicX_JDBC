package entitites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import db.DB;
import db.DbException;

public class Aluno{
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement st = null;
	
	public void insereAlunos() {
		
		
		try {
			
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			System.out.println("----------------------------------------------------------");
			System.out.println("--------------------DADOS INICIAIS------------------------");
			
			
			System.out.print("Peso: ");
			double peso = sc.nextDouble();
			
			System.out.print("Altura: ");
			double altura = sc.nextDouble();
			
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
			double femumedia = sc.nextDouble();
			
			System.out.print("Abdominal: ");
			double abdominal = sc.nextDouble();
			
			System.out.print("Panturrilha: ");
			double panturrilha = sc.nextDouble();
			
			
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
			
			st = conn.prepareStatement(
					"INSERT INTO FX_Aluno"
					+ "(alu_CodigoPessoa, alu_Altura, alu_Peso, alu_IMC, alu_Tricipital, alu_Bicipital,"
					+ "alu_Toraxica, alu_AxilarMedia, alu_Subscapular, alu_SupraIliaca, alu_FemuralMedia,"
					+ "alu_Abdominal, alu_Panturrilha, alu_Pescoco, alu_Ombro, alu_BracoDireito,"
					+ "alu_BracoEsquerdo, alu_AntiBracoDireito, alu_AntiBracoEsquerdo, alu_Torax,"
					+ "alu_Cintura, alu_Abdomen, alu_Quadril, alu_CoxaDireita, alu_CoxaEsquerda,"
					+ "alu_PanturrilhaDireita, alu_PanturrilhaEsquerda, alu_Ativo) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			st.setDouble(1, 1);
			st.setDouble(2, altura);
			st.setDouble(3, peso);
			st.setDouble(4, (peso / (altura * altura)));
			st.setDouble(5, tricipital);
			st.setDouble(6, bicipital);
			st.setDouble(7, toraxica);
			st.setDouble(8, axmedia);
			st.setDouble(9, subscapular);
			st.setDouble(10, suiliaca);
			st.setDouble(11, femumedia);
			st.setDouble(12, abdominal);
			st.setDouble(13, panturrilha);
			st.setDouble(14, pescoco);
			st.setDouble(15, ombro);
			st.setDouble(16, bradireito);
			st.setDouble(17, bradireito);
			st.setDouble(18, antibradireito);
			st.setDouble(19, antibraesquerdo);
			st.setDouble(20, torax);
			st.setDouble(21, cintura);
			st.setDouble(22, abdomen);
			st.setDouble(23, quadril);
			st.setDouble(24, coxdireita);
			st.setDouble(25,coxesquerda);
			st.setDouble(26, pandireita);
			st.setDouble(27, panesquerda);
			st.setInt(28, 1);
			
			st.executeUpdate();
			
			conn.commit();
			
			
		}
		catch(SQLException e) {
			try {
				conn.rollback();
				throw new DbException("RollBack realizado.");
			} catch (SQLException e1) {
				throw new DbException("Erro ao realizar o RollBack" + e1.getMessage());
			}
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeConnection();
			DB.closeStatement(st);
			sc.close();
		}
	}
	
}
