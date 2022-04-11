package br.com.elo7.explorandomarte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.elo7.explorandomarte.model.InitialField;
import br.com.elo7.explorandomarte.model.Probe;
import br.com.elo7.explorandomarte.service.ExplorerService;

@Controller
public class ExplorerController {
	
	@Autowired
	private ExplorerService service;

	@PostMapping(value = "/initialize-probe")
    public ResponseEntity<?> setInitialProbePosition(@RequestBody Probe probe) {
		return service.initializeProbe(probe);
    }
	
	@PostMapping(value = "/initialize-field")
    public ResponseEntity<?> setInitialField(@RequestBody InitialField field) {
		return service.initializeField(field);
    }
	
	@PostMapping(value = "/instructions")
    public ResponseEntity<?> executeInstructions(@RequestBody List<String> instructions) {
        return service.processInstructions(instructions);
    }
	
	@GetMapping(value = "/position")
    public ResponseEntity<?> getPosition() {
        return service.returnPosition();
    }
}
