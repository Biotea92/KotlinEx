package org.study.kopring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.study.kopring.entity.User

interface UserRepository : JpaRepository<User, Long> {
}
