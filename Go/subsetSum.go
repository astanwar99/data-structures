package main

import (
	"fmt"
)

func recursiveSubsetSum(arr []int, sum int, n int) bool {
	if sum == 0 {
		return true
	}

	if n == 0 {
		return false
	}

	if arr[n-1] <= sum {
		return recursiveSubsetSum(arr, sum-arr[n-1], n-1) ||
			recursiveSubsetSum(arr, sum, n-1)
	}
	return recursiveSubsetSum(arr, sum, n-1)
}

func memoizationSubsetSum(arr []int, sum int, n int) int {
	if T_int[n][sum] != -1 {
		return T_int[n][sum]
	}

	if sum == 0 {
		T_int[n][sum] = 1
		return 1
	}

	if n == 0 {
		T_int[n][sum] = 0
		return 0
	}

	if arr[n-1] <= sum {
		T_int[n][sum] = max(memoizationSubsetSum(arr, sum, n-1),
			memoizationSubsetSum(arr, sum-arr[n-1], n-1))
	} else {
		T_int[n][sum] = memoizationSubsetSum(arr, sum, n-1)
	}
	return T_int[n][sum]
}

func bottomupSubsetSum(arr []int, sum int, n int) bool {
	for i := 0; i <= n; i++ {
		T_bool[i][0] = true
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= sum; j++ {
			if arr[i-1] <= j {
				T_bool[i][j] = T_bool[i-1][j-arr[i-1]] || T_bool[i-1][j]
			} else {
				T_bool[i][j] = T_bool[i-1][j]
			}
		}
	}
	return T_bool[n][sum]
}

func subsetSum() {
	var arr = []int{2, 5, 8, 4, 9}
	var sum int = 15
	var n int = len(arr)

	for i := 0; i <= n; i++ {
		for j := 0; j <= sum; j++ {
			T_int[i][j] = -1
		}
	}

	fmt.Println(recursiveSubsetSum(arr, sum, n))
	fmt.Println(memoizationSubsetSum(arr, sum, n))
	fmt.Println(bottomupSubsetSum(arr, sum, n))
}
