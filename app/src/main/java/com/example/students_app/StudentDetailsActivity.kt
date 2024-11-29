package com.example.students_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.students_app.databinding.ActivityStudentDetailsBinding

class StudentDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val studentId = intent.getStringExtra("STUDENT_ID")
        if (studentId != null) {
            val student = StudentRepository.getStudentById(studentId)

            if (student != null) {
                binding.tvStudentName.text = "Name: ${student.name}"
                binding.tvStudentId.text = "ID: ${student.id}"
                binding.tvStudentPhone.text = "Phone: ${student.phone}"
                binding.tvStudentAddress.text = "Address: ${student.address}"
                binding.cbStudentChecked.isChecked = student.isChecked

                binding.btnEdit.setOnClickListener {
                    val intent = Intent(this, EditStudentActivity::class.java)
                    intent.putExtra("STUDENT_ID", student.id)
                    startActivity(intent)
                }
            } else {
                binding.tvStudentName.text = "Student not found"
            }
        }
    }

    override fun onResume() {
        super.onResume()

        val studentId = intent.getStringExtra("STUDENT_ID")
        if (studentId != null) {
            val student = StudentRepository.getStudentById(studentId)
            if (student != null) {
                binding.tvStudentName.text = "Name: ${student.name}"
                binding.tvStudentId.text = "ID: ${student.id}"
                binding.tvStudentPhone.text = "Phone: ${student.phone}"
                binding.tvStudentAddress.text = "Address: ${student.address}"
                binding.cbStudentChecked.isChecked = student.isChecked
            } else {
                binding.tvStudentName.text = "Name: "
                binding.tvStudentId.text = "ID: "
                binding.tvStudentPhone.text = "Phone: "
                binding.tvStudentAddress.text = "Address: "
                binding.cbStudentChecked.isChecked = false
            }
        }
    }

}
