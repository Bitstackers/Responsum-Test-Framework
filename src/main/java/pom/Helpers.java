package main.java.pom;

/**
 * Created by Anna on 2015-04-20.
 */
public class Helpers {

	public static void waiting(int time) {
		System.out.println("Waiting for " + time);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
