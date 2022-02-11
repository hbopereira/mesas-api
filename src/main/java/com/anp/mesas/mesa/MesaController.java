package com.anp.mesas.mesa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anp.mesas.base.BaseController;
import com.anp.mesas.mesaItem.MesaItem;

@RestController
@RequestMapping("/api/mesas")
public class MesaController extends BaseController<Mesa, MesaRepository, MesaService> {

	@Autowired
	private MesaService mesaService;

	@PutMapping("/adicionarItem")
	public void adicionarItem(@RequestBody MesaItem item, @RequestParam("idMesa") Long idMesa) {
		mesaService.adicionarItem(item, idMesa);
	}

	@PutMapping("/fecharMesa")
	public void fecharMesa(@RequestParam Long id) {
		mesaService.fecharMesa(id);
	}

}
