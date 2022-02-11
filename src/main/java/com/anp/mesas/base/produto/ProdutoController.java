package com.anp.mesas.base.produto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anp.mesas.base.BaseController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController extends BaseController<Produto,ProdutoRepository, ProdutoService> {

}
