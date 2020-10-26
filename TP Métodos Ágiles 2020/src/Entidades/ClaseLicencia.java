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
	}				    // años: 5,   4,  3,  1.
	
	public static ClaseLicencia getSingletonInstance() {
        if (claseLicencia == null){
            claseLicencia = new ClaseLicencia();
        }
        return claseLicencia;
    }
	
			
	public static Integer getCostoLicencia(ArrayList<Clase> clases, Calendar fechaNacimiento, Integer DNI) { //Clase=nombre enumerado
		Integer costoTotal, edad, posicion, i;
		
		//CALCULAR EDAD
		int año = fechaNacimiento.get(Calendar.YEAR);
		int mes = fechaNacimiento.get(Calendar.MONTH) + 1;
		int dia = fechaNacimiento.get(Calendar.DATE);
		LocalDate fechaNac = LocalDate.of(año, mes, dia);
		LocalDate fechaActual = LocalDate.now();
		Period diferencia = Period.between(fechaNac, fechaActual);
		edad = diferencia.getYears();
		
		
		//OBTENER LA POSICIÓN DENTRO DEL ARRAY DE CADA CLASE
		if(edad<=21) {
				if(TitularDao.buscarTitular(DNI).getLicencia().isEmpty()) //Buscamos al titular y dsps su licencia
					posicion = 3;
				else
					posicion = 2;
		}else if(edad <= 46) {
			posicion = 0;
		}else if(edad <= 60) {
			posicion = 1;
		}else if(edad <= 70) {
			posicion = 2;
		}else if(edad> 70) {
			posicion = 3;
		}
		
		
		//OBTENER EL COSTO
		i = clases.size();
		while (i != 0) {
			switch(clases.get(i-1)) {
			case Clase.A :
				costoTotal = costoTotal + costos.get(0).get(posicion);
				break;
			case Clase.B :
				costoTotal = costoTotal + costos.get(1).get(posicion);
				break;
			case Clase.C :
				costoTotal = costoTotal + costos.get(2).get(posicion);
				break;
			case Clase.D :
				costoTotal = costoTotal + costos.get(3).get(posicion);
				break;
			case Clase.E :
				costoTotal = costoTotal + costos.get(4).get(posicion);
				break;
			case Clase.F :
				costoTotal = costoTotal + costos.get(5).get(posicion);
				break;
			case Clase.G :
				costoTotal = costoTotal + costos.get(6).get(posicion);
				break;
			}		
			
			i--;
		}
			
		
		return costoTotal;
	}

}
