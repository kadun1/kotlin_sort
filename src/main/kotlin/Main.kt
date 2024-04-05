fun main(args: Array<String>) {
    val array = arrayOf(5, 4, 3, 2, 1)
    bubbleSort(array)
    insertSort(array)
}

fun bubbleSort(array: Array<Int>) {
    for (i in 0 until array.size - 1) {
        for (j in 0 until array.size - i - 1) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}

fun insertSort(array: Array<Int>) {
    for(i in 1 until array.size){
        var index = i
        var temp = array[i]
        while (index>0 && array[index-1]>temp){
            array[index] = array[index-1]
            index--
        }
        array[index]= temp
    }
}
