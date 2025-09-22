import java.lang.reflect.Array;

public class MyLL<T> {
    //node only in MyLL
    // T is the object (the generic)
    Node<T> head;
    Node<T> tail;
    int size;
    Node<T> currentNode;

    public void addFirst(T data) {
        if (head == null) {
            Node<T> newHead = new Node<T>(data);
            head = newHead;
            tail = newHead;
            size++;
            //Create new node object
            //head = newNode
        } else {
            Node<T> headNew = new Node<T>(data);
            headNew.setNext(head);
            head = headNew;
            size++;
            //Create new node object
            // newNode.setNext(head)
            //head = newNode
        }

        //LL is empty ot LL has data in it;

        // TODO: Implement this method - replace object with generic
        // Hint: Think about pointer manipulation order!
    }

    public void addLast(T data) {
        if (tail == null) {
            Node<T> newHead = new Node(data);
            head = newHead;
            tail = newHead;
            size++;
        } else {
            Node<T> tailNew = new Node(data);
            tail.setNext(tailNew);
            tail = tailNew;
            size++;
        }
        // TODO: Implement this method - replace object with generic
        // Hint: Don't forget the empty list edge case!
    }

    public void add(int index, T data) {
        currentNode = head;
        if ((size - index) == 0 && index != 0) {
            addLast(data);
        } else if ((size - index) < 0 && size != 0) {
            //do nothing because out of bounds
        } else if (size == 0 || index == 0) {
            addFirst(data);
        } else if ((size - index) > 0) {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            Node<T> newNo = new Node<T>(data);
            newNo.setNext(currentNode.getNext());
            currentNode.setNext(newNo);
            size++;
        }
        // TODO: Implement this method - replace object with generic
        // Hint: Be careful with index bounds and pointer order!
    }

