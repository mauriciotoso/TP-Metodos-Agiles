package Pantallas;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import BDD.GestorBDD;
import Entidades.*;
import Logica.GestorLicencia;
import Logica.GestorTitular;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JRadioButton;

public class RenovarLicencia extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String calle;
	private boolean calleval;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfTipoDoc;
	private JTextField tfNroDoc;
	private JTextField tfDepto;
	private JTextField tfPiso;
	private JTextField tfCalle;
	private String depto;
	private String piso;
	private String nombre;
	private boolean deptoval;
	private boolean pisoval;
	private boolean nombreval;
	private JButton confirmar;
	private Titular titularEncontrado;
	private JCheckBox cbDonante;
	private JEditorPane tfObservaciones;
	private JTextField tfFechaVencimiento;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfClases;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RenovarLicencia window = new RenovarLicencia();
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
	public RenovarLicencia() {
		initialize();
	}
	
	public RenovarLicencia(Titular titularEncontrado) {
		this.titularEncontrado=titularEncontrado;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setTitle("Renovar Licencia");
		this.setBounds(100, 100, 492, 431);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton buscarTitular = new JButton("Buscar Titular");
		buscarTitular.setHorizontalAlignment(SwingConstants.RIGHT);
		buscarTitular.setVerticalAlignment(SwingConstants.BOTTOM);
		buscarTitular.setBounds(336, 9, 117, 21);
		buscarTitular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarTitular buscarTit = new BuscarTitular();
				buscarTit.setVisible(true);
				dispose();
			}
		});
		panel.setLayout(null);
		panel.add(buscarTitular);
		
		JLabel lblSeleccioneTitular = new JLabel("Seleccione un titular existente");
		lblSeleccioneTitular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSeleccioneTitular.setLabelFor(this);
		lblSeleccioneTitular.setBounds(30, 12, 195, 13);
		panel.add(lblSeleccioneTitular);
		
		JLabel lblDatosTitular = new JLabel("Datos titular");
		lblDatosTitular.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosTitular.setBounds(40, 36, 84, 21);
		panel.add(lblDatosTitular);
		
		JPanel panelTitular = new JPanel();
		panelTitular.setBounds(30, 52, 423, 297);
		panel.add(panelTitular);
		panelTitular.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 10, 45, 13);
		panelTitular.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(225, 10, 66, 13);
		panelTitular.add(lblApellido);
		
		JLabel lblTipoDoc = new JLabel("Tipo Documento");
		lblTipoDoc.setBounds(10, 54, 96, 13);
		panelTitular.add(lblTipoDoc);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(109, 10, 100, 19);
		panelTitular.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(313, 6, 100, 19);
		panelTitular.add(tfApellido);
		tfApellido.setColumns(10);
		
		tfTipoDoc = new JTextField();
		tfTipoDoc.setColumns(10);
		tfTipoDoc.setBounds(109, 50, 100, 19);
		panelTitular.add(tfTipoDoc);
		
		tfNroDoc = new JTextField();
		tfNroDoc.setColumns(10);
		tfNroDoc.setBounds(313, 50, 100, 19);
		panelTitular.add(tfNroDoc);
		
		JLabel lblNroDocumento = new JLabel("Nro Documento");
		lblNroDocumento.setBounds(223, 54, 117, 13);
		panelTitular.add(lblNroDocumento);
		
		cbDonante = new JCheckBox("Donante de Organos");
		cbDonante.setBounds(10, 98, 150, 21);
		panelTitular.add(cbDonante);
		
		tfDepto = new JTextField();
		tfDepto.setColumns(10);
		tfDepto.setBounds(365, 145, 48, 19);
		panelTitular.add(tfDepto);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(320, 149, 73, 13);
		panelTitular.add(lblDepto);
		
		tfPiso = new JTextField();
		tfPiso.setColumns(10);
		tfPiso.setBounds(262, 145, 48, 19);
		panelTitular.add(tfPiso);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(228, 149, 45, 13);
		panelTitular.add(lblPiso);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 149, 45, 13);
		panelTitular.add(lblCalle);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(10, 125, 85, 13);
		panelTitular.add(lblDireccion);
		
		tfCalle = new JTextField();
		tfCalle.setColumns(10);
		tfCalle.setBounds(42, 146, 173, 19);
		panelTitular.add(tfCalle);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(30, 360, 85, 21);
		panel.add(cancelar);
		
		confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//logica renovar licencia
				
			}
		});
		confirmar.setBounds(350, 360, 103, 21);
		panel.add(confirmar);
		
		tfNombre.setEnabled(false);
		tfApellido.setEnabled(false);
		tfTipoDoc.setEnabled(false);
		tfNroDoc.setEnabled(false);
		tfDepto.setEnabled(false);
		tfPiso.setEnabled(false);
		tfCalle.setEnabled(false);
		cbDonante.setEnabled(false);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 79, 45, 13);
		panelTitular.add(lblSexo);
		
		JRadioButton rbMasculino = new JRadioButton("Masculino");
		buttonGroup.add(rbMasculino);
		rbMasculino.setBounds(109, 74, 94, 23);
		panelTitular.add(rbMasculino);
		
		JRadioButton rbFemenino = new JRadioButton("Femenino");
		buttonGroup.add(rbFemenino);
		rbFemenino.setBounds(207, 74, 96, 23);
		panelTitular.add(rbFemenino);
		
		JRadioButton rbOtro = new JRadioButton("Otro");
		buttonGroup.add(rbOtro);
		rbOtro.setBounds(309, 74, 100, 23);
		panelTitular.add(rbOtro);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(10, 207, 95, 21);
		panelTitular.add(lblObservaciones);
		
		tfObservaciones = new JEditorPane();
		tfObservaciones.setBounds(10, 233, 403, 53);
		panelTitular.add(tfObservaciones);
		tfObservaciones.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar()== '\n') {
					String s=tfObservaciones.getText();
					s=s.substring(0, s.length()-1);
					tfObservaciones.setText(s);
				}
				
				if (tfObservaciones.getText().length()==200) e.consume();
			}
		});
		tfObservaciones.setEnabled(false);
		
		JLabel lblFechaDeVencimiento = new JLabel("Nueva Fecha ven.");
		lblFechaDeVencimiento.setBounds(10, 186, 126, 13);
		panelTitular.add(lblFechaDeVencimiento);
		
		tfFechaVencimiento = new JTextField();
		tfFechaVencimiento.setEnabled(false);
		tfFechaVencimiento.setColumns(10);
		tfFechaVencimiento.setBounds(118, 184, 96, 19);
		panelTitular.add(tfFechaVencimiento);
		tfFechaVencimiento.setEnabled(false);
		
		JLabel lblClases = new JLabel("Clase(s)");
		lblClases.setBounds(229, 186, 126, 13);
		panelTitular.add(lblClases);
		
		tfClases = new JTextField();
		tfClases.setEnabled(false);
		tfClases.setColumns(10);
		tfClases.setBounds(308, 182, 105, 19);
		panelTitular.add(tfClases);
		tfClases.setEnabled(false);
		
		////

		JLabel lblErrorcalle = new JLabel("Calle inv\u00E1lida");
		lblErrorcalle.setBounds(149, 124, 66, 14);
		panelTitular.add(lblErrorcalle);
		lblErrorcalle.setVisible(false);
		lblErrorcalle.setForeground(Color.RED);
		
		JLabel lblErrorDepto = new JLabel("Depto inv\u00E1lido");
		lblErrorDepto.setBounds(365, 126, 45, 13);
		panelTitular.add(lblErrorDepto);
		lblErrorDepto.setVisible(false);
		lblErrorDepto.setForeground(Color.RED);
		
		JLabel lblErrornombre = new JLabel("Nombre inv\u00E1lido");
		lblErrornombre.setForeground(Color.RED);
		lblErrornombre.setBounds(119, 26, 116, 14);
		panelTitular.add(lblErrornombre);
		lblErrornombre.setVisible(false);
	
		
		///ERROR PISO
		
		JLabel ErrorPiso = new JLabel("Piso inv\u00E1lido");
		ErrorPiso.setBounds(260, 124, 50, 14);
		panelTitular.add(ErrorPiso);
		ErrorPiso.setForeground(Color.RED);
		ErrorPiso.setVisible(false);
		
		
		JButton imprimir = new JButton("Imprimir");
		imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//implementar impirmir
			}
		});
		imprimir.setBounds(125, 360, 85, 21);
		panel.add(imprimir);
		
		if(titularEncontrado!=null) {
			
			tfNombre.setEnabled(true);
			tfApellido.setEnabled(true);
			rbMasculino.setEnabled(true);
			rbFemenino.setEnabled(true);
			rbOtro.setEnabled(true);
			tfObservaciones.setEnabled(true);
			cbDonante.setEnabled(true);
			tfCalle.setEnabled(true);
			tfPiso.setEnabled(true);
			tfDepto.setEnabled(true);
			tfDepto.setEnabled(true);
			
			
			tfNombre.setText(titularEncontrado.getNombre());
			tfApellido.setText(titularEncontrado.getApellido());
			if(titularEncontrado.getSexo()==Sexo.MASCULINO) rbMasculino.setSelected(true);
			if(titularEncontrado.getSexo()==Sexo.FEMENINO) rbFemenino.setSelected(true);
			if(titularEncontrado.getSexo()==Sexo.OTRO) rbOtro.setSelected(true);
			tfObservaciones.setText(titularEncontrado.getLicencia().getObservaciones());
			tfCalle.setText(titularEncontrado.getDireccion());
			tfPiso.setText(titularEncontrado.getPiso());
			tfDepto.setText(titularEncontrado.getDepto());
			cbDonante.setSelected(titularEncontrado.isEsDonante());
			
			String clases ="";
			
			if(titularEncontrado.getLicencia().getLicenciaMoto()!=null&&titularEncontrado.getLicencia().getLicenciaOtro()!=null) {
				clases="A y "+titularEncontrado.getLicencia().getLicenciaOtro();
			}else if(titularEncontrado.getLicencia().getLicenciaMoto()!=null) {
				clases="A";
			}else {
				clases=titularEncontrado.getLicencia().getLicenciaOtro().toString();
			}
			
			tfClases.setText(clases);
			
		}else {
			tfNombre.setEnabled(false);
			tfApellido.setEnabled(false);
			rbMasculino.setEnabled(false);
			rbFemenino.setEnabled(false);
			rbOtro.setEnabled(false);
			tfObservaciones.setEnabled(false);
			cbDonante.setEnabled(false);
			tfCalle.setEnabled(false);
			tfPiso.setEnabled(false);
			tfDepto.setEnabled(false);
			
			imprimir.setEnabled(false);
			confirmar.setEnabled(false);
		}
		
		
	
		
		//ERROR CALLE
		tfCalle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			
				calle = tfCalle.getText().replace(" ", "");
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
		tfCalle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfCalle.getText().length()==50) {
					e.consume();
				}	
			}
		});
		
		
		//TODO ERROR EN VALIDACIÓN CON DEPTO Y CALLE ( TAMB PASA EN DARDEALTA)
		
		//ERROR DEPTO
		tfDepto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				depto = tfDepto.getText().toLowerCase();
				depto = tfDepto.getText().replace(" ", "");
				deptoval = true;
				
				for(int i = 0; i<depto.length(); i++) {
					if(!((Character.isLetterOrDigit(depto.charAt(i))) || (depto.charAt(i) >= 'á' &&  depto.charAt(i) <=  'ú') || depto.charAt(i)=='é' ))  {
						
						deptoval = false;
					}
				}
				if(deptoval) {
					lblErrorDepto.setVisible(false);
					
				}
				else {
					lblErrorDepto.setText("Piso inválido");
					lblErrorDepto.setVisible(true);
					
				}
			}
		});
		tfDepto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfDepto.getText().length()==4) {
					e.consume();
				}
			}
		});
		
		
		
		//PISO
		tfPiso.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				piso = tfPiso.getText().toLowerCase();
				piso = tfPiso.getText().replace(" ", "");
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
					pisoval = false;
				}
			}
		});
		tfPiso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfPiso.getText().length()==4) {
					e.consume();
				}
			}
		});
		
		//ERROR NOMBRE
		tfNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				nombre = tfNombre.getText().toLowerCase().replace(" ", "");
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
				}else {
					lblErrornombre.setText("Nombre inválido");
					lblErrornombre.setVisible(true);
				}
			}
		});
	
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(tfNombre.getText().length()==40) {
					e.consume();
				}
			}
		});
		
		
		
		/*
		JLabel lblErrornro = new JLabel("N\u00FAmero inv\u00E1lido");
		lblErrornro.setForeground(Color.RED);
		lblErrornro.setBounds(634, 100, 104, 14);
		frame.getContentPane().add(lblErrornro);
		lblErrornro.setVisible(false);
		
		textField_nro = new JTextField();
		textField_nro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				nro = tf.getText();
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
					confirmarBoolean = false;
				}
				else {
					lblErrornro.setVisible(false);
					confirmarBoolean = true;
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
		});*/
		
		
		////ACTUALIZAR DATOS DEL TITULAR + LICENCIA
		
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(calleval && nombreval && pisoval && deptoval ) {
					System.out.println("Todo ok, se crea el titular");

					if(rbMasculino.isSelected()) {
						titularEncontrado.setSexo(Sexo.MASCULINO);}
					else if(rbFemenino.isSelected()) {
						titularEncontrado.setSexo(Sexo.FEMENINO);
					}else
						titularEncontrado.setSexo(Sexo.OTRO);
					
					
					if(cbDonante.isSelected()) {
						titularEncontrado.setEsDonante(true);
					}else
						titularEncontrado.setEsDonante(false);
					
					titularEncontrado.setNombre(tfNombre.getText());
					titularEncontrado.setApellido(tfApellido.getText());
					titularEncontrado.setDireccion(tfCalle.getText());
					titularEncontrado.setPiso(tfPiso.getText());
					titularEncontrado.setDepto(tfDepto.getText());
					
					titularEncontrado.getLicencia().setObservaciones((tfObservaciones.getText()));
					titularEncontrado.getLicencia().setFechaVencimiento(GestorLicencia.getInstance().calcularVigencia(titularEncontrado));
					
					Calendar nuevaFecha = GestorLicencia.getInstance().calcularVigencia(titularEncontrado);
					tfFechaVencimiento.setText(new SimpleDateFormat("dd/MM/yyyy").format(nuevaFecha.getTime()));
					
					titularEncontrado.setLicencia(titularEncontrado.getLicencia());
					GestorLicencia.getInstance().actualizarLicencia(titularEncontrado.getLicencia());
					GestorTitular.getInstance().actualizarTitular(titularEncontrado);
					
					
				}else {
					System.out.println("Hay algun error en algun lado(?");
					
				}
				
			
				
			}
		});
		
		
	}	
}
