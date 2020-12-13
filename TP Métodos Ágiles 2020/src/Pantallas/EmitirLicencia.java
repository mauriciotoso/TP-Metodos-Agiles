package Pantallas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import Entidades.*;
import Logica.GestorLicencia;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmitirLicencia extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfTipoDoc;
	private JTextField tfNroDoc;
	private JTextField tfFechaNac;
	private JTextField tfRH;
	private JTextField tfGS;
	private JTextField tfDepto;
	private JTextField tfPiso;
	private JTextField tfCalle;
//	private Titular titularEmitir=new Titular();
	private JCheckBox cbA,cbB,cbC,cbD,cbE,cbF,cbG;
	private String aclaracion="<html>Aclaración:<br/>No se seleccionó un titular.</html>";
	private JLabel lblAclaracion;
	private JButton confirmar;
	private Titular titularEncontrado;
	private JCheckBox cbDonante;
	private JEditorPane tfObservaciones;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmitirLicencia window = new EmitirLicencia();
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
	public EmitirLicencia() {
		initialize();
	}
	
	public EmitirLicencia(Titular titularEncontrado) {
		this.titularEncontrado=titularEncontrado;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println(titularEncontrado);
		this.setTitle("Emitir Licencia");
		this.setBounds(100, 100, 779, 391);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton buscarTitular = new JButton("Buscar Titular");
		buscarTitular.setHorizontalAlignment(SwingConstants.RIGHT);
		buscarTitular.setVerticalAlignment(SwingConstants.BOTTOM);
		buscarTitular.setBounds(243, 9, 117, 21);
		buscarTitular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarTitular buscarTit = new BuscarTitular(1);
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
		lblDatosTitular.setBounds(30, 35, 84, 21);
		panel.add(lblDatosTitular);
		
		JPanel panelTitular = new JPanel();
		panelTitular.setBounds(30, 55, 330, 248);
		panel.add(panelTitular);
		panelTitular.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 10, 45, 13);
		panelTitular.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(165, 10, 66, 13);
		panelTitular.add(lblApellido);
		
		JLabel lblTipoDoc = new JLabel("Tipo Documento");
		lblTipoDoc.setBounds(10, 41, 96, 13);
		panelTitular.add(lblTipoDoc);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(59, 7, 96, 19);
		panelTitular.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(224, 7, 96, 19);
		panelTitular.add(tfApellido);
		tfApellido.setColumns(10);
		
		tfTipoDoc = new JTextField();
		tfTipoDoc.setColumns(10);
		tfTipoDoc.setBounds(131, 37, 100, 19);
		panelTitular.add(tfTipoDoc);
		
		tfNroDoc = new JTextField();
		tfNroDoc.setColumns(10);
		tfNroDoc.setBounds(131, 63, 100, 19);
		panelTitular.add(tfNroDoc);
		
		JLabel lblNroDocumento = new JLabel("Nro Documento");
		lblNroDocumento.setBounds(10, 67, 117, 13);
		panelTitular.add(lblNroDocumento);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(10, 91, 117, 13);
		panelTitular.add(lblFechaDeNacimiento);
		
		tfFechaNac = new JTextField();
		tfFechaNac.setColumns(10);
		tfFechaNac.setBounds(131, 87, 100, 19);
		panelTitular.add(tfFechaNac);
		
		tfRH = new JTextField();
		tfRH.setColumns(10);
		tfRH.setBounds(235, 116, 85, 19);
		panelTitular.add(tfRH);
		
		JLabel lblFactorrh = new JLabel("RH");
		lblFactorrh.setBounds(204, 120, 55, 13);
		panelTitular.add(lblFactorrh);
		
		tfGS = new JTextField();
		tfGS.setColumns(10);
		tfGS.setBounds(120, 116, 67, 19);
		panelTitular.add(tfGS);
		
		JLabel lblGrupoSanguineo = new JLabel("Grupo Sanguineo");
		lblGrupoSanguineo.setBounds(10, 119, 117, 13);
		panelTitular.add(lblGrupoSanguineo);
		
		cbDonante = new JCheckBox("Donante de Organos");
		cbDonante.setBounds(10, 141, 159, 21);
		panelTitular.add(cbDonante);
		
		tfDepto = new JTextField();
		tfDepto.setColumns(10);
		tfDepto.setBounds(174, 218, 85, 19);
		panelTitular.add(tfDepto);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(137, 221, 73, 13);
		panelTitular.add(lblDepto);
		
		tfPiso = new JTextField();
		tfPiso.setColumns(10);
		tfPiso.setBounds(42, 218, 85, 19);
		panelTitular.add(tfPiso);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 221, 45, 13);
		panelTitular.add(lblPiso);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 192, 45, 13);
		panelTitular.add(lblCalle);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDireccion.setBounds(10, 168, 55, 13);
		panelTitular.add(lblDireccion);
		
		tfCalle = new JTextField();
		tfCalle.setColumns(10);
		tfCalle.setBounds(42, 189, 189, 19);
		panelTitular.add(tfCalle);
		
		JLabel lblSeleccionarClase = new JLabel("Seleccione la Clase de la Licencia");
		lblSeleccionarClase.setBounds(404, 39, 278, 13);
		panel.add(lblSeleccionarClase);
		
		cbA = new JCheckBox("Clase A");
		cbA.setBounds(404, 55, 68, 21);
		panel.add(cbA);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(404, 203, 95, 21);
		panel.add(lblObservaciones);
		
		cbB = new JCheckBox("Clase B");
		cbB.setBounds(474, 55, 78, 21);
		panel.add(cbB);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Menu menu = new Menu();
				menu.frmMen.setVisible(true);
				dispose();
			}
		});
		cancelar.setBounds(29, 311, 85, 21);
		panel.add(cancelar);
		
		confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(titularEncontrado);
				
				Clase moto=null,otro=null;
				
				if(cbA.isSelected()) moto=Clase.A;
				if(cbB.isSelected()) otro=Clase.B;
				else if(cbC.isSelected()) otro=Clase.C;
				else if(cbD.isSelected()) otro=Clase.D;
				else if(cbE.isSelected()) otro=Clase.E;
				else if(cbF.isSelected()) otro=Clase.F;
				else if(cbG.isSelected()) otro=Clase.G;
					
				GestorLicencia.getInstance().crearLicencia(titularEncontrado,moto,otro,tfObservaciones.getText());
				
				
				Licencia licencia = titularEncontrado.getLicencia();
				ImprimirPantalla imprimirLic = new ImprimirPantalla(licencia, 1);
				imprimirLic.frame.setVisible(true);
				dispose();
			}
		});
		confirmar.setBounds(638, 311, 103, 21);
		panel.add(confirmar);
		
		cbC = new JCheckBox("Clase C");

		cbC.setBounds(550, 55, 78, 21);
		panel.add(cbC);
		
		cbD = new JCheckBox("Clase D");
		cbD.setBounds(625, 55, 84, 21);
		panel.add(cbD);
		
		cbE = new JCheckBox("Clase E");
		cbE.setBounds(404, 78, 68, 21);
		panel.add(cbE);
		
		cbF = new JCheckBox("Clase F");
		cbF.setBounds(474, 78, 68, 21);
		panel.add(cbF);
		
		cbG = new JCheckBox("Clase G");
		cbG.setBounds(550, 78, 95, 21);
		panel.add(cbG);
		
		lblAclaracion = new JLabel(aclaracion);
		lblAclaracion.setVerticalAlignment(SwingConstants.TOP);
		lblAclaracion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAclaracion.setBounds(404, 122, 330, 91);
		panel.add(lblAclaracion);
		
		tfObservaciones = new JEditorPane();
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
		tfObservaciones.setBounds(404, 224, 337, 79);
		panel.add(tfObservaciones);
		
		tfNombre.setEnabled(false);
		tfApellido.setEnabled(false);
		tfTipoDoc.setEnabled(false);
		tfNroDoc.setEnabled(false);
		tfFechaNac.setEnabled(false);
		tfRH.setEnabled(false);
		tfGS.setEnabled(false);
		tfDepto.setEnabled(false);
		tfPiso.setEnabled(false);
		tfCalle.setEnabled(false);
		cbDonante.setEnabled(false);
		tfObservaciones.setEnabled(false);

		actualizarAclaracion();
		
		confirmar.setEnabled(false);
		
		
		cbA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actualizarAclaracion();
			}
		});
		
		cbB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbC.setSelected(false);
				cbD.setSelected(false);
				cbE.setSelected(false);
				cbF.setSelected(false);
				cbG.setSelected(false);
				
				actualizarAclaracion();
			}
		});
		
		cbC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbB.setSelected(false);
				cbD.setSelected(false);
				cbE.setSelected(false);
				cbF.setSelected(false);
				cbG.setSelected(false);
			
				actualizarAclaracion();
			}
		});
		
		cbD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbC.setSelected(false);
				cbB.setSelected(false);
				cbE.setSelected(false);
				cbF.setSelected(false);
				cbG.setSelected(false);
				
				actualizarAclaracion();
			}
		});
		
		cbE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbC.setSelected(false);
				cbD.setSelected(false);
				cbB.setSelected(false);
				cbF.setSelected(false);
				cbG.setSelected(false);
				
				actualizarAclaracion();
			}
		});
		
		cbF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbC.setSelected(false);
				cbD.setSelected(false);
				cbE.setSelected(false);
				cbB.setSelected(false);
				cbG.setSelected(false);
				
				actualizarAclaracion();
			}
		});
		
		cbG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbC.setSelected(false);
				cbD.setSelected(false);
				cbE.setSelected(false);
				cbF.setSelected(false);
				cbB.setSelected(false);
				
				actualizarAclaracion();
			}
		});

	}	
	
	private void actualizarAclaracion() {
		aclaracion="<html>Aclaración:<br/>";
		
		if(titularEncontrado==null) {
			aclaracion=aclaracion+"No se seleccionó un titular.</html>";
			cbA.setEnabled(false);
			cbB.setEnabled(false);
			cbC.setEnabled(false);
			cbD.setEnabled(false);
			cbE.setEnabled(false);
			cbF.setEnabled(false);
			cbG.setEnabled(false);
		}else{
			tfObservaciones.setEnabled(true);
			
			actualizarDatos();
			
			if(!cbA.isSelected()&&!cbB.isSelected()&&!cbC.isSelected()&&!cbD.isSelected()&&!cbE.isSelected()&&!cbF.isSelected()&&!cbG.isSelected()){
				aclaracion=aclaracion+"Seleccione una clase para la licencia.</html>";
				confirmar.setEnabled(false);
			}else {
				
				aclaracion=aclaracion+"El titular puede conducir vehiculos de clase";

				if(cbA.isSelected()) {
					aclaracion=aclaracion+" A";
				}
				if(cbB.isSelected() && !cbA.isSelected()) {
					aclaracion=aclaracion+" B";
				}
				
				if(cbB.isSelected()&&cbA.isSelected()) {
					aclaracion=aclaracion+" y B";
				}
				if(cbC.isSelected()) {
					aclaracion=aclaracion+" B y C";
				}
				if(cbD.isSelected()) {
					aclaracion=aclaracion+" B C y D";
				}
				if(cbE.isSelected()) {
					aclaracion=aclaracion+" B C D y E";
				}
				if(cbF.isSelected()) {
					aclaracion=aclaracion+" B C D E y F";
				}
				if(cbG.isSelected()) {
					aclaracion=aclaracion+" B C D E F y G";
				}
				aclaracion=aclaracion+".<html>";
				
				confirmar.setEnabled(true);
				
			}
		}
				
		lblAclaracion.setText(aclaracion);
	}
	
	private void actualizarDatos() {
		System.out.println(titularEncontrado);
		
		tfNombre.setText(titularEncontrado.getNombre());
		tfApellido.setText(titularEncontrado.getApellido());;
		tfTipoDoc.setText("DNI");
		tfNroDoc.setText(titularEncontrado.getDni());;
		tfFechaNac.setText(new SimpleDateFormat("dd/MM/yyyy").format(titularEncontrado.getFechaNacimiento().getTime()));
		tfDepto.setText(titularEncontrado.getDepto());
		tfPiso.setText(titularEncontrado.getPiso());
		tfCalle.setText(titularEncontrado.getDireccion());
		if(titularEncontrado.isFactorRH()) {
			tfRH.setText(" + ");
		}else {
			tfRH.setText(" - ");
		}
		cbDonante.setSelected(titularEncontrado.isEsDonante());
		tfGS.setText(titularEncontrado.getGrupoSanguineo().toString());
	}

}
