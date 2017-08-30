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
   * Find Url by shortened string
   */
  fun findByShortened(shortened: String): Url

  /**
   * Find by handle
   */
  fun findByHandle(handle: String): Url
}