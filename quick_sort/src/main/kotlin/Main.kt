fun quickSort(items: List<Int>):List<Int>{
    if(items.size <= 1)
        return items

    val pivot = items[items.size / 2]

    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }

    return quickSort(less) + equal + quickSort(greater)
}

fun partition(items: IntArray,low: Int,high: Int): Int{

    val pivot = items[low]
    var i = low - 1
    var j = high + 1

    while (true){

        // find leftmost element greater than or equal to pivot
        do {
            i++
        }while (items[i] < pivot)

        // find rightmost element less than or equal to pivot
        do {
            j--
        }while (items[j] > pivot)

        // two pointers met which is the base case
        if(i >= j)
            return j

        // swapping two element
        items[i] = items[j].also {
            items[j] = items[i]
        }
    }

}
fun quickSort(items: IntArray,low: Int,high: Int){
    if(low < high){
        val pivot = partition(items,low,high)
        quickSort(items,low,pivot)
        quickSort(items,pivot+1,high)
    }
}
fun main(){

    //val numbers = listOf(2, 4, 7, 3, 6, 9, 5, 1, 0)
   // println(quickSort(numbers))

    val items = intArrayOf(2, 4, 7, 3, 6, 9, 5, 1, 0)
    quickSort(items,0,items.size-1)
    items.forEach {
        print(it)
    }

}