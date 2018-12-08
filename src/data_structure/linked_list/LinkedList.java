package data_structure.linked_list;

public class LinkedList<E> {
    public class Node {
        private E e;
        private Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    // region 构造函数
    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }
    // endregion

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // region add
    // 在链表头添加一个element
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表指定位置添加元素
    // 平常不使用，练习用
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    //在链表末尾加入元素
    public void addLast(E e) {
        add(size, e);
    }
    // endregion

    // region Retrieve
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }
    // endregion

    // region update
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    // endregion

    // region remove
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node ret = prev.next;
        prev.next = ret.next;
        ret.next = null;
        size--;
        return ret.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // 删除第一个是e的节点
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node ret = prev.next;
            prev.next = ret.next;
            ret.next = null;
            size--;
        }
    }
    // endregion


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList);
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.addFirst(777);
        System.out.println(linkedList);
        linkedList.addLast(888);
        System.out.println(linkedList);
        System.out.println("linked list third element is " + linkedList.get(3));
        System.out.println("linked list first element is " + linkedList.getFirst());
        System.out.println("linked list last element is " + linkedList.getLast());
        System.out.println("linked list contains element 1 " + linkedList.contains(1));

        linkedList.set(5, 999);
        System.out.println(linkedList);

        System.out.println("linked list contains element 1 " + linkedList.contains(1));
        linkedList.set(1,777);
        System.out.println(linkedList);
        linkedList.removeElement(777);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }

}
