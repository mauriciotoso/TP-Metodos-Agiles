/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import BDD.GestorBDD;
import Entidades.*;
import Entidades.CostosLicencia;

public class CalcularCostoTest {
    
    public CostosLicencia costosLicencia;
    
    ArrayList<Clase> clases1;
    ArrayList<Clase> clases2;
    ArrayList<Clase> clases3;
    ArrayList<Clase> clases4;
    ArrayList<Clase> clases5;
    ArrayList<Clase> clases6;
    
    Calendar fechaNac1;
    Calendar fechaNac2;
    Calendar fechaNac3;
    Calendar fechaNac4;
    Calendar fechaNac5;
    Calendar fechaNac6;
    
    Titular titular1;
    Titular titular2;
    Titular titular3;
    Titular titular4;
    Titular titular5;
    Titular titular6;
    
    String dni1;
    String dni2;
    String dni3;
    String dni4;
    String dni5;
    String dni6;
    
    public CalcularCostoTest() {
    	
    }
    
    @Before
    public void setUp() throws ParseException {
    	
    	Date fecha1 = new Date();
        Date fecha2 = new Date();
        Date fecha3 = new Date();
        Date fecha4 = new Date();
        Date fecha5 = new Date();
        Date fecha6 = new Date();
        Date fecha7 = new Date();
        
    	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        String string1 = "16/08/2001"; //( 19 anios), sin licencia previa y adquiere una licencia E
        Date date1 = format.parse(string1);
        
        String string2 = "09/11/2000";//(20 anios), con licencia clase A previa y adquiere una nueva licencia A
        Date date2 = format.parse(string2);
        
        String string3 = "30/06/1980";//(40 anios), adquiere licencia clase G y Clase A
        Date date3 = format.parse(string3);
        
        String string4 = "23/11/1970";//(50 anios),  adquiere licencia clase B
        Date date4 = format.parse(string4);
        
        String string5 = "19/11/1955";//(65 anios),  adquiere licencia clase C
        Date date5 = format.parse(string5);
        
        String string6 = "14/09/1945";//(75 anios),  adquiere licencia clase D
        Date date6 = format.parse(string6);
        
        String string7 = "10/12/2020";//fecha de vencimiento
        Date date7 = format.parse(string7);
        
        fecha1 = date1;
        fecha2 = date2;
        fecha3 = date3;
        fecha4 = date4;
        fecha5 = date5;
        fecha6 = date6;
        fecha7 = date7;
        
        fechaNac1 = Calendar.getInstance();
        fechaNac1 .setTime(fecha1);
        
        fechaNac2 = Calendar.getInstance();
        fechaNac2 .setTime(fecha2);
        
        fechaNac3 = Calendar.getInstance();
        fechaNac3 .setTime(fecha3);
        
        fechaNac4 = Calendar.getInstance();
        fechaNac4.setTime(fecha4);
        
        fechaNac5 = Calendar.getInstance();
        fechaNac5 .setTime(fecha5);
        
        fechaNac6 = Calendar.getInstance();
        fechaNac6 .setTime(fecha6);
        
        Calendar fechaVen = Calendar.getInstance();
        fechaVen.setTime(fecha7);
        
        dni1="31160819";
        dni2="31160820";
        dni3="31160821";
        dni4="31160822";
        dni5="31160823";
        dni6="31160824";
        
        titular1=new Titular(dni1, "Toso", "Mauricio", "Pje. Parpal 3055",
        		fechaNac1, GrupoSanguineo.A, true, true, Sexo.MASCULINO);
        titular2=new Titular(dni2, "Onfre", "Riggert", "Pine View 8890",
        		fechaNac2, GrupoSanguineo.B, false, false, Sexo.MASCULINO);
        titular3=new Titular(dni3, "Tankin", "Rod", "Gina Hill 9480",
        		fechaNac3, GrupoSanguineo.A, false, true, Sexo.MASCULINO);
        titular4=new Titular(dni4, "Langran", "Jolene", "Hanson Drive 5750",
        		fechaNac4, GrupoSanguineo.B, true, false, Sexo.FEMENINO);
        titular5=new Titular(dni5, "Vallis", "Corbet", "Clove Trail 4760",
        		fechaNac5, GrupoSanguineo.AB, true, true, Sexo.MASCULINO);
        titular6=new Titular(dni6, "Schulter", "Prue", "Moland Pass 4845",
        		fechaNac6, GrupoSanguineo.O, false,false , Sexo.FEMENINO);
        		        
        Licencia licencia2= new Licencia(Clase.A, null, fechaVen,
    			titular2, "");
        Licencia licencia3= new Licencia(Clase.A, Clase.G, fechaVen,
    			titular3, "");
        Licencia licencia4= new Licencia(null, Clase.B, fechaVen,
    			titular4, "");
        Licencia licencia5= new Licencia(null, Clase.C, fechaVen,
    			titular5, "");
        Licencia licencia6= new Licencia(null, Clase.D, fechaVen,
    			titular6, "");
        
        titular2.setLicencia(licencia2);
        titular3.setLicencia(licencia3);
        titular4.setLicencia(licencia4);
        titular5.setLicencia(licencia5);
        titular6.setLicencia(licencia6);
        
        clases1= new ArrayList<>();
        clases2= new ArrayList<>();
        clases3= new ArrayList<>();
        clases4= new ArrayList<>();
        clases5= new ArrayList<>();
        clases6= new ArrayList<>();
        
        clases1.add(Clase.E);
        clases2.add(Clase.A);
        clases3.add(Clase.A);
        clases3.add(Clase.G);
        clases4.add(Clase.B);
        clases5.add(Clase.C);
        clases6.add(Clase.D);
        
        costosLicencia = CostosLicencia.getInstance();
        
        GestorBDD.getInstance();
    }
    
