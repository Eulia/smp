package com.yxr.tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class CharacterFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 拦截所有的请求，解决全站中文乱码
		// 制定request和response的编码
		request.setCharacterEncoding("utf-8"); // 这只对消息体有效，也就是只对post方式的请求参数有效，post方式的请求参数存放在消息体中
		response.setContentType("text/html;charset=utf-8");

		// 在放行的时候应给给目标资源一个request对象，让目标资源调用getParameter时调用到我们写的getParameter
		// 对这获取到的request进行包装
		CharacterRequest characterRequest = new CharacterRequest(request);

		// 这里放行的时候，携带的就是我们包装后的request → characterRequest
		chain.doFilter(characterRequest, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	// 这个内部类的作用就是对获取到的request对象（原生request对象）的进行包装
	class CharacterRequest extends HttpServletRequestWrapper {

		public CharacterRequest(HttpServletRequest request) {
			super(request);

		}

		// 子类继承父类一定会覆写一些方法，此处用于重写getParameter()方法
		public String getParameter(String name) {
			// 调用被包装对象的getParameter()方法，获得请求参数
			String value = super.getParameter(name);
			if (value == null) {
				return null;
			}

			// 判断请求方式
			String method = super.getMethod();
			if ("get".equalsIgnoreCase(method)) {
				try {
					// iso-8859-1 根据具体情况确定是否是是这种编码
					value = new String(value.getBytes("iso-8859-1"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			}
			// 解决乱码后，返回结果
			return value;
		}

	}

}
