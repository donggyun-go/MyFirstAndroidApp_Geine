package com.neppplus.myfirstandroidapp_geine.datas

class Room(
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String
) {
    // 층수를 문자열로 포맷팅하는 메서드
    fun getFormattedFloor(): String {
        // 지하 층수 표현
        if (floor < 0) {
            return "B${-floor}"
        }
        // 지상 층수 표현
        return "${floor}층"
    }
}
