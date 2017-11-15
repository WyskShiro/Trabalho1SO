
public class CriaTuristas implements Runnable{

	public void run() {
		BoundedBufferTurista bufferTuristas = new BoundedBufferTurista(Factory.numtur, Factory.maxtur);
		Thread producerThread = new Thread();
  		for(int a = 0; a < Factory.numtur; a++){
      		producerThread = new Thread(new Turista(bufferTuristas, a));
      		//Thread consumerThread = new Thread(new Consumer(server));
      
      		producerThread.start();
      		try {
				Thread.sleep(Factory.intertur * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		}
  		while(producerThread.isAlive());
	}
}
