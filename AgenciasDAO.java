package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Agencias;


public class AgenciasDAO {
	
	public void save(Agencias agencia) {
		/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		 * de dados
		 */

		String sql = "INSERT INTO Agencias(Cadastur, Nome, Telefone, Endereco, GuiaTuristico)" + "VALUES(?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parámetro da sql
			pstm.setInt(1, agencia.getCadastur());

			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, agencia.getNome());

			// Adicionar o valor do terceiro parâmetro da sql
			pstm.setString(3, agencia.getTelefone());
			
			// Adicionar o valor do quarto parâmetro da sql
			pstm.setString(4, agencia.getEndereco());
			
			// Adicionar o valor do quinto parâmetro da sql
			pstm.setString(5, agencia.getGuiaTuristico());


			// Executar a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {
		String sql = "DELETE FROM Agencias WHERE Id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update( Agencias agencia) {
		String sql = "UPDATE Agencias SET Cadastur=?, Nome = ?, Telefone = ?, Email = ?, Endereco = ? WHERE Id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(1, agencia.getCadastur());

			// Adiciona o valor do segundoo parâmetro da sql
			pstm.setString(2, agencia.getNome());
			
			// Adicionar o valor do terceiro parâmetro da sql
			pstm.setString(3, agencia.getTelefone());
			
			// Adicionar o valor do quarto parâmetro da sql
			pstm.setString(4, agencia.getEndereco());
			
			// Adicionar o valor do quinto parâmetro da sql
			pstm.setString(5, agencia.getGuiaTuristico());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Agencias> getAgencias() {

		String sql = "SELECT * FROM Agencias";

		List<Agencias> agencias = new ArrayList<Agencias>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {
				Agencias agencia = new Agencias();

				// Recupera o id do banco e atribui ele ao objeto
				agencia.setCadastur(rset.getInt("Cadastur"));

				// Recupera o nome do banco e atribui ele ao objeto
				agencia.setNome(rset.getString("Nome"));

				// Recupera o telefone do banco e atribui ele ao objeto
				agencia.setTelefone(rset.getString("Telefone"));

				// Recupera o emal do banco e atribui ela ao objeto
				agencia.setEndereco(rset.getString("Endereco"));

				
				// Recupera o endereço do banco e atribui ela ao objeto
				agencia.setEndereco(rset.getString("GuiaTuristico"));


				// Adiciona o contato recuperado, a lista de contatos
				agencias.add(agencia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return agencias;
	}
}
