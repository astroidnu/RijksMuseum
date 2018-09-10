package com.scoproject.base.data.database

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
@Entity
data class Users(
        @Id
        var id: Long = 0,
        val name: String,
        val password: String
)