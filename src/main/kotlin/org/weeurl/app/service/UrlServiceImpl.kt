package org.weeurl.app.service

import org.springframework.stereotype.Service
import org.springframework.util.Assert
import org.weeurl.app.domain.Url
import org.weeurl.app.repository.UrlRepository
import java.util.*

/**
 * @author jeevan
 */
@Service
class UrlServiceImpl(val urlRepository: UrlRepository) : UrlService {

  override fun shorten(url: String): String {
    Assert.notNull(url, "URL can not be empty.")

    var existingUrl = urlRepository.findByUrl(url)
    existingUrl?.let {
      return existingUrl.shortened
    }

    val shortened = Url(UUID.randomUUID().toString(), url, "shortened" + url, Date())
    urlRepository.save(shortened)
    return "Shortened - " + url
  }
}