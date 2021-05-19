// Given an array and a target sum, we have to find number of
// ways we can add the whole array by assigning a '+'  or '-' sign
// in front of each element so that the resultant is equal to target
// sum.

package main

import "fmt"

func recursiveTargetSum(arr []int, sum int, n int) bool {

	if n == 0 {
		if sum == 0 {
			return true
		}
		return false
	}

	return recursiveTargetSum(arr, sum-arr[n-1], n-1) ||
		recursiveTargetSum(arr, sum+arr[n-1], n-1)
}

func bottomUpTargetSum(arr []int, sum int, n int) int {
	for i := 0; i <= n; i++ {
		T_int[i][0] = 1
	}

	for i := 1; i <= sum; i++ {
		T_int[0][i] = 0
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= sum; j++ {
			if arr[i-1] <= j {
				T_int[i][j] = T_int[i-1][j-arr[i-1]] + T_int[i-1][j]
			} else {
				T_int[i][j] = T_int[i-1][j]
			}
		}
	}

	return T_int[n][sum]
}

func targetSum() {
	var arr = []int{1, 1, 2, 3}
	var targetSum = 2
	var n int = len(arr)

	fmt.Println("=================================================")
	fmt.Println("Target Sum")
	fmt.Println("=================================================")

	// fmt.Println(bottomUpTargetSum(arr, targetSum, n))
	fmt.Println(recursiveTargetSum(arr, targetSum, n))

	var totalSum int = 0

	for _, a := range arr {
		totalSum += a
	}
	// s1 + s2 = sum
	// s1 - s2 = targetSum
	// s1 = (targetSum + Sum) / 2

	var sum int = (totalSum + targetSum)

	if sum%2 == 0 {
		fmt.Println(bottomUpTargetSum(arr, sum/2, n))
	} else {
		fmt.Println(0)
	}

}
