package com.anp.mesas.mesa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> adicionarItem(@RequestBody MesaItem item, @RequestParam("idMesa") Long idMesa) {
		Optional<Mesa> resultado = mesaService.adicionarItem(item, idMesa);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(resultado.get().getId().toString());
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/fecharMesa")
	public ResponseEntity<Void> fecharMesa(@RequestParam Long id) {
		mesaService.fecharMesa(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
