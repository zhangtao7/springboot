package com.ericsson.springboot.validate;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidateController {

	@RequestMapping("/demo")
    public String demo(Model model){
       model.addAttribute("demo",new ValidateBean());
       return "demo";

    }

   

   

    @RequestMapping("/demoAdd")
    public String demoAdd(@ModelAttribute("demo") @Valid ValidateBean demo,BindingResult result,Model model){
       //有错误信息.
       model.addAttribute("demo",demo);
       if(result.hasErrors()){
           List<ObjectError>  list = result.getAllErrors();
           for(ObjectError  error:list){
        	   System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
           }
           return "demo";
       }
       return "demo";

    }
}
