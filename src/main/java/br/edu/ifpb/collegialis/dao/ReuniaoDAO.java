package br.edu.ifpb.collegialis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.edu.ifpb.collegialis.entity.Colegiado;
import br.edu.ifpb.collegialis.entity.Reuniao;

public class ReuniaoDAO extends GenericDAO<Reuniao, Integer> {

	public ReuniaoDAO() {
		super();
	}

	public ReuniaoDAO(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Reuniao> findAll() throws DAOException {
		try {
		Query q = this.getEntityManager().createQuery("from Reuniao r");
		return (List<Reuniao>) q.getResultList();
		} catch(PersistenceException e) {
			throw new DAOException("N�o foi poss�vel obter todos os coordenadores do banco. " + e.getMessage());
		}
	}

}
