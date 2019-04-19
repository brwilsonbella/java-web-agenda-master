package com.agenda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agenda.model.Pessoa;
import com.agenda.service.CadastroUsuarioService;

public class CadastraUsuarioServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getParameter("name");

		Pessoa pessoa = new Pessoa();

		pessoa.setNome(request.getParameter("name"));

		pessoa.setEmail(request.getParameter("email"));

		pessoa.setEnd(request.getParameter("end"));

		pessoa.setTel(request.getParameter("tel"));

		CadastroUsuarioService service = new CadastroUsuarioService();

		service.cadastrar(pessoa);

	}
}
