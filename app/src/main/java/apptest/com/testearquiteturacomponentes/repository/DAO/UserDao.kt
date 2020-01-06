package apptest.com.testearquiteturacomponentes.repository.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import apptest.com.testearquiteturacomponentes.entity.User

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM tb_users")
    fun getUsers():LiveData<List<User>>
}