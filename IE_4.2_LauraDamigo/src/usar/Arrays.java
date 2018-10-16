package usar;

import java.util.ArrayList;

public class Arrays {

		
	/**
	 * Método matroz_n10
	 * Generar una matriz con nºs aleatorios del 1 al 10 y de las dimensiones que se indiquen
	 * @param x
	 * @param y
	 * @return la matriz generada
	 */
	public static int[][] matriz_n10 (int x, int y){  
		
		int [][] matriz=new int [x][y];
		
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				matriz [i][j]= (int)Math.floor(Math.random()*10+1);
				
			}
		}
		
		return matriz;
	}
	
	
	
	/**
	 * Método matriz_n100
	 * 
	 * Genera una matriz con nºs aleatorios del 1 al 100 y de las dimensiones que se indiquen
	 * @param x
	 * @param y
	 * @return matriz generada
	 */
	
	public static int[][] matriz_n100 (int x, int y){  
		
		int [][] matriz=new int [x][y];
		
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				matriz [i][j]= (int)Math.floor(Math.random()*100+1);
				
			}
		}
		
		return matriz;
	}
	
	
	public static int[][] matriz_n2 (int x, int y){  
		
		int [][] matriz=new int [x][y];
		
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				matriz [i][j]= (int)Math.floor(Math.random()*2+1);
				
			}
		}
		
		return matriz;
	}
	
	
	//Método para imprimir una matriz
	/**
	 * Método imprimir_matriz
	 * Imprime una matriz dada
	 * @param matriz
	 */
	public static void imprimir_matriz (int matriz [][]){
		
		for (int i=0; i<matriz.length; i++) {
			for (int j=0; j<matriz[0].length; j++) {
				System.out.print(matriz[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	
	
	

	
	/**
	 * Método array_n100
	 * 
	 * Genera un array con nºs aleatorios del 1 al 100 y de las dimensiones que se indiquen
	 * @param x
	 * @return
	 */
	
	public static int[] array_n100 (int x){  
		
		int [] array=new int [x];
		
		for (int i=0; i<x; i++) {
			array [i] = (int)Math.floor(Math.random()*100+1);
		}
		
		return array;
	}
	
	
	/**
	 * Método array n_10
	 * 
	 * Genera un array con nºs aleatorios del 1 al 10 y de las dimensiones que se indiquen
	 * @param x
	 * @return
	 */
		public static int[] array_n10 (int x){  
			
			int [] array=new int [x];
			
			for (int i=0; i<x; i++) {
				array [i] = (int)Math.floor(Math.random()*10+1);
			}
			
			return array;
		}
	
	
		
		public static int[] array_n2 (int x){  
			
			int [] array=new int [x];
			
			for (int i=0; i<x; i++) {
				array [i] = (int)Math.floor(Math.random()*2+1);
			}
			
			return array;
		}
	
		
	/**
	 * Método imprimir_array
	 * 
	 * Imprimir un array dado	
	 * @param array
	 */
	
	public static void imprimir_array (int array []) {
		
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i] + "\t");
		}
		
	}
	
	
	public static void imprimir_array_list (ArrayList array) {
		
		for (int i=0; i<array.size(); i++) {
			System.out.println(array.get(i) + "\n");
		}
	}
	
	
	
	
	
	
	
	
}
