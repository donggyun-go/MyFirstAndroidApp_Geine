package com.neppplus.myfirstandroidapp_geine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "testDb.db";
    private static final int DATABASE_VERSION = 1;

    // USERS 테이블 생성 SQL 문
    private static final String TABLE_CREATE_USERS =
            "CREATE TABLE USERS (" +
                    "ID TEXT PRIMARY KEY, " +
                    "Password TEXT NOT NULL, " +
                    "Nickname TEXT NOT NULL, " +
                    "Gender TEXT NOT NULL);";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_USERS);  // USERS 테이블 생성
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS");  // 기존 테이블 삭제
        onCreate(db);  // 다시 테이블 생성
    }

    // 데이터 삽입 메서드
    public boolean insertUser(String id, String password, String nickname, String gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", id);
        values.put("Password", password);
        values.put("Nickname", nickname);
        values.put("Gender", gender);

        long result = db.insert("USERS", null, values);
        db.close();  // 데이터베이스 연결 닫기
        return result != -1;  // 삽입 성공 시 true 반환
    }

    // 로그인 검증 메서드
    public boolean checkUser(String id, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = { "ID" };
        String selection = "ID = ? AND Password = ?";
        String[] selectionArgs = { id, password };
        Cursor cursor = db.query("USERS", columns, selection, selectionArgs, null, null, null);

        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        return cursorCount > 0;
    }
}
