package com.uzbeklion.click

import org.springframework.stereotype.Service
import java.util.*

interface RegionService {
    fun getAll(): List<RegionEntity>
    fun getRegion(id: Int): RegionEntity
    fun add(name: String): Int
    fun administrativeCrimeInfo(regionId: Int, startDate: Long, endDate: Long): CrimeInfoDto
}

@Service
class RegionServiceImpl(
        private val mapper: RegionMapper,
        private val crimeMapper: CrimeMapper
) : RegionService {
    override fun getAll() = mapper.getRegions()

    override fun getRegion(id: Int) = mapper.getRegion(id)

    override fun add(name: String) = mapper.save(RegionEntity(name, 0))

    override fun administrativeCrimeInfo(regionId: Int, startDate: Long, endDate: Long): CrimeInfoDto {
        val count = crimeMapper.countByRegionId(regionId, Date(startDate), Date(endDate))?:return CrimeInfoDto(0, emptyList())
        val items = crimeMapper.findAllByRegionId(regionId, Date(startDate), Date(endDate))
        return CrimeInfoDto(count, items)
    }
}