package com.jsp.spring.pmsm.serviceImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.spring.pmsm.dto.ProductRequest;
import com.jsp.spring.pmsm.dto.ProductRequest;
import com.jsp.spring.pmsm.exception.ProductNotFoundByIdException;
import com.jsp.spring.pmsm.exception.ProductNotFoundException;
import com.jsp.spring.pmsm.model.Product;
import com.jsp.spring.pmsm.repository.ProductRepository;
import com.jsp.spring.pmsm.service.ProductService;
import com.jsp.spring.pmsm.utility.ResponseStructure;
@Service

public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private ResponseStructure<Product> responseStructure;
	private ResponseStructure<List<Product>> structure;

	public ProductServiceImpl(ProductRepository productRepo, ResponseStructure<Product> responseStructure,ResponseStructure<List<Product>> structure) {
		super();
		this.productRepository = productRepo;
		this.responseStructure = responseStructure;
		this.structure=structure;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findProductById(int productId) {
		return productRepository.findById(productId).map(product->
		ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage(".....product found.....")
				.setData(product)))
				.orElseThrow(()->new ProductNotFoundByIdException("Invalid productId"));
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest productRequest) {
		Product exProduct=productRepository.save(mapToProduct(productRequest));
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage(".....Object saved successfully.....")
				.setData(exProduct));

	}

	private Product mapToProduct(ProductRequest productRequest) {
		//product.setProductName(productRequest.getProductName());
		//product.setProductPrice(productRequest.getProductPrice());
		//return product;
		
		//return Product.builder().getProductName(productRequest.getProductName()).getProductPrice(productRequest.getProductPrice().)bulid();.
	return Product.builder().productName(productRequest.getProductName()).productPrice(productRequest.getProductPrice()).build();
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateProduct(int productId,Product updatedProduct) {
		return productRepository.findById(productId).map(exProduct->{
			updatedProduct.setProductId(exProduct.getProductId());
			exProduct=productRepository.save(updatedProduct);
			return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
					.setMessage("....Object Updated successfully.....")
					.setData(exProduct));
		}).orElseThrow(()->new ProductNotFoundByIdException("Invalid productId"));
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int productId) {
		return productRepository.findById(productId).map(exProduct->{
			productRepository.delete(exProduct);
			return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
					.setMessage("......Object deleted successfully......")
					.setData(exProduct));
		}).orElseThrow(()->new ProductNotFoundByIdException("Invalid productId"));

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
		List<Product> products=productRepository.findAll();
		if(!products.isEmpty()) {
			return ResponseEntity.ok(structure.setStatuscode(HttpStatus.OK.value())
					.setMessage("product found")
					.setData(products));
		}else throw new ProductNotFoundException("No products exists");

	}
}
