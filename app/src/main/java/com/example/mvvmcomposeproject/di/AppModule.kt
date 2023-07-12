package com.example.mvvmcomposeproject.di

import android.app.Application
import androidx.room.Room
import com.example.mvvmcomposeproject.data.TodoDatabase
import com.example.mvvmcomposeproject.data.TodoRepository
import com.example.mvvmcomposeproject.data.TodoRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideToDatabase(app:Application):TodoDatabase{
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_dp"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db:TodoDatabase):TodoRepository{
        return TodoRepositoryImp(db.dao)
    }
}