package com.uzbeklion.click

import com.uzbeklion.click.RegionEntity
import org.apache.ibatis.annotations.*

@Mapper
interface RegionMapper {
    @Select("SELECT * FROM regions")
    fun getRegions(): List<RegionEntity>

    @Select("SELECT * FROM regions where asbt_id=#{id} ")
    fun getRegion(@Param("id") id: Int): RegionEntity

    @Insert("Insert into regions(name,asbt_id) values(#{name},#{asbtId})")
    fun save(region: RegionEntity): Int
}