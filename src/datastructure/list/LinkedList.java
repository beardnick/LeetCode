package datastructure.list;

public class LinkedList<T> {


     static class  Node<T>{
        T data;
        Node previous;
        Node next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> head;

     private Node<T> tail;

    private int size;

   public boolean isEmpty(){
       return size == 0;
   }

   public int getSize(){
       return this.size;
   }

   private void checkIndex(int index){
       if(index < 0 || index > size){
           throw new IndexOutOfBoundsException("Index: " + index + "Size:" + size);
       }
   }

    public void insertToHead(T data){
       insertToIndex(data,0);
    }

    public void insertToTail(T data){
        insertToIndex(data,size);
    }

    public void insertToIndex(T data, int index){
        Node<T> node = new Node(data);
        if(isEmpty()){
            head = node;
            tail = node;
            node.previous = node;
            node.next = node;
            size ++;
            return;
        }
        checkIndex(index);
        if (index <= size >> 1){
            int cnt = 0;
            Node<T> p = head;
            while (cnt < index){
                p = p.next;
                cnt ++;
            }
            System.out.println(node.data + ":" + cnt);
            node.next = p;
            node.previous = p.previous;
            p.previous.next = node;
            p.previous = node;
        }else {
            int cnt = size;
            Node<T> p = tail;
            while (cnt > index) {
               p = p.previous;
               cnt --;
            }
            System.out.println(node.data + ":" + cnt);
            node.previous = p;
            node.next = p.next;
            p.next.previous = node;
            p.next = node;
        }
        if(index == 0){
            head = node;
        }
        if (index == size) {
            tail = node;
        }
            size++;
        }

//    public Node<T> get(int index){
//
//    }


    @Override
    public String toString() {
       if(isEmpty()){
           return "[]";
       }
        StringBuilder sb = new StringBuilder("[");
        Node p = head;
        while (p.next != tail)
         {
            sb.append(p.data.toString()).append(",");
            p = p.next;
        }
        if(p != tail){
            sb.append(p.data.toString()).append(',');
        }
        sb.append(tail.data.toString()).append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
       LinkedList<String> linkedList = new LinkedList();
        linkedList.insertToTail("a");
        linkedList.insertToHead("b");
        linkedList.insertToTail("c");
        linkedList.insertToHead("d");
        linkedList.insertToIndex("2", 2);
        System.out.println(linkedList);

    }

}
