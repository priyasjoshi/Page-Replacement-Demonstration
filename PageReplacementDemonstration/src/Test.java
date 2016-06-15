import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	// Function to seperate the comma seperated input line and call the desired algorithm 
	public static void Perform(String line){
		// to hold the input data 
		ArrayList<Integer> arrayList =  new ArrayList<Integer>();
		int frames = 0;
		String algorithm = null;
		String [] Comma = line.split(",");
		for(int i=0;i<Comma.length;i++){
			// to get the algorithm and no of page frames
			algorithm = Comma[0];
			frames = Integer.parseInt(Comma[1]);
			if(i>1){
				// to get the input page frame values into the arraylist
				int value = Integer.parseInt(Comma[i]);
				arrayList.add(value);
			}
		}
		// converting an arralist into the array
		int [] Reference = arrayList.stream().mapToInt(i -> i).toArray();
		// calling  a desired algorithm to process the data according to the input
		if(algorithm.equals("F")){
			Implementation m = new Implementation();
			m.Fifo(frames, Reference);
		}
		else if(algorithm.equals("O")){
			Optimal O = new Optimal(frames,Reference);
		}
		else if(algorithm.equals("L")){
			Lru l = new Lru(frames,Reference);
		}
	}
	public static void main(String[] args) throws IOException {
		// Input file reading
		  try {
			BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
			String line = null;
			while((line = br.readLine())!=null){
				String [] values = line.split(" ");
				for(String data:values){
					// function call to send the input file line
					Perform(data);
					System.out.println("------------------------------------------------");
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	  
	}
}
