package com.example.work2.Databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.work2.Dao.*;
import com.example.work2.Entity.*;

@Database(
        entities = {Student.class, Teacher.class, Course.class, TeacherCourse.class, StudentCourse.class},
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();
    public abstract TeacherDao teacherDao();
    public abstract CourseDao courseDao();
    public abstract TeacherCourseDao teacherCourseDao();
    public abstract StudentCourseDao studentCourseDao();
}
