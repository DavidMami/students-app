package com.example.students_app

object StudentRepository {
    private val students = mutableListOf<Student>()

    fun getAllStudents(): List<Student> = students

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun getStudentById(id: String): Student? {
        return students.find { it.id == id }
    }

    fun updateStudent(updatedStudent: Student) {
        val index = students.indexOfFirst { it.id == updatedStudent.id }
        if (index != -1) {
            students[index] = updatedStudent
        }
    }

    fun deleteStudent(id: String) {
        students.removeAll { it.id == id }
    }
}
