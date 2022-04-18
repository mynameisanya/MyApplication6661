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
            val imageButtonPurpose = view.findViewById<ImageButton>(R.id.purpose_emotional)
            imageButtonPurpose?.setOnClickListener()
            {
                (requireActivity() as MainActivity).navigationTo(R.id.navigation_purpose_emotional)
            }
            val imageButtonNameOf = view.findViewById<ImageButton>(R.id.name_of_emotional)
            imageButtonNameOf?.setOnClickListener()
            {
                (requireActivity() as MainActivity).navigationTo(R.id.navigation_name_of_emotional)
            }
        }
}