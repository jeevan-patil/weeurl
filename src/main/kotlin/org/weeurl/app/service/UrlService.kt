package org.weeurl.app.service

/**
 * @author jeevan
 */
interface UrlService {

  /**
   * Shorten the URL.
   */
  fun shorten(url: String): String
  
}