package org.weeurl.app.util

import java.util.concurrent.ThreadLocalRandom

/**
 * @author jeevan
 */
object SecurityUtil {
  fun randomString(): String {
    return RandomString(8, ThreadLocalRandom.current()).nextString()
  }
}