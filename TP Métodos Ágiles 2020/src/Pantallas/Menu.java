package Pantallas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import BDD.GestorBDD;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Menu {

	JFrame frmMen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
		GestorBDD.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMen = new JFrame();
		frmMen.setTitle("Men\u00FA");
		frmMen.setBounds(100, 100, 407, 271);
		frmMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMen.getContentPane().setLayout(null);
		frmMen.setLocationRelativeTo(null);

		
		JButton altaTitular = new JButton("Alta Titular");
		altaTitular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DarAltaTitular alta = new DarAltaTitular(0);
				alta.setVisible(true);
				frmMen.dispose();
			}
		});
		altaTitular.setBounds(31, 97, 133, 26);
		frmMen.getContentPane().add(altaTitular);
		
		JButton emitirLicencia = new JButton("Emitir Licencia");
		emitirLicencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmitirLicencia emitir = new EmitirLicencia();
				emitir.setVisible(true);
				frmMen.dispose();
			}
		});
		emitirLicencia.setBounds(230, 96, 133, 29);
		frmMen.getContentPane().add(emitirLicencia);
		
		JButton renovarLicencia = new JButton("Renovar Licencia");
		renovarLicencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RenovarLicencia renovar= new RenovarLicencia();
				renovar.setVisible(true);
				frmMen.dispose();
			}
			
		});
		renovarLicencia.setBounds(230, 144, 133, 29);
		frmMen.getContentPane().add(renovarLicencia);
		
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de Titular");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 32, 197, 29);
		frmMen.getContentPane().add(lblNewLabel);
		
		JLabel lblGestinDeLicencia = new JLabel("Gesti\u00F3n de Licencia");
		lblGestinDeLicencia.setToolTipText("");
		lblGestinDeLicencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestinDeLicencia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGestinDeLicencia.setBounds(194, 32, 197, 29);
		frmMen.getContentPane().add(lblGestinDeLicencia);
		
		JButton cerrar = new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMen.dispose();
			}
		});
		cerrar.setBounds(26, 195, 80, 26);
		frmMen.getContentPane().add(cerrar);
	}
}
