/**
 * This is the producer thread for the bounded buffer problem.
 */


import java.util.*;

public class Turista implements Runnable
{
   int idtur;
   public Turista(BoundedBufferTurista b, int idtur) {
      buffer = b;
      this.idtur = idtur;
   }
   
   public void run()
   {
   Date message = new Date(); 
         System.out.println(message + ": O turista " + idtur  + " inicia a caminhada à piscina [" + BoundedBufferTurista.count + " turistas]");
         
         try {
			SleepUtilities.caminhar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   
         message = new Date();      
         System.out.println(message + ": O turista " + idtur + " terminou a caminhada e chegou à margem da piscina [" + BoundedBufferTurista.count + " turistas]");
           
         buffer.insert(message);
         try {
			SleepUtilities.banhar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         buffer.remove();
      
   }
   
   private BoundedBufferTurista buffer;
}
