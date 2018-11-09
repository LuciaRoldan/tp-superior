package ventana;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Font;

public class Inicio {

	private JFrame frmSiel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frmSiel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		initialize();
	}

	private void initialize() {
		frmSiel = new JFrame();
		frmSiel.setTitle("SIEL");
		frmSiel.setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagenes/Cubo icono chico.jpg")));
		frmSiel.getContentPane().setBackground(new Color(255, 235, 205));
		frmSiel.setBounds(100, 100, 508, 480);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/Cubo grande.jpg")));
		
		JLabel lblBienvenidosASiel = new JLabel("BIENVENIDOS A SIEL!");
		lblBienvenidosASiel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1 = new JLabel("Resoluci\u00F3n de sistemas de ecuaciones lineales");
		
		JLabel lblPorElMtodo = new JLabel("por el m\u00E9todo de Jacobi o Gauss-Seidel.");
		

		
		JButton btnComenzar = new JButton("Comenzar!");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMatrices ventanaValores= new VentanaMatrices();
				ventanaValores.frmSiel.setVisible(true);
				frmSiel.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmSiel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(lblPorElMtodo))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addComponent(lblBienvenidosASiel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(113)
							.addComponent(lblNewLabel)))
					.addContainerGap(120, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(382, Short.MAX_VALUE)
					.addComponent(btnComenzar)
					.addGap(25))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(123)
					.addComponent(lblNewLabel_1)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblBienvenidosASiel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(11)
					.addComponent(lblPorElMtodo)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(9)
					.addComponent(btnComenzar)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		frmSiel.getContentPane().setLayout(groupLayout);
	}
	public Color getFrmSielContentPaneBackground() {
		return frmSiel.getContentPane().getBackground();
	}
	public void setFrmSielContentPaneBackground(Color background) {
		frmSiel.getContentPane().setBackground(background);
	}
}