    public int removeFirst() {
        currentNode = head;
        // TODO: Implement this method
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return 1;
        } else if (size == 0) {
            return -1;
        } else {
            head = currentNode.getNext();
            currentNode.setData(null);
            size--;
            return 1;
        }// Hint: What happens when you remove the only element?
    }

    public int removeLast() {
        // TODO: Implement this method
        currentNode = head;

        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return 1;

        } else if (size == 0) {
            return -1;

        } else {
            for (int i = 0; i < size; i++) {
                if (currentNode.getNext().getNext() == null) {
                    currentNode.setNext(null);
                    tail = currentNode;
                    size--;
                    return 1;
                } else {
                    currentNode = currentNode.getNext();
                }

            }
        }
        return -1;
        // Hint: What happens when you remove the only element?
    }

    public boolean remove(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: You need the node BEFORE the one you're removing!
        display();
        currentNode = head;

        if (!contains(data)) {
            return false;
        } else if (head.getData().equals(data)) {
            removeFirst();
            return true;
        } else {
            currentNode = head; //WHY DOES THIS WORK
            System.out.println("I'm at: " + currentNode.getData());
            for (int i = 0; i < size; i++) {
                if (currentNode.getNext().getData().equals(data) && i == size - 1) {
                    removeLast();
                    return true;
                } else if (currentNode.getNext().getData().equals(data)) {
                    Node<T> currNodeNewNext = currentNode.getNext().getNext();
                    Node<T> currNodeOldNext = currentNode.getNext();
                    currentNode.setNext(currNodeNewNext);
                    currNodeOldNext.setNext(null);
                    size--;
                    return true;
                } else {
                    currentNode = currentNode.getNext();
                }
            }
            return false;
        }
    }

    // I just coped remove because it seems they are the same method, are they?
    public boolean removeFirstOccurrence(T data) {
        // TODO: Implement this method - replace object with generic

        display();
        currentNode = head;

        if (!contains(data)) {
            return false;
        } else if (head.getData().equals(data)) {
            removeFirst();
            return true;
        } else {
            currentNode = head; //WHY DOES THIS WORK
            System.out.println("I'm at: " + currentNode.getData());
            for (int i = 0; i < size; i++) {
                if (currentNode.getNext().getData().equals(data) && i == size - 1) {
                    removeLast();
                    return true;
                } else if (currentNode.getNext().getData().equals(data)) {
                    Node<T> currNodeNewNext = currentNode.getNext().getNext();
                    Node<T> currNodeOldNext = currentNode.getNext();
                    currentNode.setNext(currNodeNewNext);
                    currNodeOldNext.setNext(null);
                    size--;
                    return true;
                } else {
                    currentNode = currentNode.getNext();
                }
            }
            return false;
        }
    }

    // I need help with this one
    public boolean removeLastOccurrence(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Track the previous node of the last occurrence found
        currentNode = head;
        Node<T> mover = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (currentNode.getData().equals(data)) {
                lastIndex = i;
            }
            mover = currentNode;
            currentNode = currentNode.getNext();
        }
        if (lastIndex == -1) {
            return false;
        }
        System.out.println("last index is: " + lastIndex);
        mover = head;
        currentNode = head;
        if (lastIndex == 1) {
            removeFirst();
            return true;
        } else if (lastIndex == size - 1) {
            removeLast();
            return true;
        } else {
            for (int i = 0; i < lastIndex - 1; i++) {
                mover = mover.getNext();
            }

        }
        mover.setNext(mover.getNext().getNext());
        size--;
        return true;
    }

    public void clear() {
        // TODO: Implement this method
        tail = null;
        head = null;
        size = 0;
    }


    public Object get(int index) {
        // TODO: Implement this method - replace object with generic
        // Hint: Use a loop counter to traverse the right number of steps
        currentNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return currentNode;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return null;
    }

    public Object getFirst() {
        // TODO: Implement this method - replace object with generic
        // Hint: Check if list is empty first!
        if (size == 0) {
            return null;
        } else {
            return head;
        }
    }

    public Object getLast() {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse to the end or use tail pointer if available
        if (size == 0) {
            return null;
        } else {
            return tail;
        }
    }


    public boolean contains(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse the entire list checking each node's data
        currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.getData().equals(data)) {
                return true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }

    public int indexOf(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Keep track of current index while traversing
        // Return -1 if not found
        currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.getData().equals(data)) {
                return i;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Track the last found index during traversal
        currentNode = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (currentNode.getData().equals(data)) {
                lastIndex = i;
                currentNode = currentNode.getNext();
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return lastIndex;
    }

    public Object set(int index, T data) {
        // TODO: Implement this method - replace object with generic
        // Hint: Similar to get(), but replace the data
        // Returns old value
        currentNode = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                T oldData = currentNode.getData();
                currentNode.setData(data);
                if (index == 0) {
                    head.setData(data);
                }
                return oldData;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return null;
    }

    public void replaceAll(T oldValue, T newValue) {
        // TODO: Implement this method - replace object with generic
        // Hint: Traverse and replace all instances of old value with new
        currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.getData().equals(oldValue)) {
                currentNode.setData(newValue);
                currentNode = currentNode.getNext();
            } else {
                currentNode = currentNode.getNext();
            }
        }
    }

    public int size() {
        // TODO: Implement this method
        // Hint: Just return the size field!
        return size;
    }

    public boolean isEmpty() {
        // TODO: Implement this method
        // Hint: Check if size is 0 or head is null
        if (size == 0 || head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        // TODO: Implement this method
        // Goal: Print something like "[HEAD] -> 10 -> 20 -> 30 -> [NULL]"
        currentNode = head;
        String str = "";
        for (int i = 0; i < size; i++) {
            if (currentNode.getData() == null) {
                String temp = "null";
                if (i == 0) {
                    str = str + "Head:" + temp + " ";
                } else if (i == size - 1) {
                    str = str + " Tail: " + temp;
                } else {
                    str = str + temp + " ";
                }
            } else {
                String temp2 = (String) (currentNode.getData());
                if (i == 0) {
                    str = str + "Head:" + temp2 + " ";
                } else if (i == size - 1) {
                    str = str + " Tail: " + temp2;
                } else {
                    str = str + temp2 + " ";
                }

            }
            currentNode = currentNode.getNext();
        }
        System.out.println(str);
    }

    public Object[] toArray() {
        // TODO: Implement this method - replace object with generic
        // Hint: Create array of size() and populate while traversing
        currentNode = head;

        T[] array = (T[]) Array.newInstance(currentNode.getData().getClass(), size);

        if (size == 0) {
            return null;
        } else {
            for (int i = 0; i < size; i++) {
                array[i] = currentNode.getData();
                currentNode = currentNode.getNext();
            }
        }
        return array;
    }
}
