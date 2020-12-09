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
		frmMen.setBounds(100, 100, 407, 380);
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
		altaTitular.setBounds(27, 97, 149, 29);
		frmMen.getContentPane().add(altaTitular);
		
		JButton emitirLicencia = new JButton("Emitir Licencia");
		emitirLicencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmitirLicencia emitir = new EmitirLicencia();
				emitir.setVisible(true);
				frmMen.dispose();
			}
		});
		emitirLicencia.setBounds(214, 96, 149, 29);
		frmMen.getContentPane().add(emitirLicencia);
		
		JButton modificarTitular = new JButton("Modificar Titular");
		modificarTitular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarTitular modificar= new ModificarTitular();
				modificar.setVisible(true);
				frmMen.dispose();
			}
			
		});
		modificarTitular.setBounds(27, 136, 149, 29);
		frmMen.getContentPane().add(modificarTitular);
		
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
		lblGestinDeLicencia.setBounds(182, 32, 197, 29);
		frmMen.getContentPane().add(lblGestinDeLicencia);
		
		JButton cerrar = new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMen.dispose();
			}
		});
		cerrar.setBounds(10, 307, 80, 26);
		frmMen.getContentPane().add(cerrar);
		
		JButton ListadoExpirado = new JButton("Licencias Expiradas");
		ListadoExpirado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoExpirado le= new ListadoExpirado();
				le.frame.setVisible(true);
				frmMen.dispose();
			}
		});
		ListadoExpirado.setBounds(214, 190, 149, 29);
		frmMen.getContentPane().add(ListadoExpirado);
		
		JButton licenciaVigente = new JButton("Licencias Vigentes");
		licenciaVigente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListadoVigente lv= new ListadoVigente();
				lv.frame.setVisible(true);
				frmMen.dispose();

			}
		});
		licenciaVigente.setBounds(214, 231, 149, 29);
		frmMen.getContentPane().add(licenciaVigente);
		

		JButton renovarLicencia_1 = new JButton("Renovar Licencia");
		renovarLicencia_1.setBounds(214, 136, 149, 29);
		frmMen.getContentPane().add(renovarLicencia_1);

		
		
		JLabel gestionUsuario = new JLabel("Gesti\u00F3n de Usuario");
		gestionUsuario.setToolTipText("");
		gestionUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		gestionUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		gestionUsuario.setBounds(7, 152, 197, 29);
		frmMen.getContentPane().add(gestionUsuario);
		
		JButton altaUsuario = new JButton("Alta Usuario");
		altaUsuario.setBounds(31, 194, 133, 26);
		frmMen.getContentPane().add(altaUsuario);
		altaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DarAltaUsuario aU= new DarAltaUsuario();
				aU.setVisible(true);
				frmMen.dispose();

			}
		});
		
		
		
		JButton crearCopia = new JButton("Crear Copia Licencia");
		crearCopia.setBounds(214, 276, 149, 29);
		frmMen.getContentPane().add(crearCopia);
		crearCopia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CopiaLicencia cl= new CopiaLicencia();
				cl.setVisible(true);
				frmMen.dispose();

			}
		});
		
		
		
		

	}
}
