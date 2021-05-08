package main

import "fmt"

func bottomupCountSubsetDiff(arr []int, n int, val int) int {
	for i := 1; i <= val; i++ {
		T_int[0][i] = 0
	}

	for i := 0; i <= n; i++ {
		T_int[i][0] = 1
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= val; j++ {
			if arr[i-1] <= j {
				T_int[i][j] = T_int[i-1][j] + T_int[i-1][j-arr[i-1]]
			} else {
				T_int[j][j] = T_int[i-1][j]
			}
		}
	}
	return T_int[n][val]
}

func countSubsetDiff() {
	var arr = []int{1, 1, 2, 3}
	var diff int = 1
	var sum int = 0
	var n int = len(arr)

	for _, a := range arr {
		sum += a
	}
	var val int = (sum + diff) / 2
	// s1 + s2 = sum
	// s1 - s2 = diff
	// s1 = (sum + diff) / 2

	fmt.Println("=================================================")
	fmt.Println("Find number of ways to divide array in 2 parts with differnce of given value")
	fmt.Println("=================================================")

	if (sum+diff)%2 != 0 {
		fmt.Println(0)
		return
	}
	fmt.Println(bottomupCountSubsetDiff(arr, n, val))
}
