package main

import (
	"fmt"
	"sync"
	"time"
)

var wg sync.WaitGroup

func foo(){
	defer fmt.Println("second")
	fmt.Println("first")
}

func say(s string) {
	defer wg.Done()
	for i:=0; i < 3; i++ {
		time.Sleep(100*time.Millisecond)
		fmt.Println(s)
	}	
}

func main() {
	wg.Add(1)
	go say("Hey")
	wg.Add(1)
	go say("there")
	wg.Add(1)
	go say("hi")
	wg.Wait()
}