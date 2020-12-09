package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Entidades.Titular;
import Logica.GestorTitular;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ModificarTitular extends JFrame {

	private JPanel contentPane;
	
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
	private int pantalla;
	private Titular titular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarTitular frame = new ModificarTitular();
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
	public ModificarTitular() {
		initialize();
	}
	
	public ModificarTitular(Titular titularEncontrado) {
		this.titular = titularEncontrado;
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnBuscar = new JButton("Buscar Titular");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarTitular buscar = new BuscarTitular(10);
				buscar.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setBounds(226, 19, 115, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblSeleccioneTitular_2 = new JLabel("Seleccione un titular existente");
		lblSeleccioneTitular_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSeleccioneTitular_2.setBounds(31, 23, 195, 13);
		contentPane.add(lblSeleccioneTitular_2);
		
		JLabel lblDni = new JLabel("DNI*");
		lblDni.setBounds(28, 73, 46, 14);
		getContentPane().add(lblDni);
		
		textField_DNI = new JTextField();
		
		textField_DNI.setBounds(97, 67, 149, 20);
		getContentPane().add(textField_DNI);
		textField_DNI.setColumns(10);
		textField_DNI.setEditable(false);
		
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
		
		comboBoxDia.setEnabled(false);
		
		JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(224, 226, 55, 22);
		getContentPane().add(comboBoxMes);
		
		comboBoxMes.addItem("Mes");
		for (Integer i = 1; i<13; i++) {
			comboBoxMes.addItem(i.toString());
		}
		
		comboBoxMes.setEnabled(false);
		
		JComboBox<String> comboBoxAnyo = new JComboBox<String>();
		comboBoxAnyo.setBounds(289, 226, 65, 22);
		getContentPane().add(comboBoxAnyo);
		
		comboBoxAnyo.addItem("Año");
		for (Integer i = 2020; i>1919; i--) {
			comboBoxAnyo.addItem(i.toString());
		}
		
		comboBoxAnyo.setEnabled(false);
		
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(403, 46, 58, 14);
		getContentPane().add(lblDireccion);
		
		JLabel lblCalle = new JLabel("Calle y nro.*");
		lblCalle.setBounds(413, 76, 72, 14);
		getContentPane().add(lblCalle);
		
		JLabel lblErrorcalle = new JLabel("Calle inv\u00E1lida");
		lblErrorcalle.setForeground(Color.RED);
		lblErrorcalle.setBounds(495, 97, 143, 14);
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
		
		textField_Calle.setBounds(495, 70, 195, 20);
		getContentPane().add(textField_Calle);
		textField_Calle.setColumns(10);
		
		
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
		
		comboBoxGrupoS.setEnabled(false);
 		
		JLabel lblFactorRh = new JLabel("Factor RH*");
		lblFactorRh.setBounds(403, 229, 109, 14);
		getContentPane().add(lblFactorRh);
		
		
		JComboBox<String> comboBoxFactor = new JComboBox<String>();
		comboBoxFactor.addItem("POSITIVO");
		comboBoxFactor.addItem("NEGATIVO");
		comboBoxFactor.setBounds(553, 225, 117, 22);
		getContentPane().add(comboBoxFactor);
		
		
		comboBoxFactor.setEnabled(false);
		
		JCheckBox chckbxDonanteDeOrganos = new JCheckBox("Donante de \u00F3rganos");
		chckbxDonanteDeOrganos.setBounds(403, 267, 149, 23);
		getContentPane().add(chckbxDonanteDeOrganos);
			
		
		JComboBox<String> comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setBounds(97, 182, 149, 22);
		getContentPane().add(comboBoxSexo);
		comboBoxSexo.addItem("FEMENINO");
		comboBoxSexo.addItem("MASCULINO");
		comboBoxSexo.addItem("OTRO");
		
		
		JLabel lblSexo = new JLabel("Sexo*");
		lblSexo.setBounds(28, 186, 62, 14);
		getContentPane().add(lblSexo);
		
		if(titular != null) {
			comboBoxSexo.setSelectedItem(titular.getSexo().toString());
			if(titular.isEsDonante()) chckbxDonanteDeOrganos.setSelected(true);	
			if(titular.isFactorRH()) {
				comboBoxFactor.setSelectedItem("POSITIVO");
			}else { comboBoxFactor.setSelectedItem("NEGATIVO");}
			comboBoxGrupoS.setSelectedItem(titular.getGrupoSanguineo().toString());
			textField_piso.setText(titular.getPiso());
			textField_depto.setText(titular.getDepto());
			textField_Calle.setText(titular.getDireccion());
			comboBoxAnyo.setSelectedItem(Integer.toString(titular.getFechaNacimiento().get(Calendar.YEAR)));
			textField_DNI.setText(titular.getDni());
			textField_Apellido.setText(titular.getApellido());
			textField_Nombre.setText(titular.getNombre());
			comboBoxDia.setSelectedItem(Integer.toString(titular.getFechaNacimiento().get(Calendar.DAY_OF_MONTH)));
			comboBoxMes.setSelectedItem(Integer.toString(titular.getFechaNacimiento().get(Calendar.MONTH)+1));
		}
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
				
				if(confirmar) {
					System.out.println("Todo ok, se actualiza el titular");
					GestorTitular.getInstance().actualizarTitular(titular, textField_Apellido.getText(), textField_Nombre.getText(),
							comboBoxSexo.getSelectedItem().toString(), textField_Calle.getText(), textField_piso.getText(), textField_depto.getText(),
							chckbxDonanteDeOrganos.isSelected());
					if(pantalla==0) {
						Menu menu = new Menu();
						menu.frmMen.setVisible(true);
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
