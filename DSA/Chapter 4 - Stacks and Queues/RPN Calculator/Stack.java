public interface Stack { // Stack class ADT
  // Reinitialize the stack.
  public void clear();

  // Push "it" onto the top of the stack
  public boolean push(Object it);

  // Remove and return the element at the top of the stack
  public Object pop();

  // Return a copy of the top element
  public Object topValue();
  
  // Return true if the stack is empty 
  public boolean isEmpty();
}