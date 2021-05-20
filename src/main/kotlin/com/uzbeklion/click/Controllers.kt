package com.uzbeklion.click

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("region")

class RegionController(
        private val regionService: RegionService
) {
    @GetMapping
    fun getAllRegion() = regionService.getAll()

    @GetMapping("{id}")
    fun getRegion(@PathVariable id: Int) = regionService.getRegion(id)

    @PostMapping
    fun add(@RequestParam name: String) = regionService.add(name)
}