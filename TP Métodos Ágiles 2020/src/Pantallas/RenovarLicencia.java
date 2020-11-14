package Pantallas;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import Entidades.*;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;

public class RenovarLicencia extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfTipoDoc;
	private JTextField tfNroDoc;
	private JTextField tfDepto;
	private JTextField tfPiso;
	private JTextField tfCalle;
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
		lblTipoDoc.setBounds(10, 41, 96, 13);
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
		tfTipoDoc.setBounds(109, 37, 100, 19);
		panelTitular.add(tfTipoDoc);
		
		tfNroDoc = new JTextField();
		tfNroDoc.setColumns(10);
		tfNroDoc.setBounds(313, 37, 100, 19);
		panelTitular.add(tfNroDoc);
		
		JLabel lblNroDocumento = new JLabel("Nro Documento");
		lblNroDocumento.setBounds(223, 41, 117, 13);
		panelTitular.add(lblNroDocumento);
		
		cbDonante = new JCheckBox("Donante de Organos");
		cbDonante.setBounds(10, 85, 150, 21);
		panelTitular.add(cbDonante);
		
		tfDepto = new JTextField();
		tfDepto.setColumns(10);
		tfDepto.setBounds(365, 132, 48, 19);
		panelTitular.add(tfDepto);
		
		JLabel lblDepto = new JLabel("Depto");
		lblDepto.setBounds(320, 136, 73, 13);
		panelTitular.add(lblDepto);
		
		tfPiso = new JTextField();
		tfPiso.setColumns(10);
		tfPiso.setBounds(262, 132, 48, 19);
		panelTitular.add(tfPiso);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(228, 136, 45, 13);
		panelTitular.add(lblPiso);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 136, 45, 13);
		panelTitular.add(lblCalle);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(10, 112, 85, 13);
		panelTitular.add(lblDireccion);
		
		tfCalle = new JTextField();
		tfCalle.setColumns(10);
		tfCalle.setBounds(42, 133, 173, 19);
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
		lblSexo.setBounds(10, 66, 45, 13);
		panelTitular.add(lblSexo);
		
		JRadioButton rbMasculino = new JRadioButton("Masculino");
		buttonGroup.add(rbMasculino);
		rbMasculino.setBounds(109, 61, 94, 23);
		panelTitular.add(rbMasculino);
		
		JRadioButton rbFemenino = new JRadioButton("Femenino");
		buttonGroup.add(rbFemenino);
		rbFemenino.setBounds(207, 61, 96, 23);
		panelTitular.add(rbFemenino);
		
		JRadioButton rbOtro = new JRadioButton("Otro");
		buttonGroup.add(rbOtro);
		rbOtro.setBounds(309, 61, 100, 23);
		panelTitular.add(rbOtro);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(10, 186, 95, 21);
		panelTitular.add(lblObservaciones);
		
		tfObservaciones = new JEditorPane();
		tfObservaciones.setBounds(10, 207, 403, 79);
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
		lblFechaDeVencimiento.setBounds(10, 165, 126, 13);
		panelTitular.add(lblFechaDeVencimiento);
		
		tfFechaVencimiento = new JTextField();
		tfFechaVencimiento.setEnabled(false);
		tfFechaVencimiento.setColumns(10);
		tfFechaVencimiento.setBounds(118, 163, 96, 19);
		panelTitular.add(tfFechaVencimiento);
		tfFechaVencimiento.setEnabled(false);
		
		JLabel lblClases = new JLabel("Clase(s)");
		lblClases.setBounds(229, 165, 126, 13);
		panelTitular.add(lblClases);
		
		tfClases = new JTextField();
		tfClases.setEnabled(false);
		tfClases.setColumns(10);
		tfClases.setBounds(308, 161, 105, 19);
		panelTitular.add(tfClases);
		tfClases.setEnabled(false);
		
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
		
	}	
}
