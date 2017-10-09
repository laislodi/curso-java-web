package br.com.tt.cliente;

import static javax.persistence.TemporalType.DATE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message="Nome é uma informação obrigatória")
	@Column(nullable = false)
	private String nome;
	@NotBlank(message="CPF é uma informação obrigatória")
	@Pattern(regexp="\\d{11}", message="CPF necessita ter 11 dígitos")
	@Column(length = 11)
	private String cpf;
	@Temporal(DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;

	public Cliente() {
		super();
	}

	public Cliente(Long id, String nome, String cpf, Date data) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
