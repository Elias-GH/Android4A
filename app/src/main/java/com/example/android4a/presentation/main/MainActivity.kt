package com.example.android4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.android4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){

                is LoginError ->
                    MaterialAlertDialogBuilder(this)
                            .setTitle("Error")
                            .setMessage("Error Unknow Account")
                            .setPositiveButton("Accept") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()

                is LoginSucess ->
                    MaterialAlertDialogBuilder(this)
                            .setTitle("Confirmation")
                            .setMessage("Registered user : You can enter")
                            .setPositiveButton("Thanks") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()


            }

        })
        login_button.setOnClickListener {
            mainViewModel.OnClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }

    }
}