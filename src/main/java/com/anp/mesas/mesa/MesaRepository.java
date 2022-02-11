package com.anp.mesas.mesa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anp.mesas.base.BaseRepository;
import com.anp.mesas.mesaItem.MesaItem;

@Repository
public interface MesaRepository extends BaseRepository<Mesa> {
	
	@Modifying
	@Query(value="UPDATE mesa SET fechou = 1 WHERE id =:id ", nativeQuery=true)
	public void fecharMesa(@Param("id") Long id);
    
}
