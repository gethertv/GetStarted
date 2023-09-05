package dev.gether.GetStarted.rest.student;

import dev.gether.GetStarted.dao.StudentDAO;
import dev.gether.GetStarted.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private StudentDAO studentDAO;

    @Autowired
    public StudentRestController(StudentDAO studentDAO)
    {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        Student student = studentDAO.findById(studentId);
        if(student!=null)
            return student;

        throw new StudentNotFoundException("Student id not found - " + studentId);
    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        List<Student> students = studentDAO.findAll();
        if(students==null || students.isEmpty()) {
            throw new StudentNotFoundException("List of students is empty!");
        }
        return students;
    }

}
