package com.example.work2;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.work2.fragments.AddStudentFragment;
import com.example.work2.fragments.AddTeacherFragment;
import com.example.work2.fragments.AssignStudentToCourseFragment;
import com.example.work2.fragments.AssignTeacherToCourseFragment;
import com.example.work2.fragments.CreateCourseFragment;
import com.example.work2.fragments.ViewStudentsByCourseFragment;

public class MainActivity extends AppCompatActivity {

    Button btnStudents, btnTeachers, btnStudentCourses, btnCreateCourse, btnAssignTeacher, btnViewCourseStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all buttons
        btnStudents = findViewById(R.id.btnStudents);
        btnTeachers = findViewById(R.id.btnTeachers);
        btnStudentCourses = findViewById(R.id.btnStudentCourses);
        btnCreateCourse = findViewById(R.id.btnCreateCourse);
        btnAssignTeacher = findViewById(R.id.btnAssignTeacher);
        btnViewCourseStudents = findViewById(R.id.btnViewCourseStudents);

        // Load default fragment (optional)
        loadFragment(new AddStudentFragment());

        // Set click listeners
        btnStudents.setOnClickListener(v -> loadFragment(new AddStudentFragment()));
        btnTeachers.setOnClickListener(v -> loadFragment(new AddTeacherFragment()));
        btnStudentCourses.setOnClickListener(v -> loadFragment(new AssignStudentToCourseFragment()));
        btnCreateCourse.setOnClickListener(v -> loadFragment(new CreateCourseFragment()));
        btnAssignTeacher.setOnClickListener(v -> loadFragment(new AssignTeacherToCourseFragment()));
        btnViewCourseStudents.setOnClickListener(v -> loadFragment(new ViewStudentsByCourseFragment()));
    }

    // Utility function to load fragments
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
