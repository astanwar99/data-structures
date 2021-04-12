package main

import "fmt"

func recursiveCountSubsetSum(arr []int, sum int, n int) int {
	if sum == 0 {
		return 1
	}

	if n == 0 {
		return 0
	}

	if arr[n-1] <= sum {
		return recursiveCountSubsetSum(arr, sum, n-1) +
			recursiveCountSubsetSum(arr, sum-arr[n-1], n-1)
	}
	return recursiveCountSubsetSum(arr, sum, n-1)
}

func memoizationCountSubsetSum(arr []int, sum int, n int) int {
	if T_int[n][sum] != -1 {
		return T_int[n][sum]
	}

	if sum == 0 {
		T_int[n][sum] = 1
		return T_int[n][sum]
	}

	if n == 0 {
		T_int[n][sum] = 0
		return T_int[n][sum]
	}

	if arr[n-1] <= sum {
		T_int[n][sum] = memoizationCountSubsetSum(arr, sum, n-1) +
			memoizationCountSubsetSum(arr, sum-arr[n-1], n-1)
	} else {
		T_int[n][sum] = memoizationCountSubsetSum(arr, sum, n-1)
	}
	return T_int[n][sum]
}

func bottomupCountSubsetSum(arr []int, sum int, n int) int {
	for i := 0; i <= n; i++ {
		T_int[i][0] = 1
	}
	for i := 1; i <= sum; i++ {
		T_int[0][i] = 0
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= sum; j++ {
			if arr[i-1] <= j {
				T_int[i][j] = T_int[i-1][j] + T_int[i-1][j-arr[i-1]]
			} else {
				T_int[i][j] = T_int[i-1][j]
			}
		}
	}
	return T_int[n][sum]
}

func countSubsetSum() {
	var arr = []int{2, 3, 5, 8, 4, 10}
	var sum int = 8
	var n int = len(arr)

	for i := 0; i <= n; i++ {
		for j := 0; j <= sum; j++ {
			T_int[i][j] = -1
		}
	}

	fmt.Println(recursiveCountSubsetSum(arr, sum, n))
	fmt.Println(memoizationCountSubsetSum(arr, sum, n))
	fmt.Println(bottomupCountSubsetSum(arr, sum, n))

}
