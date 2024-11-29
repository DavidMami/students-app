package com.example.students_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.students_app.databinding.ActivityStudentsListBinding

class StudentsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentsListBinding
    private lateinit var adapter: StudentsAppAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentsListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = StudentsAppAdapter(StudentRepository.getAllStudents())
        { student ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("STUDENT_ID", student.id)
            startActivity(intent)
        }

        binding.recyclerViewStudents.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewStudents.adapter = adapter

        binding.btnAddStudent.setOnClickListener {
            startActivity(Intent(this, NewStudentActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.updateStudents(StudentRepository.getAllStudents())
    }
}
