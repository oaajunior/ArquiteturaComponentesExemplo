package apptest.com.testearquiteturacomponentes.repository

import androidx.lifecycle.LiveData
import apptest.com.testearquiteturacomponentes.entity.User

interface IUserRepository {

    fun insertUser(user: User)

    fun getUsers():LiveData<List<User>>
}