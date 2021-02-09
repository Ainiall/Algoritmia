package alg53522658;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class Cambio {

	private int n; //numero de monedas
	private int[] t; //lista de tipos de moneda
	private int cantidad; //cantidad de cambio
	
	private int [][] C; //se calcula min monedas 
	private boolean [][] marca; //se calcula cantidad de tipo de monedas
	
	private int numMonedas; //numero de monedas a utilizar
	private int[] vuelta; //vector con la cantidad de cada moneda


	// constructor desde fichero
	public Cambio(String file) {
		BufferedReader fich = null;
        String linea;
        try {
            fich = new BufferedReader(new FileReader(file));
            linea = fich.readLine();
            n = Integer.parseInt(linea);
            linea = fich.readLine();
            cargaElementos(linea.split("\t"));
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero: " + file);
        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero: " + file);
        }
	}
    private int[] cargaElementos(String[] split) {
        t = new int[n + 1];
         for (int i = 0; i < split.length; i++) {
         	t[i+1] = Integer.parseInt(split[i]);
         }
         return t;
     }
	
	// constructor aleatorios 
	public Cambio(int numMonedas) {
		this.n = numMonedas;
		Random r = new Random();
		t = new int [n+1];
		//la posicion 0 no se usa
		for(int i=1; i<= numMonedas;i++) {
			t[i] = r.nextInt(200 - 1) + 1;// valores entre 1 y max
		}
	}

	private void initializeMatrix() {
		C = new int[this.n+1][this.cantidad + 1];
		marca = new boolean[this.n+1][this.cantidad + 1];
		
		
	}
	// obtiene el numero de monedas devuelto
	public int getNumMonedas(int cambio) {
		this.cantidad = cambio;
		initializeMatrix();
		for (int i = 1; i <= this.n; i++) {
			C[i][1]=1;
			marca[i][1]=false;
			for (int j = 1; j <= this.cantidad; j++) {
				C[1][j]=j;
				marca[1][j]=true;
				if(i>=2) {
					if (j < this.t[i]) {
						C[i][j] = C[i-1][j];
						marca[i][j] = false;
					} else if (j == this.t[i]) {
						C[i][j] = 1;
						marca[i][j] = true;
					} else {
						C[i][j] = Math.min(C[i - 1][j], 1 + C[i][j - this.t[i]]);
						marca[i][j] = (C[i][j] == C[i - 1][j])? false : true;
					}
				}
				
			}
		}
		
		this.numMonedas = C[this.n][this.cantidad];
		return this.numMonedas;
	}

	// obtiene la lista de monedas utilizadas
	public int[] getMejoresMonedas() {
		this.vuelta = new int[n];
		
		int i = this.n;
		int j = this.cantidad;

		while (j >= 1) {
			if (!marca[i][j]) {
				i--;
				if(i==0) {
					j--;
					i=n;
				}
			}else {
				this.vuelta[i-1]++;
				j -= this.t[i];
			}
		}
		return this.vuelta;
	}
	
}
