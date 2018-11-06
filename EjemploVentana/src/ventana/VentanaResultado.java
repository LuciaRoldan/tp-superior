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
	public static void main(String[] args, Result resultado, int cantidadVariables) {
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
	public VentanaResultado(Result resultado, int cantidadVariables) {
		initialize(resultado, cantidadVariables);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Result res, int cantidadVariables) {
		frmSiel =  new JFrame();
		frmSiel.setBounds(100, 100, 600, 444);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Result resultado = res;
		int cantidadIteraciones = resultado.getCoeficientes().size();
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 11));
		
		
		String[][] leTabla = new String[cantidadIteraciones+1][cantidadVariables+1];
		leTabla = crearTablaResultados(resultado, cantidadVariables);
		
		
		table.setModel(new DefaultTableModel(
			leTabla, null));
		
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
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(table_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(136)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(29))
		);
		frmSiel.getContentPane().setLayout(groupLayout);
	}

	private String[][] crearTablaResultados(Result resultado, int cantidadVariables) {
		
		int cantidadIteraciones = resultado.getCoeficientes().size();
		System.out.print("cant it" + String.valueOf(cantidadIteraciones));
		System.out.print("cant var" + String.valueOf(cantidadVariables));
		
		String[][] tabla = new String[cantidadIteraciones+1][cantidadVariables+1];
		
		
		String[] nombreDeColumnas = new String[cantidadVariables+1];
		nombreDeColumnas[0] = "";
		for(int i=1; i<cantidadVariables+1; i++) {
			nombreDeColumnas[i] = "x_" + String.valueOf(i);
		}
		
		tabla[0] = nombreDeColumnas;
		
		
		for(int i = 1; i < cantidadIteraciones+1; i++) {
			String[] fila = new String[cantidadVariables+1];
			fila[0] = "x(" + String.valueOf(i-1) + ")";
			for(int j = 1; j < cantidadVariables+1; j++) {
				resultado.getCoeficientes().get(i-1).mostrar();
				fila[j] = String.valueOf(resultado.getCoeficientes().get(i-1).getValues().get(j-1));
			}
			System.out.print("sali de un for chiquito");
			tabla[i] = fila;
		}
		
		return tabla;
	}
}