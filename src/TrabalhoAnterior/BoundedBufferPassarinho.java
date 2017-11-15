import java.util.Date;

public class BoundedBufferPassarinho{

	Date message = new Date();
	public BoundedBufferPassarinho(int BUFFER_SIZES, int MAXPAS) {

		  BUFFER_SIZE = BUFFER_SIZES; 
	      count = 0;
	      in = 0;
	      out = 0;

	      mutex = new Semaphore(1);
	      empty = new Semaphore(MAXPAS);
	      full = new Semaphore(0);
	}
	  private static int BUFFER_SIZE;

	   private Semaphore mutex;
	   public Semaphore empty;
	   private Semaphore full;

	   static int count;
	   private int in, out;

	   public boolean insert(Object idpasO) {
	      empty.acquire();
	      mutex.acquire();

	      if(Factory.maxtur == BoundedBufferTurista.count){
		      empty.release();
		      mutex.release();
	    	  return true;
	      }

	      message = new Date();

	      System.out.println(message + ": O passarinho " + in + " começou a beber água da piscina [" + BoundedBufferPassarinho.count + " passarinhos]");
	      in = (in + 1) % BUFFER_SIZE;
	      ++count;

	      mutex.release();
	      full.release();
	      
	      try {
				SleepUtilities.beber();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	      return false;
	   }

	   public boolean remove() {
	      full.acquire();
	      mutex.acquire();

	      message = new Date();
	      System.out.println(message + ": O passarinho " + out+ " já bebeu água da piscina e não volta mais [" + BoundedBufferPassarinho.count + " passarinhos]");
	      out = (out + 1) % BUFFER_SIZE;

	      --count;

	      mutex.release();
	      empty.release();
	      return true;

	   }

}
