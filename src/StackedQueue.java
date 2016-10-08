
public class StackedQueue<T> implements Queue<T> {
	private final ArrayStack<T> leftStack;
	private final ArrayStack<T> rightStack;

	public StackedQueue(int capacity) {
		this.leftStack = new ArrayStack<T>(capacity);
		this.rightStack = new ArrayStack<T>(capacity);
	}

	public void enqueue(T a) throws InvalidOperationException {
		if (isFull()) {
			throw new InvalidOperationException("Queue is overfull");
		} else {
			this.leftStack.push(a);
		}
	}

	public T peek() throws InvalidOperationException {
		if (isEmpty()) {
			throw new InvalidOperationException("Queue is Empty");
		} else {
			if (!this.rightStack.isEmpty()) {
				return this.rightStack.peek();
			} else {
				while (!this.leftStack.isEmpty()) {
					this.rightStack.push(this.leftStack.peek());
					this.leftStack.pop();
				}

				return this.rightStack.peek();
			}
		}
	}

	public T dequeue() throws InvalidOperationException {
		if (isEmpty()) {
			throw new InvalidOperationException("Queue is Empty");
		} else {

			if (!this.rightStack.isEmpty()) {
				return this.rightStack.pop();
			} else {
				while (!this.leftStack.isEmpty()) {
					this.rightStack.push(this.leftStack.peek());
					this.leftStack.pop();
				}

				return this.rightStack.pop();
			}
		}
	}

	public int getSize() {
		return this.leftStack.getSize() + this.rightStack.getSize();
	}

	public boolean isEmpty() {
		return this.getSize() == 0;
	}

	public boolean isFull() {
		return this.leftStack.isFull() || this.rightStack.isFull();
	}
}
