package br.ufac.si.academico.filtros;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class loginFiltro implements Filter {
	
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession httpsession = httpRequest.getSession(false);
		
		String loginURI = httpRequest.getContextPath() + "/login.xhtml";
		
		boolean estaLogado = (httpsession != null && httpsession.getAttribute("usuarioLogado") != null);
		boolean acessandoLogin = httpRequest.getRequestURI().equals(loginURI);
		if(estaLogado || acessandoLogin) {
			chain.doFilter(request, response);
		}else {
			httpResponse.sendRedirect(loginURI);
		}

	}

	public void init(FilterConfig fcon) throws ServletException{
		
	}
}
