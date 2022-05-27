package br.com.fiap.gui;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MyRadioButtonGroup extends JPanel {
	private static final long serialVersionUID = 1L;

	private List<String> options;
	private ButtonGroup group = new ButtonGroup();

	public MyRadioButtonGroup(List<String> options) {
		super();
		this.options = options;
		init();
	}

	private void init() {
		options.forEach(opt -> {
			JRadioButton radio = new JRadioButton(opt);
			this.add(radio);
			group.add(radio);
		});
	}
}
