package org.tukorea.interweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MeasureInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("Starttime", System.currentTimeMillis());
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		Long startTime = (Long)request.getAttribute("Starttime");
		Long stopTime = System.currentTimeMillis();
		System.out.println(request.getRequestURL() + " 실행 시간 : " + (stopTime-startTime));
	}
}