package leetcode.helper

class NodeLRU(var key: Int, var value: Int) {
    var prev: NodeLRU? = null
    var next: NodeLRU? = null
}
