

package usar;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.JOptionPane;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/**
 * Clase Operaciones
 * 
 * Operaciones usadas en todos los ejercicios
 * 
 * @author Laura Damigo
 * 
 * @version 1.0
 *
 */


public class Operaciones {

	
	//Ejercicio 09
/**
 * Método burbuja
 * 
 * Ordena un array de forma ascendente
 * 	
 * @param array
 */

	public static void burbuja(int array[]){
		int aux;
		for (int i=array.length;i>0;i--){
			for (int j=0; j<i-1; j++){
				if(array[j]>array[j+1]){
					aux=array[j+1];
					array[j+1]=array[j];
					array[j]=aux;
				}
			}
		}
	}
	

	
	
	
//Ejercicio 35
	/**
	 * Método factorial
	 * 
	 * Calcula el factorial de un número dado con recursividad.
	 * @param x
	 * @return factorial
	 */
	
public static long factorial(long x) {
	
	if (x==1) {
		
		return x;
		
	}else {
		return x*factorial (x-1);
	}
	
}


//Ejercicio 30 

/**
 * Método capicua
 * 
 * Comprueba si un número es capicua
 * 
 * @param num
 * @return <ul>
 * 	<li> true: el número es capicúa
 * 	<li> false: el número no es capicúa
 * 	</ul>	
 */
public static boolean capicua(int num) {
	String n=Integer.toString(num);
	
	StringBuffer n2=new StringBuffer (n) ;
	
	StringBuffer n3=n2.reverse();
	
	String n4=n3.toString();
	
	if (n.equalsIgnoreCase(n4)) {
		return true;
	}else {
		return false;
	}
	
}
	/*int [] vector= new int [n.length()];
	int [] vector2= new int [n.length()];
	
	for (int i=0; i<n.length(); i++) {
		vector [i]=n.charAt(i);
		vector2 [i]=n.charAt(i);
	}*/
	
	
	
	
//Ejercicio 36 
/**
 * Método fibonacci
 * 
 * Calcula la secuencia de Fibonacci y devuelve en número de dígitos de dicha secuencia que se hayan solicitado
 * @param num 
 * @return secuencia de Fibonacci
 */
public static int fibonacci (int num) {
	
	if (num>1) {
		return fibonacci (num-1)+fibonacci (num-2);
		
	}else{
		if(num==1) {
			return 1;
		}else { if (num==0) {
			return 0;
		}else {
			
			return 000;
		}
		}
	}
}


//Ejercicio 37 Piramide pascal

/**
 * Método pascal
 * 
 * Calcula el triángulo de pascal con recursividad
 * 
 * @param a
 * @param b
 * @return triángulo de pascal
 * 
 */

public static int pascal(int a, int b) {
	
	if (b==0 || a==b) {
		return 1;
	}else {
		return pascal (a-1, b-1) + pascal(a-1, b);
	}
	
	
}


//Ejercicio 38 Matriz caracol

/**
 * Método caracol
 * 
 * Genera una matriz caracol
 * @param matriz
 */

public static void matriz_caracol (int matriz [][]){
	
	int x=matriz.length;
	int inicio=0, fin=x-1, aux=1, i;

	
	while(aux<=x*x) {
		
		for (i=inicio; i<=fin; i++) {  //rellenamos la primera línea horizontal
			matriz [inicio][i]=aux;
			aux++;
		}
		
		for (i=inicio+1; i<=fin; i++) {   //rellenamos la última línea vertical
			matriz [i][fin]=aux;
			aux++;
		}
		
		for (i=fin-1; i>=inicio; i--) {   //rellenamos la última línea horizontal
			matriz [fin][i]=aux;
			aux++;		
		}
		
		for (i=fin-1; i>inicio; i--) {   //rellenamos la primera línea vertical
			matriz [i][inicio]=aux;
			aux++;
		}
		
		inicio++;
		fin--;
	}
}


// Ejercicio 39 - ordenar fila

/**
 * Método ordenar_fila
 * De una matriz dada, selecciona la fila indicada y la ordena de forma ascendente
 * @param matriz
 * @param num
 */

public static void ordenar_fila (int matriz [][], int num) {
	
	int [] array=new int [matriz.length];
	
	for (int j=0; j<matriz.length; j++) {
		array[j]=matriz [num][j];
	}
	
	Operaciones.burbuja(array);
	
	for (int j=0; j<matriz.length; j++) {
		matriz [num][j]=array[j];
	}
}


//Ejercicio 39 - INSERCIÓN DIRECTA - 

/**
 * Método insercion_directa
 * De un array dado, lo ordena de forma ascendente
 * @param A
 */

public static void insercion_directa(int[] A) {
	//n=la cantidad de elementos en A
	int n = A.length;
	//empezamos por el segundo (1) y terminamos en el último (n-1)
	for (int i = 1; i < n; i++) {
		//guardamos el valor del elemento i
		int v = A[i];
		//empezamos a compararlo con el anterior
		int j = i - 1;
		//y seguimos mientras no hayamos llegado al principio del array y los
		//elementos que encontremos sean mayores que el que analizamos
		while (j >= 0 && A[j] > v) 	{
			//desplazamos el elemento un lugar a la derecha
			A[j + 1] = A[j];
			//y pasamos al anterior
			j--;
		}
		//Al terminar el bucle, j indica el lugar inmediatamente anterior a donde
		//debemos encajar v
		A[j + 1] = v;
	}
	}


//Ejercicio 39 - Sacar diagonal

/**
 * Método ordenar_diagonal_pcpal
 * De una matriz dada, ordena de forma ascendente la diagonal principal
 * @param matriz
 */

public static void ordenar_diagonal_pcpal (int matriz [][]) {
	
	int [] diagonal = new int [matriz.length];
	
	for (int i=0; i<matriz.length; i++) {
		
		for (int j=0; j<matriz.length; j++) {
			
			if (i==j) {  // en la diagonal, asignamos el valor a un array auxiliar
				diagonal[i]=matriz[i][j];
			}
		}
	}
		
	
	insercion_directa(diagonal);
	
	for (int i=0; i<matriz.length; i++) {
		
		for (int j=0; j<matriz.length; j++) {
			
			if (i==j) {  // en la diagonal pcpal, asignamos la diagonal ya ordenada
				matriz[i][j]=diagonal[i];
			}
		}
	}
	
}



//Ejercicio 40 - Comprobar la vector con columna

/**
 * Método comprobar_columna
 * Dada una matriz y un vector, que compruebe si ese vector es igual a algunas de las columnas de la matriz
 * en caso de que lo sea, imprime por pantalla la posición de la columna en la que se repite
 * 
 * @param matriz
 * @param array
 * @return
 */

public static void comprobar_columna (int matriz[][], int array[]) {
		
	int c=0;
	int columna;
	//ArrayList iguales=new ArrayList();
	
	for (int i=0; i<matriz.length; i++) {  
		c=0;		
		for (int j=0; j<matriz.length; j++) {
			
			if (matriz [j][i]==array[j]) { //recorremos la matriz por columnas comparando los nºs con los del array
				c++;   // cada vez que un nº de esa columna es igual sumamos uno al contador
			}
		}
		if (c==array.length) {  //si el contador es = al largo del array es que todos los nºs de la colum son iguales
			columna=i;
			System.out.println("La columna "+columna+" es igual al vector");
			//iguales.add(i); //esta sería la forma de hacerlo con un arraylist
		}
		}
	
	//esta sería la forma de hacerlo con un arraylist
	/*for (int i=0; i<iguales.size(); i++) {
		System.out.println("La columna "+iguales.get(i))+"es/son igual al vector");
	}*/
	
}


/**
 * Método para introducir por teclado datos int (con try catch incluido)
 * @param pregunta // la pregunta que se le hace al usuario para que introduzca el int
 * @return el int que se ha metido por teclado
 */

public static int addInt (String pregunta) {
		
	boolean aux=false;
	int atr=0;
	do {
		try {
			
			atr=Integer.parseInt(JOptionPane.showInputDialog(pregunta));
			aux=true;
			
		}catch(NumberFormatException nfe){
			
			JOptionPane.showMessageDialog(null, "Debe introducir un numero");
			aux=false;
			
		}catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Accion cancelada !!!"," ^-^ Information^-^ ",JOptionPane.INFORMATION_MESSAGE);
            aux=true;
         
		}
	
	}while (aux==false);	
			
