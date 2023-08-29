package android.example.com

import android.content.Context
import android.example.com.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aedan Cousland")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) //a resource is a layout with name activity_main
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        //findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickname(it) //it = done button, equivalent to "this" in java
        //}
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
        //set label's text to input
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString() //nicknameText.text = binding.nicknameEdit.text //nicknameTextView.text = editText.text
            invalidateAll() //refresh ui with new data old bindings
            //hide input field and done button
            nicknameEdit.visibility = View.GONE //editText.visibility = View.GONE
            doneButton.visibility = View.GONE //view.visibility = View.GONE
            //and show label
            nicknameText.visibility = View.VISIBLE //nicknameTextView.visibility = View.VISIBLE
        }
        //hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}