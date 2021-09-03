package spring.partie6.mvc.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplicationErrorController implements ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationErrorController.class);

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {


        Object requestStatus = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String statusCode="";
        if (requestStatus != null) {
             statusCode = requestStatus.toString();
        }

        logger.error("une erreur  s est produite "+statusCode);
        model.addAttribute("status",statusCode);

        return "error";
    }

}
