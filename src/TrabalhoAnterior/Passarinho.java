import java.util.*;
public class Passarinho implements Runnable{
	int idpas;
	boolean primeiraVez;
	   public Passarinho(BoundedBufferPassarinho b, int idpas) {
	      buffer = b;
	      this.idpas = idpas;
	      this.primeiraVez = true;
	   }
	   
	   public void run()
	   {
	   Date message = new Date();
	         System.out.println(message + ": O passarinho " + idpas + " chegou à margem pela primeira vez [" + BoundedBufferPassarinho.count + " passarinhos]");
	         
	         while(Factory.maxtur == BoundedBufferTurista.count){
	        	 message = new Date();
	        	System.out.println(message + ": O passarinho " + idpas + " teve que ir embora porque há muitos turistas [" + BoundedBufferPassarinho.count + " passarinhos]");
				try {
					Thread.sleep(Factory.interpas * 1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				message = new Date();
				System.out.println(message + ": O passarinho " + idpas + " voltou à margem da piscina [" + BoundedBufferPassarinho.count + " passarinhos]");
	         }

	
	         message = new Date();  

	         boolean variavel = true;
	         while(variavel){	 
	        	variavel = buffer.insert(idpas);
	        	if(variavel == false) break;
	        	message = new Date();
	        	System.out.println(message + ": O passarinho " + idpas + " teve que ir embora porque há muitos turistas [" + BoundedBufferPassarinho.count + " passarinhos]");
				try {
					Thread.sleep(Factory.interpas * 1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				message = new Date();
				System.out.println(message + ": O passarinho " + idpas + " voltou à margem da piscina");
	         }
	         buffer.remove();
	        
	      
	   }
	   
	   private  BoundedBufferPassarinho buffer;
}
