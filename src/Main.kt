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
            "3" -> rightToLeft(size, pole)
            "4" -> downToUp(size, pole)

        }
        print(pole)
    }
}

private fun upToDown(
    size: Int,
    pole: MutableList<MutableList<Int>>
) {
    for (i in size - 1 downTo 0) {
        for (j in size - 1 downTo  0) {
            if (i == 0)
                pole[i][j] = Random.nextInt(1, 4)
            else if(pole[i-1][j]!=0)
                pole[i][j] = pole[i-1][j]
        }
    }
}

private fun downToUp(
    size: Int,
    pole: MutableList<MutableList<Int>>
) {
    for (i in 0 until size) {
        for (j in size - 1 downTo  0) {
            if (i == size-1)
                pole[i][j] = Random.nextInt(1, 4)
            else if (pole[i+1][j]!=0)
                pole[i][j] = pole[i+1][j]
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
            else if ((it[i-1]!=0)){
                it[i] = it[i-1]
            }
        }
    }
}

private fun rightToLeft(
    size: Int,
    pole: MutableList<MutableList<Int>>
) {
    pole.forEach {
        for (i in 0 until size) {
            if (i == size-1)
                it[i] = Random.nextInt(1, 4)
            else if ((it[i+1]!=0)){
                it[i] = it[i+1]
            }
        }
    }
}

private fun print(pole: MutableList<MutableList<Int>>) {
    println("------------------")
    for (i in pole.indices) {
        for (j in pole[i].indices)
            if (pole[i][j] > 9) {
                print("${pole[i][j]} ")
            } else {
                print(" ${pole[i][j]}\t")
            }
        println()
    }
}