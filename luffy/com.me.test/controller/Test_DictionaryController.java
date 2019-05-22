package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wistron.pojo.Dictionary;

@Controller
public class Test_DictionaryController {
	//指定url到请求方法的映射
	//例如:localhost:8080/dspringMVC01/list.action
	@RequestMapping("/list")
	public ModelAndView list() {
		List<Dictionary> dicList = new ArrayList<Dictionary>();
		Dictionary dic1 = new Dictionary(1,"dictionary1","a01");
		Dictionary dic2 = new Dictionary(2,"dictionary2","a01");
		dicList.add(dic1);
		dicList.add(dic2);
		
		//模型和视图
		//model模型：模型对象中存放了返回给页面的数据
		//view视图：视图对象中指定了返回的页面的位置
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dicList",dicList);
		modelAndView.setViewName("/WEB-INF/views/dictionary.jsp");
		return modelAndView;
		
		
	} 
}
