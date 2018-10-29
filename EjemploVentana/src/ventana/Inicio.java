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
		frmSiel.getContentPane().setBackground(new Color(255, 239, 213));
		frmSiel.setBounds(100, 100, 508, 480);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/Cubo grande.jpg")));
		
		JLabel lblBienvenidosASiel = new JLabel("BIENVENIDOS A SIEL!");
		
		JLabel lblNewLabel_1 = new JLabel("Resoluci\u00F3n de ecuaciones diferenciales");
		
		JLabel lblPorElMtodo = new JLabel("por el m\u00E9todo de Jacobi o Gauss-Seidel");
		

		
		JButton btnComenzar = new JButton("Comenzar!");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana ventanaValores= new Ventana();
				ventanaValores.frmSiel.setVisible(true);
				frmSiel.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmSiel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(169)
							.addComponent(lblBienvenidosASiel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(113)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnComenzar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPorElMtodo)
								.addComponent(lblNewLabel_1))))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(lblBienvenidosASiel)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(11)
					.addComponent(lblPorElMtodo)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addContainerGap(64, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(369, Short.MAX_VALUE)
					.addComponent(btnComenzar)
					.addGap(49))
		);
		frmSiel.getContentPane().setLayout(groupLayout);
	}
}
