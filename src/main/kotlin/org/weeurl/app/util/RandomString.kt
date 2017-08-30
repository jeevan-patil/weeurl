package org.weeurl.app.util

import java.util.*


/**
 * @author jeevan
 */
class RandomString {
  fun nextString(): String {
    for (idx in buf.indices)
      buf[idx] = symbols[random.nextInt(symbols.size)]
    return String(buf)
  }

  private val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

  private val lower = upper.toLowerCase(Locale.ROOT)

  private val digits = "0123456789"

  private val alphanumeric = upper + lower + digits

  private lateinit var random: Random

  private lateinit var symbols: CharArray

  private lateinit var buf: CharArray

  constructor(length: Int, random: Random) {
    if (length < 1) throw IllegalArgumentException()
    this.random = Objects.requireNonNull(random)
    this.symbols = alphanumeric.toCharArray()
    this.buf = CharArray(length)
  }

}