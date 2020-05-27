package edu.sjsu.cs.cs151.app;
import edu.sjsu.cs.cs151.view.View;
import edu.sjsu.cs.cs151.controller.Controller;
import edu.sjsu.cs.cs151.model.Model;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.SwingUtilities;

/**
 * <h1>Driver Class</h1>
 * <p>
 * The main driver of the game that runs all the components
 * 
 * @author Au, Phu, Tri
 * @version 1.0
 * @since 11-29-2018
 */
public class Driver {
	private static LinkedBlockingQueue<Message> queue; 
	private static Model model;
	private static View	view;

	/**
	 * The main method of the program
	 * @param args 
	 * @return Nothing
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		queue = new LinkedBlockingQueue<>();
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					view = new View();
					view.init(queue);
				}
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model = new Model();
		Controller game = new Controller(model, view, queue);
		game.mainLoop();
		view.dispose();
		queue.clear();


	}

}
