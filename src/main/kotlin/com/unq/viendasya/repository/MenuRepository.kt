package com.unq.viendasya.repository

import com.unq.viendasya.model.Menu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface MenuRepository : JpaRepository<Menu, Int>{

    @Query("SELECT * FROM menues m WHERE UPPER(m.name) ILIKE ?1", nativeQuery = true)
    fun findByQuery(query: String): List<Menu>

    @Query("SELECT * FROM menues m WHERE m.provider_id = :providerId", nativeQuery = true)
    fun findByProviderId( @Param("providerId") providerId: Int): List<Menu>
}

