package neetcode150;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> cache = new HashMap<>();
    LinkedList<Integer> keysOrder = new LinkedList<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        System.out.println("get "+key);
        System.out.println("Before Get Order: " + keysOrder);
        if (cache.containsKey(key)) {
            keysOrder.removeFirstOccurrence(key);
            keysOrder.addFirst(key);
            return cache.get(key);
        }
        System.out.println("Get Cache: " + cache);
        System.out.println("Get Order: " + keysOrder);
        System.out.println("-----------");
        return -1;
    }

    public void put(int key, int value) {
        System.out.println("put "+key + " " + value);
        System.out.println("Before Put Cache: " + cache);
        System.out.println("Before Put Order: " + keysOrder);
        if (keysOrder.size() == capacity) {
            System.out.println("Eviction is required");
            if(cache.containsKey(key)){
                keysOrder.removeFirstOccurrence(key);
            }else {
                int removedKey = keysOrder.removeLast();
                cache.remove(removedKey);
            }
            keysOrder.addFirst(key);
        } else {
            keysOrder.addFirst(key);
        }
        cache.put(key, value);
        System.out.println("After Put Cache: " + cache);
        System.out.println("After Put Order: " + keysOrder);
        System.out.println("-----------");
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2, 6); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(1, 5); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.put(1, 2);    // returns -1 (not found)
        System.out.println(lRUCache.get(1)); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(2)); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    }
}