package com.neppplus.myfirstandroidapp_geine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import com.neppplus.myfirstandroidapp_geine.adapters.RoomAdapter
import com.neppplus.myfirstandroidapp_geine.datas.Room

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val listView = findViewById<ListView>(R.id.lvRooms)
        val rooms = arrayListOf(
            Room(5000000, "서울시 강남구 역삼동", 15, "편리한 위치의 아파트"),
            Room(7500000, "서울시 서초구 반포동", 20, "한강 뷰가 보이는 고층 아파트"),
            Room(3000000, "서울시 동작구 사당동", 5, "가성비 좋은 신축 빌라")
        )

        val adapter = RoomAdapter(this, R.layout.room_list_item, rooms)
        listView.adapter = adapter
    }
}
