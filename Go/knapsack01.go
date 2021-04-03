package main

import (
	"fmt"
	"time"
)

var T [10][50]int

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

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
	if T[n][W] != -1 {
		return T[n][W]
	}

	if n == 0 || W == 0 {
		T[n][W] = 0
		return T[n][W]
	}

	if wt[n-1] <= W {
		T[n][W] = max(knapsackMemoization(val, wt, W, n-1),
			knapsackMemoization(val, wt, W-wt[n-1], n-1)+val[n-1])
	} else {
		T[n][W] = knapsackMemoization(val, wt, W, n-1)
	}
	return T[n][W]

}

func knapsackTopdown(val []int, wt []int, W int, n int) int {
	for i := 0; i <= W; i++ {
		T[n][i] = 0
	}
	for i := 1; i <= n; i++ {
		T[n][W] = 0
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= W; j++ {
			if wt[i-1] <= j {
				T[i][j] = max(T[i-1][j-wt[i-1]]+val[i-1], T[i-1][j])
			} else {
				T[i][j] = T[i-1][j]
			}
		}
	}
	return T[n][W]
}

func main() {
	var val = []int{10, 15, 40, 40}
	var wt = []int{1, 3, 4, 6}
	var W int = 7
	var n int = len(val)

	for i := 0; i <= n; i++ {
		for j := 0; j <= W; j++ {
			T[i][j] = -1
		}
	}
	start := time.Now()
	fmt.Println(recursiveKnapsack(val, wt, W, n))
	fmt.Println("Execution Time: ", time.Since(start))
	fmt.Println(knapsackMemoization(val, wt, W, n))
	fmt.Println("Execution Time: ", time.Since(start))
	fmt.Println(knapsackTopdown(val, wt, W, n))
	fmt.Println("Execution Time: ", time.Since(start))
	// for i := 0; i <= n; i++ {
	// 	for j := 0; j <= W; j++ {
	// 		fmt.Print(T[i][j], " ")
	// 	}
	// 	fmt.Println()
	// }
}
