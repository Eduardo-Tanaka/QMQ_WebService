package br.com.fiap.dao;

import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.exceptions.IdNotFoundException;

public interface DAO<T,K> {

	void create(T entity) throws DBCommitException;
	void update(T entity) throws DBCommitException;
	void delete(K id) throws DBCommitException, 
								IdNotFoundException;
	T findById(K id);
	
}
