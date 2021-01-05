package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {
	
	private StringBuilder buffer;
	
	
	public WktVisitor() {
		this.buffer = new StringBuilder();
	}

	@Override
	public void visit(Point point) {
		this.buffer.append(point.getType().toUpperCase());
		if (point.isEmpty()) {
			this.buffer.append(" EMPTY");
			return;
		}
		else {
            this.buffer.append("(").append(point.getCoordinate().getX()).append(" ").append(point.getCoordinate().getY()).append(")");
		}
	}

	@Override
	public void visit(LineString lineString) {
		buffer.append(lineString.getType().toUpperCase());
		if (lineString.isEmpty()) {
			this.buffer.append(" EMPTY");
			return;
		}
		else {
			this.buffer.append("(");
			for (int i=0; i<lineString.getNumPoints() ; i++){
				if (i < lineString.getNumPoints() && i != 0){
					this.buffer.append(",");
				}
				this.buffer.append(Double.toString(lineString.getPointN(i).getCoordinate().getX())).append(" ").append(Double.toString(lineString.getPointN(i).getCoordinate().getY()));
			}
			this.buffer.append(")");
		}
		
	}
	
	public String getResult() {
        return this.buffer.toString();
    }
	
	

}
