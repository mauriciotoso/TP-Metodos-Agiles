package Pantallas;

import java.awt.EventQueue;

import Entidades.Titular;
import Logica.GestorLicencia;
import Logica.GestorTitular;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

public class CopiaLicencia extends JFrame{

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
	private JLabel lblNroCopia;
	private JLabel lblFechaNacimiento;
	private JButton crearCopia;
	private JLabel lblLicencia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopiaLicencia window = new CopiaLicencia();
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
	
	public CopiaLicencia() {
		initialize();
		
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
				Menu menu = new Menu();
				menu.frmMen.setVisible(true);
				dispose();
			}
		});
		cancelar.setBounds(10, 152, 85, 21);
		getContentPane().add(cancelar);
		
		crearCopia = new JButton("Crear Copia");
	    crearCopia.setBounds(288, 152, 138, 21);
		getContentPane().add(crearCopia);
		
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
		lblLicencia.setBounds(194, 56, 192, 14);
		panel.add(lblLicencia);
		
		lblNroCopia = new JLabel("Copia Nro: ");
		lblNroCopia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNroCopia.setBounds(194, 78, 212, 14);
		panel.add(lblNroCopia);
		
		
		crearCopia.setEnabled(false);
	}
	
	private void actualizarDatos() {
		
		if(titularEncontrado!=null) {
		lblNombre.setText("Nombre: "+titularEncontrado.getNombre());
		lblApellido.setText("Apellido: "+titularEncontrado.getApellido());
		lblNroDni.setText("DNI: "+titularEncontrado.getDni());
		lblNroCopia.setText("Copia Nro: " + titularEncontrado.getLicencia().getCopia());
		lblFechaNacimiento.setText("Fecha Nacimiento: "+new SimpleDateFormat("dd/MM/yyyy").format(titularEncontrado.getFechaNacimiento().getTime()));
		crearCopia.setEnabled(true);
		
		boolean vencida=GestorLicencia.getInstance().vencida(titularEncontrado.getLicencia());
		
		if(titularEncontrado.getLicencia()==null||vencida) {
			
			if(vencida) lblLicencia.setText("Licencia: Vencida.");
			
			else lblLicencia.setText("Licencia: No posee.");
			
			
		}else{
				lblLicencia.setText("Licencia: Vigente.");
				crearCopia.setEnabled(true);
				crearCopia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						GestorLicencia.getInstance().crearCopia(titularEncontrado.getLicencia());
						JOptionPane.showMessageDialog(null, "Copia realizada", "Mensaje de éxito", JOptionPane.INFORMATION_MESSAGE);
						lblNroCopia.setText("Copia Nro: " + titularEncontrado.getLicencia().getCopia());
						//dispose();
					}
				});
		
		}
		
	
		}else {
			lblNombre.setText("No existe el titular con el documento ingresado.");
			lblApellido.setText("");
			lblNroDni.setText("");
			lblFechaNacimiento.setText("");
			lblLicencia.setText("");
			lblNroCopia.setText("");
			crearCopia.setEnabled(false);
		
			
		}
	}
}
