package com.example.work2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.work2.R;
import com.example.work2.Databases.AppDatabase;
import com.example.work2.Entity.Student;
import com.example.work2.Recycler.StudentAdapter;

import java.util.List;

public class AddStudentFragment extends Fragment {

    EditText etFirst, etLast, etTehudatZeut, etAverage;
    Button btnAdd;
    RecyclerView recyclerView;
    AppDatabase db;
    StudentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);

        etFirst = view.findViewById(R.id.etFirstName);
        etLast = view.findViewById(R.id.etLastName);
        etTehudatZeut = view.findViewById(R.id.etTehudatZeut);
        etAverage = view.findViewById(R.id.etAverage);
        btnAdd = view.findViewById(R.id.btnAddStudent);
        recyclerView = view.findViewById(R.id.recyclerStudents);

        db = Room.databaseBuilder(requireContext(), AppDatabase.class, "school-database")
                .allowMainThreadQueries()
                .build();

        refreshStudentList();

        btnAdd.setOnClickListener(v -> {
            Student s = new Student();
            s.firstName = etFirst.getText().toString();
            s.lastName = etLast.getText().toString();
            s.tehudatZeut = etTehudatZeut.getText().toString();
            s.average = Float.parseFloat(etAverage.getText().toString());
            db.studentDao().insertStudent(s);
            Toast.makeText(getContext(), "Student added!", Toast.LENGTH_SHORT).show();
            clearFields();
            refreshStudentList();
        });

        adapter.setOnDeleteListener(student -> {
            db.studentDao().deleteStudent(student);
            Toast.makeText(getContext(), "Student deleted", Toast.LENGTH_SHORT).show();
            refreshStudentList();
        });


        return view;
    }

    private void clearFields() {
        etFirst.setText("");
        etLast.setText("");
        etTehudatZeut.setText("");
        etAverage.setText("");
    }

    private void refreshStudentList() {
        List<Student> students = db.studentDao().getAllStudents();
        adapter = new StudentAdapter(students);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }


}
