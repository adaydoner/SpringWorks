package springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	// iki ayni request handler olursa ne olucagina bakiyoruz. Browser da cok net belirtiyior , birden fazla /showForm handler i oldugunu
	@RequestMapping("/showForm")
	public String displayForm (){
		return "silly";
	}
}
