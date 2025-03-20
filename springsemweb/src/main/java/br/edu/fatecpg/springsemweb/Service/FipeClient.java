package br.edu.fatecpg.springsemweb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Service
public class FipeClient {
private final RestTemplate restTemplate = new RestTemplate();
private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/carros/&quot;;<br/><br/> public List<Map<String, Object>> getMarcas() {
return restTemplate.getForObject(BASE_URL + "marcas", List.class);
}

public List<Map<String, Object>> getModelos(int marcaId) {
Map<String, Object> response = restTemplate.getForObject(BASE_URL + "marcas/" + marcaId + "/modelos", Map.class);
return (List<Map<String, Object>>) response.get("modelos");
}

public List<Map<String, Object>> getAnos(int marcaId, int modeloId) {
return restTemplate.getForObject(BASE_URL + "marcas/" + marcaId + "/modelos/" + modeloId + "/anos", List.class);
}

public Map<String, Object> getPreco(int marcaId, int modeloId, String ano) {
return restTemplate.getForObject(BASE_URL + "marcas/" + marcaId + "/modelos/" + modeloId + "/anos/" + ano, Map.class);
}
}