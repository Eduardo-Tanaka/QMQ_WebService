package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.to.DoadorTO;

public interface DoadorDAO extends DAO<DoadorTO, Integer> {

	List<DoadorTO> list();
	List<DoadorTO> searchByEmail(String nome);
}
