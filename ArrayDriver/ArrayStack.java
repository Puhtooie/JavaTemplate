import java.util.Arrays;

/**
 * @author
 * @author Dilshad
 *
 * @param <T>
 */

public class ArrayStack<T> implements StackADT<T> {

    T[] array;
    int top;
    private static final int INITIAL_CAPACITY = 16;

    public ArrayStack() {
        // Generic arrays have to be created with Object arrays
        //Java does not allow to create/instantiate generic array by itself
        array = (T[]) (new Object[ArrayStack.INITIAL_CAPACITY]);
        top = 0;
    }

    /**
     * 	Method stubs of Stack <T> interface given, lets implement them together.
     */
    @Override
    public void push(T element) {
        //deal with the array being full later
        array[top] = element;
        top++;

    }

    @Override
    public T pop() {

        if(isEmpty())
            throw new EmptyCollectionException("Stack");
        top--;

        T temp = array[top];
        array[top] = null;

        return temp;
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyCollectionException("Stack");

        return array[top-1];
    }

    @Override
    public boolean isEmpty() {

        return (top == 0);
    }

    @Override
    public int size() {

        return top;
    }
    public void expandCapacty()
    {
        array = Arrays.copyOf(array, array.length * 2);
    }

    public String toString()
    {
        String result ="";
        for(int i =top-1; i >=0; i --)
            result += (array[i] + " ");
        return result;
    }
}
