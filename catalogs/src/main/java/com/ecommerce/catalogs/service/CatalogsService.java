package com.ecommerce.catalogs.service;

import java.util.List;

import com.ecommerce.catalogs.domain.entity.Catalogs;
import com.ecommerce.catalogs.domain.entity.Order;

public interface CatalogsService {

	public List<Catalogs>  selectAllCatalogs() throws Exception;
	public Catalogs selectCatalogsByProductId(String productId) throws Exception;
	public int insertCatalogs(Catalogs catalogs) throws Exception;
	public int deleteCatalogs(String productId) throws Exception;
	public int updateCatalogs(Catalogs catalogs) throws Exception;
	
	public int updateQuantity(Order order) throws Exception;
}
