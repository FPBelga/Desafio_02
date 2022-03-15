
import models.Cliente;
import models.Produto;
import models.Venda;
import models.Vendedor;

public class App {

    public static void main(String[] args) {

        Vendedor vendedor1 = new Vendedor();

        vendedor1.setnome("FELIPE BELGA DIAS");
        vendedor1.setCpf("075.129.517.99");
        vendedor1.setTelefone("(21)99567-0844");
        vendedor1.setEmail("belgasystem@gmail.com");
        vendedor1.setcomissao(3.0);

        Cliente cliente1 = new Cliente();

        cliente1.setnome("ANGELA MARIA ALVES BELGA DIAS");
        cliente1.setCpf("048.355.77-42");
        cliente1.setTelefone("(21)99381-1247");
        cliente1.setEmail("angelabelga@gmail.com");

        Produto produto1 = new Produto();
        produto1.setnome("NOTEBOOK PROBOOK II 17 POLEGADAS");
        produto1.setquantidade(2);
        produto1.setvalorUnitario(2590.00);
        produto1.setacrescimo(100.00);
        produto1.setdesconto(150.00);

        Produto produto2 = new Produto();
        produto2.setnome("CALDEIRA GAMER XFORCE VERMELHA");
        produto2.setquantidade(2);
        produto2.setvalorUnitario(890.00);
        produto2.setacrescimo(150.00);
        produto2.setdesconto(45.00);

        Produto produto3 = new Produto();
        produto3.setnome("TECLADO DELL COM LUZ");
        produto3.setquantidade(1);
        produto3.setvalorUnitario(100.00);
        produto3.setacrescimo(50.00);
        produto3.setdesconto(20.00);

        Venda venda1 = new Venda(cliente1, vendedor1);
        venda1.AddItem(produto2);
        venda1.AddItem(produto3);
        venda1.AddItem(produto1);

        venda1.applyDescount(20.0);

        venda1.ImprimeCupom();
    }

}
