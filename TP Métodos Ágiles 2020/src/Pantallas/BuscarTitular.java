package Pantallas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import Entidades.Titular;
import Logica.GestorLicencia;
import Logica.GestorTitular;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

public class BuscarTitular extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfBuscarDNI;
	private String dniTitular;
	private Titular titularEncontrado;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblNroDni;
	private JLabel lblFechaNacimiento;
	private JButton confirmar;
	private JButton crearTitular;
	private JLabel lblLicencia;
	private int pantalla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarTitular window = new BuscarTitular(-1);
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
	
	public BuscarTitular(int pantalla) {
		initialize();
		this.pantalla=pantalla;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Buscar Titular");
		setBounds(100, 100, 450, 219);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		tfBuscarDNI = new JTextField();
		tfBuscarDNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) e.consume();
				
				if (tfBuscarDNI.getText().length()==8) e.consume();
			}
		});
		tfBuscarDNI.setBounds(193, 12, 138, 19);
		getContentPane().add(tfBuscarDNI);
		tfBuscarDNI.setColumns(10);
		
		JLabel lblDNI = new JLabel("Ingresar n\u00FAmero DNI:");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDNI.setToolTipText("");
		lblDNI.setBounds(15, 10, 173, 18);
		getContentPane().add(lblDNI);
		
		
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dniTitular = tfBuscarDNI.getText();
				titularEncontrado=GestorTitular.getInstance().buscarTitular(dniTitular);
				actualizarDatos();
				
			}
		});
		buscar.setBounds(341, 11, 85, 21);
		getContentPane().add(buscar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pantalla==1) {
					EmitirLicencia emitir = new EmitirLicencia();
					emitir.setVisible(true);
				}else {
					RenovarLicencia renovar = new RenovarLicencia();
					renovar.setVisible(true);
				}
				
				dispose();
			}
		});
		cancelar.setBounds(10, 152, 85, 21);
		getContentPane().add(cancelar);
		
		confirmar = new JButton("Confirmar");
		confirmar.setBounds(288, 152, 138, 21);
		getContentPane().add(confirmar);
		
		crearTitular = new JButton("Crear titular");
		crearTitular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarAltaTitular daraltatitular = new DarAltaTitular(pantalla);
				daraltatitular.setVisible(true);
				dispose();
			}
		});
		crearTitular.setBounds(105, 152, 109, 21);
		getContentPane().add(crearTitular);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 416, 101);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDatos = new JLabel("Datos del titular:");
		lblDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatos.setBounds(10, 10, 124, 13);
		panel.add(lblDatos);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 33, 325, 13);
		panel.add(lblNombre);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido.setBounds(10, 56, 174, 13);
		panel.add(lblApellido);
		
		lblNroDni = new JLabel("DNI:");
		lblNroDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNroDni.setBounds(10, 79, 174, 13);
		panel.add(lblNroDni);
		
		lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaNacimiento.setBounds(193, 33, 174, 13);
		panel.add(lblFechaNacimiento);
		
		lblLicencia = new JLabel("Licencia: ");
		lblLicencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLicencia.setBounds(194, 57, 212, 14);
		panel.add(lblLicencia);
		
		confirmar.setEnabled(false);
		
	}
	
	private void actualizarDatos() {
		
		if(titularEncontrado!=null) {
		lblNombre.setText("Nombre: "+titularEncontrado.getNombre());
		lblApellido.setText("Apellido: "+titularEncontrado.getApellido());
		lblNroDni.setText("DNI: "+titularEncontrado.getDni());
		lblFechaNacimiento.setText("Fecha Nacimiento: "+new SimpleDateFormat("dd/MM/yyyy").format(titularEncontrado.getFechaNacimiento().getTime()));
		confirmar.setEnabled(true);
		boolean vencida=GestorLicencia.getInstance().vencida(titularEncontrado.getLicencia());

		if(vencida) lblLicencia.setText("Licencia: Vencida.");
		else lblLicencia.setText("Licencia: No posee.");
		if(pantalla == 10) {
			confirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ModificarTitular modificarTitular = new ModificarTitular(titularEncontrado);
					modificarTitular.setVisible(true);
					
					dispose();
				}
			});
		}else {

			if(titularEncontrado.getLicencia()==null||vencida) {
				confirmar.setText("Emitir licencia");

				
				confirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EmitirLicencia emitir = new EmitirLicencia(titularEncontrado);
						emitir.setVisible(true);
						
						dispose();
					}
				});
			}else{
				if(GestorLicencia.getInstance().enRangoRenovacion(titularEncontrado.getLicencia())) {
					lblLicencia.setText("Licencia: En rango de renovación.");
					confirmar.setText("Renovar licencia");
					confirmar.setEnabled(true);
					confirmar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							RenovarLicencia renovar = new RenovarLicencia(titularEncontrado);
							renovar.setVisible(true);
							
							dispose();
						}
					});
				}else{
					lblLicencia.setText("Licencia: Vigente.");
					confirmar.setEnabled(false);				
					confirmar.setText("Confirmar");
				}
			}
			crearTitular.setEnabled(false);
		}
		
		
	
		}else {
			lblNombre.setText("No existe el titular con el documento ingresado.");
			lblApellido.setText("");
			lblNroDni.setText("");
			lblFechaNacimiento.setText("");
			lblLicencia.setText("");
			
			confirmar.setEnabled(false);
			//TODO Hacer que vaya a darDeAlta = tira error en darAltaTitular
			
			/*crearTitular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DarAltaTitular darAlta = new DarAltaTitular();
					darAlta.setVisible(true);
					dispose();
				}
			});*/
			
			
		}
	}
}
