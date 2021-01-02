import java.io.FileNotFoundException;

public class TSP_Main {
	
	// Takes one command line argument. An integer
	public static void main(String[] args) throws UnderflowException, FileNotFoundException {
		int numCities = 9;
		//int numCities = Integer.parseInt(args[0]);
		TSP_GUI d = new TSP_GUI(numCities);
		d.setVisible(true);
	}
}
