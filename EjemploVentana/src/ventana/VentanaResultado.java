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
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class VentanaResultado {

	private JFrame frmSiel;
	private JFrame frameAnterior;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Result resultado, int cantidadVariables, int cantidadDecimales, JFrame fAnterior) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaResultado window = new VentanaResultado(resultado, cantidadVariables, cantidadDecimales);
					window.frmSiel.setVisible(true);
					window.frameAnterior = fAnterior;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param cantidadDecimales 
	 */
	public VentanaResultado(Result resultado, int cantidadVariables, int cantidadDecimales) {
		initialize(resultado, cantidadVariables, cantidadDecimales);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Result res, int cantidadVariables, int cantidadDecimales) {
		frmSiel =  new JFrame();
		frmSiel.setTitle("SIEL");
		frmSiel.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaResultado.class.getResource("/imagenes/Cubo icono chico.jpg")));
		frmSiel.getContentPane().setBackground(new Color(255, 235, 205));
		frmSiel.getContentPane().setForeground(new Color(0, 0, 0));
		frmSiel.setBounds(100, 100, 940, 402);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Result resultado = res;
		int cantidadIteraciones = resultado.getCoeficientes().size();
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 11));
				
		String[][] leTabla = new String[cantidadIteraciones+1][cantidadVariables+1];
		leTabla = crearTablaResultados(resultado, cantidadVariables, cantidadDecimales);
		String[] arrayDeNewColumn = new String[cantidadVariables+1];
	
		
		for (int i = 0; i < cantidadVariables+1; i++) {
			arrayDeNewColumn[i] = "New column";
		}
		table.setModel(new DefaultTableModel(
			leTabla, arrayDeNewColumn));
		
		
		table_1 = new JTable();
		String[][] leTablaErrores = new String[cantidadIteraciones+1][cantidadVariables+1];
		leTablaErrores = crearTablaErrores(resultado, cantidadVariables, cantidadDecimales);	
		table_1.setModel(new DefaultTableModel(
			leTablaErrores, arrayDeNewColumn
		));
		
		table_2 = new JTable();
		
		String[] columna = new String[1];
		columna[0] = "New column";
		
		String[][] leTablaInfinito = new String[cantidadIteraciones+1][1];
		leTablaInfinito = crearTablaInfinito(resultado, cantidadDecimales);
		table_2.setModel(new DefaultTableModel( 
				leTablaInfinito, columna
		));
		
		JButton btnNewButton = new JButton("Nueva Matriz\r\n");
		btnNewButton.setToolTipText("nuevaMatriz");
		btnNewButton.setFont(UIManager.getFont("Button.font"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaMatrices().main(null);
				frameAnterior.dispose();
				frmSiel.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Atr\u00E1s");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAnterior.setVisible(true);
				frmSiel.dispose();
			}
		});
		btnNewButton_1.setToolTipText("volverAtras");
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setFont(UIManager.getFont("Button.font"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSiel.dispose();
			}
		});
		btnNewButton_2.setToolTipText("botonSalir");
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblIteraciones = new JLabel("Iteraciones:");
		
		JLabel lblDiferenciasParciales = new JLabel("Diferencias parciales:");
		
		JLabel lblErrorAbsoluto = new JLabel("Error absoluto:");
		GroupLayout groupLayout = new GroupLayout(frmSiel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblResultados, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIteraciones)
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
											.addGap(171)
											.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(separator, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
											.addGap(3)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblErrorAbsoluto)
												.addComponent(table_2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))))
									.addGap(21))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDiferenciasParciales, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblResultados, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIteraciones)
						.addComponent(lblDiferenciasParciales)
						.addComponent(lblErrorAbsoluto))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(table_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		frmSiel.getContentPane().setLayout(groupLayout);
	}

	private String[][] crearTablaInfinito(Result resultado, int cantidadDecimales) {
		
		int cantidadIteraciones = resultado.getCoeficientes().size();
		String[][] tabla = new String[cantidadIteraciones+1][1];
		
		tabla[0][0] = "||x(n) - x(n-1)||";
		
		for(int i = 0; i < cantidadIteraciones-1; i++) {
			tabla[i+2][0] = String.format("%."+cantidadDecimales+"f", resultado.getInfinito().getValues().get(i));  
		}
		
		return tabla;
	}

	private String[][] crearTablaResultados(Result resultado, int cantidadVariables, int cantidadDecimales) {
		
		int cantidadIteraciones = resultado.getCoeficientes().size();
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
				fila[j] = String.format("%."+cantidadDecimales+"f", resultado.getCoeficientes().get(i-1).getValues().get(j-1));
			}

			tabla[i] = fila;
		}
		
		return tabla;
	}
	
	
private String[][] crearTablaErrores(Result resultado, int cantidadVariables, int cantidadDecimales) {
		
		int cantidadIteraciones = resultado.getCoeficientes().size();
		String[][] tabla = new String[cantidadIteraciones+1][cantidadVariables+1];
		
		
		String[] nombreDeColumnas = new String[cantidadVariables+1];
		nombreDeColumnas[0] = "";
		for(int i=1; i<cantidadVariables+1; i++) {
			nombreDeColumnas[i] = "x_" + String.valueOf(i);
		}
		
		tabla[0] = nombreDeColumnas;
		
		for(int i = 2; i < cantidadIteraciones+1; i++) {
			String[] fila = new String[cantidadVariables+1];
			fila[0] = "x_" + String.valueOf(i-1) + " - x_" + String.valueOf(i-2);
			for(int j = 1; j < cantidadVariables+1; j++) {
				//resultado.getErrores().get(i-1).mostrar();
				fila[j] = String.format("%."+cantidadDecimales+"f", resultado.getErrores().get(i-2).getValues().get(j-1));
			}

			tabla[i] = fila;
		}
		
		return tabla;
	}
	
	
	
}