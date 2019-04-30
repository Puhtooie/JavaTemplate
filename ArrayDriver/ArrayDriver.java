
public class ArrayDriver {

    public static void main(String[] args) {

        //create an ArrayStack object of type Stack that stores Integers


        ArrayStack<Integer> stacks = new ArrayStack<>();
        //Push 1, 2, 3, 4, and 5 on stack

        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);

        //Display contents of stack

        System.out.println(stacks.toString());

        System.out.println("There are: " + stacks.size() + " stacks in the array.");

        //pop one of the element
        System.out.println("The top is now: " + stacks.peek());
        stacks.pop();

        //Display stack
        System.out.println(stacks.toString());

//push some more integers on stack

        stacks.push(6);
        stacks.push(7);
        stacks.push(8);
        stacks.push(9);

        //Display

        System.out.println(stacks.toString());
        System.out.println("There are: " + stacks.size() + " stacks in the array.");

    }

}
