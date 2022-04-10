package br.com.elo7.explorandomarte.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.elo7.explorandomarte.model.InitialField;
import br.com.elo7.explorandomarte.model.Probe;

@Service
public class ExplorerService {

	private InitialField field;
	
	private InitialField initializeField(int x, int y) {
			field = new InitialField(x, y);
			return field;
	}
	
	private ResponseEntity<Object> processInstructions(List<String> instructions){
		if (instructions.isEmpty())
			return new ResponseEntity<>(HttpStatus.OK);
		return null;
	}
	
	private ResponseEntity<Object> returnPosition(){
		return null;
	}
	
	private ResponseEntity<?> operateDirections(List<String> directions, Probe probe) {
		for (String direction : directions) {
			if (direction.equalsIgnoreCase("L") || direction.equalsIgnoreCase("R"))
				setProbeDirection(direction, probe);
			
			if (direction.equalsIgnoreCase("M")) {
				
			}
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
	private boolean isDirectionsGood(List<String> directions) {		
		for (String direction : directions)
			if (!direction.equalsIgnoreCase("L") || !direction.equalsIgnoreCase("R") || !direction.equalsIgnoreCase("M"))
				return false;
		return true;
	}
	
	private void setProbeDirection(String direction, Probe probe) {
		if(probe.getDirection().getActualDirection().equalsIgnoreCase("N")) {
			if (direction.equalsIgnoreCase("L")) {
				probe.getDirection().setActualDirection("W");
				return;
			} else {
				probe.getDirection().setActualDirection("E");
				return;
			}
		}
		if(probe.getDirection().getActualDirection().equalsIgnoreCase("S")) {
			if (direction.equalsIgnoreCase("L")) {
				probe.getDirection().setActualDirection("E");
				return;
			} else {
				probe.getDirection().setActualDirection("W");
				return;
			}
		}
		if(probe.getDirection().getActualDirection().equalsIgnoreCase("W")) {
			if (direction.equalsIgnoreCase("L")) {
				probe.getDirection().setActualDirection("S");
				return;
			} else {
				probe.getDirection().setActualDirection("N");
				return;
			}
		}
		if(probe.getDirection().getActualDirection().equalsIgnoreCase("E")) {
			if (direction.equalsIgnoreCase("L")) {
				probe.getDirection().setActualDirection("N");
				return;
			} else {
				probe.getDirection().setActualDirection("S");
				return;
			}
		}
	}
	
	private void moveProbe(Probe probe) {
		if(probe.getDirection().getActualDirection().equalsIgnoreCase("N")){
			probe.getPosition().setActualPosition(null);
		} else if(probe.getDirection().getActualDirection().equalsIgnoreCase("S")) {
			probe.getPosition().setActualPosition(null);
		} else if(probe.getDirection().getActualDirection().equalsIgnoreCase("E")) {
			probe.getPosition().setActualPosition(null);
		} else {
			probe.getPosition().setActualPosition(null);
		}
	}
}
