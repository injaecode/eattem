package com.mysite.eattem.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping(value = "/admin/upload")
    public String itemForm(){
        return "admin_upload_form";
    }
}
