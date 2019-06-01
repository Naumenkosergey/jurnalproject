package com.itacademy.database.util;

import com.itacademy.database.entity.Employee;
import com.itacademy.database.entity.Faculty;
import com.itacademy.database.entity.Flow;
import com.itacademy.database.entity.Groupa;
import com.itacademy.database.entity.Lesson;
import com.itacademy.database.entity.Mark;
import com.itacademy.database.entity.Office;
import com.itacademy.database.entity.Role;
import com.itacademy.database.entity.Status;
import com.itacademy.database.entity.Student;
import com.itacademy.database.entity.Subject;
import com.itacademy.database.entity.User;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.Instant;

@NoArgsConstructor
public class FillingDB {

    private static FillingDB INSTANCE = new FillingDB();

    public static FillingDB getInstance() {
        return INSTANCE;
    }

    private static Role roleSave(Session session, String name) {
        Role role = new Role().builder()
                .name(name)
                .build();
        session.save(role);

        return role;
    }

    private static Employee employeeSave(Session session, String name, String surname, User user) {
        Employee employee = new Employee().builder()
                .name(name)
                .surname(surname)
                .user(user)
                .build();
        session.save(employee);

        return employee;
    }

    private static User userSave(Session session, String login, String password, Role role) {
        User user = new User().builder()
                .login(login)
                .password(password)
                .role(role)
                .build();
        session.save(user);

        return user;
    }

    private static Status statusSave(Session session, String name) {
        Status status = new Status().builder()
                .name(name)
                .build();
        session.save(status);
        return status;
    }

    private static Student studentSave(Session session, String serName, String name, String patronymic, User user, Groupa groupa, Status status) {
        Student student = new Student().builder()
                .sername(serName)
                .name(name)
                .patronymich(patronymic)
                .user(user)
                .groupa(groupa)
                .status(status)
                .build();
        session.save(student);
        return student;
    }

    private static Flow flowSave(Session session, String name) {
        Flow flow = new Flow().builder()
                .name(name)
                .build();
        session.save(flow);
        return flow;
    }

    private static Groupa groupaSave(Session session, Integer number, Integer semestr, Flow flow) {
        Groupa groupa = new Groupa().builder()
                .number(number)
                .semestr(semestr)
                .flow(flow)
                .build();
        session.save(groupa);
        return groupa;
    }

    private static Office officeSave(Session session, String name) {
        Office office = new Office().builder()
                .name(name)
                .build();
        session.save(office);
        return office;
    }

    private static Faculty facultySave(Session session, String name) {
        Faculty faculty = new Faculty().builder()
                .name(name)
                .build();
        session.save(faculty);
        return faculty;
    }

    private static Subject subjectSave(Session session, String name, Integer semestr, Flow flow, Faculty faculty) {
        Subject subject = new Subject().builder()
                .name(name)
                .semestr(semestr)
                .flow(flow)
                .faculty(faculty)
                .build();
        session.save(subject);
        return subject;
    }

    private static Lesson lessonSave(Session session, Instant data, String topick, String homework, Office office, Employee employee) {
        Lesson lesson = new Lesson().builder()
                .data(data)
                .topick(topick)
                .homework(homework)
                .office(office)
                .employee(employee)
                .build();
        session.save(lesson);
        return lesson;
    }

    private static Mark markSave(Session session, Integer value, Integer expiriance, Lesson lesson, Student student) {
        Mark mark = new Mark().builder()
                .value(value)
                .experiance(expiriance)
                .lesson(lesson)
                .student(student)
                .build();
        session.save(mark);
        return mark;
    }

//    public static void main(String[] args) {
//        importDdataForTest();
//    }

