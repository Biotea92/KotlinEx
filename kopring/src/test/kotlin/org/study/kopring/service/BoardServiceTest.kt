package org.study.kopring.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.study.kopring.entity.*
import org.study.kopring.repository.BoardRepository
import org.study.kopring.repository.TagRepository
import org.study.kopring.repository.UserRepository

@DataJpaTest(showSql = true)
class BoardServiceTest {

    @Autowired
    private lateinit var boardRepository: BoardRepository

    @Autowired
    private lateinit var tagRepository: TagRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var testEntityManager: TestEntityManager

    @Test
    fun test() {
        val tom = User("tom")
        userRepository.saveAndFlush(tom)

        val tags = setOf(Tag("key", "value"))
        val information = BoardInformation("http", 1)
        val board = Board("title", "content", information, tom, tags)
        boardRepository.saveAndFlush(board)

        testEntityManager.flush()
        testEntityManager.clear()
//
//        val result = boardRepository.findById(board.id).get()
//        assertThat(board.id).isEqualTo(result.id)
//        assertThat(board.tags.size).isEqualTo(1)
//
//        result.removeTag(tags.first().id)
//
//        testEntityManager.flush()
//        testEntityManager.clear()
//
//        board.addComment(Comment("comment", tom))
//        boardRepository.saveAndFlush(board)
//
//        testEntityManager.flush()
//        testEntityManager.clear()
//
//        val result2 = boardRepository.findById(board.id).get()
//        assertThat(result2.comments.size).isEqualTo(1)
        val findById = userRepository.findById(1L).get()
        val board2 = Board("title", "content", information, findById, setOf())


        
        boardRepository.saveAndFlush(board2)
    }
}
