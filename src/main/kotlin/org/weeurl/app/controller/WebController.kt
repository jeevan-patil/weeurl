package org.weeurl.app.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author jeevan
 */
@Controller
class WebController {

  @GetMapping("/")
  fun index(): String {
    return "index"
  }
}