package model;

import java.util.Stack;

public class UndoHistory {
    // initialize a stack to store the undo history
    private Stack<int[]> undoStack = new Stack<int[]>();
    
    // check if stack is empty
    public boolean isStackEmpty() {
    	return this.undoStack.isEmpty();
    }
    
    // return the top element of the stack
    public int[] stackPeek() {
    	return this.undoStack.peek();
    }
    
    // empty stack
    public void clearStack() {
    	this.undoStack.clear();
    }
	
    // push an array to the stack
	public void pushToStack(int[] cell) {
		this.undoStack.push(cell);
	}
	
	// pop the topmost array from the stack
	public int[] popFromStack() {
		return this.undoStack.pop();
	}
}
