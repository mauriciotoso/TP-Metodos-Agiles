package Test;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.*;
import Entidades.*;
import Logica.GestorLicencia;

import static org.junit.Assert.assertTrue;

public class EnRangoRenovacionTest {
    
    public GestorLicencia gestorLicencia;
    Licencia l1;
    Licencia l2;
    Licencia l3;
    Licencia l4;
    Licencia l5;
    Licencia l6;
    Licencia l7;
    
    @Before
    public void setUp() throws ParseException {

    	DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	String string1 = "16/08/2020";
        Date date1 = format.parse(string1);
        
        String string2 = "30/12/2020";
        Date date2 = format.parse(string2);
        
        String string3 = "30/06/2021";
        Date date3 = format.parse(string3);
        
        String string4 = "03/01/2021";
        Date date4 = format.parse(string4);
        
        String string5 = "11/12/2020";
        Date date5 = format.parse(string5);
        
        String string6 = "12/12/2020";
        Date date6 = format.parse(string6);
        
        String string7 = "10/12/2020";
        Date date7 = format.parse(string7);
        
        Calendar fechaVen1 = Calendar.getInstance();
        fechaVen1 .setTime(date1);
        
        Calendar fechaVen2 = Calendar.getInstance();
        fechaVen2 .setTime(date2);
        
        Calendar fechaVen3 = Calendar.getInstance();
        fechaVen3 .setTime(date3);
        
        Calendar fechaVen4 = Calendar.getInstance();
        fechaVen4.setTime(date4);
        
        Calendar fechaVen5 = Calendar.getInstance();
        fechaVen5 .setTime(date5);
        
        Calendar fechaVen6 = Calendar.getInstance();
        fechaVen6 .setTime(date6);
                        
        Calendar fechaVen7 = Calendar.getInstance();
        fechaVen7.setTime(date7);
     
        l1= new Licencia(Clase.A, null, fechaVen1,
    			null, "");
        l2= new Licencia(Clase.A, Clase.G, fechaVen2,
    			null, "");
        l3= new Licencia(null, Clase.B, fechaVen3,
    			null, "");
        l4= new Licencia(null, Clase.C, fechaVen4,
    			null, "");
        l5= new Licencia(null, Clase.D, fechaVen5,
    			null, "");
        l6= new Licencia(null, Clase.D, fechaVen6,
    			null, "");
        l7= new Licencia(null, Clase.D, fechaVen7,
    			null, "");
    
    }
    
    @Test
    public void Test1() throws ParseException {
        assertTrue(!GestorLicencia.getInstance().enRangoRenovacion(l1));
    }
    
    @Test
    public void Test2() throws ParseException {
        assertTrue(GestorLicencia.getInstance().enRangoRenovacion(l2));
    }
    
    @Test
    public void Test3() throws ParseException {
        assertTrue(!GestorLicencia.getInstance().enRangoRenovacion(l3));
    }
    
    @Test
    public void Test4() throws ParseException {
        assertTrue(GestorLicencia.getInstance().enRangoRenovacion(l4));
    }
    
    @Test
    public void Test5() throws ParseException {
        assertTrue(!GestorLicencia.getInstance().enRangoRenovacion(l5));
    }
    
    @Test
    public void Test6() throws ParseException {
        assertTrue(GestorLicencia.getInstance().enRangoRenovacion(l6));
    }
    
    @Test
    public void Test7() throws ParseException {
        assertTrue(!GestorLicencia.getInstance().enRangoRenovacion(l7));
    }
}
