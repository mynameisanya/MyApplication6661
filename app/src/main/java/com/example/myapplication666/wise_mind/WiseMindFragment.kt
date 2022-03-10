package com.example.myapplication666.wise_mind

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R
import com.example.myapplication666.what_skills.WHATSkillsViewModel

class WiseMindFragment : Fragment() {

    companion object {
        fun newInstance() = WiseMindFragment()
    }

    private lateinit var viewModel: WHATSkillsViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WHATSkillsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wise_mind_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButton = view.findViewById<ImageButton>(R.id.rational_mind_image)
        imageButton.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_rational_mind)
        }

    }
}
