package com.example.students_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.students_app.databinding.ActivityNewStudentBinding

class NewStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewStudentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.title = "New Students"

        binding.btnSave.setOnClickListener {
            val student = Student(
                id = binding.etStudentId.text.toString(),
                name = binding.etStudentName.text.toString(),
                phone = binding.etStudentPhone.text.toString(),
                address = binding.etStudentAddress.text.toString(),
                isChecked = binding.cbStudentChecked.isChecked
            )
            StudentRepository.addStudent(student)
            finish()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }
}
