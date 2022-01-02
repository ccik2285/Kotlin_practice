package com.example.myapplication

import android.content.ContentValues.TAG
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {
    val TAG: String = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btn_login.setOnClickListener{
            var id = edit_id.text.toString()
            var pw = edit_pw.text.toString()

            val ref = getSharedPreferences("file name", Context.MODE_PRIVATE)
            val ch_id = ref.getString("id","")
            val ch_pw = ref.getString("pw","")

            if(ch_id == id && ch_pw == pw){
                dialog("success")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                dialog("fail")
            }
        }
        btn_register.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
    }
    fun dialog(type: String){
        var dialog = AlertDialog.Builder(this)

        if(type.equals("success")){
            dialog.setTitle("로그인 성공")
            dialog.setMessage("로그인 성공!")
        }
        else if(type.equals("fail")){
            dialog.setTitle("로그인 실패")
            dialog.setMessage("아이디와 비밀번호를 확인해주세요")
        }

        var dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(TAG, "")
                }
            }
        }

        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }
}