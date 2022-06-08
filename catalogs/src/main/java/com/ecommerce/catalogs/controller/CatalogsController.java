package com.ecommerce.catalogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.catalogs.domain.entity.Catalogs;
import com.ecommerce.catalogs.service.CatalogsService;
import io.swagger.annotations.ApiOperation;

@RestController
public class CatalogsController {
	
	@Autowired
	CatalogsService catalogsService;

	@ApiOperation(value = "상품 전체 조회", httpMethod = "GET", notes = "상품 전체 조회")
	@GetMapping(value="/rest/catalogs")
	public List<Catalogs>  selectAllCatalogs() throws Exception{
		return catalogsService.selectAllCatalogs();
	}
	
	@ApiOperation(value = "상품 조회", httpMethod = "GET", notes = "상품 조회")
	@GetMapping(value="/rest/catalogs/{productId}")
	public Catalogs selectCatalogsByProductId(@PathVariable("productId") String productId) throws Exception{
		return catalogsService.selectCatalogsByProductId(productId);
	}
	
	@ApiOperation(value = "상품 등록", httpMethod = "POST", notes = "상품 등록")
	@PostMapping(value="/rest/catalog")
	public int insertCatalogs(@RequestBody Catalogs catalogs) throws Exception{
		return catalogsService.insertCatalogs(catalogs);
	}
	
	@ApiOperation(value = "상품 삭제", httpMethod = "DELETE", notes = "상품 삭제")
	@DeleteMapping(value="/rest/catalog/{productId}")
	public int deleteCatalogs(@PathVariable("productId") String productId) throws Exception{
		return catalogsService.deleteCatalogs(productId);
	}
	
	@ApiOperation(value = "상품 수정", httpMethod = "PUT", notes = "상품 수정")
	@PutMapping(value="/rest/catalog")
	public int updateCatalogs(@RequestBody Catalogs catalogs) throws Exception{
		return catalogsService.updateCatalogs(catalogs);
	}
}






