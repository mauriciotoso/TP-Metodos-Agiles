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

public class DarAltaTitular extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	//JFrame frame;
	private JTextField textField_DNI;
	private String dni;
	private boolean dnival,deptoval, pisoval, dniUnico, calleval, nroval, apellidoval, nombreval, fechaval;
	private boolean confirmar;
	
	private JTextField textField_Apellido;
	private String apellido;
	
	private JTextField textField_Nombre;
	private String nombre;
	
	private JTextField textField_Calle;
	private String calle;
	
	private JTextField textField_nro;
	private String nro;
	private JTextField textField_piso;
	private String piso;
	
	private JTextField textField_depto;
	private String depto;

	private String dia;
	private String mes;
	private String anyo;
	private Calendar fecha;
	
	private int pantalla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarAltaTitular window = new DarAltaTitular(-1);
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
	public DarAltaTitular(int pantalla) {
		initialize();
		this.pantalla=pantalla;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		confirmar= true;
		dnival = true;
		deptoval= true;
		pisoval = true;
		dniUnico = true;
		calleval = true;
		nroval = true;
		apellidoval = true;
		nombreval = true;
		fechaval = true;
		
		
		setTitle("Dar de Alta a Titular");
		setBounds(100, 100, 779, 391);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblCrearTitular = new JLabel("Crear titular");
		lblCrearTitular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCrearTitular.setBounds(10, 26, 80, 14);
		getContentPane().add(lblCrearTitular);
		
		JLabel lblDni = new JLabel("DNI*");
		lblDni.setBounds(28, 73, 46, 14);
		getContentPane().add(lblDni);
		
		JLabel lblErrorDNI = new JLabel("DNI inv\u00E1lido");
		lblErrorDNI.setForeground(Color.RED);
		lblErrorDNI.setBounds(256, 70, 116, 14);
		getContentPane().add(lblErrorDNI);
		lblErrorDNI.setVisible(false);
		
		JLabel lblDniunico = new JLabel("DNI ya en uso");
		lblDniunico.setForeground(Color.RED);
		lblDniunico.setBounds(256, 70, 129, 14);
		getContentPane().add(lblDniunico);
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
					dniUnico = false;
				}else {
					lblDniunico.setVisible(false);
					dniUnico = true;
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
		
		textField_DNI.setBounds(97, 67, 149, 20);
		getContentPane().add(textField_DNI);
		textField_DNI.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido*");
		lblApellido.setBounds(28, 108, 62, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblerrorapellido = new JLabel("Apellido inv\u00E1lido");
		lblerrorapellido.setForeground(Color.RED);
		lblerrorapellido.setBounds(256, 108, 116, 14);
		getContentPane().add(lblerrorapellido);
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
						
					}
				}
				if(apellidoval) {
					lblerrorapellido.setVisible(false);
					confirmar = true;
				}else {
					confirmar = false;
					lblerrorapellido.setVisible(true);
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
		
		textField_Apellido.setBounds(97, 105, 149, 20);
		getContentPane().add(textField_Apellido);
		textField_Apellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre*");
		lblNombre.setBounds(28, 150, 62, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblErrornombre = new JLabel("Nombre inv\u00E1lido");
		lblErrornombre.setForeground(Color.RED);
		lblErrornombre.setBounds(256, 147, 116, 14);
		getContentPane().add(lblErrornombre);
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
				}else {
					lblErrornombre.setVisible(true);
					confirmar = false;}
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
		
		textField_Nombre.setBounds(97, 144, 149, 20);
		getContentPane().add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento*");
		lblFechaDeNacimiento.setBounds(28, 230, 129, 14);
		getContentPane().add(lblFechaDeNacimiento);
		
		JComboBox<String> comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(159, 226, 55, 22);
		getContentPane().add(comboBoxDia);
		
		comboBoxDia.addItem("Día");
		for (Integer i = 1; i<32; i++) {
			comboBoxDia.addItem(i.toString());
		}
		
		JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(224, 226, 55, 22);
		getContentPane().add(comboBoxMes);
		
		comboBoxMes.addItem("Mes");
		for (Integer i = 1; i<13; i++) {
			comboBoxMes.addItem(i.toString());
		}
		
		JComboBox<String> comboBoxAnyo = new JComboBox<String>();
		comboBoxAnyo.setBounds(289, 226, 65, 22);
		getContentPane().add(comboBoxAnyo);
		
		comboBoxAnyo.addItem("Año");
		for (Integer i = 2020; i>1919; i--) {
			comboBoxAnyo.addItem(i.toString());
		}
		
		
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(403, 46, 58, 14);
		getContentPane().add(lblDireccion);
		
		JLabel lblCalle = new JLabel("Calle*");
		lblCalle.setBounds(413, 76, 46, 14);
		getContentPane().add(lblCalle);
		
		JLabel lblErrorcalle = new JLabel("Calle inv\u00E1lida");
		lblErrorcalle.setForeground(Color.RED);
		lblErrorcalle.setBounds(454, 100, 143, 14);
		getContentPane().add(lblErrorcalle);
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
		getContentPane().add(textField_Calle);
		textField_Calle.setColumns(10);
		
		JLabel lblN = new JLabel("Nro.*");
		
		lblN.setBounds(624, 76, 46, 14);
		getContentPane().add(lblN);
		
		JLabel lblErrornro = new JLabel("N\u00FAmero inv\u00E1lido");
		lblErrornro.setForeground(Color.RED);
		lblErrornro.setBounds(634, 100, 104, 14);
		getContentPane().add(lblErrornro);
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
		getContentPane().add(textField_nro);
		textField_nro.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(419, 125, 46, 14);
		getContentPane().add(lblPiso);
		
		JLabel ErrorPiso = new JLabel("Piso inv\u00E1lido");
		ErrorPiso.setForeground(Color.RED);
		ErrorPiso.setBounds(454, 150, 80, 14);
		getContentPane().add(ErrorPiso);
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
		getContentPane().add(textField_piso);
		textField_piso.setColumns(10);
		
		
		JLabel lblDpto = new JLabel("Dpto.");
		lblDpto.setBounds(535, 123, 46, 14);
		getContentPane().add(lblDpto);
		
		JLabel lblErrordepto = new JLabel("Depto inv\u00E1lido");
		lblErrordepto.setForeground(Color.RED);
		lblErrordepto.setBounds(587, 150, 83, 14);
		getContentPane().add(lblErrordepto);
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
		getContentPane().add(textField_depto);
		textField_depto.setColumns(10);
		
		JLabel lblGrupoSanguneo = new JLabel("Grupo Sangu\u00EDneo*");
		lblGrupoSanguneo.setBounds(403, 190, 109, 14);
		getContentPane().add(lblGrupoSanguneo);
		

		JComboBox<String> comboBoxGrupoS = new JComboBox<String>();
		comboBoxGrupoS.addItem("A");
		comboBoxGrupoS.addItem("B");
		comboBoxGrupoS.addItem("AB");
		comboBoxGrupoS.addItem("O");
		comboBoxGrupoS.setBounds(553, 186, 117, 22);
		getContentPane().add(comboBoxGrupoS);
		
 		JLabel lblFactorRh = new JLabel("Factor RH*");
		lblFactorRh.setBounds(403, 229, 109, 14);
		getContentPane().add(lblFactorRh);
		
		
		JComboBox<String> comboBoxFactor = new JComboBox<String>();
		comboBoxFactor.addItem("POSITIVO");
		comboBoxFactor.addItem("NEGATIVO");
		comboBoxFactor.setBounds(553, 225, 117, 22);
		getContentPane().add(comboBoxFactor);
		
		JCheckBox chckbxDonanteDeOrganos = new JCheckBox("Donante de \u00F3rganos");
		chckbxDonanteDeOrganos.setBounds(403, 267, 149, 23);
		getContentPane().add(chckbxDonanteDeOrganos);
		
		JLabel lblErrorFecha = new JLabel("Fecha inv\u00E1lida");
		lblErrorFecha.setForeground(Color.RED);
		lblErrorFecha.setBounds(28, 258, 174, 14);
		getContentPane().add(lblErrorFecha);
		lblErrorFecha.setVisible(false);
		
		JComboBox<String> comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setBounds(97, 182, 149, 22);
		getContentPane().add(comboBoxSexo);
		comboBoxSexo.addItem("FEMENINO");
		comboBoxSexo.addItem("MASCULINO");
		comboBoxSexo.addItem("OTRO");
		
		JLabel lblSexo = new JLabel("Sexo*");
		lblSexo.setBounds(28, 186, 62, 14);
		getContentPane().add(lblSexo);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dia = comboBoxDia.getSelectedItem().toString();
				mes = comboBoxMes.getSelectedItem().toString();
				anyo = comboBoxAnyo.getSelectedItem().toString();
				lblErrorFecha.setVisible(false);
				
				if(dia.compareTo("Día")==0 || mes.compareTo("Mes")==0 || anyo.compareTo("Año")==0) {
					lblErrorFecha.setVisible(true);
					fechaval = false;
				
				}else{
				
					try {
					
						fecha = Calendar.getInstance();
						fecha.setLenient(false);
						fecha.set(Integer.parseInt(anyo),Integer.parseInt(mes)-1, Integer.parseInt(dia));
						fechaval = true;
						System.out.println("dia= "+fecha.get(Calendar.DAY_OF_MONTH)+" mes= "+fecha.get(Calendar.MONTH)+" año= "+fecha.get(Calendar.YEAR));
					}catch(Exception a) {
						fechaval= false;
						lblErrorFecha.setVisible(true);	
					}
				}
				
				if(textField_DNI.getText().length()==0) {
					dnival = false;
					lblErrorDNI.setVisible(true);
				}
				if(textField_Apellido.getText().length()==0) {
					apellidoval = false;
					lblerrorapellido.setVisible(true);
				}
				if(textField_Nombre.getText().length()==0) {
					nombreval = false;
					lblErrornombre.setVisible(true);
				}
				if(textField_Calle.getText().length()==0) {
					calleval = false;
					lblErrorcalle.setVisible(true);
				}
				if(textField_nro.getText().length()==0) {
					nroval = false;
					lblErrornro.setVisible(true);
				}
				
				
				if(dnival && deptoval && pisoval && dniUnico && calleval && nroval && apellidoval && nombreval && fechaval) {
					System.out.println("Todo ok, se crea el titular");
					GestorTitular.getInstance().crearTitular(textField_DNI.getText(), textField_Apellido.getText(), textField_Nombre.getText(), textField_Calle.getText(), textField_nro.getText(), 
							textField_depto.getText(),textField_piso.getText(),fecha,comboBoxGrupoS.getSelectedItem().toString(), comboBoxFactor.getSelectedItem().toString(),chckbxDonanteDeOrganos.isSelected(),
							comboBoxSexo.getSelectedItem().toString());
					if(pantalla==0) {
						Menu menu = new Menu();
						menu.frmMen.setVisible(true);
					}else {
						BuscarTitular buscar = new BuscarTitular(pantalla);
						buscar.setVisible(true);
					}
					dispose();
				}else {
					System.out.println("Hay algun error en algun lado(?");
				}
				
			}

		});
		
		btnNewButton.setBounds(624, 319, 129, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pantalla==0) {
					Menu menu = new Menu();
					menu.frmMen.setVisible(true);
				}else {
					BuscarTitular buscar = new BuscarTitular(pantalla);
					buscar.setVisible(true);
				}
				
				dispose();
			}
		});
		btnCancelar.setBounds(10, 319, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblCamposObligatorios = new JLabel("*: Campos obligatorios");
		lblCamposObligatorios.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblCamposObligatorios.setBounds(126, 321, 251, 18);
		getContentPane().add(lblCamposObligatorios);
		
	}
}
