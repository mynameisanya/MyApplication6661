package com.example.myapplication666.ui.modules.emotional_regulation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class TheoryFragment : Fragment() {

    companion object {
        fun newInstance() = TheoryFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TheoryViewModel::class.java)


        // TODO: Use the ViewModel
    }

    private lateinit var viewModel: TheoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.theory_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val imageButtonEmotions = view.findViewById<ImageButton>(R.id.emotions)
            imageButtonEmotions?.setOnClickListener()
            {
                (requireActivity() as MainActivity).navigationTo(R.id.navigation_emotions)
            }
            val imageButtonTips = view.findViewById<ImageButton>(R.id.tips_of_emo)
            imageButtonTips?.setOnClickListener()
            {
                (requireActivity() as MainActivity).navigationTo(R.id.navigation_tips_of_emo)
            }
        val imageButtonAbc = view.findViewById<ImageButton>(R.id.abc_please)
        imageButtonAbc?.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_abc_please)
        }
        }
}