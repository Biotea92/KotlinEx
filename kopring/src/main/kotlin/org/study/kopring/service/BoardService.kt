package org.study.kopring.service

import org.springframework.stereotype.Service
import org.study.kopring.repository.BoardRepository
import org.study.kopring.repository.TagRepository
import org.study.kopring.repository.UserRepository

@Service
class BoardService(
    val boardRepository: BoardRepository,
    val tagRepository: TagRepository,
    val userRepository: UserRepository
) {

}
