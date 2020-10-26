package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DarAltaTitular {

	private JFrame frame;
	private JTextField textField_DNI;
	private String dni;
	private boolean dnival;
	private JTextField textField_Apellido;
	private String apellido;
	private boolean apellidoval;
	private JTextField textField_Nombre;
	private String nombre;
	private boolean nombreval;
	private JTextField textField_Calle;
	private String calle;
	private boolean calleval;
	private JTextField textField_nro;
	private String nro;
	private boolean nroval;
	private JTextField textField_piso;
	private String piso;
	private boolean pisoval;
	private JTextField textField_depto;
	private String depto;
	private boolean deptoval;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarAltaTitular window = new DarAltaTitular();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DarAltaTitular() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCrearTitular = new JLabel("Crear titular");
		lblCrearTitular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCrearTitular.setBounds(10, 26, 80, 14);
		frame.getContentPane().add(lblCrearTitular);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(28, 70, 46, 14);
		frame.getContentPane().add(lblDni);
		
		JLabel lblErrorDNI = new JLabel("New label");
		lblErrorDNI.setForeground(Color.RED);
		lblErrorDNI.setBounds(238, 70, 116, 14);
		frame.getContentPane().add(lblErrorDNI);
		lblErrorDNI.setVisible(false);
		
		textField_DNI = new JTextField();
		textField_DNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_DNI.getText().length()==8) {
					e.consume();
				}
			}
		});
		textField_DNI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				dnival = true;
				if(textField_DNI.getText().length()<7) {
					dnival = false;
				}
				dni = textField_DNI.getText();
				for(int i = 0; i<dni.length(); i++) {
					if(!(Character.isDigit(dni.charAt(i)))) {
						dnival = false;
					}
				}
				if(!dnival) {
					lblErrorDNI.setText("DNI inválido");
					lblErrorDNI.setVisible(true);
				}
				else {
					lblErrorDNI.setVisible(false);
				}
			}
		});
		
		textField_DNI.setBounds(79, 67, 149, 20);
		frame.getContentPane().add(textField_DNI);
		textField_DNI.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(28, 120, 46, 14);
		frame.getContentPane().add(lblApellido);
		
		JLabel lblerrorapellido = new JLabel("lblErrorApellido");
		lblerrorapellido.setForeground(Color.RED);
		lblerrorapellido.setBounds(238, 120, 116, 14);
		frame.getContentPane().add(lblerrorapellido);
		lblerrorapellido.setVisible(false);
		
		textField_Apellido = new JTextField();
		textField_Apellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_Apellido.getText().length()==30) {
					e.consume();
				}
			}
		});
		
		textField_Apellido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				apellido = textField_Apellido.getText().toLowerCase().replace(" ", "");
				apellidoval = true;
				if(apellido.length()==0) { apellidoval = false;}
				for(int i = 0; i<apellido.length(); i++) {
					if(!((apellido.charAt(i) >= 'a' && apellido.charAt(i) <= 'z') || (apellido.charAt(i) >= 'á' &&  apellido.charAt(i) <=  'ú') || apellido.charAt(i)=='é' )) {
						lblerrorapellido.setText("Apellido inválido");
						lblerrorapellido.setVisible(true);
						apellidoval = false;
					}
				}
				if(apellidoval) {
					lblerrorapellido.setVisible(false);
				}
			}
		});
		textField_Apellido.setBounds(79, 117, 149, 20);
		frame.getContentPane().add(textField_Apellido);
		textField_Apellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(28, 164, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblErrornombre = new JLabel("ErrorNombre");
		lblErrornombre.setForeground(Color.RED);
		lblErrornombre.setBounds(238, 164, 116, 14);
		frame.getContentPane().add(lblErrornombre);
		lblErrornombre.setVisible(false);
		
		textField_Nombre = new JTextField();
	
		textField_Nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_Nombre.getText().length()==40) {
					e.consume();
				}
			}
		});
		
		textField_Nombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				nombre = textField_Nombre.getText().toLowerCase().replace(" ", "");
				nombreval = true;
				if(nombre.length()==0) { nombreval = false;}
				for(int i = 0; i<nombre.length(); i++) {
					if(!((nombre.charAt(i) >= 'a' && nombre.charAt(i) <= 'z') || (nombre.charAt(i) >= 'á' &&  nombre.charAt(i) <=  'ú') || nombre.charAt(i)=='é' )) {
						lblErrornombre.setText("Nombre inválido");
						lblErrornombre.setVisible(true);
						nombreval = false;
					}
				}
				if(nombreval) {
					lblErrornombre.setVisible(false);
				}
			}
		});
		
		textField_Nombre.setBounds(79, 161, 149, 20);
		frame.getContentPane().add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(28, 230, 129, 14);
		frame.getContentPane().add(lblFechaDeNacimiento);
		
		JComboBox<String> comboBoxDia = new JComboBox();
		comboBoxDia.setBounds(159, 226, 55, 22);
		frame.getContentPane().add(comboBoxDia);
		
		comboBoxDia.addItem("Día");
		for (Integer i = 1; i<32; i++) {
			comboBoxDia.addItem(i.toString());
		}
		
		JComboBox<String> comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(224, 226, 55, 22);
		frame.getContentPane().add(comboBoxMes);
		
		comboBoxMes.addItem("Mes");
		for (Integer i = 1; i<13; i++) {
			comboBoxMes.addItem(i.toString());
		}
		
		JComboBox<String> comboBoxAnyo = new JComboBox();
		comboBoxAnyo.setBounds(289, 226, 65, 22);
		frame.getContentPane().add(comboBoxAnyo);
		
		comboBoxAnyo.addItem("Año");
		for (Integer i = 2020; i>1919; i--) {
			comboBoxAnyo.addItem(i.toString());
		}
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(403, 46, 58, 14);
		frame.getContentPane().add(lblDireccion);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(413, 76, 46, 14);
		frame.getContentPane().add(lblCalle);
		
		JLabel lblErrorcalle = new JLabel("ErrorCalle");
		lblErrorcalle.setForeground(Color.RED);
		lblErrorcalle.setBounds(454, 100, 143, 14);
		frame.getContentPane().add(lblErrorcalle);
		lblErrorcalle.setVisible(false);
		
		textField_Calle = new JTextField();
		textField_Calle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_Calle.getText().length()==50) {
					e.consume();
				}
				calle = textField_Calle.getText().replace(" ", "");
				calleval = true;
				
				if(calle.length()==0) { calleval = false;}
				for(int i = 0; i<calle.length(); i++) {
					if(!((Character.isLetterOrDigit(calle.charAt(i))) || (calle.charAt(i) >= 'á' &&  calle.charAt(i) <=  'ú') || calle.charAt(i)=='é' ))  {
						calleval = false;
					}
					
				}
				
				if(!calleval) {
					lblErrorcalle.setText("Calle inválida");
					lblErrorcalle.setVisible(true);
				}
				else {
					lblErrorcalle.setVisible(false);
				}
				
			}
		});
		
		textField_Calle.setBounds(454, 73, 160, 20);
		frame.getContentPane().add(textField_Calle);
		textField_Calle.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00B0");
		
		lblN.setBounds(624, 76, 46, 14);
		frame.getContentPane().add(lblN);
		
		JLabel lblErrornro = new JLabel("ErrorNro");
		lblErrornro.setForeground(Color.RED);
		lblErrornro.setBounds(624, 100, 104, 14);
		frame.getContentPane().add(lblErrornro);
		lblErrornro.setVisible(false);
		
		textField_nro = new JTextField();
		
		textField_nro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_nro.getText().length()==6) {
					e.consume();
				}
			}
		});
		
		textField_nro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
					nro = textField_nro.getText();
					nroval = true;
					
					if(nro.length()==0) { nroval = false;}
					
					for(int i = 0; i<nro.length(); i++) {
						if(!(Character.isDigit(nro.charAt(i)))){
							nroval = false;
						}
					}
					if(!nroval) {
						lblErrornro.setText("Número inválido");
						lblErrornro.setVisible(true);
					}
					else {
						lblErrornro.setVisible(false);
					}
				}
			}
		);
		textField_nro.setBounds(645, 73, 46, 20);
		frame.getContentPane().add(textField_nro);
		textField_nro.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(419, 125, 46, 14);
		frame.getContentPane().add(lblPiso);
		
		JLabel ErrorPiso = new JLabel("New label");
		ErrorPiso.setForeground(Color.RED);
		ErrorPiso.setBounds(454, 150, 80, 14);
		frame.getContentPane().add(ErrorPiso);
		ErrorPiso.setVisible(false);
		
		textField_piso = new JTextField();
		textField_piso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_piso.getText().length()==4) {
					e.consume();
				}
			}
		});
		
		textField_piso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				piso = textField_piso.getText().toLowerCase();
				pisoval = true;
				
				for(int i = 0; i<piso.length(); i++) {
					if(!((Character.isLetterOrDigit(piso.charAt(i))) || (piso.charAt(i) >= 'á' &&  piso.charAt(i) <=  'ú') || piso.charAt(i)=='é' ))  {
						
						pisoval = false;
					}
				}
				if(pisoval) {
					ErrorPiso.setVisible(false);	
			}
				else {
					ErrorPiso.setText("Piso inválido");
					ErrorPiso.setVisible(true);
				}
			}
		});
		textField_piso.setBounds(454, 122, 65, 20);
		frame.getContentPane().add(textField_piso);
		textField_piso.setColumns(10);
		
		
		JLabel lblDpto = new JLabel("Dpto.");
		lblDpto.setBounds(535, 123, 46, 14);
		frame.getContentPane().add(lblDpto);
		
		JLabel lblErrordepto = new JLabel("ErrorDepto");
		lblErrordepto.setForeground(Color.RED);
		lblErrordepto.setBounds(587, 150, 83, 14);
		frame.getContentPane().add(lblErrordepto);
		lblErrordepto.setVisible(false);
		
		textField_depto = new JTextField();
		textField_depto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_depto.getText().length()==4) {
					e.consume();
				}
			}
		});
		
		textField_depto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				depto = textField_depto.getText().toLowerCase();
				deptoval = true;
				
				for(int i = 0; i<depto.length(); i++) {
					if(!((Character.isLetterOrDigit(depto.charAt(i))) || (depto.charAt(i) >= 'á' &&  depto.charAt(i) <=  'ú') || depto.charAt(i)=='é' ))  {
						
						deptoval = false;
					}
				}
				if(deptoval) {
					lblErrordepto.setVisible(false);	
			}
				else {
					lblErrordepto.setText("Piso inválido");
					lblErrordepto.setVisible(true);
				}
			}
		});
		
		textField_depto.setBounds(587, 122, 46, 20);
		frame.getContentPane().add(textField_depto);
		textField_depto.setColumns(10);
		
		JLabel lblGrupoSanguneo = new JLabel("Grupo Sangu\u00EDneo");
		lblGrupoSanguneo.setBounds(403, 190, 109, 14);
		frame.getContentPane().add(lblGrupoSanguneo);
		
		 String[] grupoS = new String[] {"A", "B", "AB", "O"};
		JComboBox<String> comboBoxGrupoS = new JComboBox(grupoS);
		comboBoxGrupoS.setBounds(553, 186, 80, 22);
		frame.getContentPane().add(comboBoxGrupoS);
		
 		JLabel lblFactorRh = new JLabel("Factor RH");
		lblFactorRh.setBounds(403, 229, 58, 14);
		frame.getContentPane().add(lblFactorRh);
		
		String[] factorRH = new String[] {"Positivo","Negativo"};
		JComboBox<String> comboBoxFactor = new JComboBox(factorRH);
		comboBoxFactor.setBounds(553, 225, 80, 22);
		frame.getContentPane().add(comboBoxFactor);
		
		JCheckBox chckbxDonanteDeOrganos = new JCheckBox("Donante de \u00F3rganos");
		chckbxDonanteDeOrganos.setBounds(403, 267, 149, 23);
		frame.getContentPane().add(chckbxDonanteDeOrganos);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(624, 319, 129, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 319, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
