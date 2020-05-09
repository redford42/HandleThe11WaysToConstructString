package element.collection.myCollection;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import java.util.HashMap;

/**
 * 自定义实现ArrayList
 *
 * @author Hanz
 * @date 2020/2/24
 */
public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size = 0;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new RuntimeException("容器容量不能为负数");
        } else if (capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else {
            elementData = new Object[capacity];
        }
    }

    public void add(E e) {
        grow();
        elementData[size++] = e;
    }

    public E get(int index) {
        // 索引越界检查
        checkRange(index);
        return (E) elementData[index];
    }

    public void set(E e, int index) {
        // 索引越界检查
        checkRange(index);
        elementData[index] = e;
    }

    public int size() {
        return size;
    }

    public void remove(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(get(i))) {
                remove(i);
            }
        }
    }

    public void remove(int index) {
        int numMoved = elementData.length - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        ;
    }

    private void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            // 不合法
            throw new RuntimeException("索引不合法" + index);
        }
    }


    private void grow() {
        if (size == elementData.length) {
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            // 右移1相当于除2？？
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //[a,b,c]
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]).append(",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> my1 = new MyArrayList<>(20);
        for (int i = 0; i < 40; i++) {
            my1.add(i);
        }
        System.out.println(my1.toString());
    }
}
