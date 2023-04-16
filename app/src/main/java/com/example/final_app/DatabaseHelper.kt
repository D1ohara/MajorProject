package com.example.final_app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "CourseDatabase"
        private const val DATABASE_VERSION = 1

        // Table and column names
        private const val TABLE_COURSES = "courses"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_CODE = "code"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_CREDITS = "credits"
        private const val COLUMN_PREREQUISITES = "prerequisites"
        private const val COLUMN_DESCRIPTION = "description"

        // SQL statement to create the courses table
        private const val CREATE_TABLE_COURSES =
            "CREATE TABLE $TABLE_COURSES ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_CODE TEXT, $COLUMN_NAME TEXT, $COLUMN_CREDITS INTEGER, $COLUMN_PREREQUISITES TEXT, $COLUMN_DESCRIPTION TEXT)"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_COURSES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_COURSES")
        onCreate(db)
    }

    fun addCourse(course: Course): Long {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(COLUMN_CODE, course.code)
            put(COLUMN_NAME, course.name)
            put(COLUMN_CREDITS, course.credits)
            put(COLUMN_PREREQUISITES, course.prerequisites)
            put(COLUMN_DESCRIPTION, course.description)
        }

        val rowId = db.insert(TABLE_COURSES, null, values)
        db.close()

        return rowId
    }

    fun getAllCourses(): List<Course> {
        val courseList = ArrayList<Course>()
        val selectQuery = "SELECT * FROM $TABLE_COURSES ORDER BY $COLUMN_CODE"

        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val course = Course(
                    cursor.getString(cursor.getColumnIndex(COLUMN_CODE)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                    cursor.getInt(cursor.getColumnIndex(COLUMN_CREDITS)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_PREREQUISITES)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
                )
                course.id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))

                courseList.add(course)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return courseList
    }

    fun getCourseById(id: Long) {
        val db = this.readableDatabase

        val cursor = db.query(
            TABLE_COURSES, arrayOf(
                COLUMN_ID,
                COLUMN_CODE,
                COLUMN_NAME,
                COLUMN_CREDITS,
                COLUMN_PREREQUISITES,
                COLUMN_DESCRIPTION
            ), "$COLUMN_ID = ?", arrayOf(id.toString()), null, null, null, null
        )

        var course: Course? = null

        if (cursor.moveToFirst()) {
            course = Course(
                cursor.getString(cursor.getColumnIndex(COLUMN_CODE)),
                cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                cursor.getInt(cursor.getColumnIndex(COLUMN_CREDITS)),
                cursor.getString(cursor.getColumnIndex(COLUMN_PREREQUISITES)),
                cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
            )
            course.id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
        }

        cursor
        fun getCourseById(id: Long): Course? {
            val db = this.readableDatabase

            val cursor = db.query(
                TABLE_COURSES, arrayOf(
                    COLUMN_ID,
                    COLUMN_CODE,
                    COLUMN_NAME,
                    COLUMN_CREDITS,
                    COLUMN_PREREQUISITES,
                    COLUMN_DESCRIPTION
                ), "$COLUMN_ID = ?", arrayOf(id.toString()), null, null, null, null
            )

            var course: Course? = null

            if (cursor.moveToFirst()) {
                course = Course(
                    cursor.getString(cursor.getColumnIndex(COLUMN_CODE)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                    cursor.getInt(cursor.getColumnIndex(COLUMN_CREDITS)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_PREREQUISITES)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
                )
                course!!.id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
            }

            cursor.close()
            db.close()

            return course
        }

        fun getCourse(courseCode: String): Course? {
            val db = this.readableDatabase
            var course: Course? = null
            val selectQuery = "SELECT * FROM $TABLE_COURSES WHERE $COLUMN_CODE = ?"

            val cursor = db.rawQuery(selectQuery, arrayOf(courseCode))

            if (cursor.moveToFirst()) {
                course = Course(
                    cursor.getString(cursor.getColumnIndex(COLUMN_CODE)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                    cursor.getInt(cursor.getColumnIndex(COLUMN_CREDITS)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_PREREQUISITES)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
                )
                course!!.id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
            }

            cursor.close()
            db.close()

            return course
        }
    }
}