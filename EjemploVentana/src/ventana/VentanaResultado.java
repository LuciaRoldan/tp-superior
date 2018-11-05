package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

import EquationProcessor.Result;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaResultado {

	private JFrame frmSiel;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Result resultado, Double cantidadVariables) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaResultado window = new VentanaResultado(resultado, cantidadVariables);
					window.frmSiel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaResultado(Result resultado, Double cantidadVariables) {
		initialize(resultado, cantidadVariables);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Result resultado, Double cantidadVariables) {
		frmSiel =  new JFrame();
		frmSiel.setBounds(100, 100, 600, 444);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"x(k)", "x_1", "x_2", "x_2"},
				{"x(0)", null, null, null},
				{"x(1)", null, null, null},
				{"x(2)", null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"x(n)-x(n-1)", "x(1)", "x(2)", "x(3)"},
				{"x(1)-x(0)", null, null, null},
				{"x(2)-x(1)", null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"||x(n)-x(n-1)||\u221E"},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		
		JButton btnNewButton = new JButton("Nueva Matriz\r\n");
		btnNewButton.setToolTipText("nuevaMatriz");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("Volver atr\u00E1s");
		btnNewButton_1.setToolTipText("volverAtras");
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setToolTipText("botonSalir");
		GroupLayout groupLayout = new GroupLayout(frmSiel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table_2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(73)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(92))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(215)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(236, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(table_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(136)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(29))
		);
		frmSiel.getContentPane().setLayout(groupLayout);
	}
}
