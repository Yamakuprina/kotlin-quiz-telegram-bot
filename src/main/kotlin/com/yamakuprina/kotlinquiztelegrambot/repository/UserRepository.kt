package com.yamakuprina.kotlinquiztelegrambot.repository

import com.yamakuprina.kotlinquiztelegrambot.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
}