import java.util.Date;
import java.util.Scanner;

public class Factory
{
	static int camtur, aguatur, numtur, intertur, maxtur;

	static int idpas, numpas, maxpas, interpas, beberpas;
	
	
	public static void main(String args[]) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		String valores = input.nextLine();
		Scanner shambles = new Scanner(valores);
		
		numtur = shambles.nextInt();//10; //Número de turistas
		intertur = shambles.nextInt();//3; //Valor para banhista iniciar trajeto
		
		camtur = shambles.nextInt();//3; // Tempo de demora para chegar a margem da piscina
		maxtur = shambles.nextInt();//4;// Máximo de turistas dentro da piscina

		aguatur = shambles.nextInt();//15; // Tempo para cada turista dentro da piscina
		numpas = shambles.nextInt();//20; //Número de pássaros
		
		interpas = shambles.nextInt();//4; // Valor para passaro iniciar trajeto
		maxpas = shambles.nextInt();//4; // Máx pássaros que podem estar bebendo água
		beberpas = shambles.nextInt();//5; // Tempo para beber água


		Date message = new Date(); 
		System.out.println(message + ": Início da observação [" + BoundedBufferTurista.count + " turistas e " + BoundedBufferPassarinho.count + " passarinhos]");
		CriaTuristas threadBase1 = new CriaTuristas();
		CriaPassarinhos threadBase2 = new CriaPassarinhos();
		Thread threadCriaT = new Thread(threadBase1);
		Thread threadCriaP = new Thread(threadBase2);
		threadCriaT.start();
		threadCriaP.start();
 
      	while(threadCriaT.isAlive() || threadCriaP.isAlive());	
		message = new Date(); 
		System.out.println(message + ": Término da observação [" + BoundedBufferTurista.count + " turistas e " + BoundedBufferPassarinho.count + " passarinhos]");	
	}
}
