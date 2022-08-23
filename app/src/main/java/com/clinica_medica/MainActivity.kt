package com.clinica_medica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.clinica_medica.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    companion object{
        private const val RC_SIGN_IN=9001
    }

    //Cliente de autenticacion de google
    private lateinit var googleSignInClient: GoogleSignInClient

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btRegister.setOnClickListener { haceRegistro() }
        binding.btLogin.setOnClickListener { haceLogin() }

        //opciones para hacer la autenticacion en google
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_idr)).requestEmail().build()

        //objeto para hacer la autenticacion
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.btGoogle.setOnClickListener{ googleSignIn() }
    }

    private fun googleSignIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun firebaseAuthWithGoogle(idToken: String){
        var credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) {
                    task -> if (task.isSuccessful) { //se logro autenticar en firebase auth
                actualiza(auth.currentUser)
            } else { //no se autentico en firebase
                actualiza (null)
            }
            }
    }

    //este metodo se ejecuta cuando regresa de hacer la autenticacion en google
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val cuenta = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(cuenta.idToken!!)
            } catch (e: ApiException) {

            }
        }
    }

    private fun haceRegistro() {
        val email = binding.etCorreo.text.toString()
        val clave = binding.etClave.text.toString()

        auth.createUserWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Toast.makeText(baseContext,
                        getString(R.string.msg_fallo_registro),
                        Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }

    private fun haceLogin() {
        val email = binding.etCorreo.text.toString()
        val clave = binding.etClave.text.toString()

        auth.signInWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Toast.makeText(baseContext,
                        getString(R.string.msg_fallo_login),
                        Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }

    private fun actualiza(user: FirebaseUser?) {
        if (user!=null) {

           val intent = Intent(this,Principal::class.java)
            startActivity(intent)
        }
    }

    public override fun onStart() {
        super.onStart()
        val usuario = auth.currentUser
        actualiza(usuario)
    }
}