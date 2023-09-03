package dev.gether.GetStarted.dao;

import dev.gether.GetStarted.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        // Student / lastName  (entity/fields)
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName", Student.class);

        // return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName=:lastName", Student.class);

        // set query parameters
        query.setParameter("lastName", lastName);

        // return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // get student by ID
        Student student = findById(id);

        // remove
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {

        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
