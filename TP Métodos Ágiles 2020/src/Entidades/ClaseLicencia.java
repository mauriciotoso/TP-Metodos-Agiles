package Entidades;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class ClaseLicencia {
	private List<List<Integer>> costos = new ArrayList<List<Integer>>();
	private static ClaseLicencia claseLicencia;
	
	private ClaseLicencia() {
		costos.add(Arrays.asList(40, 30, 25, 20)); //CLASE A
		costos.add(Arrays.asList(40, 30, 25, 20)); //CLASE B
		costos.add(Arrays.asList(47, 35, 30, 23)); //CLASE C
		costos.add(Arrays.asList(59, 44, 39, 29)); //CLASE D
		costos.add(Arrays.asList(59, 44, 39, 29)); //CLASE E
		costos.add(Arrays.asList(59, 44, 39, 29)); //CLASE F
		costos.add(Arrays.asList(40, 30, 25, 20)); //CLASE G
	}
	
	public static ClaseLicencia getSingletonInstance() {
        if (claseLicencia == null){
            claseLicencia = new ClaseLicencia();
        }
        return claseLicencia;
    }
			
	public static Integer getCostoLicencia(ArrayList<Clase> clases, Calendar fechaNacimiento) { //Clase=nombre enumerado
		Integer costoTotal, edad;
		
		//CALCULAR EDAD
		int año = fechaNacimiento.get(Calendar.YEAR);
		int mes = fechaNacimiento.get(Calendar.MONTH) + 1;
		int dia = fechaNacimiento.get(Calendar.DATE);
		LocalDate fechaNac = LocalDate.of(año, mes, dia);
		LocalDate fechaActual = LocalDate.now();
		Period diferencia = Period.between(fechaNac, fechaActual);
		edad = diferencia.getYears();
	
		//TODO ver el tema de los 21 años
		//Falta recorrer ArrayList e ir viendo las clases
				
		
		return costoTotal;
	}
			
			
			

}
