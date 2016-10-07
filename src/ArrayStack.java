public class ArrayStack implements Stack {

    private int capacity; // размер массива
    private int[] stackArray; //сам массив
    private int top;//индекс вершины

    public ArrayStack(int capacity) { //конструктор стэка
        this.capacity = capacity;
        stackArray = new int[capacity];
        top = -1;
    }

    public void push(int a) throws InvalidOperationException {
        if (isFull()) {
            throw new InvalidOperationException("Stack is overfull");
        } else {
            top++;
            stackArray[top] = a;//запись в массив
        }
    }

    public int pop() throws InvalidOperationException {
        if (isEmpty()) {
            throw new InvalidOperationException("Stack is Empty");
        } else {
            return stackArray[top--];//сначала вернется top,  потом отнимется 1
        }
    }

    public int peek() throws InvalidOperationException {
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
//        return  capacity;
    }
}
