package com.uzbeklion.click

import org.springframework.stereotype.Service

interface RegionService {
    fun getAll(): List<RegionEntity>
    fun getRegion(id: Int): RegionEntity
    fun add(name: String): Int
}

@Service
class RegionServiceImpl(
        private val mapper: RegionMapper
) : RegionService {
    override fun getAll() = mapper.getRegions()

    override fun getRegion(id: Int) = mapper.getRegion(id)

    override fun add(name: String) = mapper.save(RegionEntity(name, 0))

}