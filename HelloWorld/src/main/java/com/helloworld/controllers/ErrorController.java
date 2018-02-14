package com.helloworld.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {
	
    @RequestMapping(path = "/error", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> handle(HttpServletRequest request) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
        map.put("reason", request.getAttribute("javax.servlet.error.message"));

        return map;
    }

//  private final ErrorAttributes errorAttributes;
//
//  private boolean getTraceParameter(HttpServletRequest request) {
//    String parameter = request.getParameter("trace");
//    if (parameter == null) {
//        return false;
//    }
//    return !"false".equals(parameter.toLowerCase());
//  }
//
//  private Map<String, Object> getErrorAttributes(HttpServletRequest aRequest, boolean includeStackTrace) {
//    RequestAttributes requestAttributes = new ServletRequestAttributes(aRequest);
//    return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
//  }
//  
//  @Autowired
//  public CustomErrorController(ErrorAttributes errorAttributes) {
//    Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
//    this.errorAttributes = errorAttributes;
//  }
//
//  @Override
//  public String getErrorPath() {
//    return "/error";
//  }
//
//  @RequestMapping
//  public Map<String, Object> error(HttpServletRequest aRequest){
//     Map<String, Object> body = getErrorAttributes(aRequest,getTraceParameter(aRequest));
//     String trace = (String) body.get("trace");
//     if(trace != null){
//       String[] lines = trace.split("\n\t");
//       body.put("trace", lines);
//     }
//     return body;
//  }
}