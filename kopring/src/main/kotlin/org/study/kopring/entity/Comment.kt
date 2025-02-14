package org.study.kopring.entity

import jakarta.persistence.*

@Embeddable
data class Comment(
    @Column(length = 3000)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    val writer: User,
)
