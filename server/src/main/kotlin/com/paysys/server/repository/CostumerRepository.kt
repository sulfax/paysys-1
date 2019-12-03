package main.kotlin.com.paysys.server.repository

import main.kotlin.com.paysys.server.model.Costumer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CostumerRepository : JpaRepository<Costumer, Int>{

    fun getByName(name: String): Costumer?

    fun findAllByOrderByScoreDesc():List<Costumer>
}