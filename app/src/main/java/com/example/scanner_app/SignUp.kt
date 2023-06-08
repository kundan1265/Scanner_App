package com.example.scanner_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnsignup: Button

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        mAuth = FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        edtName = findViewById(R.id.edt_name)
        btnsignup = findViewById(R.id.btnSighUp)

        btnsignup.setOnClickListener {
            val email = edtEmail.text.toString()
            val name = edtName.text.toString()
            val password = edtPassword.text.toString()

            signUp( email , password)
        }
    }
    private fun signUp(email: String , password: String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // code for jumping to home activity



                    val intent = Intent( this@SignUp, MainActivity::class.java)

                    startActivity(intent)
                }
                else {
                    Toast.makeText(this@SignUp , "Some error occurred" , Toast.LENGTH_SHORT).show()
                }
            }
    }
    }
