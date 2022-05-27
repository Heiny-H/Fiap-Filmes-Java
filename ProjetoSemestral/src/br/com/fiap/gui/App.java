package br.com.fiap.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.gui.dao.FilmeDao;
import br.com.fiap.gui.model.Filme;
import br.com.fiap.gui.controller.TableListener;
import br.com.fiap.gui.controller.BotaoListener;

public class App {
	
	public static JTextField txtTitulo = new JTextField(20);
	public static MyTextField txtSinopse = new MyTextField();
	public static JButton btnSalvar = new JButton("Salvar");
	
	public static String[] colunas = {"id", "titulo", "sinopse"};
	public static DefaultTableModel tableModel = new DefaultTableModel(colunas , 0);
	public static JTable tabela = new JTable(tableModel);

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

			e.printStackTrace();
		}

		JFrame frame = new JFrame("Fiap Movies");
		frame.setLayout(new FlowLayout());

		JTabbedPane tabbedPane = new JTabbedPane();

		JPanel panelPageEnd = new JPanel();
		panelPageEnd.setBorder(new EmptyBorder(10,10,10,10));

		JPanel panelRegister = new JPanel();
		panelRegister.setBorder(new EmptyBorder(50,50,50,50));

		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new EmptyBorder(50,50,50,50));
		
		JPanel panelLineEnd = new JPanel();
		
		carregarDados();

		frame.add(tabbedPane, BorderLayout.PAGE_START);
		tabbedPane.add(panelRegister, "Cadastro");
		tabbedPane.add(new JScrollPane(tabela), "Lista");


		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		panelCenter.add(new JLabel("Título"));
		panelCenter.add(txtTitulo);
		panelCenter.add(new JLabel("Sinopse"));
		panelCenter.add(txtSinopse);
		panelCenter.add(new JLabel("Gênero"));
		String[] genres = {"Ação","Suspense","Comédia","Romance"};
		panelCenter.add(new JComboBox<String>(genres));

		panelLineEnd.setLayout(new BoxLayout(panelLineEnd, BoxLayout.Y_AXIS));
		panelLineEnd.add(new JLabel("Onde assistir"));
		List<String> radioGroup = new ArrayList<>();
		radioGroup.add("Netflix");
		radioGroup.add("Prime Video");
		radioGroup.add("Pirate Bay");
		MyRadioButtonGroup myRadio = new MyRadioButtonGroup(radioGroup);
		panelLineEnd.add(myRadio);
		panelLineEnd.add(new JCheckBox("Assistido"));
		panelLineEnd.add(new JLabel("Avaliação"));
		panelLineEnd.add(new StarRater());

		panelRegister.setLayout(new BorderLayout());
		JLabel img = new JLabel(new ImageIcon("src/homem_aranha.jpg"));
		img.setSize(new Dimension(50,50));
		panelRegister.add(img,BorderLayout.LINE_START);
		panelRegister.add(panelPageEnd, BorderLayout.PAGE_END);
		panelRegister.add(panelCenter, BorderLayout.CENTER);
		panelRegister.add(panelLineEnd, BorderLayout.LINE_END);
		
		panelPageEnd.setLayout(new FlowLayout());
		panelPageEnd.add(btnSalvar);
		panelPageEnd.add(new JButton("Cancelar"));
		
		TableListener tableListener = new TableListener();
		tabela.addMouseListener(tableListener );
		tabela.setDefaultEditor(Object.class, null);

		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		BotaoListener listener = new BotaoListener(frame);
		btnSalvar.addActionListener(listener);

	}
	
	public static void carregarDados() {
		tableModel.setRowCount(0);
		List<Filme> lista = new FilmeDao().listarTodos();
		lista.forEach(produto -> tableModel.addRow(produto.getData()));
	}
	
	public static JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public static MyTextField getTxtSinopse() {
		return txtSinopse;
	}

	/*public JTextField getTxtPreco() {
		return txtPreco;
	}*/

}
