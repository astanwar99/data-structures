package main

import (
	"fmt"
	"time"
)

func recursiveKnapsack(val []int, wt []int, W int, n int) int {
	if W == 0 || n == 0 {
		return 0
	}

	if wt[n-1] <= W {
		return max(recursiveKnapsack(val, wt, W, n-1),
			recursiveKnapsack(val, wt, W-wt[n-1], n-1)+val[n-1])
	}
	return recursiveKnapsack(val, wt, W, n-1)

}

func knapsackMemoization(val []int, wt []int, W int, n int) int {
	if T_int[n][W] != -1 {
		return T_int[n][W]
	}

	if n == 0 || W == 0 {
		T_int[n][W] = 0
		return T_int[n][W]
	}

	if wt[n-1] <= W {
		T_int[n][W] = max(knapsackMemoization(val, wt, W, n-1),
			knapsackMemoization(val, wt, W-wt[n-1], n-1)+val[n-1])
	} else {
		T_int[n][W] = knapsackMemoization(val, wt, W, n-1)
	}
	return T_int[n][W]

}

func knapsackTopdown(val []int, wt []int, W int, n int) int {
	for i := 0; i <= W; i++ {
		T_int[n][i] = 0
	}
	for i := 1; i <= n; i++ {
		T_int[n][W] = 0
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= W; j++ {
			if wt[i-1] <= j {
				T_int[i][j] = max(T_int[i-1][j-wt[i-1]]+val[i-1], T_int[i-1][j])
			} else {
				T_int[i][j] = T_int[i-1][j]
			}
		}
	}
	return T_int[n][W]
}

func knapsack01() {
	var val = []int{10, 15, 40, 40}
	var wt = []int{1, 3, 4, 6}
	var W int = 7
	var n int = len(val)

	for i := 0; i <= n; i++ {
		for j := 0; j <= W; j++ {
			T_int[i][j] = -1
		}
	}
	start := time.Now()
	fmt.Println(recursiveKnapsack(val, wt, W, n))
	fmt.Println("Execution Time: ", time.Since(start))
	fmt.Println(knapsackMemoization(val, wt, W, n))
	fmt.Println("Execution Time: ", time.Since(start))
	fmt.Println(knapsackTopdown(val, wt, W, n))
	fmt.Println("Execution Time: ", time.Since(start))
}
