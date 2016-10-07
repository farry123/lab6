public class StackedQueue implements Queue {
    private final ArrayStack leftStack;
    private final ArrayStack rightStack;

    StackedQueue(int capacity) {
        this.leftStack = new ArrayStack(capacity);
        this.rightStack = new ArrayStack(capacity);
    }

    public void enqueue(int a) throws InvalidOperationException {
        if (isFull()) {
            throw new InvalidOperationException("Queue is overfull");
        } else {
            this.leftStack.push(a);
        }
    }

    public int peek() throws InvalidOperationException {
        if (isEmpty()) {
            throw new InvalidOperationException("Queue is Empty");
        } else {
        if(!this.rightStack.isEmpty()) {
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

    public int dequeue() throws InvalidOperationException {
        if (isEmpty()) {
            throw new InvalidOperationException("Queue is Empty");
        } else {

        if(!this.rightStack.isEmpty()) {
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


