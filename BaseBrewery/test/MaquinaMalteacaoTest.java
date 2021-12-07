import com.bees.brewery.Maquina;
import com.bees.brewery.MaquinaMalteacao;
import com.bees.brewery.Processo;
import com.bees.brewery.ProcessoMalteacao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaquinaMalteacaoTest {

    private Maquina maquina;
    private Processo processo;

    @Before
    public void setup() {
        processo = new ProcessoMalteacao();
        maquina = new MaquinaMalteacao();
    }

    @Test
    public void checkIfExecuteMethodReturnsTrue() {
        Boolean success = maquina.executar(processo);

        Assert.assertTrue(success);
    }

    @Test
    public void checkMaquinaMalteacaoCapacidade() {
        float capacidade = maquina.getCapacidade();

        Assert.assertEquals(MaquinaMalteacao.CAPACIDADE, capacidade, 0.1);
    }

    @Test
    public void checkMaquinaMalteacaoProdutoFinal() {
        maquina.setQuantidade(500);
        float produtoFinal = maquina.getProdutoFinal();

        Assert.assertTrue(produtoFinal >= 475);
        Assert.assertTrue(produtoFinal <= 495);
    }

    @Test
    public void checkMaquinaMalteacaoVazao() {
        maquina.setQuantidade(500);
        float vazao = maquina.getVazao();

        Assert.assertEquals(MaquinaMalteacao.VAZAO, vazao, 0.1);
    }
}