package br.com.uniamerica.transportadora.transportadoraapi.service;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Despesa;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.StatusFrete;
import br.com.uniamerica.transportadora.transportadoraapi.repository.DespesaRepository;
import br.com.uniamerica.transportadora.transportadoraapi.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class FreteService {

    @Autowired
    private FreteRepository freteRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private HistoricoFreteService historicoFreteService;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void atualizarStatusFaturado(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(new Frete());

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado");


        Assert.isTrue(!frete.getStatusFrete().equals(StatusFrete.DESCARGA),
                "Não é possível faturar um frete que não está com o sucesso de descarte");

        final List<Despesa> despesas = this.despesaRepository.findByFreteAndAprovadorIsNull(frete.getId());

        Assert.isTrue(despesas.size() == 0,
                "Não é possível faturar um frete com despesas abertas");

        frete.setStatusFrete(StatusFrete.FATURADO);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.FATURADO);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void atualizarStatusEmTransporte(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);


        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado");


        Assert.isTrue(!frete.getStatusFrete().equals(StatusFrete.INTERROMPIDO),
                "Não é possível iniciar o transporte do frete, pois seu status é diferente de interrompido");

        frete.setStatusFrete(StatusFrete.EM_TRANSPORTE);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.EM_TRANSPORTE);
    }
}
