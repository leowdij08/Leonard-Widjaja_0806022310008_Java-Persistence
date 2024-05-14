package com.leoleo;

import org.hibernate.Session;

public class HibernateTest {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Create
        Student student = new Student();
        student.setName("Alicia");
        student.setAge(17);
        student.setMajor("Manajemen");
        session.save(student);

        student.setMajor("CBM");

        session.update(student);

        Student student2 = session.get(Student.class, 6);

        student2.setMajor("IBM");

        session.update(student2);

        // Read
        Student retrieved = session.get(Student.class, student.getId());
        System.out.println("Retrieved: " + retrieved.getName() + ", " + retrieved.getAge() + ", " + retrieved.getMajor());

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }
}
