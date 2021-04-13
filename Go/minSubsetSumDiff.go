package main

import "fmt"

func boottomupMinSubsetDiff(arr []int, tsum int, n int) int {
	var sum int = tsum / 2

	for i := 0; i <= n; i++ {
		T_bool[i][0] = true
	}
	for i := 1; i <= sum; i++ {
		T_bool[0][i] = false
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

	for i := sum; i >= 0; i-- {
		if T_bool[n][i] {
			return tsum - 2*i
		}
	}
	return 0
}

func minSubsetSumDiff() {
	var arr = []int{1, 4, 10}
	var sum int

	for _, a := range arr {
		sum += a
	}

	var n int = len(arr)
	fmt.Println(boottomupMinSubsetDiff(arr, sum, n))
}
