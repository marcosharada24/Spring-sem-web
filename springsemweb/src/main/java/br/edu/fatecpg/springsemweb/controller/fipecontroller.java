package br.edu.fatecpg.springsemweb.controller;

import br.edu.fatecpg.springsemweb.service.FipeClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fipe")
public class FipeController {
private final FipeClient fipeClient;

public FipeController(FipeClient fipeClient) {
this.fipeClient = fipeClient;
}

@GetMapping("/marcas")
public List<Map<String, Object>> listarMarcas() {
return fipeClient.getMarcas();
}

@GetMapping("/modelos/{marcaId}")
public List<Map<String, Object>> listarModelos(@PathVariable int marcaId) {
return fipeClient.getModelos(marcaId);
}

@GetMapping("/anos/{marcaId}/{modeloId}")
public List<Map<String, Object>> listarAnos(@PathVariable int marcaId, @PathVariable int modeloId) {
return fipeClient.getAnos(marcaId, modeloId);
}

@GetMapping("/preco/{marcaId}/{modeloId}/{ano}")
public Map<String, Object> consultarPreco(@PathVariable int marcaId, @PathVariable int modeloId, @PathVariable String ano) {
return fipeClient.getPreco(marcaId, modeloId, ano);
}
}