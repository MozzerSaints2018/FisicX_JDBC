package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.AlunoDao;
import db.DB;
import db.DbException;
import entitites.Aluno;

public class AlunoDaoJDBC implements AlunoDao{
	
	private Connection conn;
	
	//Criando dependencia da Conexão com a classe AlunoDaoJDBC, ao instanciar a classe estarei
	//obrigando que seja inserido já a conexão com o banco
	public AlunoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Aluno obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Aluno obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Aluno obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Aluno findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select * from fx_pessoa \r\n" + 
					"inner join fx_aluno on fx_pessoa.pes_codigo = fx_aluno.alu_codigopessoa\r\n" + 
					"where fx_pessoa.pes_codigo = ?"
					);
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				
			}else {
				return null;
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeConnection();
		}
		return null;		
	}

	@Override
	public List<Aluno> findAll(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
