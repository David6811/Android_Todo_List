package com.example.todo

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.todo.dao.AppDatabase
import com.example.todo.dao.IconDao
import com.example.todo.entities.Icons
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class IconDaoTest {

    private lateinit var iconDao: IconDao
    private lateinit var db: AppDatabase

    @Before
    fun setUp() {
        // Create an in-memory Room database for testing
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries() // You can allow queries on the main thread for testing
            .build()
        iconDao = db.iconsDao()
    }

    @After
    fun tearDown() {
        // Close the database after the test
        db.close()
    }

    @Test
    fun insertAndGetAllIcons() {
        // Create a list of Icons to insert
        val icon1 = Icons(id = 1, name = "Icon1", image = 101)
        val icon2 = Icons(id = 2, name = "Icon2", image = 102)

        // Insert icons
        iconDao.insertAll(arrayOf(icon1, icon2))

        // Get all icons from the database
        val icons = iconDao.getAll()

        // Assert that the icons were correctly inserted
        assertNotNull(icons)
        assertEquals(2, icons.size)
        assertTrue(icons.contains(icon1))
        assertTrue(icons.contains(icon2))
    }

    @Test
    fun deleteIcon() {
        // Create an icon to insert and delete
        val icon = Icons(id = 1, name = "Icon1", image = 101)

        // Insert the icon
        iconDao.insertAll(arrayOf(icon))

        // Delete the icon
        iconDao.delete(icon)

        // Get all icons and ensure the icon is deleted
        val icons = iconDao.getAll()
        assertFalse(icons.contains(icon))
    }

    @Test
    fun deleteAllIcons() {
        // Create a list of icons to insert
        val icon1 = Icons(id = 1, name = "Icon1", image = 101)
        val icon2 = Icons(id = 2, name = "Icon2", image = 102)

        // Insert icons
        iconDao.insertAll(arrayOf(icon1, icon2))

        // Delete all icons
        iconDao.deleteAll()

        // Get all icons and ensure the list is empty
        val icons = iconDao.getAll()
        assertTrue(icons.isEmpty())
    }
}
