
proc stackframe {} {
    upeval { incr &foo }
}

test upeval-1 {
    set foo 1
    stackframe
    set foo
} {2}

proc do {code while condition} {
    upeval $code
    while { upeval &condition } {
	upeval $code
    }
}

test upeval-2 {
    set x 100
    set foo ""
    do {
	append &foo $x
	incr &x
    } while {< &x 10}
    set foo
} {100}