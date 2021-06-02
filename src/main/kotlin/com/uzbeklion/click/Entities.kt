package com.uzbeklion.click

class RegionEntity(
        var name: String,
        var asbtId: Int
)

class CrimeInfo(
        var count: Long,
        var name: String
)

class CrimeInfoDto(
        val allCount: Long,
        val items: List<CrimeInfo>
)