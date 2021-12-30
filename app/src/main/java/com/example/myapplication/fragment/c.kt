package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_c.*


/**
 * A simple [Fragment] subclass.
 * Use the [c.newInstance] factory method to
 * create an instance of this fragment.
 */
class c : Fragment() {

    var option = -1

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        option = arguments?.getInt("index")?:-1 // arguments가 null 이면 -1을 반환하겠다.
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        setResult(option)
        home.setOnClickListener {
            navController.navigate(R.id.action_c_to_mainFragment)
        }
    }

    fun setResult(option : Int){
        when(option) {
            1->{
                tv_main.text = "춘식이는 화났어요"  // tv_main.setText
                tv_sub.text = "화난춘식이"
            }
            2->{
                tv_main.text = "춘식이는 고구마를 좋아해요"
                tv_sub.text = "고구마먹는 춘식이"
            }
            3-> {
                tv_main.text = "춘식이는 새침해요"
                tv_sub.text = "새침한 춘식이"
            }
            4-> {
                tv_main.text = "춘식이는 참 엉뚱해요"
                tv_sub.text = "엉뚱한 춘식이"
            }
        }
    }

}