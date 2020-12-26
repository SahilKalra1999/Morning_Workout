package com.sahilkalra.morningworkout

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ExerciseFragment : Fragment() {
    lateinit var imgChest:ImageView
    lateinit var imgBack:ImageView
    lateinit var imgTriceps:ImageView
    lateinit var imgBiceps:ImageView
    lateinit var imgShoulders:ImageView
    lateinit var imgAbs:ImageView
    lateinit var imgLeg:ImageView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_exercise, container, false)
        imgChest=view.findViewById(R.id.imgChest)
        imgBack=view.findViewById(R.id.imgBack)
        imgTriceps=view.findViewById(R.id.imgTriceps)
        imgBiceps=view.findViewById(R.id.imgBiceps)
        imgShoulders=view.findViewById(R.id.imgShoulders)
        imgAbs=view.findViewById(R.id.imgAbs)
        imgLeg=view.findViewById(R.id.imgLeg)
        imgChest.setOnClickListener {
            val intentChest=Intent(activity, ChestActivity::class.java)
            startActivity(intentChest)
        }
        imgBack.setOnClickListener {
            val intentBack=Intent(activity, BackActivity::class.java)
            startActivity(intentBack)
        }
        imgTriceps.setOnClickListener {
            val intentTriceps=Intent(activity, TricepsActivity::class.java)
            startActivity(intentTriceps)
        }
        imgBiceps.setOnClickListener {
            val intentBiceps=Intent(activity, BicepsActivity::class.java)
            startActivity(intentBiceps)
        }
        imgShoulders.setOnClickListener {
            val intentShoulders=Intent(activity, ShoulderActivity::class.java)
            startActivity(intentShoulders)
        }
        imgAbs.setOnClickListener {
            val intentAbs=Intent(activity, AbsActivity::class.java)
            startActivity(intentAbs)
        }
        imgLeg.setOnClickListener {
            val intentLeg=Intent(activity, LegsActivity::class.java)
            startActivity(intentLeg)
        }
        return view
    }


}