package models;

public class Produto {

    private String nome;
    private Integer quantidade;
    private Double valorUnitario;
    private Double desconto;
    private Double acrescimo;
    private Double valorTotal;

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public Integer getquantidade() {
        return quantidade;
    }

    public void setquantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getvalorUnitario() {
        return valorUnitario;
    }

    public void setvalorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getdesconto() {
        return desconto;
    }

    public void setdesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getacrescimo() {
        return acrescimo;
    }

    public void setacrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public Double getvalorTotal() {
        return valorTotal;
    }

    public void setvalorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getTotalAmount() {

        try {
            this.valorTotal = (valorUnitario * quantidade) + acrescimo - desconto;

        } catch (Exception e) {
            System.out.println("Error description " + e.getMessage());
        }

        return valorTotal;
    }

}
