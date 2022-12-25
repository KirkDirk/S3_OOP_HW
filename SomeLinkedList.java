import java.util.Iterator;

public class SomeLinkedList<E> implements Iterable<E>{

    private Node<E> node = null;
    private Node<E> nodeFirst = null;
    private Node<E> nodeLast = null;
    private int sizeList = 0;
    
    private class Node<E> {
        private E item;
        Node<E> prev;
        Node<E> next;
        
        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }                
    }

    public SomeLinkedList() {
        node = new Node<E>(null, null, null);
        nodeFirst = new Node<E>(null, nodeLast, null);
        nodeLast = new Node<E>(null, null, nodeFirst);
    }

    public void add(E e){
        node.setItem(e);
        nodeLast.setPrev(node);
        nodeFirst.setNext(node);
        node.setNext(nodeLast);
        node.setPrev(nodeFirst);
        nodeFirst = new Node<E>(null, nodeLast, node);
        
        sizeList ++;        
        System.out.println("prev:" + nodeFirst.prev.getItem());
        System.out.println("item:" + node.getItem());
        System.out.println("next:" + nodeFirst.next.getItem());
    }

    public int size(){
        return sizeList;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index<sizeList;
            }

            @Override
            public E next() {
                index++;
                return node.getItem();
            }
            
        };
    }
    
}

