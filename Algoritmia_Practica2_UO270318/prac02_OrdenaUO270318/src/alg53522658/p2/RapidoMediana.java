package alg53522658.p2;


/** Este programa sirve para ordenar n elementos
	con el algoritmo mejor. Es el QUICKSORT
 */
public class RapidoMediana extends Vector
{
	
	public RapidoMediana(int nElementos) {
		super(nElementos);
	}
	

	/**
	 * Calcula la mediana entre tres elementos en el vector:
	 * el primero, el último y el central
	 * @return la posición que ocupa la mediana entre estos tres elemenos
	 */
	private int mediana(int iz, int de)
	{
		int a= this.elements[iz];
		int b= this.elements[(iz+de)/2];
		int c= this.elements[de];
		
		int pos= posMediana(a,b,c);
		switch (pos)
		{
		case 0: return iz;
		case 1: return (iz+de)/2;
		case 2: return de;
		default:return -1;
		}
		
	}
	
	/**
	 * Calcula la posición de la mediana entre 3 enteros
	 * @return 0- la mediana es a, 1- la mediana es b, 2- la mediana es c
	 */
	private static int posMediana(int a, int b, int c)
	{
		if (a>b)
			if (b>c)
				return 1;
			else
				if (a>c)
					return 2;
				else
					return 0;
		else
			if (a>c)
				return 0;
			else
				if (c>b)
					return 1;
				else
					return 2;				
	}


	/** Deja el	pivote en una posicion tal que a su izquierda no 
		hay ningún mayor, ni a la derecha ningun menor.
		Es un proceso lineal O(n).  
	 */
	private int particion(int iz, int de) 
	{
		// TODO: Implementación del método de partición
		int i, pivote;
		intercambiar (mediana(iz,de),iz);
		//el pivote es la mediana y se cambia con el primero
		pivote= this.elements[iz]; 
		i= iz;
		for (int s= iz+1; s <= de; s++) 
			if (this.elements[s] <= pivote) 
			{
				i++;
				intercambiar(i,s);
			}
		intercambiar(iz,i);//se restituye el pivote donde debe estar
		return i; // retorna la posicion en que queda el pivote 
	}

	/**
	 * Ordenación por el método rápido (quicksort)
	 * Método divide y vencerás de complejidad estudiada en clase
	 */  

	private void rapirec (int iz, int de) 
	{
		// TODO: Implementación del método de ordenación
		int m;
		if (de>iz) 
		{
			m= particion(iz,de);
			rapirec(iz,m-1);
			rapirec(m+1,de);
		}
	}


	@Override
	public void ordenar() {
		// TODO: Implementación del método de ordenación
		rapirec(0, this.elements.length-1);
		
	}

	@Override
	public String getNombre() {
		return "Rápido mediana a tres";
	}

} 
