package project3;

public class Test {
    public static void main(String[] args) {
        testStack();
    }

    public static void testList() {
        MyList<Double> testList = new MyList<>();

        testList.add(4.9, 0);
        testList.add(3.7, 1);
        testList.add(2.3, 1);
        testList.add(5.1, 1);
        System.out.println("testList: " + testList);

        testList.remove(1);
        System.out.println("testList: " + testList);

        testList.remove(0);
        System.out.println("testList: " + testList);

        System.out.println(testList.get(0));

        testList.remove(1);
        System.out.println("testList: " + testList);

        testList.remove(2.3);
        System.out.println("testList: " + testList);
    }

    public static void testStack() {
        MyStack<String> testStack = new MyStack<>();

        testStack.push("Hello");
        testStack.push("Mom");
        testStack.push("Taste");
        System.out.println(testStack);

        System.out.println(testStack.pop());
        System.out.println(testStack.top());
    }
}
