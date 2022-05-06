public class LinkedList<K, V> {

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private int hash(Object key) {
        return (Math.abs(key.hashCode())) % hashTable.length;
    }

    private Node<K, V>[] hashTable;


    private int count;



    public LinkedList() {
        hashTable = new Node[4];
    }


    void print() {
        System.out.println();
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print(i + ":");
            Node<K, V> list = hashTable[i];
            while (list != null) {
                System.out.print("  (" + list.key + "," + list.value + ")");
                list = list.next;
            }
            System.out.println();
        }
    }


    public void add(K key, V value) {

        int bucket = hash(key);

        Node<K, V> list = hashTable[bucket];
        while (list != null) {

            if (list.key.equals(key))
                break;
            list = list.next;
        }


        if (list != null) {

            list.value = value;
        }
        else {

            Node<K, V> newN = new Node<>(key, value);
            newN.key = key;
            newN.value = value;
            newN.next = hashTable[bucket];
            hashTable[bucket] = newN;
            count++;
        }
    }


    public V get(K key) {

        int bucket = hash(key);

        Node<K, V> node = hashTable[bucket];
        while (node != null) {
            if (node.key.equals(key))
                return node.value;
            node = node.next;
        }
        return null;
    }


    public void remove(K key) {
        int bucket = hash(key);
        if (hashTable[bucket] == null) {
            return;
        }

        if (hashTable[bucket].key.equals(key)) {
            hashTable[bucket] = hashTable[bucket].next;
            count--;
            return;
        }

        LinkedList.Node<K, V> previousNode = hashTable[bucket];
        LinkedList.Node<K, V> currentNode = previousNode.next;
        while (currentNode != null && ! currentNode.key.equals(key)) {
            currentNode = currentNode.next;
            previousNode = currentNode;
        }

        if (currentNode != null) {
            previousNode.next = currentNode.next;
            count--;
        }
    }

    public int size() {
        return count;
    }

}
