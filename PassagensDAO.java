package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Passagens;

public class PassagensDAO {
	
	public void save(Passagens passagem) {
		/*
		 * Isso � uma sql comum, os ? s�o os par�metros que n�s vamos adicionar na base
		 * de dados
		 */

		String sql = "INSERT INTO Passagens(Destino, Preco, DataPartida, AgenciaCadastur, ClienteId)" + "VALUES(?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro par�metro da sql
			pstm.setString(1, passagem.getDestino());

			// Adicionar o valor do segundo par�metro da sql
			pstm.setDouble(2, passagem.getPreco());
			
			// Adicionar o valor do terceiro par�metro da sql
			pstm.setString(3, passagem.getDataPartida());
			
			// Adicionar o valor do quarto par�metro da sql
			pstm.setInt(4, passagem.getAgenciaCadastur());
			
			// Adicionar o valor do quinto par�metro da sql
			pstm.setInt(5, passagem.getClienteId());


			// Executar a sql para inser��o dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fecha as conex�es
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
		String sql = "DELETE FROM Passagens WHERE ClienteId = ?";

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

	public void update( Passagens passagem) {
		String sql = "UPDATE Passagens SET Destino = ?, Preco = ?, DataPartida = ?, AgenciaCadastur = ? WHERE ClienteId = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conex�o com o banco
			conn = ConnectionFactory.createConnectionSQLServer();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// Adiciona o valor do primeiro par�metro da sql
			pstm.setString(1, passagem.getDestino());

			// Adiciona o valor do segundoo par�metro da sql
			pstm.setDouble(2, passagem.getPreco());
			
			// Adicionar o valor do terceiro par�metro da sql
			pstm.setString(3, passagem.getDataPartida());
			
			// Adicionar o valor do quarto par�metro da sql
			pstm.setInt(4, passagem.getAgenciaCadastur());
			
			// Adicionar o valor do quinto par�metro da sql
			pstm.setInt(5, passagem.getClienteId());

			// Executa a sql para inser��o dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conex�es
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

	public List<Passagens> getPassagens() {

		String sql = "SELECT * FROM Passagens";

		List<Passagens> passagens = new ArrayList<Passagens>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, fa�a
			while (rset.next()) {
			Passagens passagem = new Passagens();

				// Recupera o id do banco e atribui ele ao objeto
				passagem.setDestino(rset.getString("Destino"));

				// Recupera o nome do banco e atribui ele ao objeto
				passagem.setPreco(rset.getDouble("Preco"));

				// Recupera o telefone do banco e atribui ele ao objeto
				passagem.setDataPartida(rset.getString("DataPartida"));

				// Recupera o emal do banco e atribui ela ao objeto
				passagem.setAgenciaCadastur(rset.getInt("AgenciaCadastur"));
				
				// Recupera o endere�o do banco e atribui ela ao objeto
				passagem.setClienteId(rset.getInt("ClienteId"));


				// Adiciona o contato recuperado, a lista de contatos
				passagens.add(passagem);
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
		return passagens;
	}
}
