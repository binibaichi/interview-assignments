package com.hy.shortmessage.controller;

import com.hy.shortmessage.domain.Shortmessage;
import com.hy.shortmessage.service.IShortmessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
@RequestMapping("/common")
public class ShortMessageContorller {


	@Autowired
	private IShortmessageService shortmessageService;

	@Value("ssq.redirect.url")
	private  String ssqRedirectUrl;

	/**
	 * 
	 * @Title : ShortMessageContorller @Description: 短连接 @param sk @return
	 *        : @author : hanyang Create Date : 2018年10月11日 上午10:36:01 @throws
	 */
	@RequestMapping(value = "/sm/{sk}")
	public String lookupAndRedirect(@PathVariable String sk) {
		final Shortmessage message = shortmessageService.selectShortmessageByShortKey(sk);
		if (message == null) {
			return "redirect:https://www.ctgpayroll.com";
		}
		final String originalUrl = message.getOriginalUrl();
		if (StringUtils.isBlank(originalUrl)) {
			// 如果没有找到长链接，跳转到我们的 m 站，这里其实定制一个 404 页面比较好
			return "redirect:https://www.ctgpayroll.com";
		}
		
		if(3==message.getBiz()){//上上签员工三要素认证连接
			return "redirect:" +originalUrl;
		} else if(4==message.getBiz()){//入职登记短信修改员工信息
			return "redirect:" +originalUrl;
		}
		return "redirect:" + ssqRedirectUrl + "?url=" + originalUrl;
	}

	/**
	 * 通过短链接找到原始链接
	 * @param shortmessage
	 * @return
	 */
	@RequestMapping("/getShortmessageByShortKey.jhtml")
	@ResponseBody
	public Shortmessage getShortmessageByShortKey(@RequestBody Shortmessage shortmessage) {
		return shortmessageService.selectShortmessageByShortKey(shortmessage.getShortKey());
	}

	/**
	 * 通过原始连接找到短链接
	 * @param shortmessage
	 * @return
	 */
	@RequestMapping("/getShortmessageByOriginalUrl.jhtml")
	@ResponseBody
	public Shortmessage getShortmessageByOriginalUrl(@RequestBody Shortmessage shortmessage) {
		return shortmessageService.selectShortmessageByOriginalUrl(shortmessage.getOriginalUrl());
	}

}
