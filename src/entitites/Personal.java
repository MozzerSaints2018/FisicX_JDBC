package entitites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;
import db.DbException;

public class Personal extends Pessoa{
	
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement st = null;
	
	public void insereAvaliador() {
		
		try {
			
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.prepareStatement(
					"INSERT INTO FX_Personal"
					+ "(per_CodigoPessoa, per_CodigoAluno, per_Ativo)"
					+ "VALUES (?, ?, ?)"
					);
			
			st.setInt(1, 3);
			st.setInt(2, 2);
			st.setInt(3, 1);
			
			st.executeUpdate();
			
			conn.commit();
		}
		catch(SQLException e) {
			try {
				conn.rollback();
				throw new DbException("RollBack realizado." + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Rollback não realizado." + e1.getMessage());
			}
		}
		finally {
			DB.closeConnection();
			DB.closeStatement(st);
			sc.close();
		}		
	}
}
