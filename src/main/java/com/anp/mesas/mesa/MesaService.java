package com.anp.mesas.mesa;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anp.mesas.base.BaseService;
import com.anp.mesas.mesaItem.MesaItem;
import com.anp.mesas.mesaItem.MesaItemRepository;

@Service
public class MesaService extends BaseService<Mesa, MesaRepository> {

	@Autowired
	private MesaRepository mesaRepository;

	@Autowired
	private MesaItemRepository mesaItemRepository;

	@Transactional
	public Optional<Mesa> adicionarItem(MesaItem mesaItem, Long idMesa) {
		Boolean entrou = false;
		try {
			Optional<Mesa> mesa = Optional.of(mesaRepository.getById(idMesa));
			if (mesa.isPresent()) {
				if (verificarSeItemJaFoiIncluidoNaMesa(mesaItem.getProduto().getId())) {
					mesa.get().getItens().add(mesaItem);
					mesa.get().setItens(mesa.get().getItens());
					entrou = true;
				}
			}
			return (entrou) ? salvar(mesa.get()) : Optional.empty();
		} catch (Exception e) {
			throw e;
		}

	}

	@Transactional
	public void fecharMesa(Long id) {
		mesaRepository.fecharMesa(id);
	}

	public Boolean verificarSeItemJaFoiIncluidoNaMesa(Long idItem) {
		Boolean validou = false;
		Optional<MesaItem> item = Optional.ofNullable(mesaItemRepository.retornarPorIdProduto(idItem));
		if (item.isPresent()) {
			validou = false;
			item.orElseThrow(() -> new RuntimeException("Atenção item ja foi incluido nesta mesa !"));

		} else {
			validou = true;
		}
		return validou;
	}

}
