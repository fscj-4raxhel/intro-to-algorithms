package algo.elementry.datastructure;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;

public class ArrayStack<E> implements Stack<E>{

    public Object[] s = new Object[10];
    public int top = -1;

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(E x) {
        s[++top] = x;
    }

    @Override
    public E pop() throws Exception {
        if(this.isEmpty()){
            throw new Exception("Stack underflow");
        }
        E res = (E) s[top];
        s[top--] = null;
        return res;
    }

    @Test
    public void testStack() throws Exception {
        ArrayStack<Integer> stack = new ArrayStack<>();
        System.out.println(stack.isEmpty());
        stack.push(15);
        stack.push(6);
        stack.push(2);
        stack.push(9);
        System.out.println(Arrays.toString(stack.s));
        System.out.println(stack.top);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(Arrays.toString(stack.s));
        System.out.println(stack.top);
        stack.push(2);
        stack.push(9);
        System.out.println(Arrays.toString(stack.s));
        System.out.println(stack.top);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(Arrays.toString(stack.s));
        System.out.println(stack.top);
    }
}
