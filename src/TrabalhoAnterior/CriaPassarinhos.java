
public class CriaPassarinhos implements Runnable{

	
	
	
	public void run() {
		//System.out.println("Passouv2");
		BoundedBufferPassarinho bufferPassarinhos = new BoundedBufferPassarinho(Factory.numpas, Factory.maxpas);
		Thread producerThread = new Thread(); 
		for(int b = 0; b < Factory.numpas; b++){
  			//System.out.println("Passouv2");
  			producerThread = new Thread(new Passarinho(bufferPassarinhos, b));
  			producerThread.start();
  			
  			try {
				Thread.sleep(Factory.interpas * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		}
		while(producerThread.isAlive());
	}
}
