package com.dranawhite.study.springboot.spring;

import com.dranawhite.api.model.DranaResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dranawhite
 * @version : GlobalController.java, v 0.1 2019-07-31 17:56 dranawhite Exp $$
 */
@RestController
@RequestMapping("/global")
@Slf4j
public class GlobalController {

    @GetMapping
    public DranaResponse<Boolean> getGlobalMessage(@ModelAttribute("global") String message) {
        log.info("Global Message: [{}]", message);
        return DranaResponse.success(Boolean.TRUE);
    }
}
