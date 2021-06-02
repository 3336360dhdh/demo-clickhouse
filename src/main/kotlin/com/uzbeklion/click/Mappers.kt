package com.uzbeklion.click

import com.uzbeklion.click.RegionEntity
import org.apache.ibatis.annotations.*
import java.util.*

@Mapper
interface RegionMapper {
    @Select("SELECT * FROM regions")
    fun getRegions(): List<RegionEntity>

    @Select("SELECT * FROM regions where asbt_id=#{id} ")
    fun getRegion(@Param("id") id: Int): RegionEntity

    @Insert("Insert into regions(name,asbt_id) values(#{name},#{asbtId})")
    fun save(region: RegionEntity): Int
}

@Mapper
interface CrimeMapper {
    @Select("SELECT count('tuzgan_viloyat') FROM crime WHERE tuzgan_viloyat = #{regionId} AND kiritilgan_sana >= #{startDate} AND kiritilgan_sana <= #{endDate} GROUP BY tuzgan_viloyat")
    fun countByRegionId(regionId: Int, startDate: Date, endDate: Date): Long?

    @Select("SELECT count('tuzgan_viloyat') AS count, asosiy_modda_nomi AS name FROM crime WHERE tuzgan_viloyat = #{regionId} AND kiritilgan_sana >= #{startDate} AND kiritilgan_sana <= #{endDate} GROUP BY asosiy_modda_nomi ORDER BY count DESC")
    fun findAllByRegionId(regionId: Int, startDate: Date, endDate: Date): List<CrimeInfo>
}