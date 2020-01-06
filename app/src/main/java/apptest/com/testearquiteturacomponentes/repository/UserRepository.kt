package apptest.com.testearquiteturacomponentes.repository

import apptest.com.testearquiteturacomponentes.entity.User

class UserRepository(private val userLocalRepository: IUserRepository) {

    fun insertUser(user: User){
        userLocalRepository.insertUser(user)
    }

    fun getUsers() = userLocalRepository.getUsers()
}