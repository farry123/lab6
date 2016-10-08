public class ArrayStack<T> implements Stack<T> {

    private int capacity; // Ń€Đ°Đ·ĐĽĐµŃ€ ĐĽĐ°Ń�Ń�Đ¸Đ˛Đ°
    private T[] stackArray; //Ń�Đ°ĐĽ ĐĽĐ°Ń�Ń�Đ¸Đ˛
    private int top;//Đ¸Đ˝Đ´ĐµĐşŃ� Đ˛ĐµŃ€Ń�Đ¸Đ˝Ń‹

    public ArrayStack(int capacity) { //ĐşĐľĐ˝Ń�Ń‚Ń€Ń�ĐşŃ‚ĐľŃ€ Ń�Ń‚ŃŤĐşĐ°
        this.capacity = capacity;
        stackArray = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T a) throws InvalidOperationException {
        if (isFull()) {
            throw new InvalidOperationException("Stack is overfull");
        } else {
            stackArray[++top] = a;//Đ·Đ°ĐżĐ¸Ń�ŃŚ Đ˛ ĐĽĐ°Ń�Ń�Đ¸Đ˛
        }
    }

    public T pop() throws InvalidOperationException {
        if (isEmpty()) {
            throw new InvalidOperationException("Stack is Empty");
        } else {
            return stackArray[top--];//Ń�Đ˝Đ°Ń‡Đ°Đ»Đ° Đ˛ĐµŃ€Đ˝ĐµŃ‚Ń�ŃŹ top,  ĐżĐľŃ‚ĐľĐĽ ĐľŃ‚Đ˝Đ¸ĐĽĐµŃ‚Ń�ŃŹ 1
        }
    }

    public T peek() throws InvalidOperationException {
        if (isEmpty()) {
            throw new InvalidOperationException("Stack is Empty");
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == capacity - 1);
    }

    public int getSize() {
        int size = top;
        return ++size;
    }
}
