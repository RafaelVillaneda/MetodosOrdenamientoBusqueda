import java.util.Arrays;
import java.util.Scanner;
import java.io.*;


class MetodosOrdenamientos{
	//Agregar Menu!!!!
	int [] contador=new int[3];// 1-> recorridos 2-> intercambios 3-> comparaciones
	public void mostrarContador() {
		System.out.println("Numero de recorridos-> "+contador[0]);
		System.out.println("Numero de Intercambios-> "+contador[1]);
		System.out.println("Numero de Comparaciones-> "+contador[2]);
		contador[0]=0;
		contador[1]=0;
		contador[2]=0;
	}
	static class Burbuja{
		static long tTnicio,tFin;
		//Llenar con 1 millon de datos 
		public static void ordenacionBurbuja1(long numeros[]) {
			int comparaciones = 0,intercambios = 0,recorridos=0;
			tTnicio=System.nanoTime();
			for(int i=1;i<=numeros.length-1;i++) {
				for(int j=0;j<numeros.length-i;j++) {
					recorridos++;
					if(numeros[j]>numeros[j+1]) {
						comparaciones++;
						long aux=numeros[j];
						numeros[j]=numeros[j+1];
						numeros[j+1]=aux;
						intercambios++;
					}//IF
				}//FOR J
			}//FOR I
			tFin=System.nanoTime();
			System.out.println("El tiempo de ejecucion en ordenamiento burbuja1 fue de "+(tFin-tTnicio));
			System.out.println("Recorridos"+recorridos);
			System.out.println("Intercambios: "+intercambios);
			System.out.println("Comparaciones: "+comparaciones);
		}//Buebuja 1
		/*
		 * Cantidad de pasadas
		 * Cantidad de comparaciones
		 * Cantidad de intercambios
		 */
		//Hacer burbuja 2 y 3
		//Tareas
		public static void ordenacionBurbuja2(long []numeros) {
			int comparaciones = 0,intercambios = 0,recorridos=0;
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
			System.out.println("El tiempo de ejecucion en ordenamiento burbuja2 fue de "+(tFin-tTnicio));
			System.out.println("Recorridos"+recorridos);
			System.out.println("Intercambios: "+intercambios);
			System.out.println("Comparaciones: "+comparaciones);
		}
		
