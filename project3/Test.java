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

//        MyList<Double> testList = new MyList<>();
//        MyList<Double> testList2 = new MyList<>();
//
//        testList.add(4.9, 0);
//        testList.add(3.7, 1);
//        testList.add(2.3, 1);
//        testList.add(5.1, 1);
//
//        testList2.add(4.9, 0);
//        testList2.add(3.7, 1);
//        testList2.add(2.3, 1);
//        testList2.add(5.1, 1);
//
//        System.out.println(testList.equals(testList2));
//
//        System.out.println("testList: " + testList);
//
//        testList.remove(5.1);
//        System.out.println("testList: " + testList);
//
//        testList.remove(0);
//        System.out.println("testList: " + testList);
//
//        System.out.println(testList.get(0));
//
//        testList.remove(1);
//        System.out.println("testList: " + testList);
//
//        testList.remove(2.3);
//        System.out.println("testList: " + testList);

//        MyList<Integer> intList = new MyList<Integer>();
//        intList.add(10, 0);
//        intList.add(15, 1);
//        intList.add(5, 0);
//        intList.add(5, 3);
//        System.out.println(intList);
//        System.out.println("Above should be 5, 10, 15, 5");
//        System.out.println(intList.get(0));
//        System.out.println("Above should be 5, get from pos 0");
//        System.out.println(intList.get(2));
//        System.out.println("Above should be 15, get from pos 2");
//        System.out.println(intList.find(50));
//        System.out.println("Above should be -1, finding item not in list.");
//        try {
//            System.out.print("What about pos 7: ");
//            System.out.println(intList.get(7));
//        } catch (Exception e){
//            System.out.println(e);
//        }
//        MyList<Integer> intList2 = new MyList<Integer>();
//        intList2.add(10, 0);
//        intList2.add(15, 1);
//        intList2.add(5, 0);
//        intList2.add(5, 3);
//        System.out.println("There's a new identical list: " + intList2);
//        System.out.println(intList.equals(intList2));
//        System.out.println("Above should be true, equals on 2 identical lists.");
//        intList2.remove(0);
//        System.out.println(intList.equals(intList2));
//        System.out.println("Above should be false, equals on 2 different lists, a.len > b.len.");
//        intList2.add(5, 0);
//        intList2.add(5, 0);
//        System.out.println(intList.equals(intList2));
//        System.out.println("Above should be false, equals on 2 different lists, a.len < b.len.");
//        intList2.remove(0);
//        intList2.add(10, 0);
//        System.out.println(intList.equals(intList2));
//        System.out.println("Above should be false, equals on 2 different lists, a.len = b.len.");
//        MyList<String> strList = new MyList<String>();
//        System.out.println(intList.equals(strList));
//        System.out.println("Above should be false, equals on 2 lists with dif types.");
    }

    public static void testStack() {
//        MyStack<String> testStack = new MyStack<>();
//        MyStack<String> testStack2 = new MyStack<>();
//
//        testStack.push("Hello");
//        testStack.push("Tester");
//
//        testStack2.push("Hello");
//        testStack2.push("Tester");
//
//        testStack.push(testStack.pop());
//        System.out.println(testStack);
//        System.out.println(testStack.equals(testStack2));

//        System.out.println("This starts the testing for MyStack:");
//        MyStack<Integer> ints = new MyStack<>();
//        MyStack<Integer> ints2 = new MyStack<>();
//        MyStack<String> str11 = new MyStack<>();
//        MyStack<String> str2 = new MyStack<>();
//        System.out.println(ints.equals(ints2));
//        System.out.println(ints.equals(str2));
//        ints.top();
//        ints2.top();
//        ints.pop();
//
//        ints.push(1);
//        System.out.println(ints.equals(ints2));
//        System.out.println(ints.equals(str2));
//        ints.push(2);
//        ints.push(3);
//        ints.push(4);
//        ints2.push(1);
//        ints2.push(2);
//        ints2.push(3);
//        ints2.push(4);
//        str11.push("Hello");
//        str11.push("My");
//        str11.push("Name");
//        str11.push("is");
//        str11.push("...");
//        str2.push("Hello");
//        str2.push("Hello");
//        str2.push("My");
//        str2.push("Name");
//        str2.push("is");
//        str2.push("...");
//        str2.push("Hello");
//        str2.push("topop");
//        str2.pop();
//        System.out.println(str11);
//        System.out.println(str2);
//        System.out.println(ints);
//        System.out.println(ints2);
//        System.out.println(ints.equals(ints2));
//        System.out.println(ints);
//        System.out.println(ints.top());
//        System.out.println(ints);
//        System.out.println(ints.pop());
//        System.out.println(ints);
//        System.out.println("This ends the testing for MyStack\n\n\n\n\n\n\n\n");

//        MyStack<Integer> intStack = new MyStack<>();
//        intStack.push(4);
//        intStack.push(5);
//        System.out.println(intStack.top());
//        System.out.println(intStack.pop());
//        System.out.println("Last 2 numbers should be 5 and 5, testing top and pop.");
//        intStack.push(5);
//        intStack.push(6);
//        while (intStack.top() != null) {
//            intStack.pop();
//        }
//        System.out.println(intStack.pop());
//        System.out.println(intStack.top());
//        System.out.println("Should print null and null, testing top and pop on empty stack");
//        MyStack<Integer> intStack2 = new MyStack<>();
//        intStack.push(4);
//        intStack.push(5);
//        intStack2.push(4);
//        intStack2.push(5);
//        System.out.println(intStack.equals(intStack2));
//        System.out.println("Should print true, testing equals on identical stacks.");
//        intStack2.push(6);
//        intStack.push(6);
//        intStack.push(7);
//        System.out.println(intStack.equals(intStack2));
//        System.out.println("Should print false, testing equals on stack where a.len > b.len.");
//        intStack2.push(7);
//        intStack2.push(8);
//        System.out.println(intStack.equals(intStack2));
//        System.out.println("Should print false, testing equals on stack where a.len < b.len.");
//        intStack.push(9);
//        System.out.println(intStack.equals(intStack2));
//        System.out.println("Should print false, testing equals on stack where a.len = b.len.");
//        MyStack<String> strStack = new MyStack<>();
//        strStack.push("test");
//        System.out.println(intStack.equals(strStack));
//        System.out.println("Should print false, testing equals on stacks with diff types.");
    }

    public static void testQueue() {
//        MyQueue<Integer> testQueue = new MyQueue<>(5);
//
//        testQueue.enqueue(4);
//        testQueue.enqueue(3);
//        testQueue.enqueue(1);
//        testQueue.enqueue(2);
//        System.out.println("testQueue: " + testQueue.toString());
//
//        testQueue.enqueue(5);
//        System.out.println("testQueue: " + testQueue.toString());
//
//        testQueue.dequeue();
//        testQueue.dequeue();
//        System.out.println("testQueue: " + testQueue.toString());
//
//        testQueue.enqueue(6);
//        System.out.println("testQueue: " + testQueue.toString());
//
//        testQueue.enqueue(8);
//        System.out.println("testQueue: " + testQueue.toString());
//
//        testQueue.enqueue(9);
//        System.out.println("testQueue: " + testQueue.toString());

//        System.out.println("The testing starts for MyQueue");
//        MyQueue<Integer> intsq = new MyQueue<>();
//        MyQueue<Integer> intsq2 = new MyQueue<>();
//        System.out.println(intsq);
//        intsq.enqueue(1);
//        System.out.println(intsq.equals(intsq));
//
//        intsq2.enqueue(1);
//        intsq2.enqueue(2);
//        intsq2.enqueue(3);
//        intsq2.enqueue(4);
//        intsq2.enqueue(5);
//        intsq2.enqueue(6);
//        intsq2.enqueue(7);
//        intsq2.dequeue();
//        intsq2.dequeue();
//
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.enqueue(2);
//        intsq.enqueue(3);
//        intsq.enqueue(4);
//        intsq.enqueue(5);
//        intsq.enqueue(6);
//        intsq.enqueue(7);
//        intsq.dequeue();
//
//
//        System.out.println(intsq2.equals(intsq));
//        System.out.println(intsq.equals(intsq2));
//        intsq.enqueue(8);
//        intsq.enqueue(9);
//        intsq.enqueue(10);
//        intsq.enqueue(11);
//        intsq.enqueue(12);
//        intsq.enqueue(13);
//        intsq.enqueue(14);
//        intsq.enqueue(15);
//        intsq.enqueue(16);
//        intsq.enqueue(17);
//        intsq.enqueue(18);
//        intsq.enqueue(19);
//        intsq.enqueue(20);
//        intsq.enqueue(21);
//        intsq.enqueue(22);
//        intsq.enqueue(23);
//        intsq.enqueue(24);
//        intsq.enqueue(25);
//        intsq.enqueue(26);
//        intsq.enqueue(27);
//        System.out.println(intsq);
//        intsq.dequeue();
//        System.out.println(intsq);
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq.dequeue());
//        System.out.println(intsq);
//        System.out.println(intsq);
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        System.out.println(intsq);
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        System.out.println(intsq);
//        intsq.enqueue(28);
//        intsq.dequeue();
//        System.out.println(intsq);
//        intsq.enqueue(29);
//        intsq.dequeue();
//        System.out.println(intsq);
//        intsq.enqueue(30);
//        intsq.enqueue(1);
//        intsq.enqueue(2);
//        intsq.enqueue(3);
//        intsq.enqueue(4);
//        intsq.enqueue(5);
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        System.out.println(intsq.equals(intsq2));
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        intsq.dequeue();
//        System.out.println(intsq.peek());
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(5);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        intsq.enqueue(1);
//        System.out.println(intsq);
//        System.out.println(intsq.peek());
//        System.out.println("The testing ends for MyQueue");

