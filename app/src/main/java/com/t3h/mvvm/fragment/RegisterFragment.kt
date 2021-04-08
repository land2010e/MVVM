package com.t3h.mvvm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.t3h.mvvm.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    var username: String? = null

    private var binding: FragmentRegisterBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(
            inflater, container, false
        )
//        if (arguments != null) {
//            binding!!.edtUsernameAhihiDoNgoc.setText(
//                arguments!!.getString("USERNAME")
//            )
//        }
        if (username != null ){
            binding!!.edtUsernameAhihiDoNgoc.setText(
                username
            )
        }

        binding!!.btnRegister.setOnClickListener{
            val fr = activity!!.supportFragmentManager
                .findFragmentByTag(LoginFragment.javaClass.name)
            if ( fr != null){
                (fr as LoginFragment).updateUsername(
                    binding!!.edtUsernameAhihiDoNgoc.text.toString()
                )
            }
            activity!!.onBackPressed()
        }
        return binding!!.root
    }
}