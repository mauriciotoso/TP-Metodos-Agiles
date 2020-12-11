package Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import Entidades.*;
import Logica.*;

import static org.junit.Assert.*;


public class CalcularVigenciaTest {
    
    
    public GestorLicencia gestorLicencia;
    Titular titular1;
    Titular titular2;
    Titular titular3;
    Titular titular4;
    Titular titular5;
    Titular titular6;
    Titular titular7;
    
    Date date1;
    Date date2;
    Date date3;
    Date date4;
    Date date5;
    Date date6;
    Date date7;

    Date actual;
    
    public CalcularVigenciaTest() {
    }

    @SuppressWarnings("deprecation")
	@Before
    public void setUp() throws ParseException {
        
    	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        String string1 = "16/08/2001";//(19 anios),
        date1 = format.parse(string1);
        
        String string2 = "30/12/2000";//(20 anios),
        date2 = format.parse(string2);
        
        String string3 = "30/06/1980";//(40 anios),
        date3 = format.parse(string3);
        
        String string4 = "23/11/1970";//(50 anios),
        date4 = format.parse(string4);
        
        String string5 = "19/11/1955";//(65 anios),
        date5 = format.parse(string5);
        
        String string6 = "14/09/1945";//(75 anios),
        date6 = format.parse(string6);
        
        String string7 = "10/12/2020";//fecha de vencimiento
        Date dateVen = format.parse(string7);
        
        
        actual = Calendar.getInstance().getTime();
        actual.setHours(0);
        actual.setMinutes(0);
        actual.setSeconds(0);
        
        Calendar fechaNac1 = Calendar.getInstance();
        fechaNac1 .setTime(date1);
        
        Calendar fechaNac2 = Calendar.getInstance();
        fechaNac2 .setTime(date2);
        
        Calendar fechaNac3 = Calendar.getInstance();
        fechaNac3 .setTime(date3);
        
        Calendar fechaNac4 = Calendar.getInstance();
        fechaNac4.setTime(date4);
        
        Calendar fechaNac5 = Calendar.getInstance();
        fechaNac5 .setTime(date5);
        
        Calendar fechaNac6 = Calendar.getInstance();
        fechaNac6 .setTime(date6);
        
        Calendar fechaVen = Calendar.getInstance();
        fechaVen.setTime(dateVen);
        
        titular1=new Titular("31160819", "Toso", "Mauricio", "Pje. Parpal 3055",
        		fechaNac1, GrupoSanguineo.A, true, true, Sexo.MASCULINO);
        titular2=new Titular("31160820", "Onfre", "Riggert", "Pine View 8890",
        		fechaNac2, GrupoSanguineo.B, false, false, Sexo.MASCULINO);
        titular3=new Titular("31160821", "Tankin", "Rod", "Gina Hill 9480",
        		fechaNac3, GrupoSanguineo.A, false, true, Sexo.MASCULINO);
        titular4=new Titular("31160822", "Langran", "Jolene", "Hanson Drive 5750",
        		fechaNac4, GrupoSanguineo.B, true, false, Sexo.FEMENINO);
        titular5=new Titular("31160823", "Vallis", "Corbet", "Clove Trail 4760",
        		fechaNac5, GrupoSanguineo.AB, true, true, Sexo.MASCULINO);
        titular6=new Titular("31160824", "Schulter", "Prue", "Moland Pass 4845",
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
        
        gestorLicencia = GestorLicencia.getInstance();
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void TestVigencia1() throws ParseException {
        Calendar resultado = gestorLicencia.calcularVigencia(titular1);

        System.out.println(resultado);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1); 
        Date fechaFinal =calendar.getTime();
        fechaFinal.setYear(actual.getYear()+1);
        
        resultado.add(Calendar.MONTH, -1);
        Date fechaResultado = resultado.getTime();
        fechaResultado.setHours(0);
        fechaResultado.setSeconds(0);
        fechaResultado.setMinutes(0);
     
        assertEquals(fechaFinal.toString(),fechaResultado.toString());
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void TestVigencia2() throws ParseException {
        Calendar resultado = gestorLicencia.calcularVigencia(titular2);

        System.out.println(resultado);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2); 
        Date fechaFinal =calendar.getTime();
        fechaFinal.setYear(actual.getYear()+3);
        
        resultado.add(Calendar.MONTH, -1);
        Date fechaResultado = resultado.getTime();
        fechaResultado.setHours(0);
        fechaResultado.setSeconds(0);
        fechaResultado.setMinutes(0);
     
        assertEquals(fechaFinal.toString(),fechaResultado.toString());
    }
    
    
    @SuppressWarnings("deprecation")
	@Test
    public void TestVigencia3() throws ParseException {
        Calendar resultado = gestorLicencia.calcularVigencia(titular3);

        System.out.println(resultado);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date3); 
        Date fechaFinal =calendar.getTime();
        fechaFinal.setYear(actual.getYear()+5);
        
        resultado.add(Calendar.MONTH, -1);
        Date fechaResultado = resultado.getTime();
        fechaResultado.setHours(0);
        fechaResultado.setSeconds(0);
        fechaResultado.setMinutes(0);
     
        assertEquals(fechaFinal.toString(),fechaResultado.toString());
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void TestVigencia4() throws ParseException {
    	    Calendar resultado = gestorLicencia.calcularVigencia(titular4);

            System.out.println(resultado);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date4); 
            Date fechaFinal =calendar.getTime();
            fechaFinal.setYear(actual.getYear()+4);
            
            resultado.add(Calendar.MONTH, -1);
            Date fechaResultado = resultado.getTime();
            fechaResultado.setHours(0);
            fechaResultado.setSeconds(0);
            fechaResultado.setMinutes(0);
         
            assertEquals(fechaFinal.toString(),fechaResultado.toString());
    }
    
     @SuppressWarnings("deprecation")
	@Test
    public void TestVigencia5() throws ParseException {
    	    Calendar resultado = gestorLicencia.calcularVigencia(titular5);

            System.out.println(resultado);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date5); 
            Date fechaFinal =calendar.getTime();
            fechaFinal.setYear(actual.getYear()+3);
            
            resultado.add(Calendar.MONTH, -1);
            Date fechaResultado = resultado.getTime();
            fechaResultado.setHours(0);
            fechaResultado.setSeconds(0);
            fechaResultado.setMinutes(0);
         
            assertEquals(fechaFinal.toString(),fechaResultado.toString());
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void TestVigencia6() throws ParseException {
        Calendar resultado = gestorLicencia.calcularVigencia(titular6);

        System.out.println(resultado);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date6); 
        Date fechaFinal =calendar.getTime();
        fechaFinal.setYear(actual.getYear()+1);
        
        resultado.add(Calendar.MONTH, -1);
        Date fechaResultado = resultado.getTime();
        fechaResultado.setHours(0);
        fechaResultado.setSeconds(0);
        fechaResultado.setMinutes(0);
     
        assertEquals(fechaFinal.toString(),fechaResultado.toString());
    }
}
