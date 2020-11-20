
import java.util.*
import java.util.Queue

object StackFromQueue {
    @JvmStatic
    fun main(args: Array<String>) {
        val stack = Stack()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        println(stack.top())
        stack.pop()
        println(stack.top())
        stack.pop()
        println(stack.top())
        println("Size: " + stack.size())
        stack.pop()
        println("Size: " + stack.size())

        val stack2 = Stack2()
        stack2.push(1)
        stack2.push(2)
        stack2.push(3)
        println(stack2.top())
        stack2.pop()
        println(stack2.top())
        stack2.pop()
        println(stack2.top())
        println("Size: " + stack2.size())
        stack2.pop()
        println("Size: " + stack2.size())
    }
}

internal class Stack {
    private var q1: Queue<Int> = LinkedList()
    private var q2: Queue<Int> = LinkedList()
    private var size = 0
    fun push(x: Int) {
        size++
        q2.add(x)
        while (!q1.isEmpty()) {
            q2.add(q1.peek())
            q1.remove()
        }
        val q = q1
        q1 = q2
        q2 = q
    }

    fun pop() {
        if (q1.isEmpty()) return
        q1.remove()
        size--
    }

    fun top(): Int {
        return if (q1.isEmpty()) -1 else q1.peek()
    }

    fun size(): Int {
        return size
    }

}

internal class Stack2 {
    private var q1: Queue<Int> = LinkedList()
    private var q2: Queue<Int> = LinkedList()
    private var size = 0

    fun push(x: Int) {
        size++
        q1.add(x)
    }

    fun pop() {
        if (q1.isEmpty()) return
        while (q1.size != 1) {
            q2.add(q1.peek())
            q1.remove()
        }
        q1.remove()
        val q = q1
        q1 = q2
        q2 = q
        size--
    }

    fun top(): Int {
         if (q1.isEmpty()) return -1
         while (q1.size != 1) {
             q2.add(q1.peek())
             q1.remove()
         }
        val temp:Int = q1.peek()
        q1.remove()
        q2.add(temp)
        val q = q1
        q1 = q2
        q2 = q
        return temp
    }

    fun size(): Int {
        return size
    }

}