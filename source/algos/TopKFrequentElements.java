package algos;


import java.util.*;

// 347 Top K Frequent Elements
public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] data = {10, 10, 2, 2, 3, 2, 2, 2, 2, 4, 4, 4};
//        System.out.println(Arrays.toString(topKFrequent(data, 3)));
//        System.out.println(Arrays.toString(topKFrequent(data, 1)));

        int[] data1 = {10, 10, 3, 3, 5};
        int[] data2 = {-1, -1};
//        System.out.println(Arrays.toString(topKFrequent2(data1, 2)));
//        System.out.println(Arrays.toString(bucketSort(data1, 2)));
        System.out.println(Arrays.toString(bucketSort(data2, 1)));

    }

    public static int[] bucketSort(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums)
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);

        int size = nums.length + 1;
        List<List<Integer>> sortedBucket = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            sortedBucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            sortedBucket.get(Math.abs(entry.getValue())).add(entry.getKey());
        }

        int[] data = new int[k];
        int dataFill = data.length - 1;

        for (int i = sortedBucket.size() - 1; i >= 0; i--) {
            for (Integer el : sortedBucket.get(i)) {
                if (dataFill >= 0) {
                    data[dataFill] = el;
                    dataFill--;
                } else {
                    break;
                }
            }
        }

        return data;
    }


    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int el : nums) {
            if (count.containsKey(el)) {
                count.put(el, count.get(el) + 1);
            } else count.put(el, 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(count.entrySet());
        entryList.sort((Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) -> entry2.getValue() - entry1.getValue());

        int[] kElements = new int[k];
        int counter = k;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            if (counter == 0) break;

            kElements[counter - 1] = entry.getKey();

            counter--;
        }

        return kElements;
    }

    public static int[] topKFrequent2(int[] nums, int k) {

        int[] frequent = new int[k];

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
//            map.merge(n, 1, (Integer v1, Integer v2) -> v1 + v2);
        }

        for (int key : frequencyMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();  // Удалить элемент с минимальной частотой
            }
        }

        for (int i = 0; i < k; i++)
            frequent[i] = minHeap.poll();


        return frequent;
    }


}
