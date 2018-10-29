package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import EquationProcessor.Matrix;
import EquationProcessor.Vector;

import java.awt.Button;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class VentanaMatrices {

	JFrame frmSiel;
	private JTextField textFieldCantidadEcuaciones;
	private JTable table_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMatrices window = new VentanaMatrices();
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
	public VentanaMatrices() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int cantidadEcuaciones;
		frmSiel = new JFrame();
		frmSiel.setBackground(Color.WHITE);
		frmSiel.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Daiana\\Desktop\\App Superior\\D_Q_NP_613031-MLA27595245923_062018-Q (1).jpg"));
		frmSiel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		frmSiel.setTitle("SIEL");
		frmSiel.setBounds(100, 100, 600, 444);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		frmSiel.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnChangeMatrix = new JButton("Cambiar matriz");
		btnChangeMatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int matrixSize = Integer.parseInt(textFieldCantidadEcuaciones.getText());
								
				String[] arrayDeNewColumn = new String[matrixSize];
				String[] arrayDeNewRow = new String[1] ;
				
				arrayDeNewRow[0]= "New row";
				
				for(int i=0; i<matrixSize; i++) {
					arrayDeNewColumn[i]= "New column";
				}
				
				table.setModel(new DefaultTableModel(
					new Object[matrixSize][matrixSize], arrayDeNewColumn));
				
				table_1.setModel(new DefaultTableModel(new Object[matrixSize][1],  arrayDeNewRow));
				
			}
		});
		
		textFieldCantidadEcuaciones = new JTextField();
		textFieldCantidadEcuaciones.addKeyListener(new KeyAdapter() {
		         public void keyTyped(KeyEvent e) {
		           char c = e.getKeyChar();
		           if (!(Character.isDigit(c) ||
		              (c == KeyEvent.VK_BACK_SPACE) ||
		              (c == KeyEvent.VK_DELETE))) {
		                e.consume();
		              }
		         }
		});
		textFieldCantidadEcuaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldCantidadEcuaciones.setText("7");
		textFieldCantidadEcuaciones.setColumns(10);
		
		JLabel lblA = new JLabel("AX=B");
		lblA.setFont(new Font("Calibri", Font.PLAIN, 20));
				
		JLabel lblN = new JLabel("Cantidad de ecuaciones:");
		lblN.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		
		JLabel label = new JLabel("A=");
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblB = new JLabel("B=");
		lblB.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JButton button = new JButton("Siguiente");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cantidadEcuaciones = Integer.parseInt(textFieldCantidadEcuaciones.getText());
				Matrix matriz = inicializarMatriz(cantidadEcuaciones, table);
				VentanaElegirMetodo elegir = new VentanaElegirMetodo(matriz);
				elegir.main(null, matriz);
				//frmSiel.dispose();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton button_1 = new JButton("Salir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		
		//formattedTextField.
		

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblN)
									.addGap(18)
									.addComponent(textFieldCantidadEcuaciones, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(table, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
							.addGap(54)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(btnChangeMatrix))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(46)
									.addComponent(lblB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
							.addGap(52)
							.addComponent(button)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblN)
						.addComponent(textFieldCantidadEcuaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChangeMatrix))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblB, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(24))
		);
		panel.setLayout(gl_panel);
	}

	public Matrix inicializarMatriz(int matrixSize, JTable table) {
		
		ArrayList<Vector> listaDeVectores = new ArrayList<Vector>();
		
		for(int i = 0; i < matrixSize; i++) {
			int[] array = new int[matrixSize];
			for(int j = 0; j < matrixSize; j++) {
				array[j] = Integer.parseInt(String.valueOf(table.getValueAt(i, j)));
				System.out.println(String.valueOf(table.getValueAt(i, j)));
			}
			listaDeVectores.add(new Vector(array));
		}
		
		Matrix matrix = new Matrix(matrixSize, matrixSize, listaDeVectores);
		
		//matrix.mostrar();

		return matrix;
	}
}