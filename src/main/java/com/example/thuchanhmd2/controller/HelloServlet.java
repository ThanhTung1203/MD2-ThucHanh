package com.example.thuchanhmd2.controller;

import com.example.thuchanhmd2.model.Student;
import com.example.thuchanhmd2.service.ManagerStudent;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "student", value = "/student")
public class HelloServlet extends HttpServlet {

    ManagerStudent managerStudent = new ManagerStudent();
    ;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";

        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showList(request, response);
                break;
        }

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Student students = managerStudent.findById(id);
        request.setAttribute("edit", students);
        requestDispatcher.forward(request, response);
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher r = request.getRequestDispatcher("jsp/list.jsp");
        List<Student> students = managerStudent.showALl();
        request.setAttribute("List", students);
        r.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                CreateStudent(request, response);
                System.out.println("Thành công");
                break;
            case "edit":
                edit(request, response);
                break;
        }


    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id1 = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String addr = request.getParameter("address");
        double score = Double.parseDouble(request.getParameter("score"));
        managerStudent.update(id1,new Student(id1, name, age, sex, addr, score));
        response.sendRedirect("/student");
    }

    private void CreateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        double score = Double.parseDouble(request.getParameter("score"));
        managerStudent.save(new Student(id, name, age, sex, address, score));
        response.sendRedirect("/student");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        managerStudent.delete(id);
        response.sendRedirect("/student");
    }
}