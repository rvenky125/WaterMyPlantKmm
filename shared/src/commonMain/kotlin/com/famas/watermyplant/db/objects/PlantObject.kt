package com.famas.watermyplant.db.objects

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class PlantObject(): RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId.create()

    var name: String = ""
}