    public void importDdataForTest(SessionFactory sessionFactory) {
//        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Role admin = roleSave(session, "Админ");
            Role student = roleSave(session, "Студент");
            Role teacher = roleSave(session, "Преподаватель");
            Role manager = roleSave(session, "Менеджер");

            User user1 = userSave(session, "admin", "admin", admin);
            User user2 = userSave(session, "student1", "student1", teacher);
            User user3 = userSave(session, "student2", "student2", teacher);
            User user4 = userSave(session, "manager", "manager", manager);
            User user5 = userSave(session, "teacher", "admin", admin);
            User user6 = userSave(session, "teacher", "teacher", teacher);

            Employee employee1 = employeeSave(session, "Сергей", "Науменко", user6);
            Employee employee2 = employeeSave(session, "Александра", "Диковицкая", user4);
            Employee employee3 = employeeSave(session, "дима", "Коледа", user3);
            Employee employee4 = employeeSave(session, "Саша", "Торган", user2);
            Employee employee5 = employeeSave(session, "Андрей", "Акинфин", user1);

            Status status1 = statusSave(session, "Ходит");
            Status status2 = statusSave(session, "Академ");
            Status status3 = statusSave(session, "Расторжение");
            Status status4 = statusSave(session, "Отчислен");
            Status status5 = statusSave(session, "Выпустился");

            Office priticskogo = officeSave(session, "Притыцкого");
            Office mogilevskaya = officeSave(session, "Могилевская");
            Office loginskya = officeSave(session, "Ложинская");
            Office derjinskogo = officeSave(session, "Держинского");
            Office pobediteley = officeSave(session, "Победителей");
            Office logoika = officeSave(session, "Логойский тракт");


            Flow flow1 = flowSave(session, "16/1");
            Flow flow2 = flowSave(session, "16/2");
            Flow flow3 = flowSave(session, "17/1");
            Flow flow4 = flowSave(session, "17/2");
            Flow flow5 = flowSave(session, "18/1");
            Flow flow6 = flowSave(session, "18/2");
            Flow flow7 = flowSave(session, "19/1");

            Faculty kids = facultySave(session, "kids");
            Faculty teen = facultySave(session, "teen");
            Faculty jun = facultySave(session, "jun");

            Groupa groupa1 = groupaSave(session, 1, 1, flow1);
            Groupa groupa2 = groupaSave(session, 2, 1, flow2);
            Groupa groupa3 = groupaSave(session, 3, 2, flow3);
            Groupa groupa4 = groupaSave(session, 4, 1, flow3);
            Groupa groupa5 = groupaSave(session, 5, 1, flow5);
            Groupa groupa6 = groupaSave(session, 6, 4, flow4);
            Groupa groupa7 = groupaSave(session, 5, 1, flow6);
            Groupa groupa8 = groupaSave(session, 4, 3, flow7);

            Subject pythonT = subjectSave(session, "python", 4, flow4, teen);
            Subject netJ = subjectSave(session, ".Net", 4, flow4, jun);
            Subject wedo = subjectSave(session, "wedo", 1, flow7, kids);
            Subject lrm = subjectSave(session, "LRM", 3, flow2, teen);
            Subject pc = subjectSave(session, "PC", 1, flow2, jun);

            Student studentSaha = studentSave(session, "Длробязко", "Саша", "Батьковна", user2, groupa1, status1);
            Student studentMatvey = studentSave(session, "Алесин", "Матвей", "Батькович", user3, groupa2, status5);

            Lesson lesson1 = lessonSave(session, Instant.now(), "тема1", "ДЗ1", priticskogo, employee1);
            Lesson lesson2 = lessonSave(session, Instant.now(), "тема2", "ДЗ2", priticskogo, employee1);
            Lesson lesson3 = lessonSave(session, Instant.now(), "тема3", "ДЗ3", priticskogo, employee2);

            Mark markSaha = markSave(session, 2, 400, lesson1, studentSaha);
            Mark markMatvey = markSave(session, 4, 600, lesson3, studentMatvey);
            Mark markSaha2 = markSave(session, 3, 500, lesson3, studentSaha);
//
            employee1.getOffices().add(priticskogo);
            employee1.getOffices().add(mogilevskaya);
            mogilevskaya.getEmployees().add(employee3);
            mogilevskaya.getEmployees().add(employee2);

            groupa1.getFaculties().add(jun);
            groupa1.getFaculties().add(kids);
            groupa1.getFaculties().add(teen);
            teen.getGroupas().add(groupa6);
            teen.getGroupas().add(groupa7);

            pythonT.getFaculties().add(teen);
            netJ.getFaculties().add(jun);
            jun.getSubjects().add(pc);
            kids.getSubjects().add(wedo);

            session.getTransaction().commit();
        }
    }
}
//}