	return atr;		
}


/**
 * Método para introducir String por teclado
 * @param pregunta // la pregunta que se le hace al usuario para que introduzca el String
 * @return el String que se ha metido por teclado
 */
public static String addString (String pregunta) {
	
	boolean aux=false;
	String atr="";
	do {
		try {
			
			atr=JOptionPane.showInputDialog(pregunta);
			
			if (atr.equalsIgnoreCase("")) {
				aux=false;
				JOptionPane.showMessageDialog(null, "Debe introducir texto");
			}else {
				aux=true;
			}
			
		}catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Accion cancelada !!!"," ^-^ Information^-^ ",JOptionPane.INFORMATION_MESSAGE);
            aux=true;
  		}
	
	}while (aux==false);	
			
	return atr;		
}


/**
 * Método para introducir double por teclado
 * @param pregunta // la pregunta que se le hace al usuario para que introduzca el double
 * @return el double que se ha metido por teclado
 */
public static double addDouble (String pregunta) {
	
	boolean aux=false;
	double atr=0;
	do {
		try {
			
			atr=Double.parseDouble(JOptionPane.showInputDialog(pregunta));
			aux=true;
			
		}catch(NumberFormatException nfe){
			
			JOptionPane.showMessageDialog(null, "Debe introducir un numero");
			aux=false;
			
		}catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Accion cancelada !!!"," ^-^ Information^-^ ",JOptionPane.INFORMATION_MESSAGE);
            aux=true;
         
		}
	
	}while (aux==false);	
			
	return atr;		
}


/**
 * Método para introducir una fecha por teclado
 * @param pregunta // la pregunta que se le hace al usuario para que introduzca la fecha
 * @return la fecha que se ha metido por teclado
 */
public static LocalDate addFecha(String pregunta) {
	
	boolean aux=false;
	LocalDate fecha=null;
	do {
		try {
	
			JOptionPane.showMessageDialog(null, pregunta);
			int dia=usar.Operaciones.addInt("Introduzca el dia");
			int mes=usar.Operaciones.addInt("Introduzca el mes");
			int anyo=usar.Operaciones.addInt("Introduzca el anyo");
			
			fecha=LocalDate.of(anyo, mes, dia);
			aux=true;
								
		}catch (RuntimeException ex) {
			JOptionPane.showMessageDialog(null, "La fecha introducida no es válida");
			aux=false;
		}catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Accion cancelada !!!"," ^-^ Information^-^ ",JOptionPane.INFORMATION_MESSAGE);
            aux=true;
            e.getStackTrace();
         
		}
					
	}while (aux==false);
	return fecha;
}



public static String print_map_string(HashMap map) {
	
	Iterator it= map.keySet().iterator();
	String a=" ";
	while (it.hasNext()) {
		String key=(String) it.next();
		a=a+map.get(key);
	}return a;
	
}


public static String print_map_int(HashMap map) {
	
	Iterator it= map.keySet().iterator();
	String a=" ";
	while (it.hasNext()) {
		int key=(int) it.next();
		a=a+map.get(key);
	}return a;
	
}














}







	
	

