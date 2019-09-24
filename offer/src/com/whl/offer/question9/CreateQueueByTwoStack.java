package com.whl.offer.question9;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * <p>
 * 解题思路:
 * 使用stack1和stack2两个栈，stack1用于push,stack2用于pop,这两个Stack始终有一个是没有数据的
 * push时，如果stack1不为空，就直接将数据push进stack1，否则就先将stack2中的数据pop出来push进stack1中再将本次的值push进stack1中
 * pop时，如果stack2不为空，就直接pop，否则就先将stack1中的数据pop出来push进stack2中，然后再进行pop操作
 * 真实生产场景下，需要对push和pop进行同步控制
 */
public class CreateQueueByTwoStack {


    public static void main(String[] args) {
        WhlQueue queue = new WhlQueue();
        queue.push(1);
        queue.push(2);
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }

        System.out.println("==========");

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }


}


class WhlQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private ReentrantLock lock;

    public WhlQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
        lock = new ReentrantLock();
    }

    public void push(int val) {
        try {
            lock.lock();
            if (!stack1.isEmpty()) {
                stack1.push(val);
            } else {
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
                stack1.push(val);
            }
        } finally {
            lock.unlock();
        }
    }

    public int pop() {

        try {
            lock.lock();

            if (stack1.isEmpty() && stack2.isEmpty()) {
                throw new RuntimeException("The queue is empty!!");
            }

            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        } finally {
            lock.unlock();
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }


}
