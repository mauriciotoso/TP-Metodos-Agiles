package Pantallas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class BuscarTitular extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarTitular window = new BuscarTitular();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuscarTitular() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Buscar Titular");
		setBounds(100, 100, 450, 219);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		textField = new JTextField();
		textField.setBounds(193, 12, 138, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDNI = new JLabel("Ingresar n\u00FAmero DNI:");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDNI.setToolTipText("");
		lblDNI.setBounds(15, 10, 173, 18);
		getContentPane().add(lblDNI);
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buscar.setBounds(341, 11, 85, 21);
		getContentPane().add(buscar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmitirLicencia emitir = new EmitirLicencia();
				emitir.setVisible(true);
				dispose();
			}
		});
		cancelar.setBounds(10, 152, 85, 21);
		getContentPane().add(cancelar);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmitirLicencia emitir = new EmitirLicencia();
				emitir.setVisible(true);
				dispose();
			}
		});
		confirmar.setBounds(341, 152, 85, 21);
		getContentPane().add(confirmar);
		
		JButton btnNewButton = new JButton("Crear titular");
		btnNewButton.setBounds(171, 152, 95, 21);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 416, 101);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDatos = new JLabel("Datos del titular:");
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatos.setBounds(10, 10, 124, 13);
		panel.add(lblDatos);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 33, 174, 13);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido.setBounds(10, 56, 174, 13);
		panel.add(lblApellido);
		
		JLabel lblNroDni = new JLabel("Nro. DNI:");
		lblNroDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNroDni.setBounds(10, 79, 174, 13);
		panel.add(lblNroDni);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaNacimiento.setBounds(194, 80, 174, 13);
		panel.add(lblFechaNacimiento);
	}
}
