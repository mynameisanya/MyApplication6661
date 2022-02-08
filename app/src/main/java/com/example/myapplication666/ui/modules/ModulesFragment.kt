package com.example.myapplication666.ui.modules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication666.BlankFragment
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R
import com.example.myapplication666.databinding.FragmentModulesBinding

class ModulesFragment : Fragment() {

    private lateinit var modulesViewModel: ModulesViewModel
    private var _binding: FragmentModulesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        modulesViewModel =
            ViewModelProvider(this).get(ModulesViewModel::class.java)

        _binding = FragmentModulesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageButton = view.findViewById<ImageButton>(R.id.mindfulness)
        imageButton.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_mindfulness)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}