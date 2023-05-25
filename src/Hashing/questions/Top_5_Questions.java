package Hashing.questions;
import java.util.HashMap;
import java.util.HashSet;

// 1. Given an array of integers, find all elements in array that more than appears n/3 times where n is size of array
public class Top_5_Questions {
    // take number in array as key and frequency of it as value in hashmap
    public static void MajorityElemets(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();  
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(frequency > nums.length/3){
                System.out.println(key);
            }
        }
    }

    // 2. Union of two arrays and print the count of elements in union
    public static void union(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        System.out.println(set.size());
    }

    // 3. Intersection of two arrays [common elements of both arrays]
    public static void intersection(int arr1[], int arr2[]){
        HashSet set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }
        System.out.println(count);
    }

    // 4. find itinerary [journey or path] from tickets
    // Given hashmap with source [from] as key and destination [to] as value
    // there are no loops forming and every plane ticket is unique
    public static String getStart(HashMap<String,String> map){
        HashMap<String,String> reverseMap = new HashMap<>();
        for(String key : map.keySet()){
            // here key -> key and value -> map.get(key)
            reverseMap.put(map.get(key), key);
        }
        for(String key : map.keySet()){
            if(!reverseMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }
    public static void findItinerary(HashMap<String,String> map){
        // city that does not come in destination of any city is out entry point
        String start = getStart(map);
        while(map.containsKey(start)){
            System.out.print(start + "-> ");
            start = map.get(start);
        }
        System.out.println(start);
    }

    // 5. Subarray sum equal to k : return number of such subarrays in given array
    public static void subarraySum(int arr[], int k){
        HashMap<Integer,Integer> map = new HashMap<>(); // <sum and frequency>
        int sum = 0;
        int ans = 0;
        map.put(0, 1); // for empty array
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            } else {
                map.put(sum, 1);
            }
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        int arr[] = {1, 5, 4, 1, 1, 5, 5, 5};
        int arr2[] = {1, 5, 15, 1, 14, 5, 5, 5};

        int arr3[] = {10, 2, -2, -20, 10}; // ans = 3
        int k = -10;
        subarraySum(arr3, k);

        HashMap<String,String> map = new HashMap<>();
        map.put("mumbai", "delhi");
        map.put("chennai", "bengaluru");
        map.put("goa", "chennai");
        map.put("delhi", "goa");
        findItinerary(map);

        // MajorityElemets(arr);
        // union(arr, arr2);
        // intersection(arr, arr2);
    }

}
