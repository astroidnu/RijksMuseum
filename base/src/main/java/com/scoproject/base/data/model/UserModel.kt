package com.scoproject.base.data.model

import com.scoproject.base.data.database.Users
import com.scoproject.base.data.database.Users_
import io.objectbox.BoxStore
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
class UserModel @Inject constructor(boxStore: BoxStore) {

    private val box = boxStore.boxFor(Users::class.java)

    fun getAllUserData() : List<Users>{
        return box.query()
                .order(Users_.id)
                .build()
                .find()
    }

    fun getUserData(username: String, password: String) : Users? {
        return box.query()
                .equal(Users_.name, username)
                .and()
                .equal(Users_.password, password)
                .build()
                .findFirst()
    }

    fun saveUser(username: String, password:String){
        box.put(Users(0,username,password))
    }
}