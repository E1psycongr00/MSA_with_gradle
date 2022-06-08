package com.ecommerce.catalogs.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecommerce.catalogs.domain.entity.Catalogs;

@Mapper
public interface CatalogsRepository {

	public List<Catalogs>  selectAllCatalogs() throws Exception;
	public Catalogs selectCatalogsByProductId(String productId) throws Exception;
	public int insertCatalogs(Catalogs catalogs) throws Exception;
	public int deleteCatalogs(String productId) throws Exception;
	public int updateCatalogs(Catalogs catalogs) throws Exception;
	
}
