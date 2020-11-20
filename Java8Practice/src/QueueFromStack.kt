
import java.util.Stack

object QueueFromStack {
    @JvmStatic
    fun main(args: Array<String>) {
        val queue = Queue()
        queue.enQueue(1)
        queue.enQueue(2)
        queue.enQueue(3)
        println(queue.deQueue())
        println(queue.deQueue())
        println(queue.deQueue())
    }
}

internal class Queue {
    private var stack1: Stack<Int> = Stack()
    private var stack2: Stack<Int> = Stack()

    fun enQueue(x: Int){
        stack1.push(x)
    }

    fun deQueue(): Int{
        if(stack1.isEmpty() && stack2.isEmpty()){
            return -1
        }

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop())
            }
        }
        return stack2.pop()
    }
}