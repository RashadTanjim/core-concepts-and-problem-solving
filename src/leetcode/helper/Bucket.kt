package leetcode.helper

class Bucket(var count: Int) {
    @JvmField
    var keys: Set<String> = LinkedHashSet()
    @JvmField
    var prev: Bucket? = null
    @JvmField
    var next: Bucket? = null
}