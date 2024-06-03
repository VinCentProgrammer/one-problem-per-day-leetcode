package stackandqueue;

public class MyArrayQueue implements IStackQueue {
    private int array[];
    private int SIZE;
    private int headIndex;
    private int tailIndex;

    public MyArrayQueue(int size) {
        SIZE = size;
        array = new int[size];
        headIndex = tailIndex = -1;
    }


    @Override
    public boolean push(int value) {
        if (!isFull()) {
            if (isEmpty()) {
                headIndex++;
            }
            array[++tailIndex] = value;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        int value = -1;
        if (!isEmpty()) {
            value = array[headIndex++];
            if (headIndex > tailIndex) {
                headIndex = tailIndex = -1;
            }
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return headIndex == -1 && tailIndex == -1;
    }

    @Override
    public boolean isFull() {
        return tailIndex == SIZE - 1;
    }

    public int count() {
        if (isEmpty())
            return 0;
        return tailIndex - headIndex + 1;
    }

    @Override
    public void show() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            for (int i = headIndex; i <= tailIndex; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
}