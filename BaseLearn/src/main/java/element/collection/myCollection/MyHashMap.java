package element.collection.myCollection;

import lombok.Data;

import java.util.HashMap;

/**
 * 自定义hashMap
 *
 * @author Hanz
 * @date 2020/2/25
 */
public class MyHashMap {

    @Data
    class Node {
        private int hash;
        private Object key;
        private Object value;
        private Node next;
    }

    /**
     * 位捅数组
     */
    Node[] table;
    /**
     * key-value's size
     */
    int size;

    public MyHashMap() {
        table = new Node[16]; // length should be 2's Integer power
    }

    public void put(Object key, Object value) {
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node temp = table[newNode.hash];
        if (temp == null){
            table[newNode.hash] = newNode;
        }else {
            //Traverse all
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(10,"aa");
        myHashMap.put(20,"bb");
    }
    public int myHash(int v, int length) {
        return v & (length - 1);
    }

}
