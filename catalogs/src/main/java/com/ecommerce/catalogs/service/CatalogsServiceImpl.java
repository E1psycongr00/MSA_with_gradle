package com.ecommerce.catalogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.catalogs.domain.entity.Catalogs;
import com.ecommerce.catalogs.domain.repository.CatalogsRepository;


@Service("catalogsService")
public class CatalogsServiceImpl implements CatalogsService {

	@Autowired
	CatalogsRepository catalogsRepository;
	
	@Override
	public List<Catalogs> selectAllCatalogs() throws Exception {
		return catalogsRepository.selectAllCatalogs();
	}

	@Override
	public Catalogs selectCatalogsByProductId(String productId) throws Exception {
		return catalogsRepository.selectCatalogsByProductId(productId);
	}

	@Override
	public int insertCatalogs(Catalogs catalogs) throws Exception {
		return catalogsRepository.insertCatalogs(catalogs);
	}

	@Override
	public int deleteCatalogs(String productId) throws Exception {
		return catalogsRepository.deleteCatalogs(productId);
	}

	@Override
	public int updateCatalogs(Catalogs catalogs) throws Exception {
		return catalogsRepository.updateCatalogs(catalogs);
	}

}
