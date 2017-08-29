package org.weeurl.app.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import org.weeurl.app.domain.Url

/**
 * @author jeevan
 */
@Repository
interface UrlRepository : MongoRepository<Url, String> {

  fun findByShortened(shortened: String): Url

  fun findByUrl(url: String): Url
}