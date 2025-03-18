

package com.richard.intents

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.richard.intents.databinding.FragmentHomeBinding

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class HomeFrafment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root

        binding.StartActivityButton.setOnClickListener {
        //val activity2Intent = Intent(this, MainActivity2::class.java)
        //intent.putExtra("name", "Richard")
        //intent.putExtra("age", 23)

        //binding.StartActivityButton.setOnClickListener {
        //  startActivity(activity2Intent)
        }
        return binding.root
    }

}