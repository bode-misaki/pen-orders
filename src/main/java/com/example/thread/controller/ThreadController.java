package com.example.thread.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.thread.entity.ThreadEntity;
import com.example.thread.form.ThreadForm;
import com.example.thread.form.ThreadForm2;
import com.example.thread.service.ThreadService;


@Controller
public class ThreadController {
	@Autowired
	ThreadService service;
	
	@RequestMapping("/top")
	public ModelAndView top(@ModelAttribute("form") @Validated ThreadForm2 form, BindingResult result,
			@RequestParam(value="page",defaultValue="0")int pageNum){
		//ページ情報取得
		
		Page<ThreadEntity> ThreadEntityList = service.getPage(pageNum, form.getSearchName(), form.getSearchMessage());
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("entityList", ThreadEntityList);
		modelAndView.setViewName("threadview.html");
		
		
		return modelAndView;
	
	}
	
	@RequestMapping("/regist")
	public String regist() {
		return "registview.html";
	}
	
	@RequestMapping("/regist_button")
	public ModelAndView top(@ModelAttribute("form") @Validated  ThreadForm form, BindingResult result){
	//バリデーションエラーがあった場合の処理
		if(result.hasErrors()) {
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("registview.html");
				return modelAndView;
		}else {
			//バリデーションエラーがなかった場合の処理	
		service.insertDB(form.getName(),form.getMessage());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/top");
		
		return modelAndView;
							}
	}
	//２にちめ
	@RequestMapping("/edit")
	public ModelAndView edit(@ModelAttribute("form") @Validated  ThreadForm form, BindingResult result){
		//バリデーションエラーがあった場合の処理
		System.out.println(result.hasErrors());
				if(result.hasErrors()) {
					ThreadEntity threadEntity = service.getRecode(form.getId());
					ModelAndView modelAndView = new ModelAndView();
					modelAndView.addObject("entity", threadEntity);
						
						modelAndView.setViewName("editview.html");
						return modelAndView;
				}else {
					//バリデーションエラーがなかった場合の処理	
		service.insertDB(form.getId(),form.getName(),form.getMessage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/top");
		
		return modelAndView;
							}
	}
	
	@RequestMapping("/edit_button")
	public ModelAndView editt_button(@RequestParam("id") Integer id){
		
		ThreadEntity threadEntity = service.getRecode(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("entity", threadEntity);
		modelAndView.setViewName("editview.html");
		return modelAndView;
		
	}
	
	@RequestMapping("/delete_button")
	public ModelAndView delete_button(@RequestParam("id") Integer id){
		ThreadEntity threadEntity = service.getRecode(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("entity", threadEntity);
		modelAndView.setViewName("deleteview.html");
		return modelAndView;
	}
	
	@RequestMapping("/no_button")
	public ModelAndView no_button() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/top");
		return modelAndView;

	}
	
	@RequestMapping("/yes_button")
	public ModelAndView yes_button(@RequestParam("id") Integer id) {
		service.deleteRecode(id);
	ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/top");
		return modelAndView;
		
	}
	
	@RequestMapping("/reply_button")
	public ModelAndView reply_button(@RequestParam("id") Integer id){
//	ThreadEntity threadEntity = service.getRecode(id);
	ThreadEntity replyEntity = service.getRecode(id);
	ModelAndView modelAndView = new ModelAndView();
	System.out.println(replyEntity);
	modelAndView.addObject("replyEntity",replyEntity);
//	modelAndView.addObject("entity", threadEntity + "replyentity",replyEntitylist);
	modelAndView.setViewName("replyview.html");
	return modelAndView;
	}
}
