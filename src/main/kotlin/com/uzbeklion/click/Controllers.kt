package com.uzbeklion.click

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/click")
class RegionController(
        private val regionService: RegionService
) {
    @GetMapping
    fun getAllRegion() = regionService.getAll()

    @GetMapping("{id}")
    fun getRegion(@PathVariable id: Int) = regionService.getRegion(id)

    @PostMapping
    fun add(@RequestParam name: String) = regionService.add(name)

    @GetMapping("administrative")
    fun getAllAdministrative(@RequestParam regionId: Int, @RequestParam startDate: Long, @RequestParam endDate: Long) = regionService.administrativeCrimeInfo(regionId, startDate, endDate)

}

