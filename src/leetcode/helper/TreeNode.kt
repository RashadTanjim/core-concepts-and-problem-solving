package leetcode.helper

class TreeNode {
    @JvmField
    var value: Int = 0
    @JvmField
    var left: TreeNode? = null
    @JvmField
    var right: TreeNode? = null

    constructor()

    constructor(value: Int) {
        this.value = value
    }

    constructor(value: Int, left: TreeNode?, right: TreeNode?) {
        this.value = value
        this.left = left
        this.right = right
    }
}

