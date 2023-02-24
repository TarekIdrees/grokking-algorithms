/**
 * Simple iterative binary search
 */
fun Array<Int>.iterativeBinarySearch(item: Int): Int?{
    var low = 0
    var high = lastIndex

    while(low <= high){
        val mid = (low+high)/2
        if(this[mid] == item) return mid
        if(this[mid] > item) high = mid - 1
        else low = mid + 1

    }
    return null
}

/**
 * Binary search with recursion
 */
fun Array<Int>.recursionBinarySearch(item: Int,low: Int,high: Int): Int?{

    while(low <= high){
        val mid = (low+high)/2
        if(this[mid] == item) return mid
        if(this[mid] > item) recursionBinarySearch(item,low,mid-1)
        else
            recursionBinarySearch(item,mid-1,high)
    }
    return null
}

/**
 * Avoid overflow case in simple iterative binary search
 * Equation of mid = high + (high - min)/2
 */
fun Array<Int>.saveOverFlowBinarySearch(item: Int): Int?{
    var low = 0
    var high = lastIndex

    while(low <= high){
        val mid = high + (low-high)/2
        if(this[mid] == item) return mid
        if(this[mid] > item) high = mid - 1
        else low = mid + 1

    }
    return null
}

/**
 * Simple iterative binary search using ushr infix fun
 * ushr : Shift the value right by the number of bits , filling the leftmost bits with zeros
 * ushr equivalent to divide by two
 */
fun Array<Int>.ushrIterativeBinarySearch(item: Int): Int?{
    var low = 0
    var high = lastIndex

    while(low <= high){
        val mid = (high-low)+low ushr 1
        if(this[mid] == item) return mid
        if(this[mid] > item) high = mid - 1
        else low = mid + 1

    }
    return null
}

/**
 * get first occurrence of an element
 */
fun Array<Int>.getLowerBound(item: Int): Int{
    var low = 0
    var high = lastIndex
    var lowerBound = -1
    while(low <= high){
        val mid = low + (high-low)/2
        if(this[mid] == item){
            lowerBound = mid
            high = mid - 1
        }
        else if (this[mid] < item){
            low = mid + 1

        }
        else
            high = mid + 1
    }
    return lowerBound
}

/**
 * get last occurrence of an element
 */
fun Array<Int>.getUpperBound(item: Int): Int{
    var low = 0
    var high = lastIndex
    var upperBound = -1
    while(low <= high){
        val mid = low + (high-low)/2
        if(this[mid] == item){
            upperBound = mid
            low = mid + 1
        }
        else if (this[mid] < item){
            low = mid + 1

        }
        else
            high = mid + 1
    }
    return upperBound
}

fun main(){
    val sortedArray = arrayOf(1,7,3,6,5,2,7) // (1,2,3,5,6,7,7)
    sortedArray.sort()

    val item = 5

    //print(sortedArray.iterativeBinarySearch(item))

    //print(sortedArray.recursionBinarySearch(itemTwo,0,sortedArray.lastIndex))

    //print(sortedArray.saveOverFlowBinarySearch(item))

    //print(sortedArray.ushrIterativeBinarySearch(item))

    //print((sortedArray.getLowerBound(7)))

    //print((sortedArray.getUpperBound(7)))

}