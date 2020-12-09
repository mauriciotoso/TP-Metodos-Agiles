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
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Logica.GestorTitular;
import Logica.GestorUsuario;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DarAltaUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	//JFrame frame;
	private JTextField textField_Usuario;
	
	private boolean dnival;
	private Boolean usuarioUnico; 
	
	private JPasswordField passwordField_Contrasenia;
	private char[] contrasenia;
	private boolean contraseniaval;
	private JPasswordField passwordField_Contrasenia2;
	private char[] contrasenia2;
	private String contrasenia2String;
	private String contraseniaString;
	private boolean contrasenia2val;
	private boolean confirmar;

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
		
		setTitle("Dar de Alta Usuario");
		setBounds(100, 100, 450, 329);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblCrearTitular = new JLabel("Crear Usuario");
		lblCrearTitular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCrearTitular.setBounds(10, 26, 106, 14);
		getContentPane().add(lblCrearTitular);
		
		JLabel lblUsuario = new JLabel("Usuario*");
		lblUsuario.setBounds(28, 73, 88, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblUsuarioError = new JLabel("Debe contener entre 4 y 20 caracteres");
		lblUsuarioError.setForeground(Color.RED);
		lblUsuarioError.setBounds(154, 100, 264, 14);
		getContentPane().add(lblUsuarioError);
		lblUsuarioError.setVisible(false);
		
		JLabel lblUsuarioExistente = new JLabel("El nombre de Usuario ya existe");
		lblUsuarioExistente.setForeground(Color.RED);
		lblUsuarioExistente.setBounds(154, 97, 251, 20);
		getContentPane().add(lblUsuarioExistente);
		lblUsuarioExistente.setVisible(false);
		
		
		textField_Usuario = new JTextField();
		textField_Usuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
					dnival = true;
					if(textField_Usuario.getText().length()<4 || textField_Usuario.getText().length()> 20) {
						dnival = false;
					}
					
					if(!dnival) {
						lblUsuarioError.setVisible(true);
						lblUsuarioExistente.setVisible(false);
						
						confirmar = false;
					}
					else {
						lblUsuarioError.setVisible(false);
						lblUsuarioExistente.setVisible(false);
						confirmar = true;
					}
				
				if(!(textField_Usuario.getText().length()==0)){
					
					usuarioUnico = GestorUsuario.getInstance().verificarUsuario(textField_Usuario.getText());
				
					if(!usuarioUnico) {
						
						lblUsuarioExistente.setVisible(true);
						confirmar = false;
					}else {
						lblUsuarioExistente.setVisible(false);
						
						confirmar = true;
					}
				}
			}
		
				
			}
		);
		

		
		textField_Usuario.setBounds(154, 73, 162, 20);
		getContentPane().add(textField_Usuario);
		textField_Usuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a*");
		lblContrasenia.setBounds(28, 121, 106, 14);
		getContentPane().add(lblContrasenia);
		
		JLabel lblContraseniaError = new JLabel("Debe contener entre 8 y 20 caracteres");
		lblContraseniaError.setForeground(Color.RED);
		lblContraseniaError.setBounds(154, 152, 302, 14);
		getContentPane().add(lblContraseniaError);
		lblContraseniaError.setVisible(false);
		
		passwordField_Contrasenia = new JPasswordField();
		passwordField_Contrasenia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				contrasenia = passwordField_Contrasenia.getPassword();
				contraseniaString = new String(contrasenia);
				contraseniaval = true;
				if(contraseniaString.length()<8 || contraseniaString.length()>20 ) {
					contraseniaval = false;
					
					lblContraseniaError.setVisible(true);
					confirmar = false;
				}else {
					confirmar = true;
					lblContraseniaError.setVisible(false);
				}
			}
			
		});
		
		
		
		passwordField_Contrasenia.setBounds(154, 124, 162, 20);
		getContentPane().add(passwordField_Contrasenia);
		passwordField_Contrasenia.setColumns(10);
		
		JLabel lblContrasenia2 = new JLabel("Repita la Contrase\u00F1a*");
		lblContrasenia2.setBounds(28, 176, 185, 14);
		getContentPane().add(lblContrasenia2);
		
		JLabel lblContrasenia2Error = new JLabel("Las contrase\u00F1as no coinciden");
		lblContrasenia2Error.setForeground(Color.RED);
		lblContrasenia2Error.setBounds(154, 194, 264, 14);
		getContentPane().add(lblContrasenia2Error);
		lblContrasenia2Error.setVisible(false);
		
		passwordField_Contrasenia2 = new JPasswordField();
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
	
	
		passwordField_Contrasenia2.setBounds(154, 171, 162, 20);
		getContentPane().add(passwordField_Contrasenia2);
		
		
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				if(textField_Usuario.getText().length()==0) {
					confirmar = false;
					lblUsuarioError.setVisible(true);
				}
				if(contraseniaString.length()==0) {
					confirmar = false;
					lblContraseniaError.setVisible(true);
				}
				if(contrasenia2String.length()==0) {
					confirmar = false;
					lblContrasenia2Error.setVisible(true);
				}
				
								
				if(confirmar) {
					System.out.println("Todo ok, se crea el usuario");
					GestorUsuario.getInstance().guardarUsuario(textField_Usuario.getText(), contraseniaString);
					
					JOptionPane.showMessageDialog(null, "Usuario creado", "Mensaje de éxito", JOptionPane.INFORMATION_MESSAGE);
					Menu menu = new Menu();
					menu.frmMen.setVisible(true);
					dispose();
					
				}
				
			}

		});
		
		btnNewButton.setBounds(295, 259, 129, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu menu = new Menu();
				menu.frmMen.setVisible(true);
			
				dispose();
			}
		});
		btnCancelar.setBounds(10, 259, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblCamposObligatorios = new JLabel("*: Campos obligatorios");
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblCamposObligatorios.setBounds(10, 238, 251, 18);
		getContentPane().add(lblCamposObligatorios);
		
	}
}
