/**
 * Utilities for causing a thread to sleep.
 * Note, we should be handling interrupted exceptions
 * but choose not to do so for code clarity.
 *
 */

public class SleepUtilities
{
	/**
	 * Nap between zero and NAP_TIME seconds.
	 */
	public static void nap() {
		nap(NAP_TIME);
	}
	public static void caminhar() throws InterruptedException{
		try{ Thread.sleep(Factory.camtur * 1000); }
		catch(InterruptedException e){ }
		//nap(Factory.CAMTUR);
	}
	public static void banhar() throws InterruptedException{
		try{ Thread.sleep(Factory.aguatur * 1000); }
		catch(InterruptedException e){ }
		//nap(Factory.CAMTUR);
	}
	public static void beber() throws InterruptedException{
		try{ Thread.sleep(Factory.beberpas * 1000); }
		catch(InterruptedException e){ }
		//nap(Factory.CAMTUR);
	}

	/**
	 * Nap between zero and duration seconds.
	 */
	public static void nap(int duration) {
        	int sleeptime = (int) (NAP_TIME * Math.random() );
        	try { Thread.sleep(sleeptime*5000); }
        	catch (InterruptedException e) {}
	}

	private static final int NAP_TIME = 5;
}
