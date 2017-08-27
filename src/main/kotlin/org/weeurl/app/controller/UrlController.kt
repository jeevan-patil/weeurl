package org.weeurl.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.weeurl.app.util.Endpoints
import javax.websocket.server.PathParam

/**
 * @author jeevan
 */

@RestController
@RequestMapping(Endpoints.URL_API)
class UrlController {

  @GetMapping("/shorten")
  fun shorten(@PathParam(value = "url") url: String): String {
    return "Shortened - " + url
  }
}