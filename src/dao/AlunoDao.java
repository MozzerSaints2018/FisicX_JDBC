package dao;

import java.util.List;

import entitites.Aluno;

public interface AlunoDao {
	
	void insert(Aluno obj);
	void update(Aluno obj);
	void deleteById(Aluno obj);
	Aluno findById(Integer id);
	List<Aluno> findAll(Integer id);

}
