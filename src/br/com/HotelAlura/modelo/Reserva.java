package br.com.HotelAlura.modelo;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private Integer Id;
    private String DataEntrada;
    private String DataSaida;
    private String FormaPagamento;
    private double Valor;
    
    
    private List<Cliente> clientes = new ArrayList<>();

    public Reserva(Integer id, String dataEntrada, String dataSaida, String formaPagamento, double valor) {
        this.Id = id;
        this.DataEntrada=dataEntrada;
        this.DataSaida=dataSaida;
        this.FormaPagamento=formaPagamento;
        this.Valor=valor;
    }

    public Reserva(Integer id, String nomeCategoria) {
        this.Id = id;
    }

    public Integer getId(int id) {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }
}
