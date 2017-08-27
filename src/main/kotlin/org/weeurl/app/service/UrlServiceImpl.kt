package org.weeurl.app.service

import org.springframework.util.Assert

/**
 * @author jeevan
 */
class UrlServiceImpl : UrlService {

  override fun shorten(url: String): String {
    Assert.notNull(url, "URL can not be empty.")
    return "Shortened - " + url
  }
}