package br.com.fiap.gui.model;

import java.math.BigDecimal;
import java.util.Vector;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", descricao=" + descricao + "]";
	}

	public Vector<String> getData() {
		
		Vector<String> data = new Vector<String>();
		data.add(id.toString());
		data.add(nome);
		data.add(descricao);
		
		return data;
	}
}
