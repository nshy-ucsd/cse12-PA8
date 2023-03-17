import java.util.ArrayList;


public class MyBST<K extends Comparable<K>, V> {
    MyBSTNode<K, V> root = null;
    int size = 0;

    public int size() {
        return size;
    }

    public V insert(K key, V value) {
        V replaced = null;
        boolean cont = true;
        MyBSTNode<K,V> temp = root;
        while(cont)
        {
            if(key == null)
                throw new NullPointerException();
            if(temp == null)
            {
                temp = new MyBSTNode<K,V>(key, value, root);
                size++;
            }
            else if(key.compareTo(temp.getKey()) == 0)
            {
                replaced = temp.getValue();
                temp.setValue(value);
            }
            else if(key.compareTo(temp.getKey()) < 0)
            {
                temp = temp.left;
            }
            else if(key.compareTo(root.getKey()) > 0)
            {
                temp = temp.right;
            }
        }
        return replaced;
    }

    public V search(K key) {
        if(key == null)
            return null;
        MyBSTNode<K,V> temp = root;
        while(temp != null)
        {
            if(key.compareTo(temp.getKey()) == 0)
            {
                return temp.getValue();
            }
            else if(key.compareTo(temp.getKey()) < 0)
            {
                temp = temp.left;
            }
            else if(key.compareTo(root.getKey()) > 0)
            {
                temp = temp.right;
            }
        }
        return null;
    }

    public V remove(K key) {
        if(key == null)
            return null;
        MyBSTNode<K,V> temp = root;
        while(temp != null)
        {
            if(key.compareTo(temp.getKey()) == 0)
            {
                V removed = temp.getValue();
                if(temp.getLeft() == null && temp.getRight() == null)
                {
                    return removed;
                }
                else if(temp.getLeft() == null)
                {
                    temp = temp.getRight();
                }
                else if(temp.getRight() == null)
                {
                    temp = temp.getLeft();
                }
                else
                {
                    MyBSTNode<K,V> successor = temp.successor();
                    K newKey = successor.getKey();
                    temp.setValue(successor.getValue());
                    remove(newKey);
                    temp.setKey(newKey);
                }
                return removed;
            }
            else if(key.compareTo(temp.getKey()) < 0)
            {
                temp = temp.left;
            }
            else if(key.compareTo(root.getKey()) > 0)
            {
                temp = temp.right;
            }
        }
        return null;
    }

    public ArrayList<MyBSTNode<K, V>> inorder() {
        // TODO
        return null;
    }

    static class MyBSTNode<K, V> {
        private static final String TEMPLATE = "Key: %s, Value: %s";
        private static final String NULL_STR = "null";

        private K key;
        private V value;
        private MyBSTNode<K, V> parent;
        private MyBSTNode<K, V> left = null;
        private MyBSTNode<K, V> right = null;

        /**
         * Creates a MyBSTNode storing specified data
         *
         * @param key    the key the MyBSTNode will store
         * @param value  the data the MyBSTNode will store
         * @param parent the parent of this node
         */
        public MyBSTNode(K key, V value, MyBSTNode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        /**
         * Return the key stored in the the MyBSTNode
         *
         * @return the key stored in the MyBSTNode
         */
        public K getKey() {
            return key;
        }

        /**
         * Set the key stored in the MyBSTNode
         *
         * @param newKey the key to be stored
         */
        public void setKey(K newKey) {
            this.key = newKey;
        }

        /**
         * Return data stored in the MyBSTNode
         *
         * @return the data stored in the MyBSTNode
         */
        public V getValue() {
            return value;
        }

        /**
         * Set the data stored in the MyBSTNode
         *
         * @param newValue the data to be stored
         */
        public void setValue(V newValue) {
            this.value = newValue;
        }

        /**
         * Return the parent
         *
         * @return the parent
         */
        public MyBSTNode<K, V> getParent() {
            return parent;
        }

        /**
         * Set the parent
         *
         * @param newParent the parent
         */
        public void setParent(MyBSTNode<K, V> newParent) {
            this.parent = newParent;
        }

        /**
         * Return the left child
         *
         * @return left child
         */
        public MyBSTNode<K, V> getLeft() {
            return left;
        }

        /**
         * Set the left child
         *
         * @param newLeft the new left child
         */
        public void setLeft(MyBSTNode<K, V> newLeft) {
            this.left = newLeft;
        }

        /**
         * Return the right child
         *
         * @return right child
         */
        public MyBSTNode<K, V> getRight() {
            return right;
        }

        /**
         * Set the right child
         *
         * @param newRight the new right child
         */
        public void setRight(MyBSTNode<K, V> newRight) {
            this.right = newRight;
        }

        public MyBSTNode<K, V> successor() {
            MyBSTNode<K, V> ret = null;
            if(right != null)
                ret = right;
            while(ret.getLeft() != null)
            {
                ret = left;
            }
            return ret;
        }

        /**
         * This method compares if two node objects are equal.
         *
         * @param obj The target object that the currect object compares to.
         * @return Boolean value indicates if two node objects are equal
         */
        public boolean equals(Object obj) {
            if (!(obj instanceof MyBSTNode))
                return false;

            MyBSTNode<K, V> comp = (MyBSTNode<K, V>) obj;

            return ((this.getKey() == null ? comp.getKey() == null :
                    this.getKey().equals(comp.getKey()))
                    && (this.getValue() == null ? comp.getValue() == null :
                    this.getValue().equals(comp.getValue())));
        }

        /**
         * This method gives a string representation of node object.
         *
         * @return "Key:Value" that represents the node object
         */
        public String toString() {
            return String.format(
                    TEMPLATE,
                    this.getKey() == null ? NULL_STR : this.getKey(),
                    this.getValue() == null ? NULL_STR : this.getValue());
        }
    }

}
