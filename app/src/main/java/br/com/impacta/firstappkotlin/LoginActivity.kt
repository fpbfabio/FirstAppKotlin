package br.com.impacta.firstappkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private val loginEditText: EditText by lazy { findViewById(R.id.edit_text_email) }
    private val passwordEditText: EditText by lazy { findViewById(R.id.edit_text_password) }
    private val buttonMain: Button by lazy { findViewById(R.id.button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (isSigned) {
            navigateToProfile()
            return
        }
        buttonMain.setOnClickListener {
            if (
                validateEmailAt() &&
                validatePasswordLength() &&
                validatePasswordNumberAndChar() &&
                validatePasswordUpperCase()
            ) {
                isSigned = true
                navigateToProfile()
            } else {
                Toast.makeText(this, "Ops algo deu errado\nTente novamente", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun validateEmailAt(): Boolean {
        val email = loginEditText.text.toString()
        return email.contains("@")
    }

    private fun validatePasswordLength(): Boolean {
        return passwordEditText.text.length > 4
    }

    private fun validatePasswordNumberAndChar(): Boolean {
        var hasNumber = false
        var hasLetter = false
        val password = passwordEditText.text.toString()
        if (password.contains("[0-9]".toRegex())) {
            hasNumber = true
        }
        if (password.contains("[a-z|A-Z]".toRegex())) {
            hasLetter = true
        }
        return hasNumber && hasLetter
    }

    private fun validatePasswordUpperCase(): Boolean {
        val password = passwordEditText.text.toString()
        return password.contains("[A-Z]".toRegex())
    }

    private fun navigateToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
}