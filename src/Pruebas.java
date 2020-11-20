import java.util.Arrays;
import java.util.Scanner;

class MetodosOrdenamientos{
	//Agregar Menu!!!!
	static class Burbuja{
		static long tTnicio,tFin;
		//Llenar con 1 millon de datos 
		public static void ordenacionBurbuja1(long numeros[]) {
			tTnicio=System.nanoTime();
			for(int i=1;i<=numeros.length-1;i++) {
				for(int j=0;j<numeros.length-i;j++) {
					if(numeros[j]>numeros[j+1]) {
						long aux=numeros[j];
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
		 public static int [] ingregarDatos() {
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
		 
		
		public static void mostrarVector(long numeros[]) {
			System.out.println(Arrays.toString(numeros));
		}
	}
	
}
public class Pruebas {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		System.out.println("-------Burbuja----------");
		long numeros []= {6,2,9,7,1,0,4};
		MetodosOrdenamientos.Burbuja.mostrarVector(numeros);
		MetodosOrdenamientos.Burbuja.ordenacionBurbuja1(numeros);
		System.out.println("Ordenado");
		MetodosOrdenamientos.Burbuja.mostrarVector(numeros);
		System.out.println("Menu metodo de ordenmiento burbuja");
		boolean bandera=false;
		String op="";
		while(bandera==false) {
			System.out.println("Elige una opcion:");
			System.out.println("1-> Crear nuevo vector");
			System.out.println("2-> Burbuja 1");
			System.out.println("3-> Burbuja 2");
			System.out.println("4-> Burbuja 3");
			System.out.println("5-> Salir");
			op=entrada.nextLine();
			switch (op) {
			case "1":
				MetodosOrdenamientos.Burbuja.ingregarDatos();
				break;
			case "2":
				MetodosOrdenamientos.Burbuja.ordenacionBurbuja1(numeros);
				MetodosOrdenamientos.Burbuja.mostrarVector(numeros);
				break;
			case "3":
				MetodosOrdenamientos.Burbuja.ordenacionBurbuja2(numeros);
				MetodosOrdenamientos.Burbuja.mostrarVector(numeros);
				break;
			case "4":
				MetodosOrdenamientos.Burbuja.ordenacionBurbuja2(numeros);
				MetodosOrdenamientos.Burbuja.mostrarVector(numeros);
				break;
			case "5":
				System.out.println("Saliendo.....");
				bandera=true;
				break;
			default:
				break;
			}
		}
		
	}

}
