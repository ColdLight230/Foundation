package leetcode;

// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//The cache is initialized with a positive capacity.
//
//Follow up:
//Could you do both operations in O(1) time complexity?
//
//Example:
//
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 解题步骤：
 * 1. 需要有存储数据的容器，创建hashMap
 * 2. 需要在get和put时频繁更新key的位置，使用双向链表结构存储。
 * 3. 初始化头尾节点
 * 4. 实现get操作
 */
public class Code_146_LRUCache {

    class DLinkedNode {
        public int key;
        public int value;
        public DLinkedNode prev;
        public DLinkedNode next;
    }

    // 执行用时 :20 ms, 在所有 Java 提交中击败了85.71%的用户
    // 内存消耗 :53.9 MB, 在所有 Java 提交中击败了56.56%的用户
    class LRUCache {
        private HashMap<Integer, DLinkedNode> map = new HashMap<>();
        private int count;
        private int capacity;
        private DLinkedNode head;
        private DLinkedNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveNodeToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = map.get(key);
            if (node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.value = value;
                newNode.key = key;
                map.put(key, newNode);
                addNodeToHead(newNode);
                count++;
                if (count > capacity) {
                    map.remove(tail.prev.key);
                    takeNodeOut(tail.prev);
                    count--;
                }
            } else {
                node.value = value;
                moveNodeToHead(node);
            }
        }

        private void moveNodeToHead(DLinkedNode node) {
            takeNodeOut(node);
            addNodeToHead(node);
        }

        private void takeNodeOut(DLinkedNode node) {
            // 先将此节点摘出来
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addNodeToHead(DLinkedNode node) {
            // 将节点插入到头结点去
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
    }


    /**
     * 执行用时 : 27 ms , 在所有 Java 提交中击败了 58.20% 的用户
     * 内存消耗 : 50.3 MB , 在所有 Java 提交中击败了 92.14% 的用户
     */
    class LRUCache1 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache1(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public Integer get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new Code_146_LRUCache().new LRUCache(4);

        //        cache.put(1, 1);
        //        cache.put(2, 2);
        //        System.out.println(cache.get(1));       // returns 1
        //        cache.put(3, 3);    // evicts key 2
        //        System.out.println(cache.get(2));       // returns -1 (not found)
        //        cache.put(4, 4);    // evicts key 1
        //        System.out.println(cache.get(1));       // returns -1 (not found)
        //        System.out.println(cache.get(3));       // returns 3
        //        System.out.println(cache.get(4));       // returns 4

        //2,0,2,9,3,4,2,8,2,4,8,4,5
        cache.put(2, 2);
        cache.put(0, 0);
        cache.put(2, 2);
        cache.put(9, 9);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(2, 2);
        cache.put(8, 8);
        cache.put(2, 2);
        cache.put(4, 4);
        cache.put(8, 8);
        cache.put(4, 4);
        cache.put(5, 5);
        cache.put(7, 7);
    }
}
