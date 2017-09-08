package org.weeurl.app.service

import org.weeurl.app.domain.Url

/**
 * @author jeevan
 */
interface UrlService {

  /**
   * Shorten the URL.
   */
  fun shorten(url: String): String
  
  /**
   * Find by handle
   */
  fun findByHandle(handle: String): Url
}