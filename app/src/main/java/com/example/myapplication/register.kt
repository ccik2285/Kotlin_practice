package com.example.myapplication

import android.content.ContentValues.TAG
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_register.*
class register : AppCompatActivity() {
    val TAG: String = "Register"
    var isBlank = false
    var isSame = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btn_register.setOnClickListener{
            val id = id.text.toString()
            val pw = password.text.toString()
            val ch_pw = check_password.text.toString()

            if(id.isBlank() || pw.isBlank()){
                isBlank = true
            }
            else {
                if(pw == ch_pw){
                    isSame = true
                }
            }
            if(!isBlank && isSame){//회원가입 성공
                Toast.makeText(this,"회원가입 성공",Toast.LENGTH_SHORT).show()

                val sharedPreference = getSharedPreferences("file name", Context.MODE_PRIVATE)
                val editor = sharedPreference.edit()
                editor.putString("id", id)
                editor.putString("pw", pw)
                editor.apply()

                val intent = Intent(this, login::class.java)
                startActivity(intent)
            }
            else{

                // 상태에 따라 다른 다이얼로그 띄워주기
                if(isBlank){   // 작성 안한 항목이 있을 경우
                    dialog("blank")
                }
                else if(!isSame){ // 입력한 비밀번호가 다를 경우
                    dialog("not same")
                }
            }
        }

    }
    fun dialog(type: String){
        val dialog = AlertDialog.Builder(this)

        // 작성 안한 항목이 있을 경우
        if(type.equals("blank")){
            dialog.setTitle("회원가입 실패")
            dialog.setMessage("입력란을 모두 작성해주세요")
        }
        // 입력한 비밀번호가 다를 경우
        else if(type.equals("not same")){
            dialog.setTitle("회원가입 실패")
            dialog.setMessage("비밀번호가 다릅니다")
        }

        val dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which){
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d(TAG, "다이얼로그")
                }
            }
        }

        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }

}