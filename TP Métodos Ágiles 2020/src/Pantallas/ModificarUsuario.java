package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Entidades.Usuario;
import Logica.GestorUsuario;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ModificarUsuario extends JFrame {

	private JPanel contentPane;
	

	private boolean dnival;
	private Boolean usuarioUnico;
	private JPasswordField textField_Contrasenia;
	private JTextField textField_Usuario;
	private char[] password, password2;
	private String contrasenia;
	private boolean contraseniaval;
	private String contrasenia2;
	private boolean contrasenia2val;
	private boolean confirmar;
	private Usuario usuario;
	private JTextField textFieldNombreUs;
	private JTextField textFieldApellidoUs;
	private JTextField textFieldDniUs;
	private JTextField textFieldEmailUs;
	private boolean nombreval, apellidoval;
	private String nombre, apellido;
	private boolean emailval;
	private String email;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarUsuario frame = new ModificarUsuario();
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
	public ModificarUsuario (Usuario us) {
		this.usuario=us;
		initialize();
	}
	
	public ModificarUsuario () {
		initialize();
	}
	
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Modificar Usuario");
		setLocationRelativeTo(null);
		
		confirmar= true;
		contentPane.setLayout(null);
		
		JLabel lblCrearTitular = new JLabel("Modificar Usuario");
		lblCrearTitular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCrearTitular.setBounds(10, 26, 116, 14);
		getContentPane().add(lblCrearTitular);
		
		JLabel lblLegajo = new JLabel("Legajo");
		lblLegajo.setBounds(32, 135, 46, 14);
		getContentPane().add(lblLegajo);
		
		
		textField_Usuario = new JTextField();
		textField_Usuario.setBounds(116, 132, 162, 20);
		getContentPane().add(textField_Usuario);
		textField_Usuario.setColumns(10);
		textField_Usuario.setEditable(false);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setBounds(32, 183, 168, 14);
		getContentPane().add(lblContrasenia);
		
		textField_Contrasenia = new JPasswordField();
		textField_Contrasenia.setBounds(116, 180, 162, 20);
		textField_Contrasenia.setEchoChar('*');
		getContentPane().add(textField_Contrasenia);
		textField_Contrasenia.setColumns(10);
		textField_Contrasenia.setEditable(false);
		
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu menu = new Menu();
				menu.frmMen.setVisible(true);
			
				dispose();
			}
		});
		btnCancelar.setBounds(10, 314, 95, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblCamposObligatorios = new JLabel("*: Campos obligatorios");
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblCamposObligatorios.setBounds(10, 283, 142, 20);
		getContentPane().add(lblCamposObligatorios);
		
		JLabel lblNombre = new JLabel("Nombre*");
		lblNombre.setBounds(317, 85, 63, 14);
		contentPane.add(lblNombre);
		
		textFieldNombreUs = new JTextField();
		textFieldNombreUs.setBounds(390, 82, 162, 20);
		contentPane.add(textFieldNombreUs);
		textFieldNombreUs.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido*");
		lblApellido.setBounds(317, 132, 80, 14);
		contentPane.add(lblApellido);
		
		textFieldApellidoUs = new JTextField();
		textFieldApellidoUs.setColumns(10);
		textFieldApellidoUs.setBounds(390, 129, 162, 20);
		contentPane.add(textFieldApellidoUs);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setBounds(317, 179, 46, 14);
		contentPane.add(lblDni);
		
		textFieldDniUs = new JTextField();
		textFieldDniUs.setColumns(10);
		textFieldDniUs.setBounds(390, 175, 162, 20);
		contentPane.add(textFieldDniUs);
		textFieldDniUs.setEditable(false);
		
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setBounds(317, 225, 63, 14);
		contentPane.add(lblEmail);
		
		textFieldEmailUs = new JTextField();
		textFieldEmailUs.setColumns(10);
		textFieldEmailUs.setBounds(390, 222, 162, 20);
		contentPane.add(textFieldEmailUs);
		
		JLabel lblErrorNombre = new JLabel("Nombre inv\u00E1lido");
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblErrorNombre.setBounds(390, 109, 104, 14);
		contentPane.add(lblErrorNombre);
		lblErrorNombre.setVisible(false);
		
		textFieldNombreUs.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				nombre = textFieldNombreUs.getText().toLowerCase().replace(" ", "");
				nombreval = true;
				if(nombre.length()==0) { nombreval = false;}
				for(int i = 0; i<nombre.length(); i++) {
					if(!((nombre.charAt(i) >= 'a' && nombre.charAt(i) <= 'z') || (nombre.charAt(i) >= 'á' &&  nombre.charAt(i) <=  'ú') || nombre.charAt(i)=='é' )) {
						lblErrorNombre.setVisible(true);
						nombreval = false;
						confirmar = false;
					}
				}
				if(nombreval) {
					lblErrorNombre.setVisible(false);
					confirmar = true;
				}
			}
			
		});
		textFieldNombreUs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldNombreUs.getText().length()==20) {
					e.consume();
				}
			}
		}
		);
		
		JLabel lblErrorApellido = new JLabel("Apellido inv\u00E1lido");
		lblErrorApellido.setForeground(Color.RED);
		lblErrorApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblErrorApellido.setBounds(390, 154, 104, 14);
		contentPane.add(lblErrorApellido);
		lblErrorApellido.setVisible(false);
		
		textFieldApellidoUs.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				apellido = textFieldApellidoUs.getText().toLowerCase().replace(" ", "");
				apellidoval = true;
				if(apellido.length()==0) { apellidoval = false;}
				for(int i = 0; i<apellido.length(); i++) {
					if(!((apellido.charAt(i) >= 'a' && apellido.charAt(i) <= 'z') || (apellido.charAt(i) >= 'á' &&  apellido.charAt(i) <=  'ú') || apellido.charAt(i)=='é' )) {
						lblErrorApellido.setVisible(true);
						apellidoval = false;
						confirmar = false;
					}
				}
				if(apellidoval) {
					lblErrorApellido.setVisible(false);
					confirmar = true;
				}
			}
			
		});
		textFieldApellidoUs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textFieldApellidoUs.getText().length()==30) {
					e.consume();
				}
			}
		}
		);
		
		JLabel lblEmailInvlido = new JLabel("Email inv\u00E1lido");
		lblEmailInvlido.setForeground(Color.RED);
		lblEmailInvlido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmailInvlido.setBounds(390, 248, 104, 14);
		contentPane.add(lblEmailInvlido);
		lblEmailInvlido.setVisible(false);
		
		textFieldEmailUs.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				email = textFieldEmailUs.getText();
				emailval = true;
				if(email.length()==0   || !(validarEmail(email))) {
					emailval = false;
					}
			
				if(emailval) {
					lblEmailInvlido.setVisible(false);
					confirmar = true;
				}else
					lblEmailInvlido.setVisible(true);
					confirmar = false;
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Buscar usuario");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarUsuario buscar = new BuscarUsuario();
				buscar.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(141, 23, 189, 23);
		contentPane.add(btnNewButton_1);
		
		if (usuario != null) {
			textField_Usuario.setText(usuario.getLegajo());
			textField_Contrasenia.setText(usuario.getContrasenia());
			textFieldNombreUs.setText(usuario.getNombre());
			textFieldApellidoUs.setText(usuario.getApellido());
			textFieldDniUs.setText(usuario.getDni());
			textFieldEmailUs.setText(usuario.getEmail());
		}
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(textFieldNombreUs.getText().length()==0) {
					confirmar = false;
					System.out.println("chequea nombre null");
					lblErrorNombre.setVisible(true);
				}
				
				if(textFieldApellidoUs.getText().length()==0) {
					confirmar = false;
					lblErrorApellido.setVisible(true);
				}
				if(textFieldEmailUs.getText().length()==0) {
					confirmar = false;
					lblEmailInvlido.setVisible(true);
				}
				System.out.println("CONFIRMAR: "+confirmar);			
				if(confirmar) {
					System.out.println("Todo ok, se actualiza el usuario");
					password = textField_Contrasenia.getPassword();
					contrasenia = new String(password);
					GestorUsuario.getInstance().actualizarUsuario(usuario, textFieldNombreUs.getText(), textFieldApellidoUs.getText(),
							textFieldEmailUs.getText());
					
					JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.", "Mensaje de Éxito", JOptionPane.INFORMATION_MESSAGE);
					Menu menu = new Menu();
					menu.frmMen.setVisible(true);
					dispose();
					
				}
				
			}

		});
		
		btnNewButton.setBounds(487, 314, 129, 23);
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(21, 113, 269, 108);
		contentPane.add(panel);
		
		
	}
	
	public static boolean validarEmail(String email) {
	    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}
	
}


