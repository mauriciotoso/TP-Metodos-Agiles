package Pantallas;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Logica.GestorTitular;
import Logica.GestorUsuario;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Pattern;


public class DarAltaUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	//JFrame frame;
	
	
	
	private JTextField textField_Nombre;
	private Boolean usuarioUnico; 
	
	private JPasswordField passwordField_Contrasenia;
	private char[] contrasenia;

	private JPasswordField passwordField_Contrasenia2;
	private char[] contrasenia2;
	private String contrasenia2String;
	private String contraseniaString;
	private boolean contrasenia2val, contraseniaval, apellidoval, nombreval, legajoval, emailval, dnival;
	private boolean dniUnico, legajoUnico, emailUnico;
	private boolean confirmar;
	
	private String apellido;
	private String nombre;
	private String legajo;
	private String dni;
	private String email;
	
	private JTextField textField_Apellido;
	private JTextField textField_Email;
	private JTextField textField_Dni;
	private JTextField textField_Legajo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarAltaUsuario window = new DarAltaUsuario();
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
	public DarAltaUsuario() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		confirmar= true;
		emailval = true;
		contrasenia2val = true;
		contraseniaval = true; 
		apellidoval = true; 
		nombreval = true; 
		legajoval = true; 
		emailval = true;
		dnival = true;
		dniUnico= true;
		legajoUnico= true;
		emailUnico = true;
		
		setTitle("Dar de Alta Usuario");
		setBounds(100, 100, 642, 387);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblCrearTitular = new JLabel("Crear Usuario");
		lblCrearTitular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCrearTitular.setBounds(10, 26, 106, 14);
		getContentPane().add(lblCrearTitular);
		
		
		
		//NOMBRE
		JLabel lblNombre = new JLabel("Nombre*");
		lblNombre.setBounds(28, 73, 88, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblNombreError = new JLabel("Nombre inválido");
		lblNombreError.setForeground(Color.RED);
		lblNombreError.setBounds(99, 98, 185, 14);
		getContentPane().add(lblNombreError);
		lblNombreError.setVisible(false);
		
		textField_Nombre = new JTextField();
		textField_Nombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				nombre = textField_Nombre.getText().toLowerCase().replace(" ", "");
				nombreval = true;
				if(nombre.length()==0) { nombreval = false;}
				for(int i = 0; i<nombre.length(); i++) {
					if(!((nombre.charAt(i) >= 'a' && nombre.charAt(i) <= 'z') || (nombre.charAt(i) >= 'á' &&  nombre.charAt(i) <=  'ú') || nombre.charAt(i)=='é' )) {
						lblNombreError.setVisible(true);
						nombreval = false;
						confirmar = false;
					}
				}
				if(nombreval) {
					lblNombreError.setVisible(false);
					confirmar = true;
				}
			}
			
		});
		textField_Nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_Nombre.getText().length()==20) {
					e.consume();
				}
			}
		}
		);
		
		textField_Nombre.setBounds(99, 73, 162, 20);
		getContentPane().add(textField_Nombre);
		textField_Nombre.setColumns(10);
		//
		
		//CONTRASEÑA
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a*");
		lblContrasenia.setBounds(294, 124, 106, 14);
		getContentPane().add(lblContrasenia);
		
		JLabel lblContrasenia2Error = new JLabel("Las contrase\u00F1as no coinciden");
		JLabel lblContraseniaError = new JLabel("Debe contener entre 8 y 20 caracteres");
		lblContraseniaError.setForeground(Color.RED);
		lblContraseniaError.setBounds(423, 152, 302, 14);
		getContentPane().add(lblContraseniaError);
		lblContraseniaError.setVisible(false);
		
		passwordField_Contrasenia2 = new JPasswordField();
		passwordField_Contrasenia = new JPasswordField();
		passwordField_Contrasenia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				lblContraseniaError.setVisible(false);
				contrasenia = passwordField_Contrasenia.getPassword();
				contraseniaString = new String(contrasenia);
				contraseniaval = true;
				if(contraseniaString.length()<8 || contraseniaString.length()>20 ) {
					contraseniaval = false;
					
					lblContraseniaError.setVisible(true);
					confirmar = false;
				}
				
				if (!(passwordField_Contrasenia2 == null)) {
					String contrasenia2String2 = new String(passwordField_Contrasenia2.getPassword());
					if(!contrasenia2String2.equals(contraseniaString)) { 
						
						contrasenia2val = false;
						lblContrasenia2Error.setVisible(true);
						confirmar = false;
					}else {
						lblContrasenia2Error.setVisible(false);
						confirmar = true;
					}
						
	
				} else {
					confirmar = true;
					lblContraseniaError.setVisible(false);
				}
				
			}
			
		});
		
		passwordField_Contrasenia.setBounds(423, 124, 162, 20);
		getContentPane().add(passwordField_Contrasenia);
		passwordField_Contrasenia.setColumns(10);
		//
		
		//CONTRASEÑA2
		JLabel lblContrasenia2 = new JLabel("Repita la Contrase\u00F1a*");
		lblContrasenia2.setBounds(294, 177, 185, 14);
		getContentPane().add(lblContrasenia2);
		
		
		lblContrasenia2Error.setForeground(Color.RED);
		lblContrasenia2Error.setBounds(423, 199, 264, 14);
		getContentPane().add(lblContrasenia2Error);
		lblContrasenia2Error.setVisible(false);
		
		
		passwordField_Contrasenia2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				contrasenia2 = passwordField_Contrasenia2.getPassword();
				contrasenia2val = true;
				
				contrasenia2String = new String(contrasenia2);
				
				
				
				if(!contrasenia2String.equals(contraseniaString)) { 
					
					contrasenia2val = false;
					lblContrasenia2Error.setVisible(true);
					confirmar = false;
				}else {
					lblContrasenia2Error.setVisible(false);
					confirmar = true;}
			}
		});
		
		
	
	
		passwordField_Contrasenia2.setBounds(423, 176, 162, 20);
		getContentPane().add(passwordField_Contrasenia2);
		//
		
	
		
		//APELLIDO
		JLabel lblApellido = new JLabel("Apellido*");
		lblApellido.setBounds(28, 124, 88, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblApellidoError = new JLabel("Apellido inválido");
		lblApellidoError.setBounds(99, 148, 162, 13);
		getContentPane().add(lblApellidoError);
		lblApellidoError.setForeground(Color.RED);
		lblApellidoError.setVisible(false);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setColumns(10);
		textField_Apellido.setBounds(99, 124, 162, 20);
		getContentPane().add(textField_Apellido);
		
		textField_Apellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				apellido = textField_Apellido.getText().toLowerCase().replace(" ", "");
				apellidoval = true;
				if(apellido.length()==0) { apellidoval = false;}
				for(int i = 0; i<apellido.length(); i++) {
					if(!((apellido.charAt(i) >= 'a' && apellido.charAt(i) <= 'z') || (apellido.charAt(i) >= 'á' &&  apellido.charAt(i) <=  'ú') || apellido.charAt(i)=='é' )) {
						lblApellidoError.setVisible(true);
						apellidoval = false;
						confirmar = false;
					}
				}
				if(apellidoval) {
					lblApellidoError.setVisible(false);
					confirmar = true;
				}
			}
			
		});
		textField_Apellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_Apellido.getText().length()==30) {
					e.consume();
				}
			}
		}
		);
		
		//
		
		//EMAIL
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setBounds(294, 73, 88, 14);
		getContentPane().add(lblEmail);
		
		
		JLabel lblEmailUnicoError = new JLabel("El Email ya existe");
		lblEmailUnicoError.setBounds(423, 99, 129, 13);
		getContentPane().add(lblEmailUnicoError);
		lblEmailUnicoError.setVisible(false);
		lblEmailUnicoError.setForeground(Color.RED);
		
		JLabel lblEmailError = new JLabel("Email no válido");
		lblEmailError.setBounds(423, 97, 162, 13);
		getContentPane().add(lblEmailError);
		lblEmailError.setForeground(Color.RED);
		lblEmailError.setVisible(false);
		
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(423, 71, 162, 20);
		getContentPane().add(textField_Email);
		textField_Email.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				email = textField_Email.getText();
				emailval = true;
				if(email.length()==0   || !(validarEmail(email))) {
					emailval = false;}
			
				if(emailval) {
					lblEmailError.setVisible(false);
					confirmar = true;
				}else {
					lblEmailError.setVisible(true);
					confirmar = false; }
			
			
			dniUnico = GestorUsuario.getInstance().verificarEmail(textField_Email.getText());
			
			if(!dniUnico) {
				
				lblEmailError.setVisible(false);
				lblEmailUnicoError.setVisible(true);
				emailUnico = false;
			}else {
				lblEmailUnicoError.setVisible(false);
				emailUnico= true;
			}
		
		}
		});
		

	
		//

		//DNI
		JLabel lblDNIError = new JLabel("DNI inválido");
		lblDNIError.setBounds(99, 200, 162, 13);
		getContentPane().add(lblDNIError);
		lblDNIError.setForeground(Color.RED);
		lblDNIError.setVisible(false);
		
		
		JLabel lblDniunico = new JLabel("El DNI ya existe");
		lblDniunico.setForeground(Color.RED);
		lblDniunico.setBounds(99, 200, 162, 13);
		getContentPane().add(lblDniunico);
		lblDniunico.setVisible(false);
		
		JLabel lblDNI = new JLabel("DNI*");
		lblDNI.setBounds(28, 177, 88, 14);
		getContentPane().add(lblDNI);
		
		textField_Dni = new JTextField();
		textField_Dni.setColumns(10);
		textField_Dni.setBounds(99, 177, 162, 20);
		getContentPane().add(textField_Dni);
		
		
		textField_Dni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
					dnival = true;
					if(textField_Dni.getText().length()<7 ) {
						dnival = false;
					}
					dni = textField_Dni.getText();
					for(int i = 0; i<dni.length(); i++) {
						if(!(Character.isDigit(dni.charAt(i)))) {
							dnival = false;
						}
					}
					if(!dnival) {
						
						lblDniunico.setVisible(false);
						lblDNIError.setVisible(true);
						confirmar = false;
					}
					else {
						lblDNIError.setVisible(false);
						confirmar = true;
					}
				
					
				dniUnico = GestorUsuario.getInstance().verificarDNI(textField_Dni.getText());
				
				if(!dniUnico) {
					
					lblDNIError.setVisible(false);
					lblDniunico.setVisible(true);
					dniUnico = false;
				}else {
					lblDniunico.setVisible(false);
					dniUnico= true;
				}
			}
		
				
			}
		);
		textField_Dni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_Dni.getText().length()==8) {
					e.consume();
				}
				if(!Character.isDigit(e.getKeyChar())) e.consume();
			}		
			});
		
		//
		
		
		//LEGAJO
		textField_Legajo = new JTextField();
		textField_Legajo.setColumns(10);
		textField_Legajo.setBounds(99, 229, 162, 20);
		getContentPane().add(textField_Legajo);
		
		
		
		JLabel lblLegajoUnicoError = new JLabel("El legajo ya existe");
		lblLegajoUnicoError.setBounds(99, 259, 138, 13);
		getContentPane().add(lblLegajoUnicoError);
		lblLegajoUnicoError.setVisible(false);
		lblLegajoUnicoError.setForeground(Color.RED);
	
		
		JLabel lblLegajoError = new JLabel("Debe contener 5 caracteres");
		lblLegajoError.setBounds(99, 259, 162, 13);
		getContentPane().add(lblLegajoError);
		lblLegajoError.setForeground(Color.RED);
		lblLegajoError.setVisible(false);
		
		
		JLabel lblLegajo = new JLabel("Legajo*");
		lblLegajo.setBounds(28, 229, 88, 14);
		getContentPane().add(lblLegajo);
		
		textField_Legajo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				legajo = textField_Legajo.getText();
				legajoval = true;
				if(legajo.length()==0   || legajo.length()<5) { legajoval = false;}
			
				if(legajoval) {
					lblLegajoError.setVisible(false);
					confirmar = true;
				}else {
					lblLegajoError.setVisible(true);
					confirmar = false;
				}
				
				legajoUnico = GestorUsuario.getInstance().verificarLegajo(textField_Legajo.getText());
				
				if(!legajoUnico) {
					
					lblLegajoError.setVisible(false);
					lblLegajoUnicoError.setVisible(true);
					legajoUnico = false;
				}else {
					lblLegajoUnicoError.setVisible(false);
					legajoUnico = true;
				}
				
			}
			
		});
		textField_Legajo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) e.consume();
				
				if (textField_Legajo.getText().length()==5) e.consume();
			}
		});
		//
		
	
		//////////////////////////////////////////////////////CONFIRMAR
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textField_Nombre.getText().length()==0) {
					nombreval = false;
					System.out.println("chequea nombre null");
					lblNombreError.setVisible(true);
				}
				
				if(textField_Apellido.getText().length()==0) {
					apellidoval = false;
					lblApellidoError.setVisible(true);
				}
				if(textField_Email.getText().length()==0) {
					emailval = false;
					lblEmailError.setVisible(true);
				}
				if(textField_Legajo.getText().length()==0) {
					legajoval = false;
					lblLegajoError.setVisible(true);
				}
				
				if(textField_Dni.getText().length()==0) {
					dnival = false;
					lblDNIError.setVisible(true);
				}

				if(passwordField_Contrasenia.getPassword().length==0) {
					contraseniaval = false;
					System.out.println("chequea password1 null");
					lblContraseniaError.setVisible(true);
				}
				if(passwordField_Contrasenia2.getPassword().length==0) {
					contrasenia2val = false;
					System.out.println("chequea password2 null");
					lblContrasenia2Error.setVisible(true);
				}
				
				
								
				if(contrasenia2val && contraseniaval && apellidoval && nombreval && legajoval && emailval && dnival && dniUnico && legajoUnico && emailUnico) {
					System.out.println("Todo ok, se crea el usuario");
					GestorUsuario.getInstance().guardarUsuario(textField_Nombre.getText(),textField_Apellido.getText(), textField_Dni.getText(), textField_Legajo.getText(), textField_Email.getText(), contraseniaString);
					
					JOptionPane.showMessageDialog(null, "Usuario creado", "Mensaje de éxito", JOptionPane.INFORMATION_MESSAGE);
					Menu menu = new Menu();
					menu.frmMen.setVisible(true);
					dispose();
					
				}
				
			}

		});
		
		btnNewButton.setBounds(487, 314, 129, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu menu = new Menu();
				menu.frmMen.setVisible(true);
			
				dispose();
			}
		});
		btnCancelar.setBounds(10, 314, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblCamposObligatorios = new JLabel("*: Campos obligatorios");
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblCamposObligatorios.setBounds(10, 289, 251, 18);
		getContentPane().add(lblCamposObligatorios);
		
	
		
	
		
	}
	
	public static boolean validarEmail(String email) {
	    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}
}
