package apptest.com.testearquiteturacomponentes.viewmodel

import androidx.lifecycle.ViewModel
import apptest.com.testearquiteturacomponentes.entity.User
import apptest.com.testearquiteturacomponentes.repository.UserRepository

class UserViewModel(private val userRepository: UserRepository):ViewModel() {

    val userList = userRepository.getUsers()

    fun inserUser(user: User) {
        userRepository.insertUser(user)
    }
    fun getUsers() = userList
}