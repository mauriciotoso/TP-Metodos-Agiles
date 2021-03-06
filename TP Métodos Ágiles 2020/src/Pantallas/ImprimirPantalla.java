package Pantallas;

import java.awt.EventQueue;


import javax.swing.JFrame;
import Entidades.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class ImprimirPantalla extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	JFrame frame;
	private Licencia licencia;
	private String dom="", dona="", grupoF="";
	private String claseString;
	private Calendar fechaemision;
	private ArrayList<Clase> clasesLicencia;
	private String ruta = "";
	private int pantalla;
	private Paragraph parrafo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImprimirPantalla window = new ImprimirPantalla();
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
	public ImprimirPantalla(Licencia li, int pantalla) {
		System.out.println("INICIA IMPRIMIR");
		FileSystemView filesys = FileSystemView.getFileSystemView();
		ruta += filesys.getHomeDirectory();
		ruta += "\\";
		licencia = li;
		this.pantalla = pantalla;
		System.out.println("por arrancar initialize()");
		initialize();
		System.out.println("arranc� initialize()");
	}
	
	public ImprimirPantalla() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("DALE LPM");
		frame = new JFrame();
		frame.setTitle("Imprimir Licencia");
		frame.setBounds(100, 100, 779, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		

		if(licencia.getTitular().getPiso().compareTo("")==0) {
			dom+= licencia.getTitular().getDireccion()+", Santa Fe";
		}
		else {
			dom+=licencia.getTitular().getDireccion()+" piso: "+licencia.getTitular().getPiso()+
					" depto: "+ licencia.getTitular().getDepto()+", Santa Fe";
		}
		
		if(licencia.getTitular().isEsDonante())
			dona+="S�";
		else {
			dona+="NO";
		}
		if(licencia.getTitular().isFactorRH())
			grupoF+=licencia.getTitular().getGrupoSanguineo().toString()+"+";
		else {
			grupoF+=licencia.getTitular().getGrupoSanguineo().toString()+"-";
		}
		JButton btnImprimirLicencia = new JButton("Imprimir Licencia");
		btnImprimirLicencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document document = new Document();
				try {
					PdfWriter.getInstance(document, new FileOutputStream(ruta+licencia.getIdlicencia()+"Licencia.pdf"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				document.open();
				com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
				
				
				Paragraph parrafo = new Paragraph("Licencia N�: "+licencia.getIdlicencia()+
						"\nApellido: "+licencia.getTitular().getApellido()+
						"\nNombre: "+licencia.getTitular().getNombre()+
						"\nSexo: "+licencia.getTitular().getSexo().toString().substring(0, 1)+
						"\nFecha de nacimiento: "+licencia.getTitular().getFechaNacimiento().get(Calendar.DAY_OF_MONTH)+"/"+
						(licencia.getTitular().getFechaNacimiento().get(Calendar.MONTH)+1)+"/"+
						licencia.getTitular().getFechaNacimiento().get(Calendar.YEAR)+
						"\nDomicilio: "+dom+
						"\nNacionalidad: Argentina"+
						"\nClase: "+claseString+
						"\n------------------------------------------------------"+
						"\nObservaciones: "+licencia.getObservaciones()+
						"\nDonante: "+dona+
						"\nGrupo y factor: "+grupoF+
						"\nCopia N�: "+Integer.toString(licencia.getCopia()), font);
				try {
					document.add(parrafo);
				
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				document.close();
				
				//JOptionPane pane = new JOptionPane();
				
				JOptionPane.showMessageDialog(null, "La impresi�n ha comenzado", "Mensaje de �xito", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		});
		btnImprimirLicencia.setBounds(605, 318, 148, 23);
		frame.getContentPane().add(btnImprimirLicencia);
		
		JButton btnImprimirComprobante = new JButton("Imprimir Comprobante");
		btnImprimirComprobante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document document = new Document();
				try {
					PdfWriter.getInstance(document, new FileOutputStream(ruta+licencia.getIdlicencia()+"Comprobante.pdf"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				document.open();
				com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
				
				
				fechaemision = Calendar.getInstance();
				clasesLicencia = new ArrayList<Clase>();
				if(licencia.getLicenciaMoto()!=null) {
				clasesLicencia.add(licencia.getLicenciaMoto());}
				if(licencia.getLicenciaOtro()!=null) {
				clasesLicencia.add(licencia.getLicenciaOtro());}
				//System.out.println("El dni del titular a pasar es: "+licencia.getTitular().getDni());
				
				
				if(pantalla==6) {
					 parrafo = new Paragraph("Comprobante de licencia N�: "+licencia.getIdlicencia()+
							"\nPrecio: $50"+ 
							"\nFecha de emisi�n: "+fechaemision.get(Calendar.DAY_OF_MONTH)+"/"+
							(fechaemision.get(Calendar.MONTH)+1)+"/"+fechaemision.get(Calendar.YEAR)+
							"\nHora de emisi�n: "+fechaemision.get(Calendar.HOUR_OF_DAY)+":"+fechaemision.get(Calendar.MINUTE)+
							"\nDirecci�n: Salvador Caputto 3800, Santa Fe", font);
				}else {
					 parrafo = new Paragraph("Comprobante de licencia N�: "+licencia.getIdlicencia()+
							"\nPrecio: $"+CostosLicencia.getInstance().getCostoLicencia(clasesLicencia, licencia.getTitular().getFechaNacimiento(), licencia.getTitular().getDni())+
							"\nFecha de emisi�n: "+fechaemision.get(Calendar.DAY_OF_MONTH)+"/"+
							(fechaemision.get(Calendar.MONTH)+1)+"/"+fechaemision.get(Calendar.YEAR)+
							"\nHora de emisi�n: "+fechaemision.get(Calendar.HOUR_OF_DAY)+":"+fechaemision.get(Calendar.MINUTE)+
							"\nDirecci�n: Salvador Caputto 3800, Santa Fe", font);
				}
				
				try {
					document.add(parrafo);
				
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				document.close();
				
				//JOptionPane pane = new JOptionPane();
				
				JOptionPane.showMessageDialog(null, "La impresi�n ha comenzado", "Mensaje de �xito", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		});
		btnImprimirComprobante.setBounds(421, 318, 174, 23);
		frame.getContentPane().add(btnImprimirComprobante);
		
		JButton btnVolver = new JButton("Volver al Men\u00FA");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.frmMen.setVisible(true);
				frame.dispose();
			}
		});
		btnVolver.setBounds(10, 318, 123, 23);
		frame.getContentPane().add(btnVolver);
		
		JLabel lblTitulo = new JLabel("Datos a imprimir en licencia");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(54, 27, 202, 14);
		frame.getContentPane().add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(54, 55, 301, 183);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNroLic = new JLabel("N\u00FAmero de licencia:");
		lblNroLic.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNroLic.setBounds(10, 11, 118, 14);
		panel.add(lblNroLic);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(10, 36, 74, 14);
		panel.add(lblApellido);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSexo.setBounds(229, 11, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblFecha = new JLabel("Fecha de nacimiento:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFecha.setBounds(10, 86, 143, 14);
		panel.add(lblFecha);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDomicilio.setBounds(10, 111, 74, 14);
		panel.add(lblDomicilio);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(10, 61, 74, 14);
		panel.add(lblNombre);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNacionalidad.setBounds(10, 136, 64, 14);
		panel.add(lblNacionalidad);
		
		JLabel lblClase = new JLabel("Clase:");
		lblClase.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblClase.setBounds(10, 161, 46, 14);
		panel.add(lblClase);
		lblClase.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel sexo = new JLabel("F");
		sexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		sexo.setBounds(265, 11, 26, 14);
		panel.add(sexo);
		
		sexo.setText(licencia.getTitular().getSexo().toString().substring(0, 1));
		
		JLabel nroLicencia = new JLabel("New label");
		nroLicencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		nroLicencia.setBounds(107, 11, 93, 14);
		panel.add(nroLicencia);
		nroLicencia.setText(Integer.toString(licencia.getIdlicencia()));
		
		JLabel apellido = new JLabel("New label");
		apellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		apellido.setBounds(57, 36, 107, 14);
		panel.add(apellido);
		apellido.setText(licencia.getTitular().getApellido());
		
		JLabel nombre = new JLabel("New label");
		nombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		nombre.setBounds(57, 61, 96, 14);
		panel.add(nombre);
		nombre.setText(licencia.getTitular().getNombre());
		
		JLabel fechaNacimiento = new JLabel("New label");
		fechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaNacimiento.setBounds(118, 86, 143, 14);
		panel.add(fechaNacimiento);
		fechaNacimiento.setText(licencia.getTitular().getFechaNacimiento().get(Calendar.DAY_OF_MONTH)+"/"+
				licencia.getTitular().getFechaNacimiento().get(Calendar.MONTH)+"/"+
				licencia.getTitular().getFechaNacimiento().get(Calendar.YEAR));
		
		JLabel domicilio = new JLabel("New label");
		domicilio.setFont(new Font("Tahoma", Font.BOLD, 11));
		domicilio.setBounds(57, 111, 234, 14);
		panel.add(domicilio);
		if(licencia.getTitular().getPiso().compareTo("")==0) {
			domicilio.setText(licencia.getTitular().getDireccion()+", Santa Fe");
		}
		else {
			domicilio.setText(licencia.getTitular().getDireccion()+" piso: "+licencia.getTitular().getPiso()+
					" depto: "+ licencia.getTitular().getDepto()+", Santa Fe");
		}
		
		JLabel nacionalidad = new JLabel("Argentina");
		nacionalidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		nacionalidad.setBounds(79, 136, 204, 14);
		panel.add(nacionalidad);
		
		JLabel clase = new JLabel("New label");
		clase.setFont(new Font("Tahoma", Font.BOLD, 11));
		clase.setBounds(44, 161, 74, 14);
		panel.add(clase);
		claseString="";
		if(licencia.getLicenciaMoto()!=null) claseString+= licencia.getLicenciaMoto().toString();
		if(licencia.getLicenciaOtro()!=null) {
			if(claseString.isEmpty()) claseString+= licencia.getLicenciaOtro().toString();
			else {
				claseString+= ", ";
				claseString+= licencia.getLicenciaOtro().toString();
			}
		}
		clase.setText(claseString);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(416, 55, 301, 183);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblObservaciones.setBounds(10, 11, 92, 14);
		panel_1.add(lblObservaciones);
		
		JLabel lblDonante = new JLabel("Donante:");
		lblDonante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDonante.setBounds(10, 110, 83, 14);
		panel_1.add(lblDonante);
		
		JLabel lblGrupoFactor = new JLabel("Grupo y factor:");
		lblGrupoFactor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGrupoFactor.setBounds(10, 135, 83, 14);
		panel_1.add(lblGrupoFactor);
		
		JEditorPane observaciones = new JEditorPane();
		observaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		observaciones.setBounds(10, 30, 281, 69);
		panel_1.add(observaciones);
		observaciones.setEditable(false);
		observaciones.setText(licencia.getObservaciones());
		
		JLabel donante = new JLabel("New label");
		donante.setFont(new Font("Tahoma", Font.BOLD, 11));
		donante.setBounds(63, 110, 75, 14);
		panel_1.add(donante);
		if(licencia.getTitular().isEsDonante())
			donante.setText("S�");
		else {
			donante.setText("NO");
		}
		
		JLabel grupoFactor = new JLabel("New label");
		grupoFactor.setFont(new Font("Tahoma", Font.BOLD, 11));
		grupoFactor.setBounds(92, 135, 83, 14);
		panel_1.add(grupoFactor);
		
		JLabel lblCopia = new JLabel("Copia N�:");
		lblCopia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCopia.setBounds(10, 160, 56, 14);
		panel_1.add(lblCopia);
		
		JLabel lblNroCopia = new JLabel("nro");
		lblNroCopia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNroCopia.setBounds(63, 160, 46, 14);
		panel_1.add(lblNroCopia);
		lblNroCopia.setText(Integer.toString(licencia.getCopia()));
		if(licencia.getTitular().isFactorRH())
			grupoFactor.setText(licencia.getTitular().getGrupoSanguineo().toString()+"+");
		else {
			grupoFactor.setText(licencia.getTitular().getGrupoSanguineo().toString()+"-");
		}
		
		
		
		
	}
}
