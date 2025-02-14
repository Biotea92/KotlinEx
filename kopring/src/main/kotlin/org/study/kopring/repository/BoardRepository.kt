package org.study.kopring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.study.kopring.entity.Board

interface BoardRepository : JpaRepository<Board, Long> {
}
