package org.weeurl.app.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.util.Assert
import org.weeurl.app.domain.Url
import org.weeurl.app.repository.UrlRepository
import org.weeurl.app.util.SecurityUtil
import java.util.*

/**
 * @author jeevan
 */
@Service
class UrlServiceImpl(val urlRepository: UrlRepository) : UrlService {

  @Value("\${server.base.url}")
  private lateinit var baseUrl: String

  override fun shorten(url: String): String {
    Assert.notNull(url, "URL can not be empty.")

    var existingUrl = urlRepository.findByUrl(url)
    existingUrl?.let {
      return baseUrl + existingUrl.handle
    }

    val handle = SecurityUtil.randomString()
    val shortened = baseUrl + handle
    val urlDetails = Url(UUID.randomUUID().toString(), url, handle, Date())
    urlRepository.save(urlDetails)
    return shortened
  }

  override fun findByHandle(handle: String): Url {
    Assert.notNull(handle, "This is not a proper shortened url.")
    return urlRepository.findByHandle(handle)
  }
}