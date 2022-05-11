package com.example.myapplication666.ui.modules.mindfulness.what_skills

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R
import com.example.myapplication666.ui.modules.mindfulness.wise_mind.WiseMindViewModel
import kotlinx.android.synthetic.main.what_skills_fragment.*

class WHATSkillsFragment : Fragment() {

    companion object {
        fun newInstance() = WHATSkillsFragment()
    }

    private lateinit var viewModel: WiseMindViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.what_skills_fragment, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WiseMindViewModel::class.java)


        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe_image.setOnClickListener()
        {
//            val view = View.inflate(context, R.layout.observe_fragment, null)
//            val builder = AlertDialog.Builder(context)
//            val dialog = builder.create()
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_observe)
//            builder.setView(view)
//            dialog.show()
//            dialog.window?.setBackgroundDrawableResource(android.R.color.background_dark)

        }
        val imageButtonDescribe = view.findViewById<ImageButton>(R.id.descibe_image)
        imageButtonDescribe.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_describe)
        }
        val imageButtonParticiple = view.findViewById<ImageButton>(R.id.participate_image)
        imageButtonParticiple.setOnClickListener()
        {
            (requireActivity() as MainActivity).navigationTo(R.id.navigation_participle)
        }

    }

}