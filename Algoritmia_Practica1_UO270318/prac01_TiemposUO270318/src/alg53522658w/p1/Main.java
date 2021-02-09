
public class Main {

	public static void main(String[] args) {
		MatrizOperacionesPropio mtx= new MatrizOperacionesPropio(10);
		mtx.escribir();
		
		MatrizOperacionesPropio mtx2= new MatrizOperacionesPropio("src/files/matriz01.txt");
		mtx2.escribir();
		
		System.out.println(mtx2.sumarDiagonal1());
		System.out.println(mtx2.sumarDiagonal2());
		
		mtx.recorrerCamino(2, 2);
	}

}
