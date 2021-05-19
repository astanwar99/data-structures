package main

import "fmt"

func bottom_up_coin_change(arr []int, sum int, n int) int {
	for i := 0; i <= n; i++ {
		T_int[i][0] = 1
	}
	for i := 1; i <= sum; i++ {
		T_int[0][i] = 0
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= sum; j++ {
			if arr[i-1] <= j {
				T_int[i][j] = T_int[i][j-arr[i-1]] + T_int[i-1][j]
			} else {
				T_int[i][j] = T_int[i-1][j]
			}
		}
	}
	return T_int[n][sum]
}

func coin_change() {
	var arr = []int{1, 2, 3}
	var target int = 5
	var n int = len(arr)

	fmt.Println("=================================================")
	fmt.Println("Coin Change")
	fmt.Println("=================================================")
	fmt.Println(bottom_up_coin_change(arr, target, n))

}
