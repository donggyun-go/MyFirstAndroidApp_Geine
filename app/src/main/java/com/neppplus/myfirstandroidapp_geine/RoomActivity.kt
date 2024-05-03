package com.neppplus.myfirstandroidapp_geine

import android.content.Intent
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
            Room(55000, "서울시 강남구 역삼동", 15, "편리한 위치의 아파트"),
            Room(75000, "서울시 서초구 반포동", 20, "한강 뷰가 보이는 고층 아파트"),
            Room(30000, "서울시 동작구 사당동", 5, "가성비 좋은 신축 빌라"),
            Room(48000, "서울시 마포구 합정동", 10, "카페 거리 인근의 모던 아파트"),
            Room(85000, "서울시 용산구 이태원동", 25, "외국인 주거지역의 럭셔리 레지던스"),
            Room(65000, "서울시 성동구 성수동", 12, "아트 갤러리와 가까운 트렌디한 아파트"),
            Room(52000, "서울시 광진구 자양동", 7, "신규 개발 지역의 현대적인 빌라")
        )


        val adapter = RoomAdapter(this, R.layout.room_list_item, rooms)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val clickedRoom = rooms[position]
            val myIntent = Intent(this, ViewRoomDetailActivity::class.java)
            myIntent.putExtra("room", clickedRoom)
            startActivity(myIntent)
        }
    }
}
