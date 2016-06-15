import java.util.ArrayList;
// Optimal class to implement Optimal algorithm
public class Optimal {
	int [] Reference;
	int value;
	int pageFault = 0;
	// Global arraylist variable to hold the page frames 
	ArrayList<Integer> arrayList;
	// Class constructor to initialize frames and reference array
	public Optimal(int frames, int[] array){
		Reference = array;
		value = frames;
		arrayList =  new ArrayList<Integer>(frames);
		for(int i= 0;i< Reference.length;i++){
			if(!arrayList.contains(Reference[i])){
				if(arrayList.size()< frames){
					arrayList.add(array[i]);
				}
				else{
					int Greatest = 0;
					int greatestIndex = 0;
					outerloop:{
					for(int j=0;j<arrayList.size();j++){
					 int index = FutureSearch(arrayList.get(j),i+1);
						if(index==-1){
							arrayList.remove(j);
							arrayList.add(j,Reference[i]);
							break outerloop;
						}
						else{
							if(index > Greatest){
								Greatest = index;
							}
						}
					  }
						int element = Reference[Greatest];
						for(int item=0;item<arrayList.size();item++){
							if(arrayList.contains(element)){
								greatestIndex =  item;
							}
						}
						arrayList.remove(greatestIndex);
						arrayList.add(greatestIndex, Reference[i]);
					}
				}
				pageFault+=1;
			}
			display(Reference[i]);
		}
		System.out.println("Number of page faults using Optimal is " + pageFault);
	}
	// Function to  search an element in the future stream
	private int FutureSearch(int element, int pos) {
		for (int k = pos;k < Reference.length;k++){
			if(element == Reference[k]){
				return k;
			}
		}
		return -1;
	}
	// function to display desired output of pageframes
	public void display(int current) {
		boolean isFirst = true;
		int count = value - arrayList.size();
		for(int i=0;i<arrayList.size();i++){
			if(isFirst){
				System.out.print(current + ": < "+arrayList.get(i));
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
