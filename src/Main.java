public class Main {
    public static void main(String[] args) {

        Stack stack = new ArrayStack(4);

        try {
            UserType<Integer> value1 = new UserType<>(10);
            stack.push(value1);

            /*
            stack.push(3);
            stack.push(5);
            stack.push(32);
            stack.push(12);*/


        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Next element: " + Integer.toString(stack.pop()));
            System.out.println("Next element: " + Integer.toString(stack.pop()));
            System.out.println("Next element: " + Integer.toString(stack.pop()));
            System.out.println("Next element: " + Integer.toString(stack.pop()));
            System.out.println("Next element: " + Integer.toString(stack.pop()));
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
        try {
            stack.peek();

        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }



       Queue queue = new StackedQueue(4);


        try {
            queue.enqueue(23);
            queue.enqueue(342);
            queue.enqueue(21);
            queue.enqueue(39);
            queue.enqueue(100);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Next element: " + Integer.toString(queue.dequeue()));
            System.out.println("Next element: " + Integer.toString(queue.dequeue()));
            System.out.println("Next element: " + Integer.toString(queue.dequeue()));
            System.out.println("Next element: " + Integer.toString(queue.dequeue()));
            System.out.println("Next element: " + Integer.toString(queue.dequeue()));
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
        try {
            queue.peek();

        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}



