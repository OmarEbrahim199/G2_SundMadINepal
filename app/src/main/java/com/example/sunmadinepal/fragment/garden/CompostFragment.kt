package com.example.sunmadinepal.fragment.garden

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentCompostBinding
import java.util.*


class CompostFragment : Fragment() {

    private var _binding: FragmentCompostBinding? = null
    private val binding get() = _binding!!
    val string = Locale.getDefault().getLanguage()
    val locale = Locale(string)

    var progressDialog: ProgressDialog? = null // Creating Progress dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCompostBinding.inflate(inflater ,container, false)
        val view = binding?.root


        // Change ActionBar title in fragment

        (activity as AppCompatActivity).supportActionBar?.title = getText(R.string.Compost_title)


        return  view
    }
}