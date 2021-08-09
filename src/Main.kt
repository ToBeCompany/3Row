import kotlin.random.Random

fun main() {
    var size = 10
    var pole = mutableListOf<MutableList<Int>>()
    for (i in 0 until size) {
        pole.add(mutableListOf())
    }

    pole.forEach {
        for (i in 0 until size) {
            it.add(0)
        }
    }
    while (true) {
        when (readLine()) {
            "1" -> leftToRight(size, pole)
            "2" -> upToDown(size, pole)
        }
        print(pole)
    }
}

private fun upToDown(
    size: Int,
    pole: MutableList<MutableList<Int>>
) {
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (i == size - 1)
                pole[size - 1 - i][j] = Random.nextInt(1, 4)
            else
                pole[size - 1 - i][j] = pole[size - i - 2][j]
        }
    }
}
//private fun leftToRight(
//    size: Int,
//    pole: MutableList<MutableList<Int>>
//) {
//    for (j in size until size){
//        pole.forEach {
//            for (i in 0 until size){
//                if (i == size - 1)
//                    it[size-1-i]= Random.nextInt(1, 4)
//                else {
//                    it[size-1-i]=it[size-2-i]
//                }
//            }
//        }
//        print(pole)
//    }
//}

private fun leftToRight(
    size: Int,
    pole: MutableList<MutableList<Int>>
) {
    pole.forEach {
        for (i in size - 1 downTo 0) {
            if (i == 0)
                it[i] = Random.nextInt(1, 4)
            else {
                it[i] = it[i - 1]
            }
        }
    }
}

private fun print(pole: MutableList<MutableList<Int>>) {
    for (i in pole.indices) {
        for (j in pole[i].indices)
            if (pole[i][j] > 9) {
                print("${pole[i][j]} ")
            } else {
                print(" ${pole[i][j]}\t")
            }
        println()
    }
    println("------------------")
}