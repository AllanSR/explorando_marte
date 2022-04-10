package br.com.elo7.explorandomarte.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExplorerController {

	@PostMapping(value = "/initial-position")
    public ResponseEntity<Object> setInitialPosition() {
          return null;
    }
	
	@PostMapping(value = "/directions")
    public ResponseEntity<Object> setDirection() {
          return null;
    }
	
	@GetMapping(value = "/position")
    public ResponseEntity<Object> getPosition() {
          return null;
    }
}
