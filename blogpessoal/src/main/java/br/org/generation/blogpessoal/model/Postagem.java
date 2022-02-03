package br.org.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //essa classe será uma entidade do jpa hibernate
@Table(name = "postagem") //essa entidade dentro do db vai virar uma tabela chamada postagem
public class Postagem {
	
	@Id //primary key (id)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; //este atributo se tornará uma primary key
	
	@NotBlank(message = "o campo título é obrigatório!") //não permitirá um título em branco
	@Size(min = 5, max = 100, message = "o campo título deve ter no mínimo 5 e no máximo 100 caracteres.") //quantidade de caracteres
	private String titulo;
	
	@NotBlank(message = "o campo texto é obrigatório!")
	@Size(min = 10, max = 500, message = "o campo texto deve ter no mínimo 10 e no máximo 500 caracteres.")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;	
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
		
}
