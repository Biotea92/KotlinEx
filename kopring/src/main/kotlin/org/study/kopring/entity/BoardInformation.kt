package org.study.kopring.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class BoardInformation(
    @Column
    val link: String?,

    @Column(nullable = false)
    val rank: Int,
)
