package project3;

public class Test {
    public static void main(String[] args) {
//        testList();
        testStack();
//        testQueue();
    }

    public static void testList() {
        MyList<Integer> testList = new MyList<>();
        System.out.println(testList.size());

        testList.add(4,0);
        System.out.println("testList: " + testList);

        testList.add(5,0);
        System.out.println("testList: " + testList);

        testList.remove(0);
        System.out.println("testList: " + testList);
    }

    public static void testStack() {
        MyStack<String> testStack = new MyStack<>();
        MyStack<String> testStack2 = new MyStack<>();

        for (int i = 0; i < 10; i++) {
            testStack.push("Hello" + i);
        }
        testStack.pop();
        System.out.println(testStack);


        for (int i = 0; i < 10; i++) {
            testStack2.push("Hello" + i);
        }
        testStack2.pop();
        System.out.println(testStack2);

        testStack.push(testStack2.pop());
        System.out.println(testStack);

        System.out.println(testStack.equals(testStack2));


    }

    public static void testQueue() {
        MyQueue<Integer> testQueue = new MyQueue<>(5);

        testQueue.enqueue(4);
        testQueue.enqueue(3);
        testQueue.enqueue(1);
        testQueue.enqueue(2);
        System.out.println("testQueue: " + testQueue.toString());

        testQueue.enqueue(5);
        System.out.println("testQueue: " + testQueue.toString());

        testQueue.dequeue();
        testQueue.dequeue();
        System.out.println("testQueue: " + testQueue.toString());

        testQueue.enqueue(6);
        System.out.println("testQueue: " + testQueue.toString());

        testQueue.enqueue(8);
        System.out.println("testQueue: " + testQueue.toString());

        testQueue.enqueue(9);
        System.out.println("testQueue: " + testQueue.toString());
    }
}
