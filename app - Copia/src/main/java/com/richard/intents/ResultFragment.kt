package com.richard.intents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.richard.intents.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    lateinit var engine : JokenpoEngine
    lateinit var bind: FragmentResultBinding
    lateinit var resultText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bind = FragmentResultBinding.inflate(inflater, container , false)
        engine = JokenpoEngine(resources.getStringArray(R.array.available_plays_array))
        val currentPlay = arguments?.getString("currentPlay")
        resultText = bind.resultLabel

        currentPlay?.let{
            updateResultText(currentPlay)
        }
        setHasOptionsMenu(true)

        return bind.root
    }

    private fun updateResultText(currentPlay : String){
       val resultGame = engine.calculateResult(currentPlay)

        resultText.text = when (resultGame){
            Result.WIN -> "You Win!!"
            Result.LOSS -> "You Lose"
            else -> "Draw"
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.second_screen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
    }
}