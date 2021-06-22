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
		// �������е����󣬽��ȫվ��������
		// �ƶ�request��response�ı���
		request.setCharacterEncoding("utf-8"); // ��ֻ����Ϣ����Ч��Ҳ����ֻ��post��ʽ�����������Ч��post��ʽ����������������Ϣ����
		response.setContentType("text/html;charset=utf-8");

		// �ڷ��е�ʱ��Ӧ����Ŀ����Դһ��request������Ŀ����Դ����getParameterʱ���õ�����д��getParameter
		// �����ȡ����request���а�װ
		CharacterRequest characterRequest = new CharacterRequest(request);

		// ������е�ʱ��Я���ľ������ǰ�װ���request �� characterRequest
		chain.doFilter(characterRequest, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	// ����ڲ�������þ��ǶԻ�ȡ����request����ԭ��request���󣩵Ľ��а�װ
	class CharacterRequest extends HttpServletRequestWrapper {

		public CharacterRequest(HttpServletRequest request) {
			super(request);

		}

		// ����̳и���һ���ḲдһЩ�������˴�������дgetParameter()����
		public String getParameter(String name) {
			// ���ñ���װ�����getParameter()����������������
			String value = super.getParameter(name);
			if (value == null) {
				return null;
			}

			// �ж�����ʽ
			String method = super.getMethod();
			if ("get".equalsIgnoreCase(method)) {
				try {
					// iso-8859-1 ���ݾ������ȷ���Ƿ��������ֱ���
					value = new String(value.getBytes("iso-8859-1"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
			}
			// �������󣬷��ؽ��
			return value;
		}

	}

}
