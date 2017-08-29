package org.weeurl.app.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

/**
 * @author jeevan
 */
@Document(collection = "urls")
data class Url(
    @Id var id: String,
    @Indexed var url: String,
    @Indexed var shortened: String,
    val createdDate: Date
)