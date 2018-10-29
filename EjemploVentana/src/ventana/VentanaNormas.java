package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class VentanaNormas {


	protected JFrame frmSiel;
	private JTable table;
	private JTextField textFieldCantidadEcuaciones;
	private JTable table_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNormas window = new VentanaNormas();
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
	public VentanaNormas() {
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
		frmSiel.setBounds(100, 100, 596, 441);
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
		textFieldCantidadEcuaciones.setText("3");
		textFieldCantidadEcuaciones.setColumns(10);
		
		JLabel lblA = new JLabel("AX=B");
		lblA.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JButton btnSiguiente = new JButton("Siguiente");
		int numero= Integer.parseInt(textFieldCantidadEcuaciones.getText());
		String[] arrayDeNewColumn = new String[numero] ;
		for(int i=0; i<numero; i++) {
			arrayDeNewColumn[i]= "New column";
		}
		
		JLabel lblN = new JLabel("Cantidad de ecuaciones:");
		lblN.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
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
				VentanaElegirMetodo elegir = new VentanaElegirMetodo(cantidadEcuaciones);
				elegir.main(null, cantidadEcuaciones);
				frmSiel.dispose();
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton button_1 = new JButton("Inicio");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicio inicio = new Inicio();
				inicio.main(null);
				frmSiel.dispose();
			}
		});
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
		
		JButton button_2 = new JButton("Ver normas");
		
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
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
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
					.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button)
						.addComponent(button_2))
					.addGap(24))
		);
		panel.setLayout(gl_panel);
	}
	}
