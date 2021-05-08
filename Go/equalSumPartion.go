package main

import "fmt"

func recursiveEqualSumPart(arr []int, sum int, n int) bool {
	if sum == 0 {
		return true
	}
	if n == 0 {
		return false
	}

	if arr[n-1] <= sum {
		return recursiveEqualSumPart(arr, sum, n-1) ||
			recursiveEqualSumPart(arr, sum-arr[n-1], n-1)
	}
	return recursiveEqualSumPart(arr, sum, n-1)
}

func memoizationEqualSumPart(arr []int, sum int, n int) int {
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
		T_int[n][sum] = max(memoizationEqualSumPart(arr, sum, n-1),
			memoizationEqualSumPart(arr, sum-arr[n-1], n-1))
	} else {
		T_int[n][sum] = memoizationEqualSumPart(arr, sum, n-1)
	}
	return T_int[n][sum]
}

func bottomupEqualSumPart(arr []int, sum int, n int) bool {

	for i := 0; i <= n; i++ {
		T_bool[i][0] = true
	}

	for i := 1; i <= sum; i++ {
		T_bool[sum][i] = false
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= sum; j++ {
			if arr[i-1] <= j {
				T_bool[i][j] = T_bool[i-1][j] || T_bool[i-1][j-arr[i-1]]
			} else {
				T_bool[i][j] = T_bool[i-1][j]
			}
		}
	}
	return T_bool[n][sum]
}

func equalSumPart() {
	var arr = []int{2, 5, 8, 4, 9}
	var sum int

	for a := range arr {
		sum += a
	}

	var n int = len(arr)

	for i := 0; i <= n; i++ {
		for j := 0; j <= sum; j++ {
			T_int[i][j] = -1
		}
	}
	fmt.Println("=================================================")
	fmt.Println("Find if array can be divide in two equal partitions")
	fmt.Println("=================================================")
	if sum%2 == 1 {
		fmt.Println(false)
		return
	}
	fmt.Println(recursiveEqualSumPart(arr, sum/2, n))
	fmt.Println(memoizationEqualSumPart(arr, sum/2, n))
	fmt.Println(bottomupEqualSumPart(arr, sum/2, n))
}
