package com.itacademy.database.dao;

import com.itacademy.database.entity.Lesson;
import org.hibernate.SessionFactory;

public class LessonDao implements BaseDao<Long, Lesson> {
    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }

    private static final LessonDao INSTANCE = new LessonDao();

    public static LessonDao getInstance() {
        return INSTANCE;
    }
}
