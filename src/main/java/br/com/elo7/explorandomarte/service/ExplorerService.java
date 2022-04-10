package br.com.elo7.explorandomarte.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.elo7.explorandomarte.model.Direction;
import br.com.elo7.explorandomarte.model.InitialField;
import br.com.elo7.explorandomarte.model.Position;
import br.com.elo7.explorandomarte.model.Probe;

@Service
public class ExplorerService {

	private InitialField field;
	
	private Probe probe;
	
	private InitialField initializeField(int x, int y) {
			field = new InitialField(x, y);
			return field;
	}
	
	private Probe initializeProbe(Position position, Direction direction) {
		probe = new Probe (position, direction);
		return probe;
	}
	
	private ResponseEntity<?> processInstructions(List<String> instructions){
		if (instructions.isEmpty())
			return new ResponseEntity<>(HttpStatus.OK);
		if(!isDirectionsGood(instructions)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (!isFieldInitialized() || !isProbeInitialized()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		operateInstructions(instructions);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private ResponseEntity<?> returnPosition(){
		if (isProbeInitialized()) {
			return ResponseEntity.ok(probe.getDirection().getActualDirection());			
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	private void operateInstructions(List<String> directions) {
		
		for (String direction : directions) {
			if (direction.equalsIgnoreCase("L") || direction.equalsIgnoreCase("R"))
				setProbeDirection(direction);
			
			if (direction.equalsIgnoreCase("M")) {
				moveProbe();
			}
		}
	}	
	
	private boolean isDirectionsGood(List<String> directions) {		
		for (String direction : directions)
			if (!direction.equalsIgnoreCase("L") || !direction.equalsIgnoreCase("R") || !direction.equalsIgnoreCase("M"))
				return false;
		return true;
	}
	
	private void setProbeDirection(String direction) {
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
	
	private void moveProbe() {
		if(probe.getDirection().getActualDirection().equalsIgnoreCase("N")){
			probe.getPosition().setActualXPosition(probe.getPosition().getActualXPosition() + 1);
		} else if(probe.getDirection().getActualDirection().equalsIgnoreCase("S")) {
			probe.getPosition().setActualXPosition(probe.getPosition().getActualXPosition() - 1);
		} else if(probe.getDirection().getActualDirection().equalsIgnoreCase("E")) {
			probe.getPosition().setActualXPosition(probe.getPosition().getActualYPosition() + 1);
		} else {
			probe.getPosition().setActualXPosition(probe.getPosition().getActualYPosition() - 1);
		}
	}
	
	private boolean isProbeInitialized(){
		return probe != null;
	}
	
	private boolean isFieldInitialized() {
		return field != null;		
	}
}
