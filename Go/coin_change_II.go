package main

import (
	"fmt"
	"math"
)

var T [50][50]int

func min(a int, b int) int {
	if a > b {
		return b
	}
	return a
}

func bottom_up_coin_change(arr []int, n int, sum int) int {
	for i := 0; i <= n; i++ {
		T[i][0] = 0
	}
	for i := 0; i <= sum; i++ {
		T[0][i] = math.MaxInt32 - 1
	}

	for i := 0; i <= n; i++ {
		for j := 0; j <= sum; j++ {
			fmt.Print(T[i][j], " ")
		}
		fmt.Println()
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= sum; j++ {
			if arr[i-1] <= j {
				T[i][j] = min(T[i-1][j], 1+T[i][j-arr[i-1]])
			} else {
				T[i][j] = T[i-1][j]
			}
		}
	}
	for i := 0; i <= n; i++ {
		for j := 0; j <= sum; j++ {
			fmt.Print(T[i][j], " ")
		}
		fmt.Println()
	}

	return T[n][sum]
}

func main() {
	var arr = []int{1, 2, 3}
	var n int = len(arr)
	var target int = 5

	fmt.Println(bottom_up_coin_change(arr, n, target))
}
