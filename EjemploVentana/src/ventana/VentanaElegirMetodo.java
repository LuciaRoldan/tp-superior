package ventana;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaElegirMetodo {

	protected JFrame frmSiel;
	private JTable tableVectorInicial;
	private JTextField textFieldCantDecim;
	private JTextField textFieldCotaError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Matriz matriz, Vector coeficientes) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaElegirMetodo window = new VentanaElegirMetodo(matriz, coeficientes);
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
	public VentanaElegirMetodo(Matriz matriz, Vector coeficientes) {
		initialize(matriz, coeficientes);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Matriz mat, Vector coefs) {
		Matriz matriz = mat;
		Vector coeficientes = coefs;
		System.out.print("Vector: ");
		coeficientes.mostrar();
		System.out.print("Matriz: ");
		matriz.mostrar();
		int cantidadFilas = matriz.getMatrixSize();
		frmSiel = new JFrame();
		frmSiel.setTitle("SIEL");
		frmSiel.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaElegirMetodo.class.getResource("/imagenes/Cubo icono chico.jpg")));
		frmSiel.getContentPane().setBackground(new Color(255, 204, 204));
		frmSiel.setBounds(100, 100, 600, 444);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblMtodo = new JLabel("M\u00E9todo:");
		lblMtodo.setFont(new Font("Arial", Font.PLAIN, 17));
		
		JLabel lblCantiidadDeDecimales = new JLabel("Cantidad de decimales:");
		lblCantiidadDeDecimales.setFont(new Font("Arial", Font.PLAIN, 17));
		
		JLabel lblCotaDeError = new JLabel("Cota de error:");
		lblCotaDeError.setFont(new Font("Arial", Font.PLAIN, 17));
		
		JLabel lblVectorInicial = new JLabel("Vector inicial:");
		lblVectorInicial.setFont(new Font("Arial", Font.PLAIN, 17));
		
		JComboBox comboBoxMetodo = new JComboBox();
		comboBoxMetodo.setModel(new DefaultComboBoxModel(new String[] {"", "Jacobi", "Gauss Seidel"}));
		comboBoxMetodo.setToolTipText("");
		
		tableVectorInicial = new JTable();
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
				switch(String.valueOf(comboBoxMetodo.getSelectedItem())) {
					case "Jacobi":
						System.out.println("Jacobi");
						//ArrayList<Vector> resultado = new Jacobi().jacobiIterations(matriz, coeficientes, vectorInicial, Double.valueOf(textFieldCotaError.getText()));
						Result resultado = new Jacobi().jacobiIterations(matriz, coeficientes, vectorInicial, Double.valueOf(textFieldCotaError.getText()));
						int cantidadCoeficientes = coeficientes.getValues().size();
						System.out.println("cantidadCoeficientes: ");
						System.out.println(cantidadCoeficientes);
						VentanaResultado res = new VentanaResultado(resultado, cantidadCoeficientes);
						res.main(null, resultado, cantidadCoeficientes);
						break;
					case "Gauss Seidel":
						System.out.println("GS");
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
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblVectorInicial)
								.addComponent(lblMtodo)
								.addComponent(lblCantiidadDeDecimales)
								.addComponent(lblCotaDeError))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldCotaError)
								.addComponent(textFieldCantDecim)
								.addComponent(tableVectorInicial, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addComponent(comboBoxMetodo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtrs, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
					.addGap(95)
					.addComponent(btnNewButton_1)
					.addGap(48))
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
						.addComponent(lblCantiidadDeDecimales)
						.addComponent(textFieldCantDecim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCotaDeError)
						.addComponent(textFieldCotaError, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnAtrs, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		frmSiel.getContentPane().setLayout(groupLayout);
	}
}
