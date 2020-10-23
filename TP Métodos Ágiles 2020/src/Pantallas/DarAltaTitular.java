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

public class DarAltaTitular {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		
		textField = new JTextField();
		textField.setBounds(79, 67, 149, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(28, 120, 46, 14);
		frame.getContentPane().add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 117, 149, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(28, 164, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setBounds(79, 161, 149, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
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
		
		textField_3 = new JTextField();
		textField_3.setBounds(454, 73, 160, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00B0");
		lblN.setBounds(624, 76, 46, 14);
		frame.getContentPane().add(lblN);
		
		textField_4 = new JTextField();
		textField_4.setBounds(645, 73, 46, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(413, 117, 46, 14);
		frame.getContentPane().add(lblPiso);
		
		textField_5 = new JTextField();
		textField_5.setBounds(454, 114, 65, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDpto = new JLabel("Dpto.");
		lblDpto.setBounds(538, 117, 46, 14);
		frame.getContentPane().add(lblDpto);
		
		textField_6 = new JTextField();
		textField_6.setBounds(587, 114, 46, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblGrupoSanguneo = new JLabel("Grupo Sangu\u00EDneo");
		lblGrupoSanguneo.setBounds(403, 164, 109, 14);
		frame.getContentPane().add(lblGrupoSanguneo);
		
		
		JComboBox<String> comboBoxGrupoS = new JComboBox();
		comboBoxGrupoS.setBounds(553, 160, 80, 22);
		frame.getContentPane().add(comboBoxGrupoS);
		
		comboBoxGrupoS.addItem("A");
		comboBoxGrupoS.addItem("B");
		comboBoxGrupoS.addItem("O");
		comboBoxGrupoS.addItem("AB");
		
		JLabel lblFactorRh = new JLabel("Factor RH");
		lblFactorRh.setBounds(403, 203, 58, 14);
		frame.getContentPane().add(lblFactorRh);
		
		JComboBox<String> comboBoxFactor = new JComboBox();
		comboBoxFactor.setBounds(553, 199, 80, 22);
		frame.getContentPane().add(comboBoxFactor);
		
		comboBoxFactor.addItem("Positivo");
		comboBoxFactor.addItem("Negativo");
		
		JCheckBox chckbxDonanteDeOrganos = new JCheckBox("Donante de \u00F3rganos");
		chckbxDonanteDeOrganos.setBounds(403, 241, 149, 23);
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
