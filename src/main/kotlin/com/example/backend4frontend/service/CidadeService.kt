package com.example.backend4frontend.service

import com.example.backend4frontend.data.domain.CidadeStatus
import com.example.backend4frontend.data.dto.CidadeCreateRequest
import com.example.backend4frontend.data.dto.CidadeFetchResponse
import com.example.backend4frontend.data.dto.CidadeUpdateRequest


interface CidadeService {

    fun getCidades(status: CidadeStatus?): Set<CidadeFetchResponse>

    fun getCidadeById(id: Long): CidadeFetchResponse

    fun createCidade(createRequest: CidadeCreateRequest): CidadeFetchResponse

    fun updateCidade(id: Long, updateRequest: CidadeUpdateRequest): CidadeFetchResponse

    fun deleteCidade(id: Long): String
}
