package ch.hslu.sw2;

public class Demo {
    public static void main(String[] args) {
        StackArray<String> stackArray = new StackArray<>(16);
        StackArray<String> stackArray2 = new StackArray<>(4);
        StackArray<String> stackArray3 = new StackArray<>(4);

        stackArray.push("n");
        stackArray.push("e");
        stackArray.push("r");
        stackArray.push("u");
        stackArray.push("t");
        stackArray.push("k");
        stackArray.push("c");
        stackArray.push("u");
        stackArray.push("r");
        stackArray.push("t");
        stackArray.push("s");
        stackArray.push("n");
        stackArray.push("e");
        stackArray.push("t");
        stackArray.push("a");
        stackArray.push("D");


        stackArray2.push("d");
        stackArray2.push("n");
        stackArray2.push("i");
        stackArray2.push("s");


        stackArray3.push("l");
        stackArray3.push("l");
        stackArray3.push("o");
        stackArray3.push("t");

        while (!stackArray.isEmpty()) {
            System.out.print(stackArray.pop());
        }
        System.out.println();

        while (!stackArray2.isEmpty()) {
            System.out.print(stackArray2.pop());
        }
        System.out.println();

        while (!stackArray3.isEmpty()) {
            System.out.print(stackArray3.pop());
        }
    }
}