//        MyQueue<Integer> intQueue = new MyQueue<>();
//        intQueue.enqueue(1);
//        System.out.println(intQueue.dequeue());
//        System.out.println("If printed 1, successfully added and removed.");
//        intQueue.enqueue(1);
//        intQueue.enqueue(2);
//        intQueue.enqueue(3);
//        System.out.print(intQueue.dequeue());
//        System.out.print(intQueue.dequeue());
//        System.out.println(intQueue.dequeue());
//        System.out.println("If printed 1 2 3, successfully added and removed 3 objs.");
//        System.out.println("If printed 1, then 1 2 3, passed normal enqueue, dequeue testcases.");
//        System.out.println(intQueue.dequeue());
//        System.out.println("If printed null, passed empty dequeue testcase.");
//        intQueue.enqueue(1);
//        System.out.println(intQueue.peek());
//        System.out.println("If printed 1, then 1 2 3, passed normal peek testcases.");
//        System.out.print(intQueue.dequeue());
//        System.out.println(intQueue.peek());
//        System.out.println("If printed null, passed empty peek testcase.");
//        MyQueue<Integer> intQueue2 = new MyQueue<>();
//        intQueue.enqueue(1);
//        intQueue.enqueue(2);
//        intQueue.enqueue(3);
//        intQueue2.enqueue(1);
//        intQueue2.enqueue(2);
//        intQueue2.enqueue(3);
//        System.out.println(intQueue.equals(intQueue2));
//        System.out.println("If printed true, passed normal equals testcase.");
//        intQueue.enqueue(4);
//        System.out.println(intQueue.equals(intQueue2));
//        System.out.println("If printed false, passed a.size > b.size not equals testcase.");
//        intQueue2.enqueue(5);
//        intQueue2.enqueue(6);
//        System.out.println(intQueue.equals(intQueue2));
//        System.out.println("If printed false, passed a.size < b.size not equals testcase.");
//        intQueue2.dequeue();
//        System.out.println(intQueue.equals(intQueue2));
//        System.out.println("If printed false, passed a.size == b.size not equals testcase.");
//        System.out.println(intQueue);
//        System.out.println(intQueue2);
//        System.out.println("Two queues should be 1, 2, 3, 4 and 2, 3, 5, 6.");
//        for (int i = 0; i < 16; i += 1) {
//            intQueue2.enqueue(i);
//        }
//        System.out.println(intQueue2);
//        System.out.println("Queue should be  2, 3, 5, 6, 0 ... 15, testing growing during add, given starting size = 10.");
//        for (int i = 0; i < 16; i += 1) {
//            intQueue2.dequeue();
//        }
//        System.out.println(intQueue2);
//        System.out.println("Queue should be 12, 13, 14, 15.");
    }
}
