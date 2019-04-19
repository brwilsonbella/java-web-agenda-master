package com.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agenda.model.Pessoa;
import com.agenda.util.ConnectionFactory;
import com.mysql.jdbc.Connection;

public class PessoaDAO {

	private Connection connection;

	public void adiciona(Pessoa pessoa) {

		String SQL = "insert into pessoas (nome, email, endereco, telefone) values (?,?,?,?)";

		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getEnd());
			stmt.setString(4, pessoa.getTel());

			stmt.execute();
			stmt.close();
			buscarPessoas();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Pessoa> buscarPessoas() {

		String SQL = "select * from pessoas";

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Pessoa pessoa = new Pessoa();
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setEnd(rs.getString("endereco"));
				pessoa.setTel(rs.getString("telefone"));
				pessoas.add(pessoa);

			}

			stmt.close();
			this.connection.close();
			System.out.println(pessoas);

			return pessoas;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return pessoas;
	}
}
