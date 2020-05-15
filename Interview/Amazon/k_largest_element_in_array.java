import java.util.*;

class Test{

    void sol1_bubble_sort(int[] ar, int k){
        System.out.println("Modified bubble sort soln - O(n*k)");
        int[] arr = ar.clone();
        int n = arr.length;
        int temp = 0;
        for(int i = 0; i < k; ++i) {
            for(int j = 1; j < n - i; ++j){
                if(arr[j] < arr[j - 1]){
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        for (int i = n - 1; i > n - k - 1 ; i--) {
            System.out.print(arr[i] + " ");            
        }
        System.out.println();
    }

    void sol2_temp_array(int[] ar, int k){
        System.out.println("Temporary array soln - O((n - k)*k)");
        int[] arr = ar.clone();
        int n = arr.length;
        int[] temp = new int[k];
        int temp_min_index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }

        for (int i = k; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if(min > temp[j]){
                    min = temp[j];
                    temp_min_index = j;
                }
            }

            if(arr[i] > temp[temp_min_index]){
                temp[temp_min_index] = arr[i];
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(temp[i] + " ");            
        }
        System.out.println();
    }

    void sol3_sorting(int[] ar, int k) {
        System.out.println("Normal sorting soln - O(nlogn)");
        int[] arr = ar.clone();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = n - 1; i > n - k - 1 ; i--) {
            System.out.print(arr[i] + " ");            
        }
        System.out.println();
    }

    void sol4_max_heaps(int[] ar, int k) {
        System.out.println("Using Max Heap - O(n + klogn)");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Integer[] arr = Arrays.stream(ar).boxed().toArray(Integer[]::new);
        maxHeap.addAll(Arrays.asList(arr));
        
        Iterator<Integer> it = maxHeap.iterator();
        while(k-- > 0 && it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    void sol5_temp_minHeap(int[] ar, int k){
        System.out.println("Temp min heap - O(k + (n - k)logk)");
        PriorityQueue<Integer> tempMinHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            tempMinHeap.add(ar[i]);
        }
        for (int i = k; i < ar.length; i++) {
            int root = tempMinHeap.peek();
            if(root < ar[i]){
                tempMinHeap.remove(root);
                tempMinHeap.add(ar[i]);
            }
        }
        Iterator<Integer> it = tempMinHeap.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        Test t = new Test();

        t.sol1_bubble_sort(arr, k);
        t.sol2_temp_array(arr, k);
        t.sol3_sorting(arr, k);
        t.sol4_max_heaps(arr, k);
        t.sol5_temp_minHeap(arr, k);
    }
}