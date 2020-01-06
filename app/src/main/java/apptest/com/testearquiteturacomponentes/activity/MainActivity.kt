package apptest.com.testearquiteturacomponentes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import apptest.com.testearquiteturacomponentes.R
import apptest.com.testearquiteturacomponentes.entity.User
import apptest.com.testearquiteturacomponentes.repository.DatabaseRoom
import apptest.com.testearquiteturacomponentes.repository.UserLocalRepository
import apptest.com.testearquiteturacomponentes.repository.UserRepository
import apptest.com.testearquiteturacomponentes.viewmodel.UserViewModel
import apptest.com.testearquiteturacomponentes.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createUserInstance()
        val user = User(0, "Joyce", "9999-99999")
        viewModel.inserUser(user)
        viewModel.getUsers().observe(this, Observer {

            Log.d("CONSULTA", it.toString())
        })

    }

    fun createUserInstance(){

        val database = DatabaseRoom.getInstance(this)
        database?.let {

            val userDao = it.getUserDao()
            val userLocalRepo = UserLocalRepository(userDao)
            val userRepo = UserRepository(userLocalRepo)
            val userViewModelFactory = UserViewModelFactory(userRepo)

            viewModel = ViewModelProviders.of(this, userViewModelFactory).get(UserViewModel::class.java)

        }
    }
}
