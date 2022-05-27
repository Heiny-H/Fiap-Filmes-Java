package br.com.fiap.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.fiap.gui.dao.FilmeDao;
import br.com.fiap.gui.model.Filme;
import br.com.fiap.gui.App;

// MVC

public class BotaoListener implements ActionListener {
	
	private JFrame view;
	private App app;
	private FilmeDao dao = new FilmeDao();

	public BotaoListener(JFrame frame) {
		this.view = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Filme filme = new Filme();
		filme.setNome(app.getTxtTitulo().getText());
		filme.setDescricao(app.getTxtSinopse().getText());
		
		dao.inserir(filme);
		
		app.carregarDados();
		
		List<Filme> lista = dao.listarTodos();
		lista.forEach(System.out::println);
	}
	
}
