package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

func main() {
	var t int
	fmt.Scanln(&t)
	var r = bufio.NewReader(os.Stdin)

	for i := 0; i < t; i++ {
		var D, d, P, Q int

		fmt.Fscanf(r, "%d %d %d %d ", &D, &d, &P, &Q)

		var total int = 0
		var n int = int(math.Floor(float64(D / d)))
		total = n * d * (2*P + (n-1)*Q) / 2

		total += (P + n*Q) * (D % d)

		fmt.Println(total)
	}

}
