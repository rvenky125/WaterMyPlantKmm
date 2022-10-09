package com.famas.watermyplant.model

data class Plant(
    val name: String,
    val description: String = "",
    val shouldRemind: Boolean = true,
    val colorHex: Long,
    val picUrl: String,
    val waterQty: Int,
    val wateringFreaqMillis: Long,
    val placeId: String,
    val createdAt: Long
)