package com.mycompany.sistemapdv;
import java.util.ArrayList;

public class Venda {
    private int cod;
    private Cliente cliente;
    private Vendedor vendedor;
    private float total;
    private String data;
    
    ArrayList<ItemVenda> itensDoPedido = new ArrayList<>();
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public void addItemPedido(ItemVenda item){
        this.itensDoPedido.add(item);
    }
    
    public Venda(){
        
    }

    public Venda(int cod, Cliente cliente, Vendedor vendedor, String data) {
        this.cod = cod;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.data = data;
    }
    
    public float ValorTotal(){
        double total = this.itensDoPedido.stream()
                                        .mapToDouble(ItemVenda::getSubtotal)
                                        .sum(); 
        return (float) total;
    }
}
