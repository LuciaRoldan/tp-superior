package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaElegirMetodo {

	private JFrame frame;
	private JTable tableVectorInicial;
	private JTextField textFieldCantDecim;
	private JTextField textFieldCotaError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int cantidadEcuaciones) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaElegirMetodo window = new VentanaElegirMetodo(cantidadEcuaciones);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaElegirMetodo(int cantidadFilas) {
		initialize(cantidadFilas);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int cant) {
		int cantidadFilas = cant;
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 600, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblMtodo = new JLabel("M\u00E9todo:");
		lblMtodo.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblCantiidadDeDecimales = new JLabel("Cantidad de decimales:");
		lblCantiidadDeDecimales.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblCotaDeError = new JLabel("Cota de error:");
		lblCotaDeError.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JLabel lblVectorInicial = new JLabel("Vector inicial:");
		lblVectorInicial.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JComboBox comboBoxMetodo = new JComboBox();
		comboBoxMetodo.setModel(new DefaultComboBoxModel(new String[] {"", "Jacobi", "El Otro"}));
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
		btnAtrs.setForeground(new Color(0, 0, 0));
		btnAtrs.setBackground(new Color(255, 20, 147));
		btnAtrs.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCantiidadDeDecimales)
								.addComponent(lblCotaDeError)
								.addComponent(lblMtodo)
								.addComponent(lblVectorInicial))
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxMetodo, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCotaError, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCantDecim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tableVectorInicial, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAtrs)
							.addPreferredGap(ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(27)))
					.addComponent(btnNewButton_1)
					.addGap(29))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMtodo)
						.addComponent(comboBoxMetodo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVectorInicial)
						.addComponent(tableVectorInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantiidadDeDecimales)
						.addComponent(textFieldCantDecim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCotaDeError)
						.addComponent(textFieldCotaError, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtrs)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(21))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
