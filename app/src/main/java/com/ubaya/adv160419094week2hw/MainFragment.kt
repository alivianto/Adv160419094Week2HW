package com.ubaya.adv160419094week2hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var score = 0
        var result = randomQuestions()
        buttonSubmit.setOnClickListener {
            var answer: Int = editAnswer.text.toString().toInt()
            if (result == answer){
                score += 1
                textScr.text = "Score: $score"
                result = randomQuestions()
                editAnswer.setText("")
            } else {
                val action = MainFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }

        }
    }

    fun randomQuestions(): Int{
        var number1 = (0..100).random()
        var number2 = (0..100).random()
        textQuestions.text = "$number1 + $number2"
        var result = number1 + number2
        return result
    }
}