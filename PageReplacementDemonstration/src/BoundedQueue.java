import java.util.NoSuchElementException;
//Class to handle FIFO queue which implements queue interface 
public class BoundedQueue implements Queue{
	 private Object[] array;
	 private int size = 0;
	 private int head = 0; 
	 private int tail = 0;
	// Constructor to set the capacity of the queue according to the no of frames 
	public BoundedQueue(int capacity){
		array = new Object[capacity];
		//for loop to set the array empty  
		for(int i=0;i<array.length;i++){
			array[i]="";
		}
	}
	//Queue interface method to insert into the queue
	@Override
	public void enqueue(Object item) {
		if (size == array.length) {
            throw new IllegalStateException("Cannot add to full queue");
        }
		array[tail] = item;
        tail = (tail + 1) % array.length;
        size++;
    }
	//Queue interface method to delete elements from the queue
	@Override
	public Object dequeue() {
	 if (size == 0) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        Object item = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return item;
	}
	//Queue interface method to get the queue top
	@Override
	public Object peek() {
		if (size == 0) {
            throw new NoSuchElementException("Cannot peek into empty queue");
        }
        return array[size - 1];
	}
	//Queue interface method to get the queue size
	@Override
	public int size() {
		return size;
	}
	//Queue interface method to check if queue is empty
	@Override
	public boolean isFull() {
		return(size == array.length);
	}
	//Queue interface method to iterate the queue of objects
	@Override
	public boolean iterator(Object item) {
		// TODO Auto-generated method stub
		for(int i=0;i<array.length;i++){
			if(item == array[i]){
				return false;
			}
		}
		return true;
	}
	//Queue interface method to display the queue
	@Override
	public void display(int current) {
		boolean isFirst = true;
		for(int i=0;i<array.length;i++){
			if(isFirst){
				System.out.print(current + ": <"+array[i]);
				isFirst = false;
			}
			else{
				System.out.print(" , "+array[i]);
			}
		}
		System.out.println(">");
	}
}
