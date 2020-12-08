package Pantallas;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	
	private JTextField textField_Contrasenia;
	private String contrasenia;
	private boolean contraseniaval;
	private JTextField textField_Contrasenia2;
	private String contrasenia2;
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
		
		setTitle("Dar de Alta a Titular");
		setBounds(100, 100, 400, 332);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblCrearTitular = new JLabel("Crear titular");
		lblCrearTitular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCrearTitular.setBounds(10, 26, 80, 14);
		getContentPane().add(lblCrearTitular);
		
		JLabel lblUsuario = new JLabel("Usuario*");
		lblUsuario.setBounds(28, 73, 46, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblUsuarioError = new JLabel("Debe contener entre 4 y 20 caracteres");
		lblUsuarioError.setForeground(Color.RED);
		lblUsuarioError.setBounds(134, 100, 214, 14);
		getContentPane().add(lblUsuarioError);
		lblUsuarioError.setVisible(false);
		
		JLabel lblUsuarioExistente = new JLabel("El nombre de Usuario ya existe");
		lblUsuarioExistente.setForeground(Color.RED);
		lblUsuarioExistente.setBounds(134, 97, 214, 20);
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
						//lblDniunico.setText("El DNI ya existe");
						//lblUsuarioError.setVisible(false);
						lblUsuarioExistente.setVisible(true);
						confirmar = false;
					}else {
						lblUsuarioExistente.setVisible(false);
						//lblUsuarioError.setVisible(false);
						confirmar = true;
					}
				}
			}
		
				
			}
		);
		
		/*textField_Usuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_Usuario.getText().length()==8) {
					e.consume();
				}
			}		
			});*/
		
		textField_Usuario.setBounds(134, 73, 162, 20);
		getContentPane().add(textField_Usuario);
		textField_Usuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrasenia*");
		lblContrasenia.setBounds(28, 121, 62, 14);
		getContentPane().add(lblContrasenia);
		
		JLabel lblContraseniaError = new JLabel("Debe contener entre 8 y 20 caracteres");
		lblContraseniaError.setForeground(Color.RED);
		lblContraseniaError.setBounds(134, 152, 116, 14);
		getContentPane().add(lblContraseniaError);
		lblContraseniaError.setVisible(false);
		
		textField_Contrasenia = new JTextField();
		textField_Contrasenia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				contrasenia = textField_Contrasenia.getText();
				contraseniaval = true;
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
				if(textField_Contrasenia.getText().length()==30) {
					e.consume();
				}
			}
		}
		);
		
		textField_Contrasenia.setBounds(134, 124, 162, 20);
		getContentPane().add(textField_Contrasenia);
		textField_Contrasenia.setColumns(10);
		
		JLabel lblContrasenia2 = new JLabel("Repita la Contrase\u00F1a*");
		lblContrasenia2.setBounds(28, 176, 116, 14);
		getContentPane().add(lblContrasenia2);
		
		JLabel lblContrasenia2Error = new JLabel("Las contrase\u00F1as no coinciden");
		lblContrasenia2Error.setForeground(Color.RED);
		lblContrasenia2Error.setBounds(134, 194, 162, 14);
		getContentPane().add(lblContrasenia2Error);
		lblContrasenia2Error.setVisible(false);
		
		textField_Contrasenia2 = new JTextField();
		textField_Contrasenia2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				contrasenia2 = textField_Contrasenia2.getText();
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
				if(textField_Contrasenia2.getText().length()==40) {
					e.consume();
				}
			}
		});
		
		textField_Contrasenia2.setBounds(134, 171, 162, 20);
		getContentPane().add(textField_Contrasenia2);
		
		
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				if(textField_Usuario.getText().length()==0) {
					confirmar = false;
					lblUsuarioError.setVisible(true);
				}
				if(textField_Contrasenia.getText().length()==0) {
					confirmar = false;
					lblContraseniaError.setVisible(true);
				}
				if(textField_Contrasenia2.getText().length()==0) {
					confirmar = false;
					lblContrasenia2Error.setVisible(true);
				}
				
								
				if(confirmar) {
					System.out.println("Todo ok, se crea el usuario");
					GestorUsuario.getInstance().guardarUsuario(textField_Usuario.getText(), textField_Contrasenia.getText());
					
					JOptionPane.showMessageDialog(null, "Usuario creado", "Mensaje de �xito", JOptionPane.INFORMATION_MESSAGE);
					Menu menu = new Menu();
					menu.frmMen.setVisible(true);
					dispose();
					
				}
				
			}

		});
		
		btnNewButton.setBounds(219, 242, 129, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu menu = new Menu();
				menu.frmMen.setVisible(true);
			
				dispose();
			}
		});
		btnCancelar.setBounds(10, 242, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblCamposObligatorios = new JLabel("*: Campos obligatorios");
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblCamposObligatorios.setBounds(97, 247, 251, 18);
		getContentPane().add(lblCamposObligatorios);
		
	}
}
