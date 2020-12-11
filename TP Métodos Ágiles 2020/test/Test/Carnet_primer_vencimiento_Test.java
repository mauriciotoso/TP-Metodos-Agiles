/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/*
import controller.LicenciaController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Licencia;
import org.junit.*;
import static org.junit.Assert.assertEquals;
*/
/**
 *
 * @author Facundo
 */
public class Carnet_primer_vencimiento_Test {
  /*  
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Licencia l1;
    Licencia l2;
    Licencia l3;
    Licencia l4;
    Licencia l5;
    Licencia l6;
    Licencia l7;
    Licencia l8;
    Licencia l9;
    Licencia l10;
    
    @BeforeClass
    public static void setUpClass(){
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        
        l1=new Licencia(); l1.setId(1); l1.setFechaVencimiento(sdf.parse("01/10/2021"));
        l2=new Licencia(); l2.setId(2); l2.setFechaVencimiento(sdf.parse("01/10/2022"));
        l3=new Licencia(); l3.setId(3); l3.setFechaVencimiento(sdf.parse("01/10/2023"));
        l4=new Licencia(); l4.setId(4); l4.setFechaVencimiento(sdf.parse("01/10/2024"));
        l5=new Licencia(); l5.setId(5); l5.setFechaVencimiento(sdf.parse("01/10/2025"));
        l6=new Licencia(); l6.setId(6); l6.setFechaVencimiento(sdf.parse("01/10/2025"));
        l7=new Licencia(); l7.setId(7); l7.setFechaVencimiento(sdf.parse("01/10/2030"));
        l8=new Licencia(); l8.setId(8); l8.setFechaVencimiento(sdf.parse("01/10/2028"));
        l9=new Licencia(); l9.setId(9); l9.setFechaVencimiento(sdf.parse("02/10/2028"));
        l10=new Licencia(); l10.setId(10); l10.setFechaVencimiento(sdf.parse("30/09/2028"));
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void Test1() throws ParseException {

        ArrayList<Licencia> licencias = new ArrayList();
        
        licencias.add(l8);
        licencias.add(l5);
        licencias.add(l6);
        licencias.add(l4);
        licencias.add(l10);
        
        //La licencia más pronta es la 4
        assertEquals(l4.getFechaVencimiento(),LicenciaController.getInstance().primerVencimiento(licencias));
        
    }
    
    @Test
    public void Test2() throws ParseException {

        ArrayList<Licencia> licencias = new ArrayList();
        
        licencias.add(l2);
        licencias.add(l9);
        licencias.add(l5);
        licencias.add(l1);
        licencias.add(l8);
        
        //La licencia más pronta es la 1
        assertEquals(l1.getFechaVencimiento(),LicenciaController.getInstance().primerVencimiento(licencias));   
    }
    
    @Test
    public void Test3() throws ParseException {

        ArrayList<Licencia> licencias = new ArrayList();
        
        //Se valida que los casos limite funcionen correctamente
        licencias.add(l7);
        licencias.add(l9); // 2/10
        assertEquals(l9.getFechaVencimiento(),LicenciaController.getInstance().primerVencimiento(licencias)); 
        
        licencias.add(l8); // 1/10
        assertEquals(l8.getFechaVencimiento(),LicenciaController.getInstance().primerVencimiento(licencias)); 
       
        licencias.add(l10); // 30/09
        assertEquals(l10.getFechaVencimiento(),LicenciaController.getInstance().primerVencimiento(licencias)); 
    }
    
    @Test
    public void Test4() throws ParseException {

        ArrayList<Licencia> licencias = new ArrayList();
        
        licencias.add(l9);
        licencias.add(l5);
        licencias.add(l6);
        licencias.add(l7);
        licencias.add(l10);
        
        // La licencia mas pronta es la 5 y la 6
        assertEquals(l5.getFechaVencimiento(),LicenciaController.getInstance().primerVencimiento(licencias));
        assertEquals(l6.getFechaVencimiento(),LicenciaController.getInstance().primerVencimiento(licencias));
    }
    
    @Test
    public void Test5() throws ParseException {

        ArrayList<Licencia> licencias = new ArrayList();
        
        //El metodo retorna la fecha de hoy cuando recibe una lista vacia
        assertEquals(new Date(),LicenciaController.getInstance().primerVencimiento(licencias));
        
    }
    */
    
}
