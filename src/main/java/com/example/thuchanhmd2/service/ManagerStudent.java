package com.example.thuchanhmd2.service;

import com.example.thuchanhmd2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ManagerStudent implements ManageService {
    List<Student> list = new ArrayList<>();


    public ManagerStudent() {
        list.add(new Student(1, "tùng", 23, "nam", "hà đông", 10.0));
        list.add(new Student(1, "tùng", 23, "nam", "hà đông", 10.0));
        list.add(new Student(1, "tùng", 23, "nam", "hà đông", 10.0));
        list.add(new Student(1, "tùng", 23, "nam", "hà đông", 10.0));
        list.add(new Student(1, "tùng", 23, "nam", "hà đông", 10.0));
    }

    @Override
    public Student findById(int id) {
//        int index= -1;
//        for (int i = 0; i < list.size(); i++) {
//            if(index== list.get(i).getId()){
//                index = i;
//            }
//        }
        for (Student students : list
        ) {
            if (id == students.getId()) {
                return students;
            }

        }

        return null;
    }

    @Override
    public void delete(int id) {
        list.remove(findById(id));
    }

    @Override
    public void update(int id, Student student) {
        int index=-1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==id){
                index=i;

            }

        }
        list.set(index,student);

    }

    @Override
    public void save(Student student) {
        list.add(student);
    }

    @Override
    public List<Student> showALl() {
        return list;
    }
}
