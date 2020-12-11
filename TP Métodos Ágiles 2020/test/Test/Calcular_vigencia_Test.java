/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
/*
import controller.LicenciaController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ClaseLicenciaEnum;
import model.GrupoSanguineoEnum;
import model.Licencia;
import model.TipoDocumentoEnum;
import model.Titular;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
*/
/**
 *
 * @author Santo
 * Consiste de un método que, dado un titular y una clase de licencia, calcule las fechas de inicio y vigencia de la misma y la retorne a la interfaz.


 */
public class Calcular_vigencia_Test {
  /*  
    
    public LicenciaController l1;
    Titular t1;
    Titular t2;
    Titular t3;
    Titular t4;
    Titular t5;                
    Titular t6;
    Titular t7;
    private static Date today;
    
    public Calcular_vigencia_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        today=new Date();
        try{
            String command = "cmd.exe /c start "+"date 26/10/2018";
            Runtime rt = Runtime.getRuntime();
            rt.exec(command);
            Thread.sleep(500);
            rt.exec("taskkill /IM cmd.exe");
        }catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    @AfterClass
    public static void tearDownClass() {
                try{
            String command = "cmd.exe /c start "+"date "+new SimpleDateFormat("dd/MM/yyyy").format(today);
            Runtime rt = Runtime.getRuntime();
            rt.exec(command);
            Thread.sleep(500);
            rt.exec("taskkill /IM cmd.exe");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    @Before
    public void setUp() throws ParseException {
        //Init fechas nac
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        String string1 = "09/06/2002";
        Date date1 = format.parse(string1);
        
        String string2 = "16/08/1999";
        Date date2 = format.parse(string2);
        
        String string3 = "28/10/1997";
        Date date3 = format.parse(string3);
        
        String string4 = "30/06/1942";
        Date date4 = format.parse(string4);
        
        String string5 = "23/11/1944";
        Date date5 = format.parse(string5);
        
        String string6 = "19/11/1990";
        Date date6 = format.parse(string6);
        
        String string7 = "14/09/1988";
        Date date7 = format.parse(string7);
        
               
        
        //Init titulares
        t1 = new Titular("38898095", TipoDocumentoEnum.DU, "Santiago", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, false, false, date1,"");
        t2 = new Titular("38898095", TipoDocumentoEnum.DU, "Lucas", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, false, true, date2,"");
        t3 = new Titular("38898095", TipoDocumentoEnum.DU, "Martin", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, true, false, date3,"");
        t4 = new Titular("38898095", TipoDocumentoEnum.DU, "Jorge", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, true, true, date4,"");
        t5 = new Titular("38898095", TipoDocumentoEnum.DU, "Santiago", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, false, false, date5,"");
        t6 = new Titular("38898095", TipoDocumentoEnum.DU, "Lucas", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, false, true, date6,"");
        t7 = new Titular("38898095", TipoDocumentoEnum.DU, "Martin", "Roa", "San Luis 2820", GrupoSanguineoEnum.O, true, false, date7,"");
        
         //Init lista licencias
        List<Licencia> lista = new ArrayList<Licencia>();        
        Licencia lic = new Licencia();
        lic.setClaseLicenciaEnum(ClaseLicenciaEnum.A);
        lista.add(lic);
        
        t3.setLicencias(lista);               
        
        l1 = LicenciaController.getInstance();
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestVigencia1() throws ParseException {
        Date resultado = l1.calcularVigencia(t1, ClaseLicenciaEnum.C);
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String string1 = "26/10/2018";
        Date date1 = format.parse(string1);
        
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);
        
        
        assertEquals(format.format(date1),format.format(resultado));
    }
    
    @Test
    public void TestVigencia2() throws ParseException {
        Date resultado = l1.calcularVigencia(t2, ClaseLicenciaEnum.B);
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String string2 = "16/08/2020";
        Date date1 = format.parse(string2);
        
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);
        
        
        assertEquals(format.format(date1),format.format(resultado));
    }
    
    
    @Test
    public void TestVigencia3() throws ParseException {
        
        
        Date resultado = l1.calcularVigencia(t3, ClaseLicenciaEnum.A);
        
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String string3 = "28/10/2021";
        Date date1 = format.parse(string3);
        
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);
        
        
        assertEquals(format.format(date1),format.format(resultado));
        
    }
    
     @Test
    public void TestVigencia4() throws ParseException {
        
        Date resultado = l1.calcularVigencia(t4, ClaseLicenciaEnum.B);
        
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String string4 = "30/06/2020";
        Date date1 = format.parse(string4);
        
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);
        
        
        assertEquals(format.format(date1),format.format(resultado));
        
    }
    
     @Test
    public void TestVigencia5() throws ParseException {
        
        Date resultado = l1.calcularVigencia(t5, ClaseLicenciaEnum.C);
        
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String string4 = "23/11/2019";
        Date date1 = format.parse(string4);
        
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);
        
        
        assertEquals(format.format(date1),format.format(resultado));
        
    }
    
    @Test
    public void TestVigencia6() throws ParseException {
        
        Date resultado = l1.calcularVigencia(t6, ClaseLicenciaEnum.E);
        
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String string4 = "19/11/2023";
        Date date1 = format.parse(string4);
        
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);
        
        
        assertEquals(format.format(date1),format.format(resultado));
        
    }
    
    @Test
    public void TestVigencia7() throws ParseException {
        
        Date resultado = l1.calcularVigencia(t7, ClaseLicenciaEnum.E);
        
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String string4 = "14/09/2024";
        Date date1 = format.parse(string4);
        
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);
        
        
        assertEquals(format.format(date1),format.format(resultado));
        
    }
    */
}
