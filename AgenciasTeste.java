package br.com.crud.teste;

import br.com.crud.dao.AgenciasDAO;
import br.com.crud.model.Agencias;

public class AgenciasTeste {
	public static void main(String[] args) {
		AgenciasDAO agenciasDAO = new AgenciasDAO();
	
		// ------------ Cria um contato e salva no banco
		Agencias agencia = new Agencias();
		agencia.setNome("Izadora");
		agencia.setTelefone("(21)98175-8079");
		agencia.setEndereco("rua x");
		agencia.setGuiaTuristico("Pedro");
		
		agenciasDAO.save(agencia);
		
		// ------------ Atualiza o contato com id = 1 com os dados do objeto contato1
		/*Clientes cliente1 = new Clientes();
		cliente1.setId(6);
		cliente1.setNome("Carla");
		cliente1.setTelefone("(21)98175-8079");
		cliente1.setEmail("123@gmail.com");
		cliente1.setEndereco("rua x");
		
		clientesDAO.update(cliente1);*/
		
		// ------------ Remove o contato com id
		// clientesDAO.removeById(6);
		
		// ------------ Lista todos os contatos do banco de dados
		/*for (Clientes a : clientesDAO.getClientes()) {
			System.out.println("Nome: " + a.getNome());*/
		}
	}





