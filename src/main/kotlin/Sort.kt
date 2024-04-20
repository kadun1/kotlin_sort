class Sort {
    fun bubbleSort(array: MutableList<Int>) {
        for (i in 0..<array.size - 1) {
            for (j in 0..<array.size - i - 1) {
                if (array[j] > array[j + 1]) {
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                }
            }
        }
    }

}
