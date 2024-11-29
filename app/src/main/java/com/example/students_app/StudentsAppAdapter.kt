package com.example.students_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentsAppAdapter(
    private var students: List<Student>,
    private val onStudentClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentsAppAdapter.StudentViewHolder>() {

    fun updateStudents(updatedStudents: List<Student>) {
        this.students = updatedStudents
        notifyDataSetChanged()
    }

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgStudentPic: ImageView = itemView.findViewById(R.id.imgStudentPic)
        val tvStudentName: TextView = itemView.findViewById(R.id.tvStudentName)
        val tvStudentId: TextView = itemView.findViewById(R.id.tvStudentId)
        val cbStudentChecked: CheckBox = itemView.findViewById(R.id.cbStudentChecked)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): StudentViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_student, viewGroup, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(studentHolder: StudentViewHolder, position: Int) {
        val student = students[position]

        studentHolder.tvStudentId.text = student.id
        studentHolder.tvStudentName.text = student.name
        studentHolder.cbStudentChecked.isChecked = student.isChecked

        studentHolder.cbStudentChecked.setOnCheckedChangeListener { _, isChecked ->
            student.isChecked = isChecked
            StudentRepository.updateStudent(student)
        }

        studentHolder.itemView.setOnClickListener {
            onStudentClick(student)
        }
    }

    override fun getItemCount() = students.size
}
