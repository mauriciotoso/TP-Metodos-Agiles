package Pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Usuario;
import Logica.GestorUsuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class BuscarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBuscador;
	private Usuario user;
	private String usuarioABuscar;
	private JLabel lblUserfound, lblNombreus, lblApellidous, lblDnius, lblEmailus, lblLegajous;
	private JButton btnConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarUsuario frame = new BuscarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuscarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Buscar Usuario");
		setBounds(100, 100, 450, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblUser = new JLabel("Nombre de usuario:");
		lblUser.setToolTipText("");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(10, 14, 173, 18);
		contentPane.add(lblUser);
		
		textFieldBuscador = new JTextField();
		textFieldBuscador.setBounds(170, 12, 159, 20);
		contentPane.add(textFieldBuscador);
		textFieldBuscador.setColumns(10);
		textFieldBuscador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textFieldBuscador.getText().length()==20) e.consume();
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioABuscar = textFieldBuscador.getText();
				user = GestorUsuario.getInstance().getUsuario(usuarioABuscar);
				actualizarDatos();
			}
		});
		btnBuscar.setBounds(339, 12, 85, 21);
		contentPane.add(btnBuscar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 40, 414, 104);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDatosDelUsuario = new JLabel("Datos del usuario encontrado:");
		lblDatosDelUsuario.setBounds(10, 11, 284, 15);
		lblDatosDelUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblDatosDelUsuario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 37, 66, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido.setBounds(10, 59, 66, 14);
		panel.add(lblApellido);
		
		lblUserfound = new JLabel("userFound");
		lblUserfound.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserfound.setBounds(209, 12, 195, 14);
		panel.add(lblUserfound);
		lblUserfound.setVisible(false);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDni.setBounds(10, 84, 66, 14);
		panel.add(lblDni);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(193, 38, 66, 14);
		panel.add(lblEmail);
		
		JLabel lblLegajo = new JLabel("Legajo:");
		lblLegajo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLegajo.setBounds(193, 60, 66, 14);
		panel.add(lblLegajo);
		
		lblNombreus = new JLabel("nombreUs");
		lblNombreus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreus.setBounds(71, 37, 112, 14);
		panel.add(lblNombreus);
		lblNombreus.setVisible(false);
		
		lblApellidous = new JLabel("apellidoUs");
		lblApellidous.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidous.setBounds(71, 60, 112, 14);
		panel.add(lblApellidous);
		lblApellidous.setVisible(false);
		
		lblDnius = new JLabel("dniUs");
		lblDnius.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDnius.setBounds(47, 84, 124, 14);
		panel.add(lblDnius);
		lblDnius.setVisible(false);
		
		lblEmailus = new JLabel("emailUs");
		lblEmailus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmailus.setBounds(240, 38, 164, 14);
		panel.add(lblEmailus);
		lblEmailus.setVisible(false);
		
		lblLegajous = new JLabel("legajoUs");
		lblLegajous.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLegajous.setBounds(250, 60, 112, 14);
		panel.add(lblLegajous);
		lblLegajous.setVisible(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarUsuario modificar = new ModificarUsuario();
				modificar.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(10, 151, 85, 21);
		contentPane.add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarUsuario modificar = new ModificarUsuario(user);
				modificar.setVisible(true);
				dispose();
			}
		});
		btnConfirmar.setBounds(286, 151, 138, 21);
		contentPane.add(btnConfirmar);
		btnConfirmar.setEnabled(false);
	}
	
	public void actualizarDatos() {
		if (user != null) {
			lblUserfound.setText(user.getUsuario());
			lblNombreus.setText("");
			lblApellidous.setText("");
			lblDnius.setText("");
			lblEmailus.setText("");
			lblLegajous.setText("");
			
			lblUserfound.setVisible(true);
			lblNombreus.setVisible(true);
			lblApellidous.setVisible(true);
			lblDnius.setVisible(true);
			lblEmailus.setVisible(true);
			lblLegajous.setVisible(true);
			
			btnConfirmar.setEnabled(true);
		}else {
			lblUserfound.setText("No existe el usuario ingresado");
			lblUserfound.setVisible(true);
			lblNombreus.setText("");
			lblApellidous.setText("");
			lblDnius.setText("");
			lblEmailus.setText("");
			lblLegajous.setText("");
			
			btnConfirmar.setEnabled(false);
		}
	}
}
