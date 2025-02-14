package org.study.kopring.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.proxy.HibernateProxy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now()

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as BaseEntity

        return id == other.id
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()

//    override fun equals(other: Any?): Boolean {
//        if (this === other)
//            return true
//        if (other == null || HibernateProxy::class.java.isAssignableFrom(other::class.java))
//            return false
//        if (this::class != other::class)
//            return false
//
//        return id == getIdentifier(other)
//    }
//
//    private fun getIdentifier(obj: Any): Long {
//        return if (obj is HibernateProxy) {
//            obj.hibernateLazyInitializer.identifier as Long
//        } else {
//            (obj as BaseEntity).id
//        }
//    }
//
//    override fun hashCode() = Objects.hashCode(id)

}
