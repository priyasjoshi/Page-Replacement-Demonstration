import java.util.ArrayList;
import java.util.LinkedList;
// Lru class to implement Lru algorithm
public class Lru {
	int [] Reference;
	int value = 0;
	int pageFault = 0;
	ArrayList<Integer> arrayList;
	// Linkedlist to maintain stack of Least recently used apge frames
	LinkedList<Integer> List =  new LinkedList<Integer>();
	// Constructor to initalize frames and array of reference string
	public Lru(int frames, int[] array){
		Reference = array;
		value = frames;
		// arraylist to maintain frames
		arrayList =  new ArrayList<Integer>(frames);
		// Iterate through reference array
		for(int i= 0;i< Reference.length;i++){
			if(!arrayList.contains(Reference[i]))
			{
				// To check if arraylist is full?
				if(arrayList.size()< frames){
					arrayList.add(Reference[i]);
					List.addFirst(Reference[i]);
				}
				else{
					int removeElement = getElement();
					int removeIndex = 0;
					// to replace a page frame with least recently used element
						if(arrayList.contains(removeElement)){
							removeIndex = arrayList.indexOf(removeElement);
						}
					arrayList.remove(removeIndex);
					arrayList.add(removeIndex, Reference[i]);
					// to push an element into the stack 
					List.removeLast();
					List.addFirst(Reference[i]);
				}
				pageFault+=1;
			}
			// To push recently used element into the stack 
			else{
				Object p = Reference[i];
				List.remove(p);
				List.addFirst(Reference[i]);
			}
			// To print the output  
			display(Reference[i]);
		}
		 System.out.println("Number of page faults using LRU is " + pageFault);
	}
	// function to get least recently used stack elements
	public int getElement(){
		int element;
		element = List.getLast();
		return element;
	}
	// function to display desired output of pageframes
	public void display(int current) {
		boolean isFirst = true;
		int count = value - arrayList.size();
		for(int i=0;i<arrayList.size();i++){
				if(isFirst){
					System.out.print(current + ": <"+arrayList.get(i));
					isFirst = false;
				}
				else{
					System.out.print(" , "+arrayList.get(i));
				}
		}
		if(count > 0){
			for(int j =0;j< count;j++){
				System.out.print(" , "+" ");
			}
		}
		System.out.println(">");
	}
}
