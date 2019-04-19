package com.agenda.service;

import java.util.List;

import com.agenda.dao.PessoaDAO;
import com.agenda.model.Pessoa;

public class CadastroUsuarioService {

	public void cadastrar(Pessoa pessoa) {

		PessoaDAO service = new PessoaDAO();

		service.adiciona(pessoa);
		
		System.out.println(buscaPessoas());

	}

	public List<Pessoa> buscaPessoas() {

		PessoaDAO dao = new PessoaDAO();

		return dao.buscarPessoas();

	}

}
