class Test{

    void sol1_bubble_sort(int[] arr, int k){
        System.out.println("Modified bubble sort soln - O(n*k)");
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

    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        Test t = new Test();
        t.sol1_bubble_sort(arr, k);
    }
}