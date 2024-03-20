package com.jsp.spring.pmsm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.spring.pmsm.dto.ProductRequest;
import com.jsp.spring.pmsm.model.Product;
import com.jsp.spring.pmsm.utility.ResponseStructure;

public interface ProductService {
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest productRequest);
	public ResponseEntity<ResponseStructure<Product>> updateProduct(int productId,Product updatedProduct);
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId);
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId);
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct();


}
