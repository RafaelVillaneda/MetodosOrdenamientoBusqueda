import java.util.Arrays;
import java.util.Scanner;

class MetodosOrdenamientos{
	//Agregar Menu!!!!
	static class Burbuja{
		static long tTnicio,tFin;
		//Llenar con 1 millon de datos 
		public static void ordenacionBurbuja1(int numeros[]) {
			tTnicio=System.nanoTime();
			for(int i=1;i<=numeros.length-1;i++) {
				for(int j=0;j<numeros.length-i;j++) {
					if(numeros[j]>numeros[j+1]) {
						int aux=numeros[j];
						numeros[j]=numeros[j+1];
						numeros[j+1]=aux;
					}//IF
				}//FOR J
			}//FOR I
			tFin=System.nanoTime();
			System.out.println("El tiempo de ejecucion en ordenamiento burbuja fue de "+(tFin-tTnicio));
		}//Buebuja 1
		/*
		 * Cantidad de pasadas
		 * Cantidad de comparaciones
		 * Cantidad de intercambios
		 */
		//Hacer burbuja 2 y 3
		//Tareas
		public static void ordenacionBurbuja2(long []numeros) {
			tTnicio = System.nanoTime();
            for(int i=1; i<numeros.length; i++) {
				
				for(int j=0; j<numeros.length-i; j++) {
					
					if(numeros[j]>numeros[j+1]) {
						long aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
            tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja: " + (tFin-tTnicio));
		}
		
		 public static void ordenacionBurbuja3(long []numeros) {
			 tTnicio = System.nanoTime();
	           int i=1;
	     	   do {
	     		   
	     		   for(int j=0; j<numeros.length-i; j++) {
	 					
	 					if(numeros[j]>numeros[j+1]) {
	 						long aux = numeros[j];
	 						numeros[j] = numeros[j+1];
	 						numeros[j+1] = aux;
	 					}
	 				}
	     		   
	     		   i=1+i;
	     	   }while(i<numeros.length);
	     	    tFin = System.nanoTime();
				System.out.println("Tiempo de ejecucion en ordenamiento por burbuja: " + (tFin-tTnicio));
	        }
		 public int [] ingregarDatos() {
			 Scanner entrada=new Scanner(System.in);
			 System.out.println("Cuantos datos vas a ingresar?");
			 int tamaño=entrada.nextInt();
			 int vector[]=new int[tamaño];
			 for(int i=0;i<tamaño;i++) {
				 System.out.println("Ingresa el dato "+(i+1));
				 int dato=entrada.nextInt();
				 vector[i]=dato;
			 }
			 return null;
		 }
		 
		
		public static void mostrarVector(int numeros[]) {
			System.out.println(Arrays.toString(numeros));
		}
	}
	
}
public class Pruebas {

	public static void main(String[] args) {
		System.out.println("-------Burbuja----------");
		int numeros []= {6,2,9,7,1,0,4};
		MetodosOrdenamientos.Burbuja.mostrarVector(numeros);
		MetodosOrdenamientos.Burbuja.ordenacionBurbuja1(numeros);
		System.out.println("Ordenado");
		MetodosOrdenamientos.Burbuja.mostrarVector(numeros);
		
	}

}
