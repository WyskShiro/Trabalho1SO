import java.util.Date;

public class BoundedBufferTurista{

	private static int BUFFER_SIZE;
	Date message = new Date();

	   private Semaphore mutex;
	   private Semaphore empty;
	   private Semaphore full;

	   static int count;
	   private int in, out;
	   private Object[] buffer;

	   public BoundedBufferTurista(int BUFFER_SIZE, int MAXTUR)
	   {
		  this.BUFFER_SIZE = BUFFER_SIZE; 
	      count = 0;
	      in = 0;
	      out = 0;

	      buffer = new Object[BUFFER_SIZE];

	      mutex = new Semaphore(1);
	      empty = new Semaphore(MAXTUR);
	      full = new Semaphore(0);
	   }

	   public boolean insert(Object item) {
	      empty.acquire();
	      mutex.acquire();

	      message = new Date();
	      int countAux = count + 1;
	      System.out.println(message + ": O turista " + in + " entrou na piscina [" + countAux + " turistas]");
	      ++count;
	      in = (in + 1) % BUFFER_SIZE;

	      mutex.release();
	      full.release();
	      return true;
	      
	   }

	   public boolean remove() {
	      full.acquire();
	      mutex.acquire();

	      message = new Date();
	      int countAux = count - 1;
	      System.out.println(message + ": O turista " + out + " saiu da piscina [" + countAux + " turistas]");
	      out = (out + 1) % BUFFER_SIZE;

	      --count;

	      mutex.release();
	      empty.release();
	      return true;

	   }
}
