import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(0 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    int capacity;
    Map<Integer, DLinkedList> lruMap = null;
    DLinkedList head = null, tail = null;

    public class DLinkedList {
        int key;
        int val;
        DLinkedList pre;
        DLinkedList post;

        DLinkedList(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    private void removeNode(DLinkedList node) {
        if(node ==null) return;
        DLinkedList pre = node.pre;
        DLinkedList post = node.post;
        pre.post = post;
        post.pre = pre;
    }

    private DLinkedList removeTail() {
        DLinkedList node = tail.pre;
        removeNode(node);
        return node;
    }

    private void addNode(DLinkedList node){
        if(node ==null) return;
        DLinkedList second = head.post;
        second.pre = node;
        head.post = node;
        node.pre = head;
        node.post = second;
    }

    private void makeItTop(DLinkedList node) {
        removeNode(node);
        addNode(node);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedList(-1, -1);
        tail = new DLinkedList(-1, -1);
        head.post = tail;
        tail.pre = head;
        lruMap = new HashMap<>();
    }

    public int get(int key) {
        DLinkedList node = lruMap.get(key);
        if (node == null) return -1;
        makeItTop(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedList node = lruMap.get(key);
        if (node != null) {
            node.val = value;
            makeItTop(node);
            return;
        }
        if (lruMap.size() == capacity) {
            DLinkedList tail = removeTail();
            lruMap.remove(tail.key);
        }
        node = new DLinkedList(value, key);
        lruMap.put(key, node);
        addNode(node);
    }

  /*  private Map<Integer, DLinkNode> cache;
    DLinkNode tail = null;
    DLinkNode head = null;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<Integer, DLinkNode>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkNode target = cache.get(key);
            int value = target.value;
            target.update();
            return value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkNode target = cache.get(key);
            target.value = value;
            target.update();
        } else {
            if (capacity == 0) return;
            if (cache.size() == capacity) {
                cache.remove(head.key);
                head.removeFromHead();
            }
            DLinkNode newNode = new DLinkNode(key, value);
            newNode.append();
            cache.put(key, newNode);
        }
    }

    class DLinkNode {
        int key;
        int value;
        DLinkNode left = null;
        DLinkNode right = null;

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        // remove head from list and update head reference.
        private void removeFromHead() {
            // if 'this' is the only node, set both head and tail to null.
            if (tail == this) {
                head = null;
                tail = null;
            } else {
                head = this.right;
                head.left = null;
            }
        }

        private void update() {
            // no need to update if accessing the most revently used value.
            if (tail == this) return;
            else {
                // remove from current postion and update nodes (if any) on both sides.
                if (this != head) {
                    this.left.right = this.right;
                } else {
                    head = this.right;
                }
                this.right.left = this.left;
                // append to tail.
                this.append();
            }
        }

        private void append() {
            // inserting the first node.
            if (tail == null) {
                head = this;
                tail = this;
                // appned as tail and update tail reference.
            } else {
                this.right = null;
                this.left = tail;
                tail.right = this;
                tail = this;
            }
        }
    }*/
}
