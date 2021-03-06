package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_a.*


/**
 * A simple [Fragment] subclass.
 * Use the [a.newInstance] factory method to
 * create an instance of this fragment.
 */
class a : Fragment(),View.OnClickListener { //상속
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btn_next.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_next -> {
                navController.navigate(R.id.action_a_to_sectionFragment)
            }
        }

    }
}