		 public static void ordenacionBurbuja3(long []numeros) {
			 int comparaciones = 0,intercambios = 0,recorridos=0;
			 tTnicio = System.nanoTime();
	           int i=1;
	     	   do {
	     		   
	     		   for(int j=0; j<numeros.length-i; j++) {
	 					if(numeros[j]>numeros[j+1]) {
	 						recorridos++;
	 						long aux = numeros[j];
	 						numeros[j] = numeros[j+1];
	 						numeros[j+1] = aux;
	 					}
	 				}
	     		   
	     		   i=1+i;
	     	   }while(i<numeros.length);
	     	    tFin = System.nanoTime();
				System.out.println("Tiempo de ejecucion en ordenamiento por burbuja3: " + (tFin-tTnicio));
				System.out.println("Recorridos"+recorridos);
				System.out.println("Intercambios: "+intercambios);
				System.out.println("Comparaciones: "+comparaciones);
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
	public void ordenarInserccion(int [] numeros) {
		long tTnicio,tFin = 0;
		int aux;
		int comparaciones = 0,intercambios = 0,recorridos=0;
		for(int i=0;i<numeros.length;i++) {
			recorridos++;
			aux=numeros[i];
			for(int j=i-1;j>=0 &&numeros[j]>aux;j--) {
				comparaciones++;
				recorridos++;
				intercambios++;
				numeros[j+1]=numeros[j];
				numeros[j]=aux;
			}//Segundo for
		}//Primer for
		System.out.println("El tiempo de ejecucion en ordenamiento Inserccion fue de "+(tFin-tFin));
		System.out.println("Recorridos"+recorridos);
		System.out.println("Intercambios: "+intercambios);
		System.out.println("Comparaciones: "+comparaciones);
	}//Metodo de ordenamiento INseccion
	
	public void ordenamientoSeleccion(int [] numeros) {
		long comparaciones = 0,intercambios = 0,recorridos=0;
		for (int i=0;i<numeros.length-1;i++) {
			
			for(int j=0;j<numeros.length;j++) {
				comparaciones++;
				if(numeros[i]>numeros[j]) {
					int minimo=numeros[i];
					numeros[i]=numeros[j];
					numeros[j]=minimo;
					intercambios++;
				}
				recorridos++;
			}
			recorridos++;
		}
		System.out.println("Recorridos"+recorridos);
		System.out.println("Intercambios: "+intercambios);
		System.out.println("Comparaciones: "+comparaciones);
	}
	
	public int [] ordenamientoQuicksort(int[] numeros,int izq,int der) {
            int pivote = numeros[izq];
            int i = izq, j = der;
            int aux;
            while(i<j) {
            	contador[0]++;
                while(numeros[i]<=pivote && i<j) {
                	i++;
                	contador[0]++;
                }
                while(numeros[j]>pivote) {
                	j--;
                	contador[0]++;
                }
                if(i<j) {
                	contador[1]++;
                    aux = numeros[i];
                    numeros[i]=numeros[j];
                    numeros[j] = aux;
                }
            }
            contador[1]++;
            numeros[izq]=numeros[j];
            numeros[j]=pivote;
            contador[2]++;
            if(izq<j-1)
                ordenamientoQuicksort(numeros,izq,j-1);
            contador[2]++;
            if(j+1<der)
            	ordenamientoQuicksort(numeros, j+1, der);
            return numeros;
	}

	public void ordenamientoShellsort(int[] numeros) {
		
		int intervalo= numeros.length/2;
		
		while(intervalo>0) {
			contador[2]++;
			for(int i=intervalo;i<numeros.length;i++) {
				int j= i-intervalo;
				while(j>=0) {
					int k=j+intervalo;
					contador[2]++;
					if(numeros[j]<=numeros[k]) {
						j=-1;
					}else {
						int aux=numeros[j];
						contador[1]++;
						numeros[j]=numeros[k];
						numeros[k]=aux;
						j-=intervalo;
					}
					contador[0]++;
				}
				contador[0]++;
			}
			intervalo=intervalo/2;
			contador[0]++;
		}
		
	}//Metodo

	public void ordenamientoRadix(int[]numeros) {
		contador[2]++;
	      if(numeros.length == 0)
	          return;
	          int[][] np = new int[numeros.length][2];
	          int[] q = new int[0x100];
	          int i,j,k,l,f = 0;
	          for(k=0;k<4;k++) {
	             for(i=0;i<(np.length-1);i++)
	             np[i][1] = i+1;
	             np[i][1] = -1;
	             for(i=0;i<q.length;i++)
	             q[i] = -1;
	             for(f=i=0;i<numeros.length;i++) {
	                j = ((0xFF<<(k<<3))&numeros[i])>>(k<<3);
	                contador[2]++;
	                if(q[j] == -1)
	                l = q[j] = f;
	             else {
	                l = q[j];
	                while(np[l][1] != -1)
	                l = np[l][1];
	                np[l][1] = f;
	                l = np[l][1];
	                contador[0]++;
	             }
	             f = np[f][1];
	             np[l][0] = numeros[i];
	             np[l][1] = -1;
	             contador[0]++;
	          }
	          for(l=q[i=j=0];i<0x100;i++)
	          for(l=q[i];l!=-1;l=np[l][1])
	        	  numeros[j++] = np[l][0];
	          contador[0]++;
	       }//for
	}//metodo

	public int[]ordenarIntercalacion(int primero[],int[] segundo){
		int arrayOrdenado[]=new int[primero.length+segundo.length];
		int i=0,j=0,k=0;
	
		while(i<primero.length && j<segundo.length) {
			if(primero[i]<segundo[j]) {
				arrayOrdenado[k]=primero[i];
				k++;
				i++;
			}else {
				arrayOrdenado[k]=primero[j];
				j++;
				k++;
			}
		}
		while(j<segundo.length) {
			arrayOrdenado[k]=segundo[j];
			j++;
			k++;
		}
		while(i<primero.length) {
			arrayOrdenado[k]=segundo[i];
			i++;
			k++;
		}
		return arrayOrdenado;
		
	}
	
	public int [] ordenamientoMezclaDirecto(int arreglo[]) {
		int i,j,k;
		contador[2]++;
		if(arreglo.length>1) {
			int numElementosIzq=arreglo.length/2;
			int numElmentosDer=arreglo.length-numElementosIzq;
			
			int arregloIzquierdo[]=new int[numElementosIzq];
			int arregloDerecha[]=new int[numElmentosDer];
			//Copiado elementos izquierdo
			for(i=0;i<numElementosIzq;i++) {
				arregloIzquierdo[i]=arreglo[i];
				contador[0]++;
			}
			//arreglo derecho
			i=0;
			for(i=numElementosIzq;i<numElementosIzq+numElmentosDer;i++) {
				arregloDerecha[i-numElementosIzq]=arreglo[i];
				contador[0]++;
			}
			/*La separacion
			System.out.println(Arrays.toString(arregloDerecha));
			System.out.println(Arrays.toString(arregloIzquierdo));
			*/
			
			//Ahora se aplica la recursividad
			arregloIzquierdo=ordenamientoMezclaDirecto(arregloIzquierdo);
			arregloDerecha=ordenamientoMezclaDirecto(arregloDerecha);
			i=j=k=0;
			/*
			 * i=pocicion en el arreglo original
			 * j=pocicion en el arreglo izquierdo
			 * k=pocicion en el arreglo derecho
			 */
			while(arregloIzquierdo.length!=j && arregloDerecha.length!=k) {//Ordena el arreglo (Sublistas)
				contador[2]++;
				if(arregloIzquierdo[j]<arregloDerecha[k]) {
					contador[1]++;
					arreglo[i]=arregloIzquierdo[j];
					i++;
					j++;
				}else {
					contador[1]++;
					arreglo[i]=arregloDerecha[k];
					i++;
					k++;
				}
				contador[0]++;
			}
			//Arreglo final parte izquierda
			while(arregloIzquierdo.length!=j) {
				contador[1]++;
				arreglo[i]=arregloIzquierdo[j];
				i++;
				j++;
				contador[0]++;
			}
			//Arreglo final parte derecha
			while(arregloDerecha.length!=k) {
				contador[1]++;
				arreglo[i]=arregloDerecha[k];
				i++;
				k++;
				contador[0]++;
			}
		}//IF
		
		return arreglo;
	}

}//Clase


public class Pruebas {

