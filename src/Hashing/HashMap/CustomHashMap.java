package Hashing.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMap {

    static class HashMap<K,V> {

        private class Node {
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; // number of nodes
        private int N; // size of array
        private LinkedList<Node> buckets[]; // Declared array of Data type "LinkedList of type Node"

        public HashMap(){
            this.N = 3;
            this.buckets = new LinkedList[N]; // Initialized the array of linkedlists with size equal to N
            for(int i=0; i<N; i++){
                this.buckets[i] = new LinkedList<>(); // Assing the empty linkedlist at every array element position
            }
        }

        private int hashFuction(K key) {
            int bucketIndex = key.hashCode();
            return Math.abs(bucketIndex) % N;
        }
        private int searchInLinkedList(K key, int bucketIndex){
            LinkedList<Node> ll = buckets[bucketIndex];
            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key == key){
                    return i; // "i" is the index of the key we are searching in linkedlist
                }
            }
            return -1; // key is not present in linkedlist
        }
        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N*2];
            for(int i=0; i<N*2; i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i=0; i<oldBuckets.length; i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0; j<ll.size(); j++){
                    Node data = ll.get(j);
                    put(data.key, data.value);
                }
            }
        }
        public void put(K key, V value) {
            int bucketIndex = hashFuction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex); // index of data in linkedlist
            if(dataIndex == -1){ // if key doesn't exist add new one
                buckets[bucketIndex].add(new Node(key, value));
                n++;
            } else {            // if key exist just update it
                Node data = buckets[bucketIndex].get(dataIndex);
                data.value = value;
            }
            double lamda = (double)n/N;
            double k = 2.0; // threashhold value
            if(lamda > k){
                // do rehashing
                rehash();
            }
        }

        public V get(K key){
            int bucketIndex = hashFuction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);
            if(dataIndex == -1){
                return null;
            } else {
                Node data = buckets[bucketIndex].get(dataIndex);
                return data.value;
            }
        }

        public boolean containsKey(K key){
            int bucketIndex = hashFuction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);
            if(dataIndex == -1){
                return false;
            } else{
                return true;
            }
        }

        public V removeKey(K key){
            int bucketIndex = hashFuction(key);
            int dataIndex = searchInLinkedList(key, bucketIndex);
            if(dataIndex == -1){
                return null;
            } else {
                Node data = buckets[bucketIndex].remove(dataIndex);
                n--;
                return data.value;
            }
        }

        public boolean isEmpty(){
            return n == 0;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++){
                    Node data = ll.get(j);
                    keys.add(data.key);
                }
            }
            return keys;
        }

    }

    public static void main(String args[]) {
       
        HashMap<String, Integer> map = new HashMap<>();
        map.put("india", 1000);
        map.put("us", 2000);
        map.put("china", 5000);
        map.removeKey("china");
        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++){
            System.out.println("{ key: " + keys.get(i) + "  value: " + map.get(keys.get(i)) + " }");
        }

    }
}