package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaInicio {

	private JFrame frmSiel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio window = new VentanaInicio();
					window.frmSiel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaInicio() {
		initialize();
	}

	private void initialize() {
		frmSiel = new JFrame();
		frmSiel.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicio.class.getResource("/resources/cubo-fondo-blanco.jpg")));
		frmSiel.setTitle("SIEL");
		frmSiel.getContentPane().setBackground(new Color(255, 235, 205));
		frmSiel.getContentPane().setForeground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 239, 213));
		frmSiel.getContentPane().add(panel, BorderLayout.CENTER);
		panel.repaint();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaInicio.class.getResource("/resources/cubito.jpg")));
		
		JLabel lblBienvenidosASiel = new JLabel("Bienvenidos a SIEL!");
		lblBienvenidosASiel.setFont(new Font("Stencil", Font.PLAIN, 30));
		
		JLabel lblResolucinDeEcuaciones = new JLabel("Resoluci\u00F3n de ecuaciones diferenciales");
		lblResolucinDeEcuaciones.setFont(new Font("Stencil", Font.PLAIN, 19));
		
		JLabel lblPorJacobyO = new JLabel("por el m\u00E9todo de Jacobi o Gauss-Seidel");
		lblPorJacobyO.setFont(new Font("Stencil", Font.PLAIN, 19));
		
		JButton btnSiguiente = new JButton("Siguiente");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(90)
					.addComponent(lblNewLabel)
					.addContainerGap(100, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPorJacobyO)
						.addComponent(lblResolucinDeEcuaciones))
					.addGap(140))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(418, Short.MAX_VALUE)
					.addComponent(btnSiguiente)
					.addGap(22))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addComponent(lblBienvenidosASiel)
					.addContainerGap(588, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblBienvenidosASiel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblResolucinDeEcuaciones)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPorJacobyO)
					.addGap(2)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(btnSiguiente)
					.addGap(28))
		);
		panel.setLayout(gl_panel);
		frmSiel.setBounds(100, 100, 465, 494);
		frmSiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
