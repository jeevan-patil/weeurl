package org.weeurl.app.util

import org.springframework.util.StringUtils
import java.net.MalformedURLException
import java.net.URL

/**
 * @author jeevan
 */
object UrlUtil {

  fun validateUrl(url: String) {
    if (StringUtils.isEmpty(url)) {
      throw Exception("Url can not be empty.")
    }

    try {
      val uri = URL(url)
    } catch (e: MalformedURLException) {
      throw Exception("Url provided is invalid.")
    }

  }
}