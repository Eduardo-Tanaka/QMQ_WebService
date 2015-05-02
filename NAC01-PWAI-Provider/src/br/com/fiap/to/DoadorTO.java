package br.com.fiap.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@SequenceGenerator(name="seqDoador", sequenceName="SEQ_JAV_DOADOR", allocationSize=1)
@Table(name="T_JAV_DOADOR")
public class DoadorTO implements Serializable{

	@Id
	@Column(name="CD_DOADOR")
	@GeneratedValue(generator="seqDoador", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="DS_EMAIL", nullable=false, length=128)
	private String email;
	
	@Column(name="DS_SENHA", nullable=false, length=40)
	private String senha;
	
	@Column(name="DS_ENDERECO")
	private String endereco;
	
	@Lob
	@Column(name="DS_FOTO")
	private byte[] foto;
	
	@Column(name="DS_STATUS", nullable=false)
	private String status;
	
	@Column(name="DS_TIPO", nullable=false)
	private String tipoDoador; // Fisica ou Juridica
	
	@Column(name="NR_CPF")
	private String cpf;

	@Column(name="NR_CNPJ")
	private String cnpj;
	
	@Column(name="NM_DOADOR")
	private String nome;
	
	@Column(name="NM_RAZAO_SOCIAL")
	private String razaoSocial;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTipoDoador() {
		return tipoDoador;
	}
	public void setTipoDoador(String tipoDoador) {
		this.tipoDoador = tipoDoador;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
}
