package com.example.bookingclient.view.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.bookingclient.R
import com.example.bookingclient.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel : RegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerViewModel = (activity as LoginActivity).loginContainer.registerViewModelFactory.create()

        val registerObserver = Observer<Boolean> {
            if(it) {
                (activity as LoginActivity).backToLogin()
            }else {
                Toast.makeText(activity, "Something went wrong", Toast.LENGTH_LONG).show()
            }
        }
        registerViewModel.registrationStatus.observe(viewLifecycleOwner, registerObserver)

        btBack.setOnClickListener {
            (activity as LoginActivity).backToLogin()
        }

        btCreate.setOnClickListener {
            if(validateInput()){
                registerViewModel.register(
                    etRegFullname.text.toString(),
                    etRegUsername.text.toString(),
                    etRegEmail.text.toString(),
                    etRegPassword.text.toString())
            }
            else{
                Toast.makeText(activity, "Fill all boxes !", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateInput() : Boolean{
        return etRegFullname.text.isNotEmpty()
                && etRegUsername.text.isNotEmpty()
                && etRegEmail.text.isNotEmpty()
                && etRegPassword.text.isNotEmpty()
                && etRegRepeatPassword.text.toString() == etRegPassword.text.toString()
    }
}