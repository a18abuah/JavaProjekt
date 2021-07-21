import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		// SwingUtilities takes care of updates that happens in the GUI
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			// the method run starts the GUI
			public void run() {
				new GUI();
				
			}
		});
		

	}

}


