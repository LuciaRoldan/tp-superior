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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import java.awt.Button;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;


public class Ventana {

	private JFrame frmSiel;
	private JTable table;
	private JTextField textField_1;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmSiel = new JFrame();
		frmSiel.setBackground(Color.WHITE);
		frmSiel.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Daiana\\Desktop\\App Superior\\D_Q_NP_613031-MLA27595245923_062018-Q (1).jpg"));
		frmSiel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		frmSiel.setTitle("SIEL");
		frmSiel.setBounds(100, 100, 596, 441);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		frmSiel.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnChangeMatrix = new JButton("Cambiar matriz");
		btnChangeMatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int matrixSize = Integer.parseInt(textField_1.getText());

				String[] arrayDeNewColumn = new String[matrixSize] ;
				for(int i=0; i<matrixSize; i++) {
					arrayDeNewColumn[i]= "New column";
				}
				
				String[] arrayDeNewRow = new String[1] ;
				arrayDeNewRow[0]= "New row";
				

				table.setModel(new DefaultTableModel(new Object[matrixSize][matrixSize] ,  arrayDeNewColumn) {
					boolean[] columnEditables = new boolean[] {
						false, true, true
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				
				table_1.setModel(new DefaultTableModel(new Object[matrixSize][1] ,  arrayDeNewRow) {
					boolean[] columnEditables = new boolean[] {
						false, true, true
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[row];
					}
				});
				
			}
		});
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
		         public void keyTyped(KeyEvent e) {
		           char c = e.getKeyChar();
		           if (!(Character.isDigit(c) ||
		              (c == KeyEvent.VK_BACK_SPACE) ||
		              (c == KeyEvent.VK_DELETE))) {
		                e.consume();
		              }
		         }
		});
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setText("7");
		textField_1.setColumns(10);
		
		JLabel lblA = new JLabel("AX=B");
		lblA.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JButton btnSiguiente = new JButton("Siguiente");
		
		table = new JTable();
		int numero= Integer.parseInt(textField_1.getText());
		String[] arrayDeNewColumn = new String[numero] ;
		for(int i=0; i<numero; i++) {
			arrayDeNewColumn[i]= "New column";
		}
		
		
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(new Object[numero][numero] ,  arrayDeNewColumn) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		

		
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton button_1 = new JButton("Salir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(table, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
							.addGap(28)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(102)
									.addComponent(lblB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(62)
									.addComponent(button))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(btnChangeMatrix)))))
					.addGap(36))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblN)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChangeMatrix))
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblB, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(24))
		);
		panel.setLayout(gl_panel);
	}
	}
