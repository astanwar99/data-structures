package main

import "fmt"

func bottom_up_unbounded_knapsack(val []int, wt []int, W int, n int) int {
	for i := 0; i <= n; i++ {
		T_int[i][0] = 0
	}
	for i := 0; i <= W; i++ {
		T_int[0][i] = 0
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= W; j++ {
			if wt[i-1] <= j {
				T_int[i][j] = max(T_int[i][j-wt[i-1]]+val[i-1], T_int[i-1][j])
			} else {
				T_int[i][j] = T_int[i-1][j]
			}
		}
	}

	return T_int[n][W]
}

func unbounded_knapsack() {
	var val = []int{10, 15, 40, 40}
	var wt = []int{2, 3, 4, 6}
	var W int = 8
	var n int = len(val)

	fmt.Println("=================================================")
	fmt.Println("Unboounded Knapsack")
	fmt.Println("=================================================")

	fmt.Println(bottom_up_unbounded_knapsack(val, wt, W, n))
}
