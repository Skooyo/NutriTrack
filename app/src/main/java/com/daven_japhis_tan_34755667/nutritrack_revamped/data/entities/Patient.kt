package com.daven_japhis_tan_34755667.nutritrack_revamped.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Represents a patient entity in the database.
 *
 * This data class is annotated with `@Entity` to
 * indicate that it represents a table in the database.
 * The `tableName` property specifies the name
 * of the table as "patient".
 */
@Entity(tableName = "patients")
data class Patient(
    @PrimaryKey
    val userId: Int,
    val name: String,
    /** The age of the patient */
    val age: Int,
    /** The address of the patient */
    val address: String,
)
