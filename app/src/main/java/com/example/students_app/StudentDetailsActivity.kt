package com.example.students_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.students_app.databinding.ActivityStudentDetailsBinding

class StudentDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentDetailsBinding
    private lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val studentId = intent.getStringExtra("STUDENT_ID")
        student = StudentRepository.getStudentById(studentId!!)!!

        binding.tvStudentName.text = student.name
        binding.tvStudentId.text = student.id
        binding.tvStudentPhone.text = student.phone
        binding.tvStudentAddress.text = student.address
        binding.cbStudentChecked.isChecked = student.isChecked

        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("STUDENT_ID", student.id)
            startActivity(intent)
        }
    }
}
