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


public class Ventana {

	private JFrame frmSiel;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNro;
	private JLabel lblNro_1;
	private JLabel lblSuma;
	private JTable table;
	private JTextField textField_1;
	private JLabel lblHabriaQueHacer;

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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnB = new JButton("SUMAR");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				int num1= Integer.parseInt(textField.getText());
				int num2= Integer.parseInt(textField_2.getText());
				int suma=num1+num2;
				textField_3.setText(Integer.toString(suma));
				
			}
		});
		btnB.setHorizontalAlignment(SwingConstants.LEFT);
		btnB.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		btnB.setForeground(Color.BLACK);
		btnB.setBackground(Color.MAGENTA);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setText("7");
		textField_1.setColumns(10);
		
		JLabel lblA = new JLabel("AX=C");
		lblA.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		
		lblNro = new JLabel("Nro 1");
		
		lblNro_1 = new JLabel("Nro 2");
		
		lblSuma = new JLabel("Total");
		
		JButton btnSiguiente = new JButton("Siguiente");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Norma 1", "Norma 2"}));
		
		table = new JTable();
		int numero= Integer.parseInt(textField_1.getText());
		String[] arrayDeNewColumn = new String[numero] ;
		for(int i=0; i<numero; i++) {
			arrayDeNewColumn[i]= "New column";
		}
		
		
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[numero][numero] ,  arrayDeNewColumn
//			new String[]  {
//				"New column", "New column", "New column", "New column"
//			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		

		
		JLabel lblN = new JLabel("n:");
		
		JLabel lblElTamaoSe = new JLabel("El tama\u00F1o se ajusta al valor de esa celda, no en ejecuci\u00F3n.  si esta en cero desaparece la matriz.\r\n");
		lblElTamaoSe.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblHabriaQueHacer = new JLabel("Habria que hacer que el usuario lo ingrese o que sea 3 por default. y modificable.");
		lblHabriaQueHacer.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap(153, Short.MAX_VALUE)
									.addComponent(lblSuma, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblN)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
									.addComponent(lblNro, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(10))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNro_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(275, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSiguiente))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(btnB)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
							.addGap(22))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(370, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblElTamaoSe)
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHabriaQueHacer, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNro))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnB)
						.addComponent(lblNro_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSuma))
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblN))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addComponent(lblElTamaoSe)
					.addGap(18)
					.addComponent(lblHabriaQueHacer)
					.addGap(9)
					.addComponent(btnSiguiente)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
	}
