package org.weeurl.app.controller

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.weeurl.app.service.UrlService
import javax.servlet.http.HttpServletResponse


/**
 * @author jeevan
 */
@Controller
class WebController(val urlService: UrlService) {

  @GetMapping("/")
  fun index(): String {
    return "index"
  }

  @GetMapping("/{handle}")
  fun redirect(@PathVariable handle: String,
               response: HttpServletResponse): ResponseEntity<String> {
    val url = urlService.findByHandle(handle)
    url?.let {
      val headers = HttpHeaders()
      headers.add("Location", url.url)
      return ResponseEntity(headers, HttpStatus.MOVED_PERMANENTLY)
    }
    
    return ResponseEntity("No URL found.", HttpStatus.OK)
  }
}