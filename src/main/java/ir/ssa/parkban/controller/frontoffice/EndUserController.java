package ir.ssa.parkban.controller.frontoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Behrouz-ZD on 8/18/2016.
 */
@Controller
public class EndUserController {

    @RequestMapping(value = "/pub/test")
    public String start(){
        return "index";
    }
}
