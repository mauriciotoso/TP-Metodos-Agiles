package Pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JEditorPane;

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
	private JTextField tfNroDir;
	private JTextField tfDepto;
	private JTextField tfPiso;
	private JTextField tfCalle;
	
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
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
		
		JCheckBox cbDonante = new JCheckBox("Donante de Organos");
		cbDonante.setBounds(10, 141, 159, 21);
		panelTitular.add(cbDonante);
		
		tfNroDir = new JTextField();
		tfNroDir.setColumns(10);
		tfNroDir.setBounds(247, 186, 73, 19);
		panelTitular.add(tfNroDir);
		
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
		tfCalle.setBounds(42, 189, 168, 19);
		panelTitular.add(tfCalle);
		
		JLabel lblNro = new JLabel("Nro");
		lblNro.setBounds(217, 192, 32, 13);
		panelTitular.add(lblNro);
		
		JLabel lblSeleccionarClase = new JLabel("Seleccione la Clase de la Licencia");
		lblSeleccionarClase.setBounds(404, 39, 278, 13);
		panel.add(lblSeleccionarClase);
		
		JCheckBox cbA = new JCheckBox("Clase A");
		cbA.setBounds(404, 55, 68, 21);
		panel.add(cbA);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(403, 216, 95, 21);
		panel.add(lblObservaciones);
		
		JCheckBox cbB = new JCheckBox("Clase B");
		cbB.setBounds(474, 55, 78, 21);
		panel.add(cbB);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(29, 311, 85, 21);
		panel.add(cancelar);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(638, 311, 103, 21);
		panel.add(confirmar);
		
		JCheckBox cbC = new JCheckBox("Clase C");
		cbC.setBounds(550, 55, 78, 21);
		panel.add(cbC);
		
		JCheckBox cbD = new JCheckBox("Clase D");
		cbD.setBounds(625, 55, 84, 21);
		panel.add(cbD);
		
		JCheckBox cbE = new JCheckBox("Clase E");
		cbE.setBounds(404, 78, 68, 21);
		panel.add(cbE);
		
		JCheckBox cbF = new JCheckBox("Clase F");
		cbF.setBounds(474, 78, 68, 21);
		panel.add(cbF);
		
		JCheckBox cbG = new JCheckBox("Clase G");
		cbG.setBounds(550, 78, 95, 21);
		panel.add(cbG);
		
		JLabel lblAclaracion = new JLabel("Aclaraci\u00F3n:");
		lblAclaracion.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAclaracion.setBounds(404, 122, 68, 13);
		panel.add(lblAclaracion);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(404, 240, 337, 63);
		panel.add(editorPane);
		
		tfNombre.setEnabled(false);
		tfApellido.setEnabled(false);
		tfTipoDoc.setEnabled(false);
		tfNroDoc.setEnabled(false);
		tfFechaNac.setEnabled(false);
		tfRH.setEnabled(false);
		tfGS.setEnabled(false);
		tfNroDir.setEnabled(false);
		tfDepto.setEnabled(false);
		tfPiso.setEnabled(false);
		tfCalle.setEnabled(false);
		cbDonante.setEnabled(false);
		
	}
}
