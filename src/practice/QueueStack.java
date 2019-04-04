package practice;

import java.util.Stack;

public class QueueStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    @Override
    public String toString() {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return stack1.toString();
    }

    public static void main(String[] args) {
        QueueStack queue = new QueueStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue);
        queue.pop();
        System.out.println(queue);
        queue.push(4);
        queue.pop();
        queue.push(5);
        queue.pop();
        queue.push(6);
        queue.pop();
        System.out.println(queue);
    }
}
