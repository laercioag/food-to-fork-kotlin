package com.laercioag.foodtofork.domain.mapper.base

interface Mapper<InType, OutType> {

    fun map(param: InType): OutType

    fun mapList(param: List<InType>): List<OutType> = param.map(::map)

    fun mapReverse(param: OutType): InType

    fun mapListReverse(param: List<OutType>): List<InType> = param.map(::mapReverse)

}
