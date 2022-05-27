package br.com.fiap.gui.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TableListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esse produto?");
			if (resposta == JOptionPane.YES_OPTION) {
				JTable tabela = (JTable) e.getSource();
				String id = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
				System.out.print("APAGAR produto com id = " + id);
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
