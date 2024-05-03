package com.neppplus.myfirstandroidapp_geine.datas

import java.io.Serializable
import java.text.NumberFormat
import java.util.Locale

class Room(
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String) : Serializable {
    // 층수를 문자열로 포맷팅하는 메서드
    fun getFormattedFloor(): String {
        // 지하 층수 표현
        if (floor < 0) {
            return "B${-floor}"
        }
        // 지상 층수 표현
        return "${floor}층"

    }

    fun getFormattedPrice() : String {

        return if (this.price >= 10000){
            val uk = this.price / 10000
            val rest = this.price % 10000

            "${uk}억 ${NumberFormat.getNumberInstance(Locale.KOREA).format(rest)}"
        } else {
            NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)
        }
    }
}
