package main

import (
	"fmt"
)

func max(a int8, b int8) int8 {
	if a > b {
		return a
	}
	return b
}

var T [10][50]bool
var S [10][40]int8

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

func memoizationSubsetSum(arr []int, sum int, n int) int8 {
	if S[n][sum] != -1 {
		return S[n][sum]
	}

	if sum == 0 {
		S[n][sum] = 1
		return 1
	}

	if n == 0 {
		S[n][sum] = 0
		return 0
	}

	if arr[n-1] <= sum {
		S[n][sum] = max(memoizationSubsetSum(arr, sum, n-1),
			memoizationSubsetSum(arr, sum-arr[n-1], n-1))
	} else {
		S[n][sum] = memoizationSubsetSum(arr, sum, n-1)
	}
	return S[n][sum]
}

func topdownSubsetSum(arr []int, sum int, n int) bool {
	for i := 0; i <= n; i++ {
		T[i][0] = true
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= sum; j++ {
			if arr[i-1] <= j {
				T[i][j] = T[i-1][j-arr[i-1]] || T[i-1][j]
			} else {
				T[i][j] = T[i-1][j]
			}
		}
	}
	return T[n][sum]
}

func subsetSum() {
	var arr = []int{2, 5, 8, 4, 9}
	var sum int = 15
	var n int = len(arr)

	for i := 0; i <= n; i++ {
		for j := 0; j <= sum; j++ {
			S[i][j] = -1
		}
	}

	fmt.Println(recursiveSubsetSum(arr, sum, n))
	fmt.Println(memoizationSubsetSum(arr, sum, n))
	fmt.Println(topdownSubsetSum(arr, sum, n))
	// for i := 0; i <= n; i++ {
	// 	for j := 0; j <= sum; j++ {
	// 		fmt.Print(T[i][j], " ")
	// 	}
	// 	fmt.Println()
	// }
}

func main() {
	subsetSum()
}
