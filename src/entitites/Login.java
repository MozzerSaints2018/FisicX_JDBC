package entitites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;

public class Login {
	
	public void efetuarLogin() {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement stLogin = null;
		PreparedStatement stSenha = null;
		ResultSet rsLogin = null;
		ResultSet rsSenha = null;
		
		try {
			
			conn = DB.getConnection();
			
			System.out.print("Login: ");
			String login = sc.next();
			
			System.out.print("Senha: ");
			String senha = sc.next();
			
			stLogin = conn.prepareStatement(
					"SELECT pes_Login FROM FX_Pessoa"
					+ "WHERE pes_Login LIKE ?");
			
			stLogin.setString(1, login);
			//stLogin.executeUpdate();
			boolean blLogin = stLogin.execute();
			
			//rsLogin = stLogin.executeQuery(
			//		"SELECT pes_Login FROM FX_Pessoa"
			//		 + "WHERE pes_Login LIKE ?");
			
			
			
			stSenha = conn.prepareStatement(
					"SELECT pes_Senha FROM FX_Pessoa"
					+ "WHERE pes_Senha LIKE ?");
			
			stSenha.setString(1, senha);
			//stSenha.executeUpdate();
			boolean blSenha = stSenha.execute();
			
			//rsSenha = stSenha.executeQuery(
			//		"SELECT pes_Login FROM FX_Pessoa"
			//		 + "WHERE pes_Senha LIKE " + senha);
			
			if(blLogin == true && blSenha == true) {
				System.out.println(1);
			}else {
				System.out.println(2);
			}
			
			
			/*while(rsLogin.next()) {
				System.out.println(rsLogin.getString("pes_Login"));
			}
			
			while(rsSenha.next()) {
				System.out.println(rsSenha.getString("pes_Senha"));
			}*/
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeConnection();
			DB.closeResultSet(rsLogin);
			DB.closeResultSet(rsSenha);
			DB.closeStatement(stLogin);
			DB.closeStatement(stSenha);
		}
	}

}
