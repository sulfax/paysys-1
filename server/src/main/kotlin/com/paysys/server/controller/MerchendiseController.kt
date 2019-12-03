package main.kotlin.com.paysys.server.controller

import main.kotlin.com.paysys.server.repository.CostumerRepository
import main.kotlin.com.paysys.server.repository.MerchendiseRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class MerchendiseController(private val costumerRepository: CostumerRepository,private val merchendiseRepository: MerchendiseRepository) {

    @GetMapping("/merchandise")
    fun getAllMerch()= merchendiseRepository.findAll()


    @PostMapping("/submit")
    fun makePurchase(@Valid @RequestBody id:String): ResponseEntity<String> {
        val costumer = costumerRepository.findById(id.toInt())
        if(costumer.isEmpty) return ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED)
        val updatedCostumer = costumer.get().copy(balance =costumer.get().balance )
        costumerRepository.save(updatedCostumer)
        return ResponseEntity("Takk for handelen ${updatedCostumer.name}. Din nye saldo er ${updatedCostumer.balance} kroner",HttpStatus.OK)
    }




}