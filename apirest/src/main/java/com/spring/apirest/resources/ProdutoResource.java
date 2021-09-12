package com.spring.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.apirest.models.Produto;
import com.spring.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/api")
@Api(value="API Rest produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository jparepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List <Produto> listaProduto(){
		return jparepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna um item por id")
	public Produto produtoUnico(@PathVariable(value="id") long id){
		return jparepository.findById(id);
	}
	
	/*envia e salva para o banco de dados*/
	@PostMapping("/produtos")
	@ApiOperation(value="Salva um produto")
	public Produto saveProduto(@RequestBody Produto produto) {
		return jparepository.save(produto);
	}
	
	@DeleteMapping("/produtos/{id}")
	@ApiOperation(value="deleta um produto")
	public Produto deleteProduto(@PathVariable(value="nome") long id) {
		return jparepository.deleteById(id);
	}
	
	@PutMapping("/produtos")
	@ApiOperation(value="atualiza um produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return jparepository.save(produto);
	}
	
	
	

}
