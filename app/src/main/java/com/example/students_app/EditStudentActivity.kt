package com.example.students_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.students_app.databinding.ActivityEditStudentBinding

class EditStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditStudentBinding
    private lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditStudentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val studentId = intent.getStringExtra("STUDENT_ID")
        student = StudentRepository.getStudentById(studentId!!)!!

        binding.etStudentName.setText(student.name)
        binding.etStudentId.setText(student.id)
        binding.etStudentPhone.setText(student.phone)
        binding.etStudentAddress.setText(student.address)
        binding.cbStudentChecked.isChecked = student.isChecked

        binding.btnSave.setOnClickListener {
            student.name = binding.etStudentName.text.toString()
            student.id = binding.etStudentId.text.toString()
            student.phone = binding.etStudentPhone.text.toString()
            student.address = binding.etStudentAddress.text.toString()
            student.isChecked = binding.cbStudentChecked.isChecked

            StudentRepository.updateStudent(student)
            finish()
        }

        binding.btnDelete.setOnClickListener {
            StudentRepository.deleteStudent(student.id)
            finish()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }
}