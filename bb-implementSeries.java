Implement Stack using Queues
class MyStack {
    // Push element x onto stack.
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    public void push(int x) {
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        
    }

    // Get the top element.
    public int top() {
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return (queue1.isEmpty() && queue2.isEmpty());
    }
}


Implement Queue using Stacks
class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int x) {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }
}