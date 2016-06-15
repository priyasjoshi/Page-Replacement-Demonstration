// Class to implement FIFO Page replacement algorithm 
public class Implementation {
	public Implementation(){};
	// FIFO Method
	public void Fifo(int frames,int [] reference){
	int pageFault = 0;
	// Queue class object to initialize FIFO Queue 
	BoundedQueue q = new BoundedQueue(frames);
	System.out.println("for FIFO");
	// Iterate through reference array
	for(int i= 0;i< reference.length;i++){
		if(q.iterator(reference[i])){
			if(!q.isFull()){
				q.enqueue(reference[i]);
			}
			else{
				q.dequeue();
				q.enqueue(reference[i]);
			}
			// increment the page fault value
			pageFault +=1;
		}
		// display the available frames
		q.display(reference[i]);
	  }
	  System.out.println("Number of page faults using FIFO is " + pageFault);
	}
}
