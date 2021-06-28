package main

import "fmt"

var T [50][50]int

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func recursive_lcm(s1 string, s2 string, n1 int, n2 int) int {
	if n1 == 0 || n2 == 0 {
		return 0
	}

	if s1[n1-1] == s2[n2-1] {
		return recursive_lcm(s1, s2, n1-1, n2-1) + 1
	} else {
		return max(recursive_lcm(s1, s2, n1-1, n2),
			recursive_lcm(s1, s2, n1, n2-1))
	}

}

func memoization_lcm(s1 string, s2 string, n1 int, n2 int) int {
	if T[n1][n2] != -1 {
		return T[n1][n2]
	}

	if n1 == 0 || n2 == 0 {
		T[n1][n2] = 0
		return T[n1][n2]
	}

	if s1[n1-1] == s2[n2-1] {
		T[n1][n2] = memoization_lcm(s1, s2, n1-1, n2-1) + 1
	} else {
		T[n1][n2] = max(memoization_lcm(s1, s2, n1-1, n2),
			memoization_lcm(s1, s2, n1, n2-1))
	}
	return T[n1][n2]
}

func bottom_up_lcm(s1 string, s2 string, n1 int, n2 int) int {
	for i := 0; i <= n1; i++ {
		T[i][0] = 0
	}
	for i := 0; i <= n2; i++ {
		T[0][i] = 0
	}

	for i := 1; i <= n1; i++ {
		for j := 1; j <= n2; j++ {
			if s1[i-1] == s2[j-1] {
				T[i][j] = T[i-1][j-1] + 1
			} else {
				T[i][j] = max(T[i-1][j], T[i][j-1])
			}
		}
	}
	return T[n1][n2]
}

func main() {
	var s1 string = "abcdgh"
	var s2 string = "abedfh"
	var n1 int = len(s1)
	var n2 int = len(s2)

	fmt.Println(recursive_lcm(s1, s2, n1, n2))

	for i := 0; i <= n1; i++ {
		for j := 0; j <= n2; j++ {
			T[i][j] = -1
		}
	}
	fmt.Println(memoization_lcm(s1, s2, n1, n2))
	fmt.Println(bottom_up_lcm(s1, s2, n1, n2))
}
