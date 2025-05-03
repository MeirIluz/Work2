package com.example.work2.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.work2.Entity.TeacherCourse;

import java.util.List;

@Dao
public interface TeacherCourseDao {
    @Insert
    void insertTeacherCourse(TeacherCourse teacherCourse);

    @Query("SELECT * FROM teachers_courses")
    List<TeacherCourse> getAllTeacherCourses();

    @Query("SELECT COUNT(*) FROM students_courses WHERE student_id = :sid AND course_id = :cid")
    int countStudentCourse(int sid, int cid);
}

