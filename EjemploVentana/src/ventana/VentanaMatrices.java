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
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import EquationProcessor.Matriz;
import EquationProcessor.Vector;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class VentanaMatrices {

	JFrame frmSiel;
	private JTextField textFieldCantidadEcuaciones;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
		frmSiel = new JFrame();
		frmSiel.setBackground(Color.WHITE);
		frmSiel.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMatrices.class.getResource("/imagenes/Cubo icono chico.jpg")));
		frmSiel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		frmSiel.setTitle("SIEL");
		frmSiel.setBounds(100, 100, 561, 458);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		frmSiel.getContentPane().add(panel, BorderLayout.CENTER);

		JButton btnChangeMatrix = new JButton("Cambiar matriz");
		btnChangeMatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int matrixSize;

				try {
					matrixSize = Integer.parseInt(textFieldCantidadEcuaciones.getText());

					String[] arrayDeNewColumn = new String[matrixSize];
					String[] arrayDeNewRow = new String[1];

					arrayDeNewRow[0] = "New row";

					for (int i = 0; i < matrixSize; i++) {
						arrayDeNewColumn[i] = "New column";
					}

					table.setModel(new DefaultTableModel(new Object[matrixSize][matrixSize], arrayDeNewColumn));

					table_1.setModel(new DefaultTableModel(new Object[matrixSize][1], arrayDeNewRow));

				} catch (Exception e) {
					final JPanel panel = new JPanel();

					JOptionPane.showMessageDialog(panel, "Ingresar valores válidos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		textFieldCantidadEcuaciones = new JTextField();
		textFieldCantidadEcuaciones.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (textFieldCantidadEcuaciones.getText().length() < 1) {
					if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
						e.consume();
					}
				} else {
					if ((int) c == 10) {
						int matrixSize = Integer.parseInt(textFieldCantidadEcuaciones.getText());

						String[] arrayDeNewColumn = new String[matrixSize];
						String[] arrayDeNewRow = new String[1];

						arrayDeNewRow[0] = "New row";

						for (int i = 0; i < matrixSize; i++) {
							arrayDeNewColumn[i] = "New column";
						}

						table.setModel(new DefaultTableModel(new Object[matrixSize][matrixSize], arrayDeNewColumn));

						table_1.setModel(new DefaultTableModel(new Object[matrixSize][1], arrayDeNewRow));
					}
					e.consume();
				}

			}
		});
		textFieldCantidadEcuaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldCantidadEcuaciones.setText("3");
		textFieldCantidadEcuaciones.setColumns(10);

		JLabel lblA = new JLabel("AX=B");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblN = new JLabel("Cantidad de ecuaciones:");
		lblN.setFont(new Font("Calibri", Font.PLAIN, 12));

		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		table_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (textFieldCantidadEcuaciones.getText().length() < 1) {
					if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE
							|| c == KeyEvent.VK_PERIOD || c == KeyEvent.VK_MINUS)) {
						e.consume();
					}
				}
			}
		});

		table_1.setModel(
				new DefaultTableModel(new Object[][] { { null }, { null }, { null }, }, new String[] { "New column" }));
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);

		JLabel label = new JLabel("A=");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblB = new JLabel("B=");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel ErrorDom = new JLabel("Error, la matriz no es diagonalmente dominante");
		ErrorDom.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorDom.setForeground(new Color(0, 0, 0));
		ErrorDom.setBackground(new Color(255, 0, 0));
		ErrorDom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ErrorDom.setVisible(false);

		JButton button = new JButton("Siguiente");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int cantidadEcuaciones = Integer.parseInt(textFieldCantidadEcuaciones.getText());
					Matriz matriz = inicializarMatriz(cantidadEcuaciones, table);
					if (matriz.isDiagonallyDominant()) {
						ErrorDom.setVisible(false);
						Vector coeficientes = inicializarVector(cantidadEcuaciones, table_1);
						VentanaElegirMetodo.main(null, matriz, coeficientes, frmSiel);
						frmSiel.setVisible(false);
					} else {
						final JPanel panel = new JPanel();

						JOptionPane.showMessageDialog(panel, "La matriz no es diagonalmente dominante.",
								"Error", JOptionPane.ERROR_MESSAGE);

					}
				} catch (Exception ex) {
					final JPanel panel = new JPanel();

					JOptionPane.showMessageDialog(panel, "Se deben completar todos los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				}
		});

		JButton button_1 = new JButton("Inicio");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.main(null);
				frmSiel.dispose();
			}
		});

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (textFieldCantidadEcuaciones.getText().length() < 4) {
					if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE
							|| c == KeyEvent.VK_PERIOD || c == KeyEvent.VK_MINUS)) {
						e.consume();
					}
				}
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "New column", "New column", "New column" }));

		JButton button_2 = new JButton("Calcular normas");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int cantidadEcuaciones = Integer.parseInt(textFieldCantidadEcuaciones.getText());
					Matriz matriz = inicializarMatriz(cantidadEcuaciones, table);
					textField.setText(String.format("%.2f", matriz.norma1()));
					textField_1.setText(String.format("%.2f", matriz.norma2()));
					textField_2.setText(String.format("%.2f", matriz.normaInfinito()));
				} catch (Exception e) {
					final JPanel panel = new JPanel();

					JOptionPane.showMessageDialog(panel, "Se deben completar todos los campos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JSeparator separator = new JSeparator();

		JSeparator separator_1 = new JSeparator();

		JLabel label_1 = new JLabel("Norma 1:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel label_2 = new JLabel("Norma 2:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel label_3 = new JLabel("Norma infinito:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);

		NumberFormat f = NumberFormat.getInstance();
		f.setMaximumIntegerDigits(1);
		f.setMaximumFractionDigits(0);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(table, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(61)
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
							.addGap(86))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(23)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addComponent(ErrorDom, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblN)
							.addGap(18)
							.addComponent(textFieldCantidadEcuaciones, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnChangeMatrix)))
					.addContainerGap(29, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblN)
						.addComponent(textFieldCantidadEcuaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChangeMatrix))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblB, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(button_2))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button)
						.addComponent(ErrorDom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(101))
		);
		panel.setLayout(gl_panel);
	}

	public Matriz inicializarMatriz(int matrixSize, JTable table) {

		ArrayList<Vector> listaDeVectores = new ArrayList<Vector>();

		for (int i = 0; i < matrixSize; i++) {
			double[] array = new double[matrixSize];
			for (int j = 0; j < matrixSize; j++) {
				array[j] = Double.parseDouble(String.valueOf(table.getValueAt(i, j)));
			}
			listaDeVectores.add(new Vector(array));
		}

		Matriz matrix = new Matriz(matrixSize, matrixSize, listaDeVectores);

		return matrix;
	}

	public Vector inicializarVector(int matrixSize, JTable table) {

		double[] array = new double[matrixSize];

		for (int i = 0; i < matrixSize; i++) {
			array[i] = Double.parseDouble(String.valueOf(table.getValueAt(i, 0)));
		}

		Vector vector = new Vector(array);

		return vector;
	}
}