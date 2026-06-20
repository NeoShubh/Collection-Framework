package com.example.Collections.list.Stack.programs;

import java.util.Stack;

public class ProgramOne {
    public static void main(String [] args){
        Stack <Integer> stk = new Stack<>();
        stk.push(1);stk.push(3);stk.push(6);stk.push(4);
        System.out.println(stk);
        System.out.println(stk.pop());
        System.out.println(stk);
        System.out.println(stk.peek());
        System.out.println(stk);
        //ite will give us index of the element present
        System.out.println(stk.search(3));
    }
}
