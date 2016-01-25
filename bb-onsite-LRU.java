class DoubleLinkedListNode {
    DoubleLinkedListNode pre;
    DoubleLinkedListNode next;
    int val;
    int key;
    DoubleLinkedListNode(int key, int val) {
        pre = null;
        next = null;
        this.val = val;
        this.key = key;
    }
}
public class LRUCache {
    int capacity;
    int length;
    DoubleLinkedListNode head;
    DoubleLinkedListNode end;
    HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        length = 0;
        head = null;
        end = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.val;
        }
        else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            removeNode(node);
            map.remove(key);
            node.val = value;
            setHead(node);
            map.put(key, node);
        }
        else {
            if(length < capacity) {
                DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
                length++;
                map.put(key, node);
                setHead(node);
            }
            else {
                DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
                map.remove(end.key);
                end = end.pre;
                if(end != null) {
                    end.next = null;
                }
                setHead(node);
                map.put(key, node);
            }
        }
    }
    private void setHead(DoubleLinkedListNode node) {
        node.pre = null;
        node.next = head;
        if(head != null) {
            head.pre = node;
        }
        head = node;
        if(end == null) {
            end = node;
        }
    }
    private void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node;
        DoubleLinkedListNode pre = node.pre;
        DoubleLinkedListNode next = node.next;
        if(pre != null) {
            pre.next = next;
        }
        else {
            head = next;
        }
        if(next != null) {
            next.pre = pre;
        }
        else {
            end = pre;
        }
    }
}