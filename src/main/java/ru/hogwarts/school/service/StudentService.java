package ru.hogwarts.school.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentQuerySQL;
import ru.hogwarts.school.repository.AvatarRepository;
import ru.hogwarts.school.repository.StudentRepository;

@Service
public class StudentService {

    @Value("${avatars.dir.path}")
    private String avatarsDir;

    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;

    public StudentService(StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
    }


    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Faculty findFacultyByStudent(long id) {
        return studentRepository.findById(id).get().getFaculty();
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findStudentByAgeBetween(min, max);
    }

    public Collection<Student> findByFaculty(long faculty) {
        return studentRepository.findStudentByFaculty_Id(faculty);
    }

    public List<StudentQuerySQL> getNameAndAge() {
        return studentRepository.getNameAndAgeStudents();
    }

    public Integer getCountStudents() {
        return studentRepository.getCountAllStudents();
    }

    public Double getAverageAge() {
        return studentRepository.getAverageAge();
    }

}