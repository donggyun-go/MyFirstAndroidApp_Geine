package com.neppplus.myfirstandroidapp_geine.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neppplus.myfirstandroidapp_geine.R
import com.neppplus.myfirstandroidapp_geine.datas.Room

class RoomAdapter(
    mContext: Context,
    resId: Int,
    val mList: ArrayList<Room>
) : ArrayAdapter<Room>(mContext, resId, mList) {

    val inflater = LayoutInflater.from(mContext)

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.room_list_item, parent, false)
        }

        val row = tempRow!!

        // 각 뷰를 레이아웃에서 찾음
        val roomData = mList[position]
        val txtRoomPrice = row.findViewById<TextView>(R.id.RoomPrice)
        val txtRoomInfo = row.findViewById<TextView>(R.id.RoomInfo)
        val txtRoomDescription = row.findViewById<TextView>(R.id.RoomDescription)

        // 데이터를 뷰에 설정
        txtRoomPrice.text = roomData.price.toString()
        txtRoomInfo.text = "${roomData.address} / ${roomData.getFormattedFloor()}"
        txtRoomDescription.text = roomData.description

        return row
    }
}

