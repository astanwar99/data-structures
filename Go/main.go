package main

import "fmt"

var T_bool [10][50]bool
var T_int [10][50]int

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	fmt.Println("Knapsack 0-1:")
	knapsack01()

	fmt.Println("Subset Sum:")
	subsetSum()

	fmt.Println("Equal Sum Partition: ")
	equalSumPart()

	fmt.Println("Count subset sum: ")
	countSubsetSum()

	fmt.Println("Minimum subset sum difference: ")
	minSubsetSumDiff()

	countSubsetDiff()
	// for i := 0; i <= n; i++ {
	// 	for j := 0; j <= sum; j++ {
	// 		fmt.Print(T_bool[i][j], " ")
	// 	}
	// 	fmt.Println()
	// }
}
