package ud05arrays;

public class Ud5Ejercicio2 {

	//https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-expresiones-regulares-en-java/
	//DNI con 10 digitos y 2Letras
	//Fecha formato yyyy>mm>dd
	
	
	/**
	 * Devuelve una cadena con una expresión regular que sea capaz de
	 * validad un nuevo tipo de DNI.
	 * 
	 * Tiene que cumplir, tener 10 dígitos 
	 * seguido de dos LETRAS Mayúsculas entre A y Z
	 * @return Expresión regular que valida los requisitos
	 */
	public static String validaDNI() {
		String cadena = "^[0-9]{10}[A-Z]{2}";
		return cadena;
	}
	
	/**
	 * Devuelve una cadena con una expresión regular que sea capaz de
	 * de identificar si la cadena es una de las siguientes expresiones.
	 * 
	 * PERRO, GATO, TORTUGA, LORO
	 * 
	 * La expresión regular debe tener en cuenta dos casos para 
	 * esos valores. Que la palabra esté entera en mayúsuculas.
	 * o entera en minúsculas
	 * 
	 * @return Expresión regular que valida los requisitos
	 */
	public static String validaCampoEnumerado() {
		String cadena = "\bPERRO|perro|GATO|gato|TORTUGA|tortuga|LORO|loro\b";
		return cadena;
	}

}
