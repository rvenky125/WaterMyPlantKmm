package com.famas.watermyplant.db.objects.add_plant

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class PlantObject(): RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()

    var name: String = ""
    var description: String = ""
    var should_remind: Boolean = true
    var color_hex: Long? = null
    var pic_url: String? = null
    var water_qty: Int? = null
    var watering_freaq_millis: Long? = null
    var place_id: String? = null
    var created_at: Long? = null
}