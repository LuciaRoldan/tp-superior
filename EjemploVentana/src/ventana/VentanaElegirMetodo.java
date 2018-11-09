package ventana;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import EquationProcessor.Matriz;
import EquationProcessor.Result;
import EquationProcessor.Vector;
import EquationProcessor.Jacobi;
import EquationProcessor.GaussSeidel;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaElegirMetodo {

	protected JFrame frmSiel;
	protected JFrame frameAnterior;
	private JTable tableVectorInicial;
	private JTextField textFieldCantDecim;
	private JTextField textFieldCotaError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Matriz matriz, Vector coeficientes, JFrame fAnterior) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaElegirMetodo window = new VentanaElegirMetodo(matriz, coeficientes);
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
	 */
	public VentanaElegirMetodo(Matriz matriz, Vector coeficientes) {
		initialize(matriz, coeficientes);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "serial", "unchecked", "rawtypes"})
	private void initialize(Matriz mat, Vector coefs) {
		Matriz matriz = mat;
		Vector coeficientes = coefs;
		int cantidadFilas = matriz.getMatrixSize();
		frmSiel = new JFrame();
		frmSiel.setTitle("SIEL");
		frmSiel.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaElegirMetodo.class.getResource("/imagenes/Cubo icono chico.jpg")));
		frmSiel.getContentPane().setBackground(new Color(255, 235, 205));
		frmSiel.setBounds(100, 100, 484, 322);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblMtodo = new JLabel("M\u00E9todo:");
		lblMtodo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblCantidadDeDecimales = new JLabel("Cantidad de decimales:");
		lblCantidadDeDecimales.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblCotaDeError = new JLabel("Cota de error:");
		lblCotaDeError.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblVectorInicial = new JLabel("Vector inicial:");
		lblVectorInicial.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JComboBox comboBoxMetodo = new JComboBox();
		comboBoxMetodo.setModel(new DefaultComboBoxModel(new String[] {"", "Jacobi", "Gauss Seidel"}));
		comboBoxMetodo.setToolTipText("");
		
		tableVectorInicial = new JTable();
		tableVectorInicial.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		tableVectorInicial.setFillsViewportHeight(true);
		tableVectorInicial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD || c == KeyEvent.VK_MINUS)) {
					e.consume();	
				}
			}
		});
		
		String[] arrayDeColumnas = new String[cantidadFilas] ;
		for(int i=0; i<cantidadFilas; i++) {
			arrayDeColumnas[i]= "New column";
		}
		
		tableVectorInicial.setBorder(new CompoundBorder());
		tableVectorInicial.setModel(new DefaultTableModel(new Object[1][cantidadFilas],  arrayDeColumnas) {
			boolean[] columnEditables = new boolean[] {
					true, true, true
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[row];
				}
		});
		
		textFieldCantDecim = new JTextField();
		textFieldCantDecim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
					e.consume();	
				}
			}
		});
		textFieldCantDecim.setColumns(10);
		
		textFieldCotaError = new JTextField();
		textFieldCotaError.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
					e.consume();	
				}
			}
		});
		textFieldCotaError.setColumns(10);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSiel.dispose();
				frameAnterior.setVisible(true);
			}
		});
		btnAtrs.setForeground(new Color(0, 0, 0));
		btnAtrs.setBackground(UIManager.getColor("Button.background"));
		btnAtrs.setFont(UIManager.getFont("Button.font"));
		
		JButton btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double[] array = new double[matriz.getMatrixSize()];
				for(int j = 0; j < matriz.getMatrixSize(); j++) {
					array[j] = Integer.parseInt(String.valueOf(tableVectorInicial.getValueAt(0, j)));
				}
				Vector vectorInicial = new Vector(array);
				int cantidadDecimales = Integer.parseInt(textFieldCantDecim.getText());
				switch(String.valueOf(comboBoxMetodo.getSelectedItem())) {
					case "Jacobi":
						Result resultado = new Jacobi().jacobiIterations(matriz, coeficientes, vectorInicial, Double.valueOf(textFieldCotaError.getText()));
						int cantidadCoeficientes = coeficientes.getValues().size();
						VentanaResultado.main(null, resultado, cantidadCoeficientes, cantidadDecimales, frmSiel);
						frmSiel.setVisible(false);
						break;
					case "Gauss Seidel":
						Result resultadoG = new GaussSeidel().gaussSeidelIterations(matriz, coeficientes, vectorInicial, Double.valueOf(textFieldCotaError.getText()));
						int cantidadCoeficientesG = coeficientes.getValues().size();
						VentanaResultado.main(null, resultadoG, cantidadCoeficientesG, cantidadDecimales, frmSiel);
						frmSiel.setVisible(false);					
						break;
					default:
						break;
				}
				
			}
		});
		btnNewButton_1.setFont(UIManager.getFont("Button.font"));
		GroupLayout groupLayout = new GroupLayout(frmSiel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAtrs, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblVectorInicial)
								.addComponent(lblMtodo)
								.addComponent(lblCantidadDeDecimales)
								.addComponent(lblCotaDeError))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldCotaError)
								.addComponent(textFieldCantDecim)
								.addComponent(tableVectorInicial, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addComponent(comboBoxMetodo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addGap(185))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxMetodo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMtodo))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tableVectorInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVectorInicial))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantidadDeDecimales)
						.addComponent(textFieldCantDecim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCotaDeError)
						.addComponent(textFieldCotaError, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtrs, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		frmSiel.getContentPane().setLayout(groupLayout);
	}
}
