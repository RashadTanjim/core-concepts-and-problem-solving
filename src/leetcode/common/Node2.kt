package leetcode.common

internal class Node2 {
    var value: Int = 0
    var left: Node2? = null
    var right: Node2? = null
    var next: Node2? = null

    constructor()

    constructor(_val: Int) {
        value = _val
    }

    constructor(_value: Int, _left: Node2?, _right: Node2?, _next: Node2?) {
        value = _value
        left = _left
        right = _right
        next = _next
    }
}

