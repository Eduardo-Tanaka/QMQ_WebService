package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DoadorDAO;
import br.com.fiap.dao.impl.DoadorImpl;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.exceptions.EmailNomeException;
import br.com.fiap.exceptions.IdNotFoundException;
import br.com.fiap.exceptions.PasswordException;
import br.com.fiap.exceptions.TipoDoadorException;
import br.com.fiap.singleton.EMFactorySingleton;
import br.com.fiap.to.DoadorTO;

public class DoadorBO {

	private DoadorDAO dao;
	
	public DoadorBO(){
		EntityManager em = EMFactorySingleton
				.getInstance().createEntityManager();
		dao = new DoadorImpl(em);
	}
	
	public DoadorTO checkEmail(DoadorTO doador, String senha2) throws EmailNomeException  {
		if(searchByEmail(doador.getEmail()).size() >= 1) {
			throw new EmailNomeException("Email já cadastrado");
		} else if(!doador.getEmail().contains("@")) {
			throw new EmailNomeException("Email Inválido");
		}
		return doador;
	}
	
	public DoadorTO create(DoadorTO doador, String senha2) throws DBCommitException, PasswordException, EmailNomeException, TipoDoadorException {
		checkEmail(doador, senha2);
		if(doador.getTipoDoador().equals("")) {
			throw new TipoDoadorException("Escolha Física ou Jurídica");
		} else if(doador.getSenha().trim().length() == 0) { 
			throw new PasswordException("Senha Inválida");
		}else if(doador.getSenha().equals(senha2)) {
			doador.setStatus("INATIVO");
			dao.create(doador);
			return doador;
		} else {
			throw new PasswordException("Senhas devem ser iguais");
		}
	}
	
	public DoadorTO update(DoadorTO doador) throws DBCommitException {
		dao.update(doador);
		return doador;
	}
	
	public String delete(int id) throws DBCommitException, IdNotFoundException {
		dao.delete(id);
		return "deletado";
	}
	
	public DoadorTO findById(int id) {
		return dao.findById(id);
	}
	
	public List<DoadorTO> findAll(){
		return dao.list();
	}
	
	public List<DoadorTO> searchByEmail(String email) {
		return dao.searchByEmail(email);
	}
	
	public DoadorTO logar(String email, String senha) throws Exception {
		List<DoadorTO> lista = dao.searchByEmail(email);
		for (DoadorTO doador : lista) {
			if(doador.getEmail().equals(email) && doador.getSenha().equals(senha) && doador.getStatus().equals("ATIVO")) {
				return doador;
			} 
		}
		throw new Exception("Usuário ou senha inválidos.");
	}
	
	public DoadorTO alterarSenha(DoadorTO doador, String senhaAnterior, String senha1, String senha2) throws DBCommitException, IdNotFoundException, PasswordException {
		if(doador.getSenha().equals(senhaAnterior)) {
			if(senha1.trim().equals(senha2.trim()) && senha1.trim().length() >= 1) {
				doador.setSenha(senha1);
				update(doador);
			} else {
				throw new PasswordException("Senha inválida.");
			}
		} else {
			throw new PasswordException("Senha inválida.");
		}
		return doador;
	}
}
