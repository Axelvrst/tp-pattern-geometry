package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor {
	
	private List<Coordinate> coords;

    public EnvelopeBuilder() {
        this.coords = new ArrayList<Coordinate>();
    }

    public void insert(Coordinate coordinate) {
        this.coords.add(coordinate);
    }

    public Envelope build() {
        if (coords.isEmpty()) {
        	return new Envelope();
        }
        
        else {
            double Xmin = coords.get(0).getX();
            double Ymin = coords.get(0).getY();
            double Xmax = coords.get(0).getX();
            double Ymax = coords.get(0).getY();
            
            for (Coordinate coordinate : coords) {
            	Xmin = Math.min(Xmin, coordinate.getX());
            	Ymin = Math.min(Ymin, coordinate.getY());
            	Xmax = Math.max(Xmax, coordinate.getX());
            	Ymax = Math.max(Ymax, coordinate.getY());
            }
            
            return new Envelope(new Coordinate(Xmin, Ymin), new Coordinate(Xmax, Ymax));
        }
    }

	@Override
	public void visit(Point point) {
		insert(point.getCoordinate());
	}

	@Override
	public void visit(LineString lineString) {
		for (int i = 0; i < lineString.getNumPoints(); i++) {
			visit(lineString.getPointN(i));
		}
	}

}
