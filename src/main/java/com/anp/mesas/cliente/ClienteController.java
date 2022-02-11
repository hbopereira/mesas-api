package com.anp.mesas.cliente;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anp.mesas.base.BaseController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController extends BaseController<Cliente,ClienteRepository,ClienteService>{

}
