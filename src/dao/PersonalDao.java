package dao;

import java.util.List;

import entitites.Personal;

public interface PersonalDao {
	
	void insert(Personal obj);
	void update(Personal obj);
	void deleteById(Personal obj);
	Personal findById(Integer id);
	List<Personal> findAll(Integer id);

}
