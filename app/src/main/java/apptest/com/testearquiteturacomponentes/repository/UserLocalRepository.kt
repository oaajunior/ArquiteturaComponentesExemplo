package apptest.com.testearquiteturacomponentes.repository

import apptest.com.testearquiteturacomponentes.entity.User
import apptest.com.testearquiteturacomponentes.repository.DAO.UserDao

class UserLocalRepository(private val userDao: UserDao):IUserRepository {

    override fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    override fun getUsers() = userDao.getUsers()

}