package br.com.crud.model;

public class Passagens {

	private int Id;
	private String Destino;
	private Double Preco;
	private String DataPartida;
	private int AgenciaCadastur;
	private Agencias Agencia;
	private int ClienteId;
	private Clientes Cliente;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDestino() {
		return Destino;
	}
	public void setDestino(String destino) {
		Destino = destino;
	}
	public Double getPreco() {
		return Preco;
	}
	public void setPreco(Double preco) {
		Preco = preco;
	}
	public String getDataPartida() {
		return DataPartida;
	}
	public void setDataPartida(String dataPartida) {
		DataPartida = dataPartida;
	}
	public int getAgenciaCadastur() {
		return AgenciaCadastur;
	}
	public void setAgenciaCadastur(int agenciaCadastur) {
		AgenciaCadastur = agenciaCadastur;
	}
	public Agencias getAgencia() {
		return Agencia;
	}
	public void setAgencia(Agencias agencia) {
		Agencia = agencia;
	}
	public int getClienteId() {
		return ClienteId;
	}
	public void setClienteId(int clienteId) {
		ClienteId = clienteId;
	}
	public Clientes getCliente() {
		return Cliente;
	}
	public void setCliente(Clientes cliente) {
		Cliente = cliente;
	}
}
	