package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.singleton.EMFactorySingleton;

public class teste {

	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
			/*
		DoadorBO bo = new DoadorBO();
		DoadorTO doador = new DoadorTO();
		doador.setEmail("EESR");
		doador.setSenha("123");
		
		File file = new File("imagens\\img1.jpg");
		System.out.println(file.canRead());
		byte[] blob = null;
		try {
			blob = Files.readAllBytes(Paths.get("imagens\\img1.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		doador.setFoto(blob);
		
		String senha2 = "123";
		try {
			bo.create(doador, senha2);
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PasswordCheck e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}
}
