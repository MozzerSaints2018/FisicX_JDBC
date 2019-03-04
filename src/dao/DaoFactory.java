package dao;

import dao.impl.AlunoDaoJDBC;
import dao.impl.PersonalDaoJDBC;
import dao.impl.PessoaDaoJDBC;
import db.DB;

public class DaoFactory {
	
	public static AlunoDao createAlunoDao() {
		return new AlunoDaoJDBC();
	}
	
	public static PessoaDao createPessoaDao() {
		return new PessoaDaoJDBC();
	}
	
	public static PersonalDao createPersonalDao() {
		return new PersonalDaoJDBC();
	}

}
