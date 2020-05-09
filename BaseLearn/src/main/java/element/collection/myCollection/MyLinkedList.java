package element.collection.myCollection;

import java.util.LinkedList;

/**
 * @author Hanz
 * @date 2020/2/25
 */
public class MyLinkedList<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        Node() {
        }

        Node(E element) {
            this.item = element;
        }
    }

    private Node<E> first;
    private Node<E> last;

    private int size;
    int modCount = 0;

    public void add(E element) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    private void checkRange(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引数字不合法" + index);
        }
    }

    public void add(int index, E element) {
        checkRange(index);
        Node<E> newNode = new Node<>(element);
        Node<E> temp = getNode(index);
        if (temp != null) {
            Node<E> up = temp.prev;
            up.next = newNode;
            newNode.next = temp;
            newNode.prev = up;
            size++;
        }
    }


    public E get(int index) {
        // 索引合法判断
        checkRange(index);
        // index 小于size的一半
        Node<E> temp = getNode(index);
        return temp.item;
    }


    public void remove(int index) {
        checkRange(index);
        Node<E> temp = getNode(index);
        if (temp != null) {
            Node<E> p = temp.prev;
            Node<E> n = temp.next;
            if (p != null) {
                p.next = temp.next;
            } else {
                first = n;
            }
            if (n != null) {
                n.prev = temp.prev;
            } else {
                last = p;
            }
            size--;
        }
    }

    public Node<E> getNode(int index) {
        checkRange(index);
        if (index < (size >> 1)) {
            Node<E> temp = first;
            for (int i = 0; i < index; i++) {
                temp = first.next;
            }
            return temp;
        } else {
            Node<E> temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = last.prev;
            }
            return temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        // 遍历链表
        Node<E> temp = first;
        while (temp != null) {
            sb.append(temp.item);
            sb.append(",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }


    public static void main(String[] args) {
        MyLinkedList<String> my1 = new MyLinkedList<>();
        my1.add("red");
        my1.add("abe");
        my1.add("nate");
        System.out.println("test" + my1.toString());
        my1.add(0, "sophie");
        System.out.println("test" + my1.toString());
//        LinkedList<String> my1 = new LinkedList<>();
//        my1.add("red");
//        my1.add("abe");
//        my1.add("nate");
//        System.out.println("test" + my1.toString());
//        my1.add(0, "sophie");
//        System.out.println("test" + my1.toString());

    }

}
