package Pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import Entidades.Licencia;
import Logica.GestorLicencia;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ListadoExpirado {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoExpirado window = new ListadoExpirado();
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
	public ListadoExpirado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		ArrayList<Licencia> listaLicencias = GestorLicencia.getInstance().getLicenciasVencidas();
		
		String[][] lista= new String[listaLicencias.size()][5];
		String[] columnas={"ID de Licencia","Apellido","Nombre", "Fecha de Expiración","Clases"};
		
		int i=0;
		for(Licencia l:listaLicencias) {
			lista[i][0]=l.getIdlicencia()+"";
			lista[i][1]=l.getTitular().getApellido();
			lista[i][2]=l.getTitular().getNombre();
			lista[i][3]=new SimpleDateFormat("yyyy/MM/dd").format(l.getFechaVencimiento().getTime());
			
			if(l.getLicenciaMoto()==null) {
				lista[i][4]=l.getLicenciaOtro()+"";	
			}else if(l.getLicenciaOtro()==null) {
				lista[i][4]=l.getLicenciaMoto()+"";	
			}else {
				lista[i][4]=l.getLicenciaMoto()+""+l.getLicenciaOtro();	
			}
			
			i++;
		}
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 623, 314);
		frame.getContentPane().add(scrollPane);
		
		JTable tableLE = new JTable(lista, columnas);
		tableLE.setRowHeight(25);
		tableLE.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableLE.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		tableLE.editingCanceled(null);
		tableLE.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(tableLE);
		
		JButton atras = new JButton("Atr\u00E1s");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu menu= new Menu();
				menu.frmMen.setVisible(true);
				frame.dispose();
			}
		});
		atras.setBounds(12, 326, 109, 23);
		frame.getContentPane().add(atras);
		
		JLabel aclaracion = new JLabel("Para ordenar por un campo en espec\u00EDfico seleccione su respectiva columna");
		aclaracion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		aclaracion.setBounds(156, 329, 444, 16);
		frame.getContentPane().add(aclaracion);
//		tableLE.getColumnModel().getColumn(0).setResizable(false);
//		tableAC.getColumnModel().getColumn(0).setPreferredWidth(280);
//		tableAC.getColumnModel().getColumn(0).setMinWidth(10);
//		tableAC.getColumnModel().getColumn(0).setMaxWidth(500);
//		tableAC.getColumnModel().getColumn(1).setPreferredWidth(409);
				
		
	}
}
