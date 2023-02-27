import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Leyes {

    public static void main(String[] args) {
        int num1 = leerInt("Ingrese el cardinal de conjunto universal: ");
        ArrayList<Integer> U = crearConjunto(num1);

        int num2 = leerInt("Ingrese el cardinal del conjunto A: ");
        ArrayList<Integer> A = crearConjunto(num2);

		int num3 = leerInt("Ingrese el cardinal del conjunto B: ");
        ArrayList<Integer> B = crearConjunto(num3);

		boolean flag1 = verificarMorgan1(A, B, U);
		if(flag1==true){
			imprimir("La primera Ley de Morgan se cumple");


		}
		boolean flag2 = veficiarMorga2(A, B, U);
		if(flag2==true){
			imprimir("La segunda Ley de Morgan se cumple");
		}





		
        
      




        
        
    }
	// AUB = AnB Primera ley

	public static boolean verificarMorgan1(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> U){
		boolean flag = false;

		ArrayList<Integer> unionAB = calcularUnion(A, B);
		ArrayList<Integer> complementoAB = calcularDiferenciaSi(unionAB, U);

		imprimir("El complemento de la unión de A y B es:   " + complementoAB);

		ArrayList<Integer> complementoA = calcularDiferenciaSi(A, U);
		ArrayList<Integer> complementoB = calcularDiferenciaSi(B, U);

		ArrayList<Integer> ANB = calcularInterseccion(complementoA, complementoB);

		imprimir("La intersección de los complementos A y B:    " + ANB );

		boolean centi = compararArray(ANB, complementoAB);
		if(centi==true){
			flag = true;
		}

		return flag;

	}
	
	public static boolean veficiarMorga2(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> U){
		boolean flag = false;

		ArrayList<Integer> interAB = calcularInterseccion(A, B);
		ArrayList<Integer> complementoInter = calcularDiferenciaSi(interAB, U);

		imprimir("El complemento de la intersección de ANB:    " + complementoInter);

		ArrayList<Integer> complementoA = calcularDiferenciaSi(A, U);
		ArrayList<Integer> complementoB = calcularDiferenciaSi(B, U);

		ArrayList<Integer> AUB = calcularUnion(complementoA, complementoB);

		imprimir("La unión de los complementos A y B es:   " + AUB);

		boolean centi = compararArray(complementoInter, AUB);
		if(centi==true){
			flag = true;
		}

		return flag;

	}

	

	

    public static ArrayList<Integer> crearConjunto(int num){
		ArrayList<Integer> conjunto = new ArrayList<>();
		
		for(int i = 0 ; i<num ; i++) {
			int numero = leerInt("Ingrese el número que estará en la posición " + (i+1) + " :");
			conjunto.add(numero);

		}
		Collections.sort(conjunto);

		return conjunto;

}
	public static ArrayList<Integer> calcularUnion(ArrayList<Integer> A, ArrayList<Integer> B){
		ArrayList<Integer> conjunto = new ArrayList<>();
	
			for(int i = 0 ; i < A.size() ; i++ ){
				int numero = A.get(i);
				if(verificarContenencia(numero, conjunto)==false){
					conjunto.add(numero);

				}
			}
			for(int j = 0 ; j < B.size() ; j++ ){
				int num2 = B.get(j);
				if(verificarContenencia(num2, conjunto)==false){
					conjunto.add(num2);

				}
			}
		Collections.sort(conjunto);	
		return conjunto;
		}

	public static ArrayList<Integer> calcularInterseccion(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> conjunto = new ArrayList<>();
		
		for(int i = 0 ; i < A.size() ; i++ ){
			int num = A.get(i);
			if(B.indexOf(num)!= -1){
				conjunto.add(num);
			}
			
		}
		return conjunto;
		}
	
	public static ArrayList<Integer> calcularDiferenciaSi(ArrayList<Integer> A, ArrayList<Integer> B){
		ArrayList<Integer> union = calcularUnion(A, B);
		ArrayList<Integer> interseccion = calcularInterseccion(A, B);


		for(int i = 0 ; i < interseccion.size() ; i++){
			int num = interseccion.get(i);
			int num1 =union.indexOf(num);
			union.remove(num1);
		}

		Collections.sort(union);

		return union;

	}


	public static int leerInt(String mensaje) {
		int dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return dato;
	}
	
	public static void imprimir(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
		
	}
	
	public static boolean verificarContenencia(int num, ArrayList<Integer> con) {
		boolean cent = false;
		if(con.indexOf(num)!=-1) {
			cent = true;
			
		}
		return cent;
		
	}

	public static boolean compararArray(ArrayList<Integer> miA , ArrayList<Integer> miA2){
		int cont = 0;
		boolean flag = false;


		if(miA.size()==miA2.size()){
			for(int i = 0 ; i<miA.size() ; i++){
				int num = miA.get(i);
				if(num==miA2.get(i)){
					cont = cont + 1;

				}
				else{
					break; 
				}
			}
			if(cont==miA.size()){
				flag = true;
			}
		}
		return flag;



	}




    
}