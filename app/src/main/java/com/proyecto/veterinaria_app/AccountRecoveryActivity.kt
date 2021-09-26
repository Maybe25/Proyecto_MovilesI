package com.proyecto.veterinaria_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.proyecto.veterinaria_app.databinding.ActivityAccountRecoveryBinding

class AccountRecoveryActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAccountRecoveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAccountRecoveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.senEmailAppCompatButton.setOnClickListener{
            val emailAddress = binding.emailEditText.text.toString()
            Firebase.auth.sendPasswordResetEmail(emailAddress).addOnCompleteListener{task->
                if(task.isSuccessful){
                    val intent = Intent(this,SignInActivity::class.java)
                    this.startActivity(intent)
                }else{
                    Toast.makeText(this,"Ingrese un email valido",
                    Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}