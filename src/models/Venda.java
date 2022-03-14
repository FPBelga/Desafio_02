package models;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import util.DataConverte;

public class Venda {

    protected Cliente cliente;
    protected Vendedor vendedor;
    protected Date dataVenda;
    protected Double totalVenda = 0.0;
    protected Double totalVendaDiscount = 0.0;
    protected Double DESCONTO_MAX_VALOR = 10.0;
    protected Double valorDesconto = 0.0;
    protected Double vendaDesconto = 0.0;
    protected Integer item = 0;

    protected ArrayList<itemVenda> produtos;

    public Venda(Cliente cliente, Vendedor vendedor) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.dataVenda = new Date();

        this.produtos = new ArrayList<itemVenda>();

    }

    public void includeItem(Produto produto) {

        try {

            itemVenda itemVenda = new itemVenda(produto);

            this.produtos.add(itemVenda);

            this.totalVenda += produto.getTotalAmount();

        } catch (Exception e) {
            System.out.println("Error - " + e);
        }

    }

    public void printCoupon() {

        try {

            String formato1 = "%-34s%s%n";
            String formato2 = "%-27s%s%n";
            DecimalFormat df = new DecimalFormat("#.00");
            // df.setRoundingMode(RoundingMode.UP);

            System.out.println("\n-----------------------------------------------");
            System.out.printf(formato2, "Cupom Emitido ", DataConverte.convertDateHour(new Date()) + "\n");
            System.out.println("clientee: " + cliente.getnome());
            System.out.println("CPF: " + cliente.getCpf() + "\n");
            System.out.println("Vendedor: " + vendedor.getnome());
            System.out.println("Comissão: " + vendedor.getcomissao() + "%\n");

            for (itemVenda itemVenda : this.produtos) {
                item += 1;
                System.out.println("Item " + item + " - " + itemVenda.produto.getnome() +
                        " R$" + itemVenda.produto.getvalorUnitario().toString());
                System.out.printf(formato2,
                        "\tQtd(" + itemVenda.produto.getquantidade() + ")",
                        "R$" + itemVenda.produto.getvalorTotal());
                System.out.println();

            }

            if (this.valorDesconto > 0.0 & this.valorDesconto < DESCONTO_MAX_VALOR) {
                System.out.printf(formato1, "Total da Venda:", "R$" + this.totalVenda);
                System.out.printf(formato1, "\nDesconto:", " " + this.valorDesconto + "%");
                System.out.printf(formato1, "Total de Desconto:", "R$" + df.format(this.vendaDesconto));
                System.out.printf(formato1, "Total da Venda com desconto:", "R$" + df.format(this.totalVendaDiscount));

            } else {
                System.out.printf(formato1, "\nTotal da Venda :", "R$" + df.format(this.totalVendaDiscount));
            }
            System.out.println("-----------------------------------------------");

        } catch (Exception e) {
            System.out.println("Erro - " + e);
        }

    }

    public void applyDescount(Double valorDesconto) {

        try {

            this.valorDesconto = valorDesconto;
            this.totalVendaDiscount = this.totalVenda;

            if (valorDesconto < DESCONTO_MAX_VALOR) {

                this.vendaDesconto = this.totalVenda * (valorDesconto / 100);

                this.totalVendaDiscount -= this.vendaDesconto;
            } else {

                System.out.print("\nAtenção:");
                System.out.println("\nDesconto excedeu o valor de " + this.valorDesconto + "%\n");
            }

        } catch (Exception e) {
            System.out.println("Erro - " + e);
        }

    }
}
