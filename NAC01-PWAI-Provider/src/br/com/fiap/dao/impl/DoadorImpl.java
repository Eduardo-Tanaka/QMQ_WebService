package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.DoadorDAO;
import br.com.fiap.to.DoadorTO;

public class DoadorImpl extends DAOImpl<DoadorTO, Integer> implements DoadorDAO {

	public DoadorImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<DoadorTO> list() {
		TypedQuery<DoadorTO> query = 
				em.createQuery("from DoadorTO",DoadorTO.class);
		return query.getResultList();
	}

	@Override
	public List<DoadorTO> searchByEmail(String email) {
		TypedQuery<DoadorTO> query = 
				em.createQuery("from DoadorTO d where d.email = :email",DoadorTO.class);
		query.setParameter("email", email);
		return query.getResultList();
	}
}
