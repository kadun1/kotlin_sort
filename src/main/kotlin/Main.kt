fun main(args: Array<String>) {
    val array = mutableListOf(5, 4, 3, 2, 1)
//    bubbleSort(array)
//    insertSort(array)
//    mergeSort(array)
    quickSort(array.toIntArray(), 0, array.size - 1)
}

fun bubbleSort(array: MutableList<Int>) {
    for (i in 0..<array.size - 1) {
        for (j in 0..<array.size - i - 1) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}

fun insertSort(array: MutableList<Int>) {
    for (i in 1..<array.size) {
        var index = i
        var temp = array[i]
        while (index > 0 && array[index - 1] > temp) {
            array[index] = array[index - 1]
            index--
        }
        array[index] = temp
    }
}

fun mergeSort(array: List<Int>): List<Int> {
    if (array.size < 2) return array

    val (front, rear) = split(array)
    return merge(mergeSort(front), mergeSort(rear))
}

fun split(array: List<Int>): Pair<List<Int>, List<Int>> {
    val mid = array.size / 2
    return Pair(array.subList(0, mid), array.subList(mid, array.size))
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var l_idx = 0
    var r_idx = 0

    val result = mutableListOf<Int>()

    while (l_idx < left.size && r_idx < right.size) {
        val l_v = left[l_idx]
        val r_v = right[r_idx]

        if (l_v < r_v) {
            result.add(l_v)
            l_idx += 1
        } else if (l_v > r_v) {
            result.add(r_v)
            r_idx += 1
        } else {
            result.add(l_v)
            result.add(r_v)
            l_idx += 1
            r_idx += 1
        }
    }
    if (l_idx < left.size) {
        result.addAll(left.subList(l_idx, left.size))
    }
    if (r_idx < right.size) {
        result.addAll(right.subList(r_idx, right.size))
    }
    return result
}

fun quickSort(arr: IntArray, start: Int, end: Int) {
    if (start + 1 > end) return
    val pivot = arr[end]
    var i = start - 1

    for (j in start..end - 1) {
        if (arr[j] < pivot) {
            i += 1
            val term = arr[j]
            arr[j] = arr[i]
            arr[i] = term
        }
    }
    arr[end] = arr[i + 1]
    arr[i + 1] = pivot
    quickSort(arr, start, i) // pivot 기존 왼쪽 배열 정렬
    quickSort(arr, i + 2, end) // pivot 기존 오른쪽 배열 정렬
}
