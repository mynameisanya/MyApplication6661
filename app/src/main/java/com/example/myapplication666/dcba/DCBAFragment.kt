package com.example.myapplication666.dcba

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

class DCBAFragment : Fragment() {

    companion object {
        fun newInstance() = DCBAFragment()
    }

    private lateinit var viewModel: DCBAViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dcba_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DCBAViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val imageButtonAbstinence = view.findViewById<ImageButton>(R.id.abstinence_image)
        imageButtonAbstinence.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_abstinence)
        }
        val imageButtonClearMind = view.findViewById<ImageButton>(R.id.clear_mind_image)
        imageButtonClearMind.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_clear_mind)
        }
        val imageButtonSupportCommunity = view.findViewById<ImageButton>(R.id.support_community_image)
        imageButtonSupportCommunity.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_support_community)
        }
        val imageButtonBridges = view.findViewById<ImageButton>(R.id.bridges_image)
        imageButtonBridges.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_bridges)
        }
        val imageButtonRiot = view.findViewById<ImageButton>(R.id.riot_image)
        imageButtonRiot.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_riot)
        }
    }
}
