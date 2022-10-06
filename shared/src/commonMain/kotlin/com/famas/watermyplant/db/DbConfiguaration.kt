package com.famas.watermyplant.db

import com.famas.watermyplant.db.objects.PlantObject
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

private val config = RealmConfiguration.Builder(
    schema = setOf(PlantObject::class)
).build()

val realm: Realm = Realm.open(config)