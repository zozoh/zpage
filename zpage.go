package main

import (
	"flag"
	"fmt"
	"strings"
	"z"
)

var wp = flag.String("wp", ".", "workpath for zpage")

func main() {
	flag.Parse()

	pp := z.PPreadf(strings.Join([]string{*wp, "zpage.conf"}, "/"))

	for key, val := range pp {
		fmt.Println("[", key, "]:", val)
	}
}
