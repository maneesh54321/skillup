package com.learning.twentythree.dsalgo.stack;

import java.util.Deque;
import java.util.LinkedList;

public class BrowserHistory {

    private Deque<String> fwdStack;
    private Deque<String> bwdStack;

    public BrowserHistory(String homepage) {
        bwdStack = new LinkedList<>();
        bwdStack.push(homepage);
        fwdStack = new LinkedList<>();
    }

    public void visit(String url) {
        bwdStack.push(url);
        if (!fwdStack.isEmpty()) {
            fwdStack.clear();
        }
    }

    public String back(int steps) {
        steps = steps >= bwdStack.size() ? bwdStack.size()-1 : steps;
        while (steps>0) {
            steps--;
            fwdStack.push(bwdStack.pop());
        }
        return bwdStack.peek();
    }

    public String forward(int steps) {
        steps = steps > fwdStack.size() ? fwdStack.size() : steps;

        while (steps>0){
            steps--;
            bwdStack.push(fwdStack.pop());
        }

        return bwdStack.peek();
    }
}
