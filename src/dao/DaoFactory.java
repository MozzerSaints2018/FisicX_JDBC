package dao;

import dao.impl.PersonalDaoJDBC;
import dao.impl.PessoaDaoJDBC;

public class DaoFactory {
	
	//public static AlunoDao createAlunoDao() {
	//	return new AlunoDaoJDBC();
	//}
	
	public static PessoaDao createPessoaDao() {
		return new PessoaDaoJDBC();
	}
	
	public static PersonalDao createPersonalDao() {
		return new PersonalDaoJDBC();
	}

}
