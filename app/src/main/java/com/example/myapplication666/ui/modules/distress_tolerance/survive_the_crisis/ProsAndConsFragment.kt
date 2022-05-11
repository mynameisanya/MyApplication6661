package com.example.myapplication666.ui.modules.distress_tolerance.survive_the_crisis

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R

class ProsAndConsFragment : Fragment() {

    companion object {
        fun newInstance() = ProsAndConsFragment()
    }

    private lateinit var viewModel: ProsAndConsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pros_and_cons_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProsAndConsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonProsClose = view.findViewById<ImageButton>(R.id.close_btn)
        buttonProsClose.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_survive_the_crisis)
        }
    }

}