    @Test
    public void TestCosto1() throws ParseException {

        GestorBDD.getInstance().guardarTitular(titular1);
        Integer resultado = costosLicencia.getCostoLicencia(clases1,fechaNac1,dni1);
        Integer costoEsperado = 29;        
        
        assertEquals(costoEsperado, resultado);
    }
    
    @Test
    public void TestCosto2() throws ParseException {
    	
        GestorBDD.getInstance().guardarTitular(titular2);
        Integer resultado = costosLicencia.getCostoLicencia(clases2, fechaNac2, dni2);
        Integer costoEsperado = 25;        
        
        assertEquals(costoEsperado, resultado);
    }
    
    @Test
    public void TestCosto3() throws ParseException {
    	
    	GestorBDD.getInstance().guardarTitular(titular3);
    	Integer resultado = costosLicencia.getCostoLicencia(clases3, fechaNac3, dni3);
        Integer costoEsperado = 40+40;        
        
        assertEquals(costoEsperado, resultado);
    }
    
    @Test
    public void TestCosto4() throws ParseException {
    	
    	GestorBDD.getInstance().guardarTitular(titular4);
        Integer resultado = costosLicencia.getCostoLicencia(clases4, fechaNac4, dni4);
        Integer costoEsperado = 30;        
        
        assertEquals(costoEsperado, resultado);
    }
    
    //
    @Test
    public void TestCosto5() throws ParseException {
    	 
    	GestorBDD.getInstance().guardarTitular(titular5);
        Integer resultado = costosLicencia.getCostoLicencia(clases5, fechaNac5, dni5);
        Integer costoEsperado = 30;        
        
        assertEquals(costoEsperado, resultado);
    }
    
    @Test
    public void TestCosto6() throws ParseException {
    	 
    	GestorBDD.getInstance().guardarTitular(titular6);
        Integer resultado = costosLicencia.getCostoLicencia(clases6, fechaNac6, dni6);
        Integer costoEsperado = 29;        
        
        assertEquals(costoEsperado, resultado);
    }
}
