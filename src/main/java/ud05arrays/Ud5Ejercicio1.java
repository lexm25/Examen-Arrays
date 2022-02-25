/**
 * 
 */
package ud05arrays;

import helpers.Helper;

/**
 * @author eserrano
 *
 */
public class Ud5Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[][] datosVirus = { { "Coronavirus", 3, 0.125f }, { "Sarampión", 12, 0.0001f },
				{ "Viruela", 7, 0.00015f }, { "Paperas", 4, 0.00001f }, { "Ébola", 2, 0.199f } };

		Virus[] arrayVirus = crearArrayVirus(datosVirus);

		imprimeVirus(arrayVirus, "Pares", true);
		imprimeVirus(arrayVirus, "Impares", false);

	}

	/**
	 * El método debe crear un nuevo Array de Virus usando los datos que se pasan
	 * como parametro.
	 * 
	 * @param datosVirus datos de las bolas en array bidimensional de numero de
	 *                   filas variable y longitud de columnas = 3, la primera
	 *                   columna de cada fila tiene el String nombre del virus la
	 *                   segunda el Integer tasa de reproducción r0 la tercera el
	 *                   Float tasa de letalidad
	 * @return Nuevo array con los Virus creados.
	 */
	public static Virus[] crearArrayVirus(Object[][] datosVirus) {
		Virus[] retorno = new Virus[datosVirus.length];

		int i = 0;
		for (Object[] fs : datosVirus) {
			retorno[i] = new Virus(fs[0].toString(), (int) fs[1], (float) fs[2]);
			i++;
		}
		return retorno;
	}

	/**
	 * Metodo que Imprime un array de Virus.
	 * 
	 * Se imprimiran los virus que ocupan posicion par si el parametro pares es
	 * true. Ej: 0, 2, 4, 6, ...
	 * 
	 * Se imprimiran los virus que ocupan posición impar si el parametro pares es
	 * false. Ej: 1, 3, 5, 7, ...
	 * 
	 * Por cada virus a imprimir, hacer un print en una linea con la informacion que
	 * el virus proporciona de forma predeterminada en su metodo toString
	 * 
	 * NOTA: Modificar sobrescribiendo el comentario TODO y no modificar ni borrar
	 * las lineas ya existentes
	 */
	public static void imprimeVirus(Virus[] array, String titulo, boolean pares) {
		System.out.println(titulo + ": --------------------");

		if (pares) {
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
				i++;
			}
		} else {
			for (int i = 1; i < array.length; i++) {
				System.out.println(array[i]);
				i++;
			}
		}

		System.out.println("-----------------------------");
	}

	/**
	 * El metodo ordena UNA COPIA del array que se pasa como parametro
	 * 
	 * El orden ha de ser ASCENDENTE, De Mayor a menor
	 * 
	 * RECUERDA QUE EL METODO TRABAJA SOBRE UNA COPIA NO DEBE MODIFICAR EL ARRAY
	 * ORIGINAL. PISTA: Clona el array antes de ordenar.
	 * 
	 * @param array A clonar y ordenar
	 * @return copia ordenada del array pasado como parametro
	 */
	public static Virus[] ordena(final Virus[] array) {
		Virus[] retorno = array.clone();

		for (int i = 0; i < retorno.length; i++) {
			for (int j = i + 1; j < retorno.length; j++) {
				if (retorno[j].compareTo(retorno[i]) < 0) {
					Helper.swap(retorno, i, j);
				}
			}
		}
		return retorno;
	}

	/**
	 * Elimina todas las veces que aparece un Virus en un Array.
	 * 
	 * Debe devolver un nuevo array que contiene de forma consecutiva todos los
	 * elementos que no se han eliminado en las primeras posiciones. En las últimas
	 * posiciones del array quedarán los huecos nulos pertenecientes a las
	 * eliminaciones producidas
	 * 
	 * Ejemplo:
	 * 
	 * Eliminar 3 en [6,5,1,8,3,9,9,3,2,null,null] Debe devolver:
	 * [6,5,1,8,9,9,2,null,null,null,null]
	 * 
	 * RECUERDA QUE EL METODO TRABAJA SOBRE UNA COPIA NO DEBE MODIFICAR EL ARRAY
	 * ORIGINAL. PISTA: Clona el array antes de eliminar.
	 * 
	 * @param Virus de muestra a borrar
	 * @return nuevo array sin los eliminados. //
	 */
	public static Virus[] eliminaVirus(Virus v, final Virus[] array) {
		Virus[] retorno = array.clone();

		for (int i = 0; i < retorno.length; i++) {
				if (retorno[i].equals(v)) {
					retorno[i] = null;
			}
				for(int j = 1;j<retorno.length;j++) {
					Helper.swap(retorno, i, j);
				}
		}
		return retorno;
	}

	/**
	 * Encuentra en el Array los virus que sean igual o más peligrosos que el Virus
	 * que se pasa como parámetro
	 * 
	 * Se considera que un Virus es más peligroso que otro usando la relación r0 *
	 * letalidad. A mayor Valor, mayor peligrosidad
	 * 
	 * @param v
	 * @return array con los índices de los elementos peligrosos, null si no hay
	 *         ninguno más peligroso
	 */
	public static int[] encuentraPeligrosos(Virus v, Virus[] array) {
		int[] retorno = new int[array.length];
		int j = 0;
		for(int i = 0;i < array.length;i++) {
			if((array[i].getLetalidad()*array[i].getR0())>=(v.getLetalidad()*v.getR0())) {
				retorno[j] = i;
				j++;
			}
			else {
				retorno[i] = (Integer) null;
			}
		}
		return retorno;
	}

}
