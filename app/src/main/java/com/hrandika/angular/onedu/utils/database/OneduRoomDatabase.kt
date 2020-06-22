package com.hrandika.angular.onedu.utils.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hrandika.angular.onedu.course.data.Course
import com.hrandika.angular.onedu.course.data.CourseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Course::class], version = 1, exportSchema = false)
public abstract class OneduRoomDatabase: RoomDatabase() {

    abstract fun courseDao(): CourseDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: OneduRoomDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): OneduRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OneduRoomDatabase::class.java,
                    "onedu_database"
                ).fallbackToDestructiveMigration()
                    .addCallback(OneduDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        private class OneduDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.courseDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        fun populateDatabase(wordDao: CourseDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            wordDao.deleteAll()

            var word = Course(name = "Mobile Computing",durationMonth = 3,id = 1)
            wordDao.insertAll(word)

            word = Course(2,name = "Machine Learning",durationMonth = 3)
            wordDao.insertAll(word)

            word = Course(3,name = "Augmented Reality",durationMonth = 5)
            wordDao.insertAll(word)
        }
    }
}