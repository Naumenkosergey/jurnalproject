package com.itacademy.database.dao;

import com.itacademy.database.entity.Lesson;

public class LessonDao implements BaseDao<Long,Lesson> {

    private static final LessonDao INSTANCE = new LessonDao();

    public static LessonDao getInstance(){
        return INSTANCE;
    }
}
