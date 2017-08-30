package org.weeurl.app.service

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

  val site = "http://localhost:8080/redirect/" //"https:/wee.url/"

  override fun shorten(url: String): String {
    Assert.notNull(url, "URL can not be empty.")

    var existingUrl = urlRepository.findByUrl(url)
    existingUrl?.let {
      return existingUrl.shortened
    }

    val handle = SecurityUtil.randomString()
    val shortened = site + handle
    val urlDetails = Url(UUID.randomUUID().toString(), url, handle, shortened, Date())
    urlRepository.save(urlDetails)
    return shortened
  }

  override fun findByShortened(shortened: String): Url {
    Assert.notNull(shortened, "This is not a proper shortened url.")
    return urlRepository.findByShortened(shortened)
  }

  override fun findByHandle(handle: String): Url {
    Assert.notNull(handle, "This is not a proper shortened url.")
    return urlRepository.findByHandle(handle)
  }
}