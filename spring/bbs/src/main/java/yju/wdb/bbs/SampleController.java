package yju.wdb.bbs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import yju.wdb.domain.SampleDTOList;
import yju.wdb.domain.TodoDTO;
import yju.wdb.domain.sampleDTO;

//import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping("/sample/*")
public class SampleController {

//	Logger log = Logger.getLogger(SampleController.class);
	@RequestMapping("")
	public void basic() {
		System.out.println("Basic.........................");
	}
		@RequestMapping(value="basic", method= {RequestMethod.GET, RequestMethod.POST})
		public void basicGet() {
			System.out.println("basicGet........");	
	}
	/*
	@RequestMapping(value="basic", method=RequestMethod.POST)
		public String basicGet2() {
			System.out.println("basicGet2........");
			return "sample/basic2";
	}
	*/	
	@RequestMapping(value="test")
	public String test() {
		return "sample/mytest";
	}
	
	@RequestMapping("dto")
	public void dto(sampleDTO dto) {
		System.out.println(dto);
	}
	
	@RequestMapping("param")
	public void param(@RequestParam("name") String myName, int age) {
		System.out.println("name: " + myName + ", age: " + age);
	}
	
	@RequestMapping("list")
	public String list(@RequestParam("ids") ArrayList<String> ids) {
		System.out.println(ids);
		
		return "sample/exList";
	}
	
	@RequestMapping("array")
	public String myArray(@RequestParam("ids") String[] ids) {
		System.out.println(Arrays.deepToString(ids));
		
		return "sample/myArray";
	}
	
	@RequestMapping("objList")
	public String objList(SampleDTOList list) {
		System.out.println(list);
		return "sample/object";	
	}
	
	@RequestMapping("binder")
	public void myBinder(TodoDTO todo) {
		System.out.println(todo);
	}
	/*
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	*/
	
	@RequestMapping("model")
	public String testModelAttr(sampleDTO dto, @ModelAttribute("page") int page, Model model) {
		System.out.println("dto");
		System.out.println("page:"+page);
		model.addAttribute("myValue", "Hi~ My name is Seungwoo");
		
		return "sample/modelAttr";
	}
	
	@RequestMapping("redirect")
	public String testRedirect(RedirectAttributes rttr) {
		rttr.addAttribute("name", "GeForce GTX1070");
		rttr.addAttribute("age", "24");
		rttr.addAttribute("page", "100");
		return "redirect: /sample/model";
	}
	
	@GetMapping("json")
	public @ResponseBody sampleDTO testJson() {
		sampleDTO dto = new sampleDTO();
		dto.setName("Yoo Seungwoo");
		dto.setAge(24);
		
		return dto;
	}
	
	@GetMapping("resEntity")
	public ResponseEntity<String> testEntity() {
		
		String msg = "{'name':'À¯½Â¿ì','age':24,'gender':'³²'}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
}
