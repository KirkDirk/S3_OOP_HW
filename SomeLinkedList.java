import java.util.Iterator;

public class SomeLinkedList<E> implements Iterable<E>{

    //private Node<E> node;
    private Node<E> nodeFirst;
    private Node<E> nodeLast;
    private int sizeList = 0;
    
    private class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;
        
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
        //node = new Node<E>(null, null, null);
        nodeFirst = new Node<E>(null, null, nodeLast);
        nodeLast = new Node<E>(null, nodeFirst, null);
    }

    public void add(E el){
        Node<E> node = nodeLast; 
        node.setItem(el);
        nodeLast = new Node<E>(null, node, null);
        nodeFirst.setNext(node);
        node.setNext(nodeLast);
        //node.setPrev(nodeFirst);
        //System.out.println(node.getItem() + " " + nodeLast.getPrev().getItem() + " " + nodeFirst.getNext().getItem() + " " + node.getNext().getItem()+ " " + node.getPrev().getItem());
        //nodeFirst = new Node<E>(null, null, node);
        //System.out.println(nodeFirst.getNext());
        
        sizeList ++;        
        // System.out.println("prev:" + node.getPrev().getItem());
        // System.out.println("item:" + node.getItem());
        // System.out.println("next:" + node.getNext().getItem());
    }

    public int size(){
        return sizeList;
    }

    public E getItemByIndex(int counter){
        Node<E> getItem = nodeFirst.getNext();
        //System.out.println(nodeFirst.getNext().getItem());
        for (int i = 0; i < counter; i++) {
            getItem = getNextItem(getItem);
        }
        return getItem.getItem();
    }

    private Node<E> getNextItem(Node<E> element){
        return element.getNext();
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
                return getItemByIndex(index++);
            }
            
        };
    }
    
}

