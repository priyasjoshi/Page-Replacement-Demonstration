// Queue interface 
public interface Queue {
	 void enqueue(Object item);
	 Object dequeue();
	 Object peek();
	 int size();
	 boolean isFull();
	 boolean iterator(Object item);
	 void display(int current);
}
