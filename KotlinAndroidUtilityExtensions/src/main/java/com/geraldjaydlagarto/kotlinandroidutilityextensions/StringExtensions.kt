package com.geraldjaydlagarto.kotlinandroidutilityextensions

import java.util.regex.Pattern

object CustomPatterns {

    val STRONG_PASSWORD: Pattern = Pattern.compile(
        "^(?=.*([A-Z]){1,})(?=.*[!@#\$&*]{1,})(?=.*[0-9]{1,})(?=.*[a-z]{1,}).{8,}\$"
    )
}

fun String?.isStrongPassword(): Boolean {
    this ?: return false
    return CustomPatterns.STRONG_PASSWORD.matcher(this).matches()
}

fun String?.isLengthMoreThan(value: Int): Boolean {
    this ?: return false
    return this.length > value
}

fun String?.containsSpecialCharacters(): Boolean {
    this ?: return false
    return Pattern.compile(".*[^A-Za-z0-9].*").matcher(this).matches()
}

fun String?.containsUpperCaseCharacters(): Boolean {
    this ?: return false
    return Pattern.compile(".*[A-Z]+.*").matcher(this).matches()
}

fun String?.containsNumericCharacters(): Boolean {
    this ?: return false
    return Pattern.compile(".*[0-9]+.*").matcher(this).matches()
}

fun String?.isNotNullOrBlank(): Boolean {
    return !this.isNullOrBlank()
}

fun Float?.toEuros(): String = "%.2f €".format(this ?: 0.00f)

fun Double?.toEuros(): String = "%.2f €".format(this ?: 0.00)

infix fun Float?.add(value: Float?): Float = (this ?: 0.00f) + (value ?: 0.00f)
