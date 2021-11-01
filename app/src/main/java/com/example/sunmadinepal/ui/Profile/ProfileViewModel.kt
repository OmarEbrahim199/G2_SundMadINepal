package com.example.sunmadinepal.ui.Profile

import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Profile Fragment"

    }
    val text: LiveData<String> = _text


    private val _New_activity = MutableLiveData<String>().apply {
        value = "This is Profile Fragment"

    }
    val newactivity: LiveData<String> = _New_activity



}
/*

override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val rootView: View = inflater.inflate(com.example.sunmadinepal.R.layout.fragment_home, container, false)
    val aboutBtn = rootView.findViewById<View>(com.example.sunmadinepal.R.id.aboutusButton) as Button
    val phonebookBtn = rootView.findViewById<View>(com.example.sunmadinepal.R.id.phbookButton) as Button
    val schemeBtn = rootView.findViewById<View>(com.example.sunmadinepal.R.id.schemeButton) as Button
    val loanBtn = rootView.findViewById<View>(com.example.sunmadinepal.R.id.loanButton) as Button
    val serviceBtn = rootView.findViewById<View>(com.example.sunmadinepal.R.id.serviceButton) as Button
    val devBtn = rootView.findViewById<View>(com.example.sunmadinepal.R.id.devButton) as Button
    aboutBtn.setOnClickListener { // Launching new Activity on selecting single List Item
        val i = Intent(activity, AboutFragment::class.java)
        startActivity(i)
    }
    phonebookBtn.setOnClickListener { // Launching new Activity on selecting single List Item
        val j = Intent(activity, PhoneBookFragment::class.java)
        startActivity(j)
    }
    schemeBtn.setOnClickListener { // Launching new Activity on selecting single List Item
        val k = Intent(activity, HomeFragment::class.java)
        startActivity(k)
    }
    loanBtn.setOnClickListener { // Launching new Activity on selecting single List Item
        val l = Intent(activity, RemittanceFragment::class.java)
        startActivity(l)
    }
    serviceBtn.setOnClickListener { // Launching new Activity on selecting single List Item
        val m = Intent(activity, ServiceFragment::class.java)
        startActivity(m)
    }
    devBtn.setOnClickListener { // Launching new Activity on selecting single List Item
        val n = Intent(activity, AboutDeveloper::class.java)
        startActivity(n)
    }
    return rootView
}*/
