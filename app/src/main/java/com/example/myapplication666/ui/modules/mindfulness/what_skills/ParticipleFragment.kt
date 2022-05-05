package com.example.myapplication666.ui.modules.mindfulness.what_skills

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R
import com.example.myapplication666.ui.modules.what_skills.ParticipleViewModel

class ParticipleFragment : Fragment() {

    companion object {
        fun newInstance() = ParticipleFragment()
    }

    private lateinit var viewModel: ParticipleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.actionBar?.setDisplayHomeAsUpEnabled(false)
        activity?.actionBar?.setHomeButtonEnabled(false)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.participle_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ParticipleViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonParticiplePage2 = view.findViewById<Button>(R.id.next_btn)
        buttonParticiplePage2.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_participle_page2)
        }
    }

}