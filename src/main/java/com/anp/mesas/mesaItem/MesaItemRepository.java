package com.anp.mesas.mesaItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anp.mesas.base.BaseRepository;

@Repository
public interface MesaItemRepository extends BaseRepository<MesaItem> {
	
	@Query(value="SELECT m FROM MesaItem m where m.produto.id =:produtoId ")
	public MesaItem retornarPorIdProduto(@Param("produtoId") Long produtoId);

}
