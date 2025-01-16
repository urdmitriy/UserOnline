fun main (){
    agoToText(60*60+1)
}

fun agoToText(timeSecond: Int) = println(
    when {
        timeSecond >= 0 && timeSecond <= 60 -> "был(а) только что"
        timeSecond >= 61 && timeSecond < 60 * 60 -> "был(а) ${timeSecond / 60} ${minutsWord(timeSecond / 60)} назад"
        timeSecond >= 60 * 60 && timeSecond <= 24 * 60 * 60 -> "был(а) ${timeSecond / 60 / 60} ${hoursWord(timeSecond / 60 / 60)} назад"
        timeSecond >= 24 * 60 * 60 + 1 && timeSecond <= 24 * 60 * 60 * 2 -> "был(а) вчера"
        timeSecond >= 24 * 60 * 60 * 2 + 1 && timeSecond <= 24 * 60 * 60 * 3 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
)

fun minutsWord(timeSecond: Int): String {
    return if (timeSecond % 100 != 11 && timeSecond % 100 != 12 && timeSecond % 100 != 13) when {
        timeSecond % 10 == 1 ->  "минуту"
        timeSecond % 10 >= 2 && timeSecond % 10 <= 4 ->  "минуты"
        timeSecond == 60 -> "час"
        else -> "минут"
    } else {
        "минут"
    }
}

fun hoursWord(timeSecond: Int) = when {
    timeSecond == 1 || timeSecond == 21 -> "час"
    timeSecond >= 5 && timeSecond <= 20 -> "часов"
    else -> "часа"
}