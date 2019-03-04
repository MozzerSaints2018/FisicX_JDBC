package dao;

import java.util.List;

import entitites.Pessoa;

public interface PessoaDao {
	
	void insert(Pessoa obj);
	void update(Pessoa obj);
	void deleteById(Pessoa obj);
	Pessoa findById(Integer id);
	List<Pessoa> findAll(Integer id);

}
