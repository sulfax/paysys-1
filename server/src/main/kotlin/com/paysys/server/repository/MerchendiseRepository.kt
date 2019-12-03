package main.kotlin.com.paysys.server.repository

import main.kotlin.com.paysys.server.model.Merchendise
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MerchendiseRepository : JpaRepository<Merchendise, Int>{

}