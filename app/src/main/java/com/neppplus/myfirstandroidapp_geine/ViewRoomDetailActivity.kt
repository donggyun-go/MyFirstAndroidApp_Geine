package com.neppplus.myfirstandroidapp_geine

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.neppplus.myfirstandroidapp_geine.datas.Room

@Suppress("DEPRECATION")
class ViewRoomDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_room_detail)

        // findViewById를 사용하여 각 뷰에 대한 참조를 얻습니다.
        val roomPrice: TextView = findViewById(R.id.RoomPrice)
        val roomDescription: TextView = findViewById(R.id.RoomDescription)
        val addressName: TextView = findViewById(R.id.addressName)
        val floor: TextView = findViewById(R.id.floor)

        // intent에서 "room"이라는 키로 넘겨받은 Room 객체를 받아옵니다.
        val roomData = intent.getSerializableExtra("room") as? Room
        roomData?.let { room ->
            // 데이터가 있다면 각 TextView에 값을 설정합니다.
            roomPrice.text = room.getFormattedPrice()
            roomDescription.text = room.description
            addressName.text = room.address
            floor.text = room.getFormattedFloor()
        }
    }
}
