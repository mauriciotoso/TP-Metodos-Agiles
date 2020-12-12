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

public class ModificarUsuario extends JFrame {

	private JPanel contentPane;
	

	private boolean dnival;
	private Boolean usuarioUnico;
	private JPasswordField textField_Contrasenia;
	private JTextField textField_Usuario;
	private char[] password, password2;
	private String contrasenia;
	private boolean contraseniaval;
	private JPasswordField textField_Contrasenia2;
	private String contrasenia2;
	private boolean contrasenia2val;
	private boolean confirmar;
	private Usuario usuario;


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
		setBounds(100, 100, 450, 329);
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
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(28, 73, 46, 14);
		getContentPane().add(lblUsuario);
		
		
		textField_Usuario = new JTextField();
		textField_Usuario.setBounds(164, 73, 162, 20);
		getContentPane().add(textField_Usuario);
		textField_Usuario.setColumns(10);
		textField_Usuario.setEditable(false);
		
		JLabel lblContrasenia = new JLabel("Nueva contrase\u00F1a*");
		lblContrasenia.setBounds(28, 127, 168, 14);
		getContentPane().add(lblContrasenia);
		
		JLabel lblContraseniaError = new JLabel("Debe contener entre 8 y 20 caracteres");
		lblContraseniaError.setForeground(Color.RED);
		lblContraseniaError.setBounds(164, 152, 270, 14);
		getContentPane().add(lblContraseniaError);
		lblContraseniaError.setVisible(false);
		
		textField_Contrasenia = new JPasswordField();
		textField_Contrasenia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				password = textField_Contrasenia.getPassword();
				contrasenia = new String(password);
				if(contrasenia.length()<8 || contrasenia.length()>20 ) {
					contraseniaval = false;
					
					lblContraseniaError.setVisible(true);
					confirmar = false;
				}else {
					confirmar = true;
					lblContraseniaError.setVisible(false);
				}
			}
			
		});
		
		//TODO PREG
		textField_Contrasenia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				password = textField_Contrasenia.getPassword();
				contrasenia = new String(password);
				if(contrasenia.length()==30) {
					e.consume();
				}
			}
		}
		);
		
		textField_Contrasenia.setBounds(164, 124, 162, 20);
		textField_Contrasenia.setEchoChar('*');
		getContentPane().add(textField_Contrasenia);
		textField_Contrasenia.setColumns(10);
		
		
		JLabel lblContrasenia2 = new JLabel("Repita la Contrase\u00F1a*");
		lblContrasenia2.setBounds(28, 176, 220, 14);
		getContentPane().add(lblContrasenia2);
		
		JLabel lblContrasenia2Error = new JLabel("Las contrase\u00F1as no coinciden");
		lblContrasenia2Error.setForeground(Color.RED);
		lblContrasenia2Error.setBounds(164, 194, 270, 14);
		getContentPane().add(lblContrasenia2Error);
		lblContrasenia2Error.setVisible(false);
		
		textField_Contrasenia2 = new JPasswordField();
		textField_Contrasenia2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				password2 = textField_Contrasenia2.getPassword();
				contrasenia2 = new String(password2);
				contrasenia2val = true;
				if(!contrasenia2.equals(contrasenia)) { 
					contrasenia2val = false;
					lblContrasenia2Error.setVisible(true);
					confirmar = false;
				}else {
					lblContrasenia2Error.setVisible(false);
					confirmar = true;}
			}
		});
	
		textField_Contrasenia2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				password2 = textField_Contrasenia2.getPassword();
				contrasenia2 = new String(password2);
				if(contrasenia2.length()==40) {
					e.consume();
				}
			}
		});
		
		textField_Contrasenia2.setBounds(164, 171, 162, 20);
		textField_Contrasenia2.setEchoChar('*');
		getContentPane().add(textField_Contrasenia2);
		
		
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(contrasenia.length()==0) {
					confirmar = false;
					lblContraseniaError.setVisible(true);
				}
				if(contrasenia2.length()==0) {
					confirmar = false;
					lblContrasenia2Error.setVisible(true);
				}
				
								
				if(confirmar) {
					System.out.println("Todo ok, se actualiza el usuario");
					password = textField_Contrasenia.getPassword();
					contrasenia = new String(password);
					GestorUsuario.getInstance().actualizarUsuario(usuario, contrasenia);
					
					JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.", "Mensaje de éxito", JOptionPane.INFORMATION_MESSAGE);
					Menu menu = new Menu();
					menu.frmMen.setVisible(true);
					dispose();
					
				}
				
			}

		});
		
		btnNewButton.setBounds(300, 262, 129, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu menu = new Menu();
				menu.frmMen.setVisible(true);
			
				dispose();
			}
		});
		btnCancelar.setBounds(5, 262, 95, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblCamposObligatorios = new JLabel("*: Campos obligatorios");
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblCamposObligatorios.setBounds(5, 243, 142, 20);
		getContentPane().add(lblCamposObligatorios);
		
		if(usuario != null) {
			textField_Usuario.setText(usuario.getUsuario());
		}
		
	}
	}


