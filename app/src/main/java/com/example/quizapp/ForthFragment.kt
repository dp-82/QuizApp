package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForthFragment(var score:Int) : Fragment(),View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var fragmentView : View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_forth, container, false)

        val btnStart = fragmentView!!.findViewById<Button>(R.id.btnNext)
        btnStart.setOnClickListener(this)
        return fragmentView
    }

    override fun onClick(v: View?) {
        if(fragmentView!!.findViewById<RadioGroup>(R.id.radioGroupFirst).checkedRadioButtonId==R.id.rbElon){
            score++
        }

        if(fragmentView!!.findViewById<RadioButton>(R.id.rbTim).isChecked || fragmentView!!.findViewById<RadioButton>(R.id.rbSundar).isChecked || fragmentView!!.findViewById<RadioButton>(R.id.rbElon).isChecked || fragmentView!!.findViewById<RadioButton>(R.id.rbJeff).isChecked){
            fragmentManager!!.beginTransaction().apply {
                setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
                replace(R.id.frameLayout,EndFragment(score))
                addToBackStack(null)
                commit()
            }
        }else
            Toast.makeText(context,"Please select an option",Toast.LENGTH_SHORT).show()

    }

}