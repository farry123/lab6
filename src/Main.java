public class Main {
	
	public static void test() {
		int testCapacity = 10;
		Stack<String> stack = new ArrayStack<>(testCapacity);
		
		for (int i = 0; i < testCapacity; i++) {
			try {
				stack.push("Some value");
			} catch (InvalidOperationException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < testCapacity + 1; i++) {
			try {
				System.out.println(stack.pop());
			} catch (InvalidOperationException e) {
				e.printStackTrace();
			}
		}
		
		try {
			stack.peek();
		} catch (InvalidOperationException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		Stack<Integer> stack = new ArrayStack<>(4);

		try {
			stack.push(3);
			stack.push(5);
			stack.push(32);
			stack.push(12);
		} catch (InvalidOperationException e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("Next element: " + stack.pop());
			System.out.println("Next element: " + stack.pop());
			System.out.println("Next element: " + stack.pop());
			System.out.println("Next element: " + stack.pop());
			System.out.println("Next element: " + stack.pop());
		} catch (InvalidOperationException e) {
			System.out.println(e.getMessage());
		}
		try {
			stack.peek();
		} catch (InvalidOperationException e) {
			System.out.println(e.getMessage());
		}

		Queue<Integer> queue = new StackedQueue<>(4);

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
			System.out.println("Next element: " + queue.dequeue());
			System.out.println("Next element: " + queue.dequeue());
			System.out.println("Next element: " + queue.dequeue());
			System.out.println("Next element: " + queue.dequeue());
			System.out.println("Next element: " + queue.dequeue());
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
