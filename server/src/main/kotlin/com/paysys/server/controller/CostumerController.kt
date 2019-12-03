package main.kotlin.com.paysys.server.controller

import main.kotlin.com.paysys.server.model.Costumer
import main.kotlin.com.paysys.server.repository.CostumerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class CostumerController(private val costumerRepository: CostumerRepository) {

    @PutMapping("/login")
    fun doLogin(@Valid @RequestBody costumerId: String):ResponseEntity<Costumer>{
        return costumerRepository.findById(costumerId.toInt()).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/costumers")
    fun createNewCostumer(@Valid @RequestBody costumer: Costumer): Costumer =
        costumerRepository.save(costumer)

    @GetMapping("/costumers")
    fun getUserById(@RequestHeader( "Id") id: Int): ResponseEntity<Costumer> {
        return costumerRepository.findById(id).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/costumers/score")
    fun getAllCostumers():List<Costumer> = costumerRepository.findAllByOrderByScoreDesc()


    @PutMapping("costumers/increaseBalance")
    fun increaseBalance(@RequestHeader("id") id: Int, @Valid @RequestBody addedBallance: Int) : ResponseEntity<Costumer> {

        val costumer = costumerRepository.findById(id)
        if(costumer.isPresent){
            val existingCostumer = costumer.get()
            val updatedCostumer = existingCostumer.copy(balance = existingCostumer.balance+addedBallance)
            costumerRepository.save(updatedCostumer)
            return ResponseEntity(updatedCostumer,HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    fun MutableMap<String, Double>.addUserData(costumer: Costumer, data: Double){
        if(data<0){
            return
        }
        val name = costumer.name
        this[name] = data
    }
}
