import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.mycompany.sistemapdv.Cliente;
import com.mycompany.sistemapdv.ItemVenda;
import com.mycompany.sistemapdv.Produto;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.sistemapdv.Venda;
import com.mycompany.sistemapdv.Vendedor;

public class VendaTest {
    @Test
    public void testValorTotal(){
        Cliente cliente = new Cliente(1, "gabriel");
        Vendedor vendedor = new Vendedor(2, "roberto");
        Produto produto = new Produto("Arroz", 15.0f); // Preço de 15
        ItemVenda item = new ItemVenda(produto, 3); // Quantidade 3
        Venda venda = new Venda(1, cliente, vendedor, "22/08/2025");

        venda.addItemPedido(item);

        float valorEsperado = 45.0f;
        float valorCalculado = venda.ValorTotal();
        assertEquals(valorEsperado, valorCalculado);
    }

    @Test
    public void testValorTotalComMultiplosItens() {
        // Arrange (Organizar o cenário)
        Cliente cliente = new Cliente(1, "gabriel");
        Vendedor vendedor = new Vendedor(2, "roberto");
        Venda venda = new Venda(1, cliente, vendedor, "22/08/2025");

        Produto produtoArroz = new Produto("Arroz", 15.0f);
        Produto produtoFeijao = new Produto("Feijão", 12.50f);
        Produto produtoBife = new Produto("Bife", 40.0f);

        // Act (Executar a ação)
        venda.addItemPedido(new ItemVenda(produtoArroz, 2));   // Subtotal: 2 * 15.0f  = 30.0f
        venda.addItemPedido(new ItemVenda(produtoFeijao, 4));  // Subtotal: 4 * 12.5f  = 50.0f
        venda.addItemPedido(new ItemVenda(produtoBife, 1));    // Subtotal: 1 * 40.0f  = 40.0f

        // Assert (Fazer a verificação)
        float valorEsperado = 120.0f; // 30.0f + 50.0f + 40.0f
        float valorCalculado = venda.ValorTotal();
        assertEquals(valorEsperado, valorCalculado);
    }
}