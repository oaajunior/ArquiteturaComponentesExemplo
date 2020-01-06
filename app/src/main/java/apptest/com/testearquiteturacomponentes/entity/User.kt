package apptest.com.testearquiteturacomponentes.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val telephone: String) {
}