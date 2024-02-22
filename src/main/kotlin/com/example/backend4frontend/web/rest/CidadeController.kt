package com.example.backend4frontend.web.rest

import com.example.backend4frontend.data.domain.TaskStatus
import com.example.backend4frontend.data.dto.TaskCreateRequest
import com.example.backend4frontend.data.dto.TaskFetchResponse
import com.example.backend4frontend.data.dto.TaskUpdateRequest
import com.example.backend4frontend.service.TaskService
import jakarta.validation.Valid
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("api/cidade")
class CidadeController(private val service: CidadeService) {

    @GetMapping
    fun getCidades(
        @RequestParam("status", required = false) status: CidadeStatus?
    ): ResponseEntity<Set<CidadeFetchResponse>> = ResponseEntity.ok(service.getCidades(status))

    @GetMapping("{id}")
    fun getCidadeById(@PathVariable id: Long): ResponseEntity<CidadeFetchResponse> = ResponseEntity.ok(service.getCidadeById(id))

    @PostMapping
    fun createCidade(
        @Valid @RequestBody
        createRequest: CidadeCreateRequest
    ): ResponseEntity<CidadeFetchResponse> {
        val task = service.createCidade(createRequest)
        return ResponseEntity(task, HttpStatus.CREATED)
    }

    @PatchMapping("{id}")
    fun updateCidade(
        @PathVariable id: Long,
        @Valid @RequestBody
        updateRequest: CidadeUpdateRequest
    ): ResponseEntity<CidadeFetchResponse> = ResponseEntity.ok(service.updateCidade(id, updateRequest))

    @DeleteMapping("{id}")
    fun deleteCidade(@PathVariable id: Long): ResponseEntity<Unit> {
        val headerValue: String = service.deleteCidade(id)
        val httpHeader = HttpHeaders()
        httpHeader.add("delete-cidade-header", headerValue)
        return ResponseEntity(null, httpHeader, HttpStatus.NO_CONTENT)
    }
}
