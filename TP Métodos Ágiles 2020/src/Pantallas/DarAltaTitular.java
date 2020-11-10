package Pantallas;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DarAltaTitular {

	private JFrame frame;
	private JTextField textField_DNI;
	private String dni;
	private boolean dnival;
	private boolean dniUnico;
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
	private String dia;
	private String mes;
	private String anyo;
	private Calendar fecha;
	
	private boolean confirmar;

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
		confirmar= true;
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCrearTitular = new JLabel("Crear titular");
		lblCrearTitular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCrearTitular.setBounds(10, 26, 80, 14);
		frame.getContentPane().add(lblCrearTitular);
		
		JLabel lblDni = new JLabel("DNI*");
		lblDni.setBounds(28, 70, 46, 14);
		frame.getContentPane().add(lblDni);
		
		JLabel lblErrorDNI = new JLabel("DNI inv\u00E1lido");
		lblErrorDNI.setForeground(Color.RED);
		lblErrorDNI.setBounds(256, 67, 116, 14);
		frame.getContentPane().add(lblErrorDNI);
		lblErrorDNI.setVisible(false);
		
		JLabel lblDniunico = new JLabel("DNI ya en uso");
		lblDniunico.setForeground(Color.RED);
		lblDniunico.setBounds(256, 67, 129, 14);
		frame.getContentPane().add(lblDniunico);
		lblDniunico.setVisible(false);
		// !!!!!!!!!!!
		
		// VALIDAR CON GESTOR DNI UNICO
		
		// !!!!!!!!!!!
		textField_DNI = new JTextField();
		textField_DNI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
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
						lblDniunico.setVisible(false);
						lblErrorDNI.setVisible(true);
						confirmar = false;
					}
					else {
						lblErrorDNI.setVisible(false);
						confirmar = true;
					}
				
				dniUnico = GestorTitular.getInstance().verificarDNI(textField_DNI.getText());
				
				if(!dniUnico) {
					//lblDniunico.setText("El DNI ya existe");
					lblErrorDNI.setVisible(false);
					lblDniunico.setVisible(true);
					confirmar = false;
				}else {
					lblDniunico.setVisible(false);
					confirmar = true;
				}
			}
		
				
			}
		);
		textField_DNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_DNI.getText().length()==8) {
					e.consume();
				}
			}		
			});
		
		textField_DNI.setBounds(97, 64, 149, 20);
		frame.getContentPane().add(textField_DNI);
		textField_DNI.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido*");
		lblApellido.setBounds(28, 120, 62, 14);
		frame.getContentPane().add(lblApellido);
		
		JLabel lblerrorapellido = new JLabel("Apellido inv\u00E1lido");
		lblerrorapellido.setForeground(Color.RED);
		lblerrorapellido.setBounds(256, 117, 116, 14);
		frame.getContentPane().add(lblerrorapellido);
		lblerrorapellido.setVisible(false);
		
		textField_Apellido = new JTextField();
		textField_Apellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				apellido = textField_Apellido.getText().toLowerCase().replace(" ", "");
				apellidoval = true;
				if(apellido.length()==0) { apellidoval = false;}
				for(int i = 0; i<apellido.length(); i++) {
					if(!((apellido.charAt(i) >= 'a' && apellido.charAt(i) <= 'z') || (apellido.charAt(i) >= 'á' &&  apellido.charAt(i) <=  'ú') || apellido.charAt(i)=='é' )) {
						lblerrorapellido.setText("Apellido inválido");
						lblerrorapellido.setVisible(true);
						apellidoval = false;
						confirmar = false;
					}
				}
				if(apellidoval) {
					lblerrorapellido.setVisible(false);
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
		
		textField_Apellido.setBounds(97, 114, 149, 20);
		frame.getContentPane().add(textField_Apellido);
		textField_Apellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre*");
		lblNombre.setBounds(28, 164, 62, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblErrornombre = new JLabel("Nombre inv\u00E1lido");
		lblErrornombre.setForeground(Color.RED);
		lblErrornombre.setBounds(256, 161, 116, 14);
		frame.getContentPane().add(lblErrornombre);
		lblErrornombre.setVisible(false);
		
		textField_Nombre = new JTextField();
		textField_Nombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				nombre = textField_Nombre.getText().toLowerCase().replace(" ", "");
				nombreval = true;
				if(nombre.length()==0) { nombreval = false;}
				for(int i = 0; i<nombre.length(); i++) {
					if(!((nombre.charAt(i) >= 'a' && nombre.charAt(i) <= 'z') || (nombre.charAt(i) >= 'á' &&  nombre.charAt(i) <=  'ú') || nombre.charAt(i)=='é' )) {
						lblErrornombre.setText("Nombre inválido");
						lblErrornombre.setVisible(true);
						nombreval = false;
						confirmar = false;
					}
				}
				if(nombreval) {
					lblErrornombre.setVisible(false);
					confirmar = true;
				}
			}
		});
	
		textField_Nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_Nombre.getText().length()==40) {
					e.consume();
				}
			}
		});
		
		textField_Nombre.setBounds(97, 158, 149, 20);
		frame.getContentPane().add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento*");
		lblFechaDeNacimiento.setBounds(28, 230, 129, 14);
		frame.getContentPane().add(lblFechaDeNacimiento);
		
		JComboBox<String> comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(159, 226, 55, 22);
		frame.getContentPane().add(comboBoxDia);
		
		comboBoxDia.addItem("Día");
		for (Integer i = 1; i<32; i++) {
			comboBoxDia.addItem(i.toString());
		}
		
		JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(224, 226, 55, 22);
		frame.getContentPane().add(comboBoxMes);
		
		comboBoxMes.addItem("Mes");
		for (Integer i = 1; i<13; i++) {
			comboBoxMes.addItem(i.toString());
		}
		
		JComboBox<String> comboBoxAnyo = new JComboBox<String>();
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
		
		JLabel lblCalle = new JLabel("Calle*");
		lblCalle.setBounds(413, 76, 46, 14);
		frame.getContentPane().add(lblCalle);
		
		JLabel lblErrorcalle = new JLabel("Calle inv\u00E1lida");
		lblErrorcalle.setForeground(Color.RED);
		lblErrorcalle.setBounds(454, 100, 143, 14);
		frame.getContentPane().add(lblErrorcalle);
		lblErrorcalle.setVisible(false);
		
		textField_Calle = new JTextField();
		textField_Calle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
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
					confirmar = false;
				}
				else {
					lblErrorcalle.setVisible(false);
					confirmar = true;
				}
			}
		});
		textField_Calle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_Calle.getText().length()==50) {
					e.consume();
				}	
			}
		});
		
		textField_Calle.setBounds(454, 73, 160, 20);
		frame.getContentPane().add(textField_Calle);
		textField_Calle.setColumns(10);
		
		JLabel lblN = new JLabel("Nro.*");
		
		lblN.setBounds(624, 76, 46, 14);
		frame.getContentPane().add(lblN);
		
		JLabel lblErrornro = new JLabel("N\u00FAmero inv\u00E1lido");
		lblErrornro.setForeground(Color.RED);
		lblErrornro.setBounds(634, 100, 104, 14);
		frame.getContentPane().add(lblErrornro);
		lblErrornro.setVisible(false);
		
		textField_nro = new JTextField();
		textField_nro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
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
					confirmar = false;
				}
				else {
					lblErrornro.setVisible(false);
					confirmar = true;
				}
			}
		});
		
		textField_nro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_nro.getText().length()==6) {
					e.consume();
				}	
			}
		});
		
		textField_nro.setBounds(663, 73, 46, 20);
		frame.getContentPane().add(textField_nro);
		textField_nro.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(419, 125, 46, 14);
		frame.getContentPane().add(lblPiso);
		
		JLabel ErrorPiso = new JLabel("Piso inv\u00E1lido");
		ErrorPiso.setForeground(Color.RED);
		ErrorPiso.setBounds(454, 150, 80, 14);
		frame.getContentPane().add(ErrorPiso);
		ErrorPiso.setVisible(false);
		
		textField_piso = new JTextField();
		textField_piso.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				piso = textField_piso.getText().toLowerCase();
				pisoval = true;
				
				for(int i = 0; i<piso.length(); i++) {
					if(!((Character.isLetterOrDigit(piso.charAt(i))) || (piso.charAt(i) >= 'á' &&  piso.charAt(i) <=  'ú') || piso.charAt(i)=='é' ))  {
						
						pisoval = false;
					}
				}
				if(pisoval) {
					ErrorPiso.setVisible(false);
					confirmar = true;
			}
				else {
					ErrorPiso.setText("Piso inválido");
					ErrorPiso.setVisible(true);
					confirmar = false;
				}
			}
		});
		textField_piso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_piso.getText().length()==4) {
					e.consume();
				}
			}
		});
		
		textField_piso.setBounds(454, 122, 65, 20);
		frame.getContentPane().add(textField_piso);
		textField_piso.setColumns(10);
		
		
		JLabel lblDpto = new JLabel("Dpto.");
		lblDpto.setBounds(535, 123, 46, 14);
		frame.getContentPane().add(lblDpto);
		
		JLabel lblErrordepto = new JLabel("Depto inv\u00E1lido");
		lblErrordepto.setForeground(Color.RED);
		lblErrordepto.setBounds(587, 150, 83, 14);
		frame.getContentPane().add(lblErrordepto);
		lblErrordepto.setVisible(false);
		
		textField_depto = new JTextField();
		textField_depto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				depto = textField_depto.getText().toLowerCase();
				deptoval = true;
				
				for(int i = 0; i<depto.length(); i++) {
					if(!((Character.isLetterOrDigit(depto.charAt(i))) || (depto.charAt(i) >= 'á' &&  depto.charAt(i) <=  'ú') || depto.charAt(i)=='é' ))  {
						
						deptoval = false;
					}
				}
				if(deptoval) {
					lblErrordepto.setVisible(false);
					confirmar = true;
			}
				else {
					lblErrordepto.setText("Piso inválido");
					lblErrordepto.setVisible(true);
					confirmar = false;
				}
			}
		});
		textField_depto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_depto.getText().length()==4) {
					e.consume();
				}
			}
		});
		
		
		textField_depto.setBounds(587, 122, 46, 20);
		frame.getContentPane().add(textField_depto);
		textField_depto.setColumns(10);
		
		JLabel lblGrupoSanguneo = new JLabel("Grupo Sangu\u00EDneo*");
		lblGrupoSanguneo.setBounds(403, 190, 109, 14);
		frame.getContentPane().add(lblGrupoSanguneo);
		
		 String[] grupoS = new String[] {"A", "B", "AB", "O"};
		JComboBox<String> comboBoxGrupoS = new JComboBox<String>(grupoS);
		comboBoxGrupoS.setBounds(553, 186, 80, 22);
		frame.getContentPane().add(comboBoxGrupoS);
		
 		JLabel lblFactorRh = new JLabel("Factor RH*");
		lblFactorRh.setBounds(403, 229, 109, 14);
		frame.getContentPane().add(lblFactorRh);
		
		String[] factorRH = new String[] {"Positivo","Negativo"};
		JComboBox<String> comboBoxFactor = new JComboBox<String>(factorRH);
		comboBoxFactor.setBounds(553, 225, 80, 22);
		frame.getContentPane().add(comboBoxFactor);
		
		JCheckBox chckbxDonanteDeOrganos = new JCheckBox("Donante de \u00F3rganos");
		chckbxDonanteDeOrganos.setBounds(403, 267, 149, 23);
		frame.getContentPane().add(chckbxDonanteDeOrganos);
		
		JLabel lblErrorFecha = new JLabel("Fecha inv\u00E1lida");
		lblErrorFecha.setForeground(Color.RED);
		lblErrorFecha.setBounds(28, 258, 174, 14);
		frame.getContentPane().add(lblErrorFecha);
		lblErrorFecha.setVisible(false);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dia = comboBoxDia.getSelectedItem().toString();
				mes = comboBoxMes.getSelectedItem().toString();
				anyo = comboBoxAnyo.getSelectedItem().toString();
				lblErrorFecha.setVisible(false);
				
				if(dia.compareTo("Día")==0 || mes.compareTo("Mes")==0 || anyo.compareTo("Año")==0) {
					lblErrorFecha.setVisible(true);
					confirmar = false;
				
				}else{
				
					try {
					
						fecha = Calendar.getInstance();
						fecha.setLenient(false);
						fecha.set(Integer.parseInt(anyo),Integer.parseInt(mes)-1, Integer.parseInt(dia));
						confirmar = true;
						System.out.println("dia= "+fecha.get(Calendar.DAY_OF_MONTH)+" mes= "+fecha.get(Calendar.MONTH)+" año= "+fecha.get(Calendar.YEAR));
					}catch(Exception a) {
						confirmar= false;
						lblErrorFecha.setVisible(true);	
					}
				}
				
				if(textField_DNI.getText().length()==0) {
					confirmar = false;
					lblErrorDNI.setVisible(true);
				}
				if(textField_Apellido.getText().length()==0) {
					confirmar = false;
					lblerrorapellido.setVisible(true);
				}
				if(textField_Nombre.getText().length()==0) {
					confirmar = false;
					lblErrornombre.setVisible(true);
				}
				if(textField_Calle.getText().length()==0) {
					confirmar = false;
					lblErrorcalle.setVisible(true);
				}
				if(textField_nro.getText().length()==0) {
					confirmar = false;
					lblErrornro.setVisible(true);
				}
					
				
				if(confirmar) {
					System.out.println("Todo ok, se crea el titular");
					GestorTitular.getInstance().crearTitular(textField_DNI.getText(), textField_Apellido.getText(), textField_Nombre.getText(), textField_Calle.getText(), textField_nro.getText(), 
							textField_depto.getText(),textField_piso.getText(),fecha,comboBoxGrupoS.getSelectedItem().toString(), comboBoxFactor.getSelectedItem().toString(),chckbxDonanteDeOrganos.isSelected());
				}else {
					System.out.println("Hay algun error en algun lado(?");
				}
				
			}

		});
		
		btnNewButton.setBounds(624, 319, 129, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 319, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblCamposObligatorios = new JLabel("*: Campos obligatorios");
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblCamposObligatorios.setBounds(126, 321, 251, 18);
		frame.getContentPane().add(lblCamposObligatorios);
		
		
		
	
		//
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