	public static void main(String[] args) {
		int copi[];
		long tTnicio,tFin;
		MetodosOrdenamientos orden=new MetodosOrdenamientos();
		Scanner entrada=new Scanner(System.in);
		boolean bandera=false,menu=false;
		long numeros []= {6,2,9,7,1,0,4};
		String op2="";
		
		
		int vector1000elementos[]=new int[1000];
		int vector10000elementos[]=new int[10000];
		int vector100000elementos[]=new int[100000];
		int vector1000000elementos[]=new int[1000000];
		System.out.println("Acabo el 1");
		for(int i=0;i<vector1000elementos.length;i++) {
			vector1000elementos[i]=(int) (Math.random() * 1000 + 1);
		}
		System.out.println("Acabo el 2");
		for(int i=0;i<vector10000elementos.length;i++) {
			vector10000elementos[i]=(int) (Math.random() * 1000 + 1);
		}
		System.out.println("Acabo el 3");
		for(int i=0;i<vector100000elementos.length;i++) {
			vector100000elementos[i]=(int) (Math.random() * 1000 + 1);
		}
		System.out.println("Acabo el 4");
		for(int i=0;i<vector1000000elementos.length;i++) {
			vector1000000elementos[i]=(int) (Math.random() * 1000 + 1);
		}
		while(menu==false) {
		int numerosDesordenados[]= {55,15,78,99,16,1,112,23,1789};
		System.out.println("Elige una opcion");
		System.out.println("1- Metodo ordenamiento burbuja");
		System.out.println("2- Metodo ordenamiento INSERCIÓN");
		System.out.println("3- Metodo ordenamiento Seleccion");
		System.out.println("4- Metodo ordenamiento QUICKSORT");
		System.out.println("5- Metodo ordenamiento SHELLSORT");
		System.out.println("6- Metodo ordenamiento RADIX");
		System.out.println("7- Metodo ordenamiento INTERCALACIÓN");
		System.out.println("8- Metodo ordenamiento Mezcla directa");
		System.out.println("9- Metodo ordenamiento Mezcla naturala");
		System.out.println("10- Metodo busqueda Binaria");
		System.out.println("11- Metodo busqueda funciones HASH");
		System.out.println("12- Salir");
		op2=entrada.nextLine();
		String op="";
		switch (op2) {
		case "1":
			while(bandera==false) {
				System.out.println("Menu metodo de ordenmiento burbuja");
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
			break;
		case "2":
			String eleccion;
			boolean banderaIn=false;
			do {
			System.out.println("1-> Ordenar elementos precargados");
			System.out.println("2-> Ordenar 1000 elementos");
			System.out.println("3-> Ordenar 10000");
			System.out.println("4-> Ordenar 100000");
			System.out.println("5-> Ordenar 1000000");
			System.out.println("6-> Salir");
			eleccion=entrada.nextLine();
			switch (eleccion) {
			case "1":
				tFin=tTnicio=0;
				copi=Arrays.copyOf(numerosDesordenados, numerosDesordenados.length-1);
				System.out.println("Numeros desordenados: "+Arrays.toString(copi));
				tTnicio=System.nanoTime();
				orden.ordenarInserccion(copi);
				System.out.println("Numeros ordenados: "+Arrays.toString(copi));
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				break;
			case "2":
				tFin=tTnicio=0;
				System.out.println("Ordenar 1000 elementos");
				copi=Arrays.copyOf(vector1000elementos, vector1000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenarInserccion(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				break;
			case "3":
				tFin=tTnicio=0;
				System.out.println("Ordenar 10000 elementos");
				copi=Arrays.copyOf(vector10000elementos, vector10000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenarInserccion(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				break;
			case "4":
				tFin=tTnicio=0;
				System.out.println("Ordenar 100000 elementos");
				copi=Arrays.copyOf(vector100000elementos,vector100000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenarInserccion(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				break;
			case "5":
				tFin=tTnicio=0;
				System.out.println("Ordenar 1000000 elementos");
				copi=Arrays.copyOf(vector1000000elementos,vector1000000elementos.length-1);
				System.out.println("Ordenar 1000000 elementos");
				tTnicio=System.nanoTime();
				orden.ordenarInserccion(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				
				break;

			case "6":
				System.out.println("Saliendo....");
				banderaIn=true;
				break;
			default:
				break;
			}
			}while(banderaIn==false);
			
			break;
		case "3":
			System.out.println("Oredenamiento por seleccion");
			copi=Arrays.copyOf(numerosDesordenados, numerosDesordenados.length-1);
			int[] numerosSeleccion= {6,1,10,2,8,4,6,9};
			System.out.println(Arrays.toString(copi));
			orden.ordenamientoSeleccion(copi);
			System.out.println("Numeros ordenados: "+Arrays.toString(copi));
			break;
		case "4":
			String eleccion4;
			boolean banderaQ=false;
			do {
			System.out.println("1-> Ordenar elementos precargados");
			System.out.println("2-> Ordenar 1000 elementos");
			System.out.println("3-> Ordenar 10000");
			System.out.println("4-> Ordenar 100000");
			System.out.println("5-> Ordenar 1000000");
			System.out.println("6-> Salir");
			eleccion4=entrada.nextLine();
			switch (eleccion4) {
			case "1":
				tFin=tTnicio=0;
				copi=Arrays.copyOf(numerosDesordenados, numerosDesordenados.length-1);
				System.out.println("Numeros desordenados: "+Arrays.toString(copi));
				tTnicio=System.nanoTime();
				orden.ordenamientoQuicksort(copi, 0, copi.length-1);
				System.out.println("Numeros ordenados: "+Arrays.toString(copi));
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "2":
				tFin=tTnicio=0;
				System.out.println("Ordenar 1000 elementos");
				copi=Arrays.copyOf(vector1000elementos, vector1000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoQuicksort(copi,0,copi.length-1);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "3":
				tFin=tTnicio=0;
				System.out.println("Ordenar 10000 elementos");
				copi=Arrays.copyOf(vector10000elementos, vector10000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoQuicksort(copi,0,copi.length-1);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "4":
				tFin=tTnicio=0;
				System.out.println("Ordenar 100000 elementos");
				copi=Arrays.copyOf(vector100000elementos,vector100000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoQuicksort(copi,0,copi.length-1);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "5":
				tFin=tTnicio=0;
				System.out.println("Ordenar 1000000 elementos");
				copi=Arrays.copyOf(vector1000000elementos,vector1000000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoQuicksort(copi,0,copi.length-1);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;

			case "6":
				System.out.println("Saliendo....");
				banderaQ=true;
				break;
			default:
				break;
			}
			}while(banderaQ==false);
			break;
		case "5":
			System.out.println("Metodo de ordenamiento por shellSort");
			String eleccionShell;
			boolean banderaShell=false;
			do {
			System.out.println("1-> Ordenar elementos precargados");
			System.out.println("2-> Ordenar 1000 elementos");
			System.out.println("3-> Ordenar 10000");
			System.out.println("4-> Ordenar 100000");
			System.out.println("5-> Ordenar 1000000");
			System.out.println("6-> Salir");
			eleccion=entrada.nextLine();
			switch (eleccion) {
			case "1":
				copi=Arrays.copyOf(numerosDesordenados, numerosDesordenados.length-1);
				tFin=tTnicio=0;
				System.out.println("Numeros desordenados: "+Arrays.toString(copi));
				tTnicio=System.nanoTime();
				orden.ordenamientoShellsort(copi);
				tFin=System.nanoTime();
				System.out.println("Numeros ordenados: "+Arrays.toString(copi));
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "2":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 1000 elementos");
				copi=Arrays.copyOf(vector1000elementos, vector1000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoShellsort(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "3":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 10000 elementos");
				copi=Arrays.copyOf(vector10000elementos, vector10000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoShellsort(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "4":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 100000 elementos");
				copi=Arrays.copyOf(vector100000elementos,vector100000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoShellsort(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "5":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 1000000 elementos");
				copi=Arrays.copyOf(vector1000000elementos,vector1000000elementos.length-1);
				System.out.println("Ordenar 1000000 elementos");
				tTnicio=System.nanoTime();
				orden.ordenamientoShellsort(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "6":
				System.out.println("Saliendo....");
				banderaShell=true;
				break;
			default:
				break;
				}//Switch
			}while(banderaShell==false);
			
			break;
		case "6":
			System.out.println("Metodo de ordenamiento por Radix");
			String eleccionRadix;
			boolean banderaRadix=false;
			do {
			System.out.println("1-> Ordenar elementos precargados");
			System.out.println("2-> Ordenar 1000 elementos");
			System.out.println("3-> Ordenar 10000");
			System.out.println("4-> Ordenar 100000");
			System.out.println("5-> Ordenar 1000000 Tiempo de ejecucion muy largo");
			System.out.println("6-> Salir");
			eleccionRadix=entrada.nextLine();
			switch (eleccionRadix) {
			case "1":
				copi=null;
				copi=Arrays.copyOf(numerosDesordenados, numerosDesordenados.length-1);
				tFin=tTnicio=0;
				System.out.println("Numeros desordenados: "+Arrays.toString(numerosDesordenados));
				tTnicio=System.nanoTime();
				orden.ordenamientoRadix(copi);
				tFin=System.nanoTime();
				System.out.println("Numeros ordenados: "+Arrays.toString(numerosDesordenados));
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "2":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 1000 elementos");
				copi=Arrays.copyOf(vector1000elementos, vector1000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoRadix(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "3":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 10000 elementos");
				copi=Arrays.copyOf(vector10000elementos, vector10000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoRadix(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "4":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 100000 elementos");
				copi=Arrays.copyOf(vector100000elementos,vector100000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoRadix(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "5":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 1000000 elementos");
				copi=Arrays.copyOf(vector1000000elementos,vector1000000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoRadix(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "6":
				System.out.println("Saliendo....");
				banderaRadix=true;
				break;
			default:
				break;
				}//Switch
			}while(banderaRadix==false);
			
			break;
		case "7":
			
			break;
			
		case "8":
			System.out.println("Metodo de ordenamiento por Radix");
			String eleccionMezclaDirecta;
			boolean MezclaDirecta=false;
			do {
			System.out.println("1-> Ordenar elementos precargados");
			System.out.println("2-> Ordenar 1000 elementos");
			System.out.println("3-> Ordenar 10000");
			System.out.println("4-> Ordenar 100000");
			System.out.println("5-> Ordenar 1000000 ");
			System.out.println("6-> Salir");
			eleccionMezclaDirecta=entrada.nextLine();
			switch (eleccionMezclaDirecta) {
			case "1":
				copi=null;
				copi=Arrays.copyOf(numerosDesordenados, numerosDesordenados.length-1);
				tFin=tTnicio=0;
				System.out.println("Numeros desordenados: "+Arrays.toString(numerosDesordenados));
				tTnicio=System.nanoTime();
				orden.ordenamientoMezclaDirecto(copi);
				tFin=System.nanoTime();
				System.out.println("Numeros ordenados: "+Arrays.toString(numerosDesordenados));
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "2":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 1000 elementos");
				copi=Arrays.copyOf(vector1000elementos, vector1000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoMezclaDirecto(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "3":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 10000 elementos");
				copi=Arrays.copyOf(vector10000elementos, vector10000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoMezclaDirecto(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "4":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 100000 elementos");
				copi=Arrays.copyOf(vector100000elementos,vector100000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoMezclaDirecto(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "5":
				copi=null;
				tFin=tTnicio=0;
				System.out.println("Ordenar 1000000 elementos");
				copi=Arrays.copyOf(vector1000000elementos,vector1000000elementos.length-1);
				tTnicio=System.nanoTime();
				orden.ordenamientoMezclaDirecto(copi);
				tFin=System.nanoTime();
				System.out.println("Tardo: "+(tFin-tTnicio));
				orden.mostrarContador();
				break;
			case "6":
				System.out.println("Saliendo....");
				MezclaDirecta=true;
				break;
			default:
				break;
				}//Switch
			}while(MezclaDirecta==false);
			break;
		case "9":
			
			break;
		case "10":
			
			break;
		case "11":
			
			break;
		case "12":
			System.out.println("Saliendo....");
			menu=true;
			break;
			
		}
		}
		System.out.println("----------------------");
		System.out.println();
		int primero[]= {1,2,10,37,50};
		int segundo[]= {30,100};
		System.out.println(Arrays.toString(primero)+" -- "+Arrays.toString(segundo));
		System.out.println("Aray ordenado: "+Arrays.toString(orden.ordenarIntercalacion(primero, segundo)));
	}